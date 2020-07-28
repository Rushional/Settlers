package views.graphics;

import views.TurnsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTurnListener implements ActionListener {
    private final TurnsView turnsView;
    private Object monitor;

    EndTurnListener(Object monitor, TurnsView turnsView) {
        super();
        this.monitor = monitor;
        this.turnsView = turnsView;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("End turn button pressed!");
        turnsView.setIntention(new ViewIntentionEndTurn());
        synchronized (monitor) {
            monitor.notify();
        }
    }
}
