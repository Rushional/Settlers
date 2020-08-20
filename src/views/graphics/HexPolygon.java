package views.graphics;

import models.hex.Hex;

import java.awt.*;

public class HexPolygon extends Polygon {
    private Point upPoint, upperRightPoint, lowerRightPoint, lowPoint, lowerLeftPoint, upperLeftPoint;
    private Hex hexModel;

    HexPolygon(Hex hexModel, int upPointX, int upPointY) {
        super();
        this.hexModel = hexModel;
        upPoint = new Point(upPointX, upPointY);
        upperRightPoint = new Point(upPointX + 64, upPointY + 32);
        lowerRightPoint = new Point(upPointX + 64, upPointY + 106);
        lowPoint = new Point(upPointX, upPointY + 138);
        lowerLeftPoint = new Point(upPointX - 64, upPointY + 106);
        upperLeftPoint = new Point(upPointX - 64, upPointY + 32);
        addPoint(upPoint.x, upPoint.y);
        addPoint(upperRightPoint.x, upperRightPoint.y);
        addPoint(lowerRightPoint.x, lowerRightPoint.y);
        addPoint(lowPoint.x, lowPoint.y);
        addPoint(lowerLeftPoint.x, lowerLeftPoint.y);
        addPoint(upperLeftPoint.x, upperLeftPoint.y);
    }

    public Point getUpPoint() {
        return upPoint;
    }

    public Point getUpperRightPoint() {
        return upperRightPoint;
    }

    public Point getLowerRightPoint() {
        return lowerRightPoint;
    }

    public Point getLowPoint() {
        return lowPoint;
    }

    public Point getLowerLeftPoint() {
        return lowerLeftPoint;
    }

    public Point getUpperLeftPoint() {
        return upperLeftPoint;
    }

    public Hex getHexModel() {
        return hexModel;
    }
}
