package game_view.graphics;

import game_view.TurnsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

public class EndTurnListener implements ActionListener {
    private final TurnsView turnsView;
    private CountDownLatch latch;

    EndTurnListener(CountDownLatch latch, TurnsView turnsView) {
        super();
        this.latch = latch;
        this.turnsView = turnsView;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("End turn button pressed!");
        turnsView.setIntention(new ViewIntentionEndTurn());
        latch.countDown();
    }
}
