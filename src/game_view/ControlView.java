package game_view;

import game_view.graphics.ControlPanel;

import java.util.concurrent.CountDownLatch;

class ControlView {
    private ControlPanel controlPanel;

    ControlView(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    void waitForIntention(CountDownLatch latch, TurnsView turnsView) {
        controlPanel.addEndTurnListener(latch, turnsView);
    }

    void removeEndTurnListener() {
        controlPanel.removeEndTurnListener();
    }
}
