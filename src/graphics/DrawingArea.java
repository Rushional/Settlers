package graphics;

import sound.AudioPlayer;
import system.GameInitiator;
import user_interface.GuiActionsProcessor;
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
    private GuiActionsProcessor guiActionsProcessor;
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
        guiActionsProcessor = new GuiActionsProcessor(map, this, mapLocationX, mapLocationY);
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

    public GuiActionsProcessor getGuiActionsProcessor() {
        return guiActionsProcessor;
    }

    public Player getCurrentPlayer() {
        return game.getPlayers().getCurrentPlayer();
    }

    //for tests
    public MapDrawer getDrawer() {
        return drawer;
    }

    public MapHexes getMap() {
        return map;
    }

    public Game getGame() {
        return game;
    }

    public GameInitiator getGameInitiator() {
        return gameInitiator;
    }
}
