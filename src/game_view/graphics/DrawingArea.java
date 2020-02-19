package game_view.graphics;

import game_model.map.MapHexes;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;

public class DrawingArea extends JPanel {
    private static int mapLocationX = 210, mapLocationY = 30;
    private MapHexes map;
    private MouseInputAdapter currentListener = null;

    DrawingArea(MapHexes map)
    {
        super();
        this.map = map;
        setBackground(new Color(235, 240, 255));
        setPreferredSize(new Dimension(700, 700));
    }

    public void replaceListener(MouseInputAdapter newListener) {
        if (currentListener != null) this.removeMouseListener(currentListener);
        currentListener = newListener;
        this.addMouseListener(currentListener);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        MapDrawer drawer = new MapDrawer(map, mapLocationX, mapLocationY);
        drawer.drawMap(g2d);
    }

    MapHexes getMap() {
        return map;
    }

    public int[] getMapCoordinates() {
        return new int[] { mapLocationX, mapLocationY };
    }
}
