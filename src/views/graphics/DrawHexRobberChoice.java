package views.graphics;

import models.hex.Hex;

import java.awt.*;

public class DrawHexRobberChoice extends DrawHex {
    private Point cursorPoint;

    public DrawHexRobberChoice(Graphics2D g2d, Hex hex, int upPointX, int upPointY, Point cursorPoint) {
        super(g2d, hex, upPointX, upPointY);
        this.cursorPoint = cursorPoint;
    }

    @Override
    protected Color chooseHexColor() {
//        check if hexPolygon.contains(cursorPoint) I guess, then change color if true, ot just super() if not???
        if (hexPolygon.contains(cursorPoint)) {
            return new Color(255, 0, 171);
        }
        else {
            return super.chooseHexColor();
        }
    }
}
