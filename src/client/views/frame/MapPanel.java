package client.views.frame;

import client.models.map.MapHexes;
import client.views.graphics.DrawMap;
import client.views.graphics.DrawMapRobberChoice;
import client.views.graphics.DrawingState;
import client.views.graphics.MapView;
import client.views.inputs.listeners.MapListener;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private MapHexes map;
    private MapView mapView;
    private MapListener currentListener = null;
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
        DrawMap drawMap;
        if (drawingState == DrawingState.USUAL) {
            drawMap = new DrawMap(g2d, mapView);
        }
        else {
/*
*        TODO: It's probably better to use something like robberMouseListener.getStuff() to get the cursor point
*         instead of updating the field of the whole MapPanel all the time. It would just look cleaner
*/
            drawMap = new DrawMapRobberChoice(g2d, mapView, cursorPoint);
        }
        drawMap.call();
//        System.out.println("I'm mister Meeseeks look at me!"); // I just wanted to find out how often this is run
    }

    public void addMapListener(Object monitor, MapListener mapListener) {
//        BuildListener buildListener = new BuildListener(monitor);
        addMouseListener(mapListener);
    }

    public void removeMapListener() {
        removeMouseListener(currentListener);
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
