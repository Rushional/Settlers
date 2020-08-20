package views.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTurnListener implements ActionListener {
    private Object monitor;
    private boolean pressed = false;

    EndTurnListener(Object monitor) {
        super();
        this.monitor = monitor;
    }

    public void actionPerformed(ActionEvent e) {
        pressed = true;
        synchronized (monitor) {
            monitor.notify();
        }
    }

    public boolean isPressed() {
        return pressed;
    }
}
