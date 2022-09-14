package views.inputs.listeners;

import views.inputs.intentions.ViewIntention;

public abstract class InputRequester {
    void waitForAction(Object monitor) {
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    abstract void requestTurnIntention(Object monitor);

    public abstract ViewIntention getIntentionInputFromListener();
}
