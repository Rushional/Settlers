package views.graphics;

import models.hex.Hex;
import models.map.MapHexes;

import java.awt.*;

public class DrawMapRobberChoice extends DrawMap {
    private Point cursorPoint;

    public DrawMapRobberChoice(Graphics2D g2d, MapHexes map, Point cursorPoint) {
        super(g2d, map);
        this.cursorPoint = cursorPoint;
    }

    @Override
    void callDrawHex(Graphics2D g2d, Hex hex, int upPointX, int upPointY) {
        DrawHex drawHex = new DrawHexRobberChoice(g2d, hex, upPointX, upPointY, cursorPoint);
        drawHex.call();
    }
}
