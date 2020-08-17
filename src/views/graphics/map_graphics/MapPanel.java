package views.graphics.map_graphics;

import models.map.MapHexes;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;

public class MapPanel extends JPanel {
    private static int mapLocationX = 210, mapLocationY = 30;
    private MapHexes map;
    private MouseInputAdapter currentListener = null;
    private DrawingState drawingState = DrawingState.USUAL;
    private Point cursorPoint = new Point(300, 300); //Needed to update the position of cursor to color the chosen hex

    public MapPanel(MapHexes map)
    {
        super();
        this.map = map;
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
            drawMap = new DrawMap(g2d, map, mapLocationX, mapLocationY);
        }
        else {
/*            TODO: It's probably better to use something like robberMouseListener.getStuff() to get the cursor point
*              instead of updating the field of the whole MapPanel all the time. It would just look cleaner
*/
            drawMap = new DrawMapRobberChoice(g2d, map, mapLocationX, mapLocationY, cursorPoint);
        }
        drawMap.call();
//        System.out.println("I'm mister Meeseeks look at me!"); // I just wanted to find out how often this is run
    }

    MapHexes getMap() {
        return map;
    }

    public int[] getMapCoordinates() {
        return new int[] { mapLocationX, mapLocationY };
    }
}
