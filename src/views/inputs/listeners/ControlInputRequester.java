package views.inputs.listeners;

import views.frame.ControlPanel;
import views.frame.EndTurnListener;
import views.inputs.intentions.ViewIntention;
import views.inputs.intentions.ViewIntentionEndTurn;
import views.inputs.intentions.ViewIntentionNone;

public class ControlInputRequester extends InputRequester {
    private ControlPanel controlPanel;
    private EndTurnListener currentListener = null;

    public ControlInputRequester(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public void requestTurnIntention(Object monitor) {
        currentListener = controlPanel.addEndTurnListener(monitor);
    }

    public ViewIntention getIntentionInputFromListener() {
        controlPanel.removeEndTurnListener();
        ViewIntention intention;
        if (currentListener.isPressed()) {
            intention = new ViewIntentionEndTurn();
        }
        else {
            intention = new ViewIntentionNone();
        }
        return intention;
    }
}
