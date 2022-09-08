package client.views.graphics;

import java.awt.*;

public class DrawHexRobberChoice extends DrawHex {
    private Point cursorPoint;

    public DrawHexRobberChoice(Graphics2D g2d, HexView hexView, Point cursorPoint) {
        super(g2d, hexView);
        this.cursorPoint = cursorPoint;
    }

    @Override
    protected Color chooseHexColor() {
//        check if hexPolygon.contains(cursorPoint) I guess, then change color if true, ot just super() if not???
        if (hexView.getPolygon().contains(cursorPoint)) {
            return new Color(255, 0, 171);
        }
        else {
            return super.chooseHexColor();
        }
    }
}
