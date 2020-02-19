package game_view.graphics;

import system.GameInitiator;
import game_view.building_view.BuildingGraphicsManager;
import game_model.GameModel;
import game_model.Player;
import game_model.map.MapHexes;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;

//TO DO make some game_view.graphics class so that a JPanel doesn't run everything and instead IS run by some bigger game_view.graphics class
public class DrawingArea extends JPanel {
    private final static int mapLocationX = 210, mapLocationY = 30;
    private MapHexes map;
    //Can we delete this?
    //The roles should be reversed probably. Panel shouldn't control the manager
    private BuildingGraphicsManager buildingGraphicsManager;
    private MouseInputAdapter currentListener = null;
    private GameInitiator gameInitiator;

    public DrawingArea(MapHexes map, GameInitiator gameInitiator)
    {
        super();
        this.map = map;
        this.gameInitiator = gameInitiator;
        setBackground(new Color(235, 240, 255));
        //TO DO buildingGuiActionsProcessor is now too big to be created inside drawingArea,
        // so it needs to be moved higher,
        // probably somewhere in the GameInitiator
        buildingGraphicsManager = new BuildingGraphicsManager(this, mapLocationX, mapLocationY);
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

    //Is this necessary?
    public BuildingGraphicsManager getBuildingGraphicsManager() {
        return buildingGraphicsManager;
    }

    MapHexes getMap() {
        return map;
    }

    public GameInitiator getGameInitiator() {
        return gameInitiator;
    }
}
