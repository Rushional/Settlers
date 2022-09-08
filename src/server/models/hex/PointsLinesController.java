package server.models.hex;

import server.exceptions.pointsNotClose;

public class PointsLinesController {
    static void connectPoints(HexPoint leftPoint, HexPoint rightPoint, HexLine line) {
        leftPoint.addLine(line);
        rightPoint.addLine(line);
        line.addPoint(leftPoint);
        line.addPoint(rightPoint);
    }

    static void connectLinePoint(HexLine line, HexPoint point) {
        point.addLine(line);
        line.addPoint(point);
    }

    public static HexLine getLineFromPoints(HexPoint point1, HexPoint point2) throws pointsNotClose {
        if (point1.getOtherPoint(point1.lines[0]) == point2) return point1.lines[0];
        else if (point1.getOtherPoint(point1.lines[1]) == point2) return point1.lines[1];
        else if (point1.getOtherPoint(point1.lines[2]) == point2) return point1.lines[2];
        else throw new pointsNotClose();
    }
}
