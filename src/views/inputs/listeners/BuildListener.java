package views.inputs.listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class BuildListener extends MapListener {
    private ClickCoordinates clickCoordinates = null;
    private Point pressedPoint;

    public BuildListener(Object monitor) {
        super(monitor);
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