package views.frame;

import models.map.MapHexes;
import views.graphics.MapView;
import views.inputs.listeners.BuildListener;
import views.graphics.DrawMap;
import views.graphics.DrawMapRobberChoice;
import views.graphics.DrawingState;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;

public class MapPanel extends JPanel {
    private MapHexes map;
    private MapView mapView;
    private MouseInputAdapter currentListener = null;
    private DrawingState drawingState = DrawingState.USUAL;
    private Point cursorPoint = new Point(300, 300); //Needed to update the position of cursor to color the chosen hex

    public MapPanel(MapHexes map, MapView mapView)
    {
        super();
        this.map = map;
        this.mapView = mapView;
        setBackground(new Color(235, 240, 255));
        setPreferredSize(new Dimension(700, 700));
    }

    public void replaceListener(MouseInputAdapter newListener) {
        if (currentListener != null) removeMouseListener(currentListener);
        currentListener = newListener;
        addMouseListener(currentListener);
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

    public BuildListener addBuildListener(Object monitor) {
        BuildListener buildListener = new BuildListener(monitor);
        addMouseListener(buildListener);
        return buildListener;
    }

    MapHexes getMap() {
        return map;
    }
}
