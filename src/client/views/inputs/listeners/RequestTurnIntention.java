package client.views.inputs.listeners;

// This class calls requestIntention methods from both mapPanel and controlPanel,
// then processes the result and re

import client.views.inputs.intentions.ViewIntention;
import client.views.inputs.intentions.ViewIntentionNone;

public class RequestTurnIntention {
    public static ViewIntention call(MapInputRequester mapManager, ControlInputRequester controlManager) {
        var monitor = new Object();
        mapManager.requestTurnIntention(monitor);
        controlManager.requestTurnIntention(monitor);
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        ViewIntention mapIntention = mapManager.getIntentionInputFromListener();
        ViewIntention controlIntention = controlManager.getIntentionInputFromListener();
//        Basically XOR on these intentions so that only one of them can be not null at once,
//        to make sure that everything is fine
        if (!(controlIntention instanceof ViewIntentionNone)) {
            if (mapIntention instanceof ViewIntentionNone) {
                return controlIntention;
            }
            else throw new RuntimeException();
        }
        else if (!(mapIntention instanceof ViewIntentionNone)) {
            return mapIntention;
        }
        else throw new RuntimeException();
    }
}
