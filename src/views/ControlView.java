package views;

import views.graphics.ControlPanel;

class ControlView {
    private ControlPanel controlPanel;

    ControlView(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    void waitForIntention(Object monitor, TurnsView turnsView) {
        controlPanel.addEndTurnListener(monitor, turnsView);
    }

    void removeEndTurnListener() {
        controlPanel.removeEndTurnListener();
    }
}
