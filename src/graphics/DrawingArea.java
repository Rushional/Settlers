package graphics;

import system.GameInitiator;
import building_interface.BuildingGuiActionsProcessor;
import interactions.Game;
import interactions.Player;
import map.MapHexes;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;

public class DrawingArea extends JPanel {
    private final static int mapLocationX = 210, mapLocationY = 30;
    private MapDrawer drawer;
    private MapHexes map;
    private BuildingGuiActionsProcessor buildingGuiActionsProcessor;
    private Game game;
    private MouseInputAdapter currentListener = null;
    private GameInitiator gameInitiator;

    public DrawingArea(MapHexes map, Game game, GameInitiator gameInitiator)
    {
        super();
        this.map = map;
        this.game = game;
        this.gameInitiator = gameInitiator;
        setBackground(new Color(235, 240, 255));
        //TO DO buildingGuiActionsProcessor is now too big to be created inside drawingArea,
        // so it needs to be moved higher,
        // probably somewhere in the GameInitiator
        buildingGuiActionsProcessor = new BuildingGuiActionsProcessor(map, this, mapLocationX, mapLocationY, gameInitiator.getAudioPlayer());
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
        initializeDrawer(map);
        drawer.drawMap(g2d);
    }

    private void initializeDrawer(MapHexes map) {
        drawer = new MapDrawer(map, mapLocationX, mapLocationY);
    }

    public BuildingGuiActionsProcessor getBuildingGuiActionsProcessor() {
        return buildingGuiActionsProcessor;
    }

    public Player getCurrentPlayer() {
        return game.getPlayers().getCurrentPlayer();
    }

    //for tests
    public MapDrawer getDrawer() {
        return drawer;
    }

    MapHexes getMap() {
        return map;
    }

    Game getGame() {
        return game;
    }

    public GameInitiator getGameInitiator() {
        return gameInitiator;
    }
}
