package client.views.graphics;

import java.awt.*;

public class DrawMapRobberChoice extends DrawMap {
    private Point cursorPoint;

    public DrawMapRobberChoice(Graphics2D g2d, MapView mapView, Point cursorPoint) {
        super(g2d, mapView);
        this.cursorPoint = cursorPoint;
    }


    @Override
    void callDrawHex(Graphics2D g2d, HexView hexView) {
        DrawHex drawHex = new DrawHexRobberChoice(g2d, hexView, cursorPoint);
        drawHex.call();
    }
}
