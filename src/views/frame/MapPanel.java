package views.frame;

import models.map.MapHexes;
import views.graphics.MapView;
import views.graphics.MapDrawer;
import views.graphics.MapDrawerRobberChoice;
import views.graphics.DrawingState;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseListener;

public class MapPanel extends JPanel {
    private MapHexes map;
    private MapView mapView;
    private DrawingState drawingState = DrawingState.USUAL;
    private Point cursorPoint = null; //Needed to update the position of cursor to color the chosen hex

    public MapPanel(MapHexes map, MapView mapView)
    {
        super();
        this.map = map;
        this.mapView = mapView;
        setBackground(new Color(235, 240, 255));
        setPreferredSize(new Dimension(700, 700));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        MapDrawer mapDrawer;
        if (drawingState == DrawingState.USUAL) {
            mapDrawer = new MapDrawer(g2d, mapView);
        }
        else {
/*
*        TODO: It's probably better to use something like robberMouseListener.getStuff() to get the cursor point
*         instead of updating the field of the whole MapPanel all the time. It would just look cleaner
*/
            mapDrawer = new MapDrawerRobberChoice(g2d, mapView, cursorPoint);
        }
        mapDrawer.drawMap();
//        System.out.println("I'm mister Meeseeks look at me!"); // I just wanted to find out how often this is run
    }

    public void addMouseListener(Object monitor, MouseListener mouseListener) {
//        BuildListener buildListener = new BuildListener(monitor);
        addMouseListener(mouseListener);
    }

    public void setCursorPoint(Point cursorPoint) {
        this.cursorPoint = cursorPoint;
    }

    public void setStateUsual() {
        drawingState = DrawingState.USUAL;
    }

    public void setStateRobber() {
        drawingState = DrawingState.ROBBER;
    }



    MapHexes getMap() {
        return map;
    }
}
