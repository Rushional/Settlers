package views.inputs.listeners;

import views.frame.MapPanel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveRobberListener extends MapListener {
    private ClickCoordinates clickCoordinates = null;
    private Point pressedPoint;
    private MapPanel mapPanel;

    public MoveRobberListener(Object monitor, MapPanel mapPanel) {
        super(monitor);
        this.mapPanel = mapPanel;
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

    public void mouseMoved(MouseEvent e) {
        mapPanel.setCursorPoint(new Point(e.getX(), e.getY()));
        mapPanel.repaint();
    }

    public ClickCoordinates getClickCoordinates() {
        return clickCoordinates;
    }
}
