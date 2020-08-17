package views.graphics.map_graphics;

import models.hex.Hex;
import models.map.MapHexes;

import java.awt.*;

public class DrawMapRobberChoice extends DrawMap {
    private Point cursorPoint;

    public DrawMapRobberChoice(Graphics2D g2d, MapHexes map, int top1LeftX, int top1LeftY, Point cursorPoint) {
        super(g2d, map, top1LeftX, top1LeftY);
        this.cursorPoint = cursorPoint;
    }

    @Override
    void callDrawHex(Graphics2D g2d, Hex hex, int upPointX, int upPointY) {
        DrawHex drawHex = new DrawHexRobberChoice(g2d, hex, upPointX, upPointY, cursorPoint);
        drawHex.call();
    }
}
