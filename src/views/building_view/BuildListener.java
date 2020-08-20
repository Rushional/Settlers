package views.building_view;

import views.listeners.ClickCoordinates;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class BuildListener extends MouseInputAdapter {
    private Object monitor;
    private ClickCoordinates clickCoordinates = null;
    private Point pressedPoint;

    public BuildListener(Object monitor) {
        super();
        this.monitor = monitor;
    }

    public void mousePressed(MouseEvent e)
    {
        pressedPoint = e.getPoint();
    }

    public void mouseReleased(MouseEvent e)
    {
        Point releasedPoint = e.getPoint();
        clickCoordinates = new ClickCoordinates(pressedPoint, releasedPoint);
        synchronized (monitor) {
            monitor.notify();
        }
    }

    public ClickCoordinates getClickCoordinates() {
        return clickCoordinates;
    }
}