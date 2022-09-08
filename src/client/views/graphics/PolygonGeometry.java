package client.views.graphics;

import java.awt.*;

// This class takes the position of the upPoint of a Hex and calculates all the other Points' positions
public class PolygonGeometry {
    private Point upPoint, upperRightPoint, lowerRightPoint, lowPoint, lowerLeftPoint, upperLeftPoint;

    public PolygonGeometry(int upPointX, int upPointY) {
        upPoint = new Point(upPointX, upPointY);
        upperRightPoint = new Point(upPointX + 64, upPointY + 32);
        lowerRightPoint = new Point(upPointX + 64, upPointY + 106);
        lowPoint = new Point(upPointX, upPointY + 138);
        lowerLeftPoint = new Point(upPointX - 64, upPointY + 106);
        upperLeftPoint = new Point(upPointX - 64, upPointY + 32);
    }

    public static Polygon calculateHexPolygon(int upPointX, int upPointY) {
        PolygonGeometry coordinates = new PolygonGeometry(upPointX, upPointY);
        Polygon polygon = new Polygon();
        polygon.addPoint(coordinates.getUpPoint().x, coordinates.getUpPoint().y);
        polygon.addPoint(coordinates.getUpperRightPoint().x, coordinates.getUpperRightPoint().y);
        polygon.addPoint(coordinates.getLowerRightPoint().x, coordinates.getLowerRightPoint().y);
        polygon.addPoint(coordinates.getLowPoint().x, coordinates.getLowPoint().y);
        polygon.addPoint(coordinates.getLowerLeftPoint().x, coordinates.getLowerLeftPoint().y);
        polygon.addPoint(coordinates.getUpperLeftPoint().x, coordinates.getUpperLeftPoint().y);
        return polygon;
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
}
