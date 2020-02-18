package game_model.hex;

import game_model.ResourcesSet;

public class Hex {
    HexPoint upPoint;
    HexPoint upperRightPoint;
    HexPoint lowerRightPoint;
    HexPoint lowPoint;
    HexPoint lowerLeftPoint;
    HexPoint upperLeftPoint;
    HexLine upperRightLine;
    HexLine middleRightLine;
    HexLine lowerRightLine;
    HexLine lowerLeftLine;
    HexLine middleLeftLine;
    HexLine upperLeftLine;
    private int frequency;

    public Hex(int frequency) {
        upPoint = new HexPoint();
        upperRightPoint = new HexPoint();
        lowerRightPoint = new HexPoint();
        lowPoint = new HexPoint();
        lowerLeftPoint = new HexPoint();
        upperLeftPoint = new HexPoint();
        upperRightLine = new HexLine();
        middleRightLine = new HexLine();
        lowerRightLine = new HexLine();
        lowerLeftLine = new HexLine();
        middleLeftLine = new HexLine();
        upperLeftLine = new HexLine();
        PointsLinesController.connectPoints(upPoint, upperRightPoint, upperRightLine);
        PointsLinesController.connectPoints(upperRightPoint, lowerRightPoint, middleRightLine);
        PointsLinesController.connectPoints(lowerRightPoint, lowPoint, lowerRightLine);
        PointsLinesController.connectPoints(lowerLeftPoint, lowPoint, lowerLeftLine);
        PointsLinesController.connectPoints(upperLeftPoint, lowerLeftPoint, middleLeftLine);
        PointsLinesController.connectPoints(upperLeftPoint, upPoint, upperLeftLine);
        this.frequency = frequency;
    }

    public ResourcesSet getResource() {
        return null;
    }

    public void printInfo() {
        System.out.println("Points of game_model.hex " + this + " are: ");
        System.out.println("upPoint - " + upPoint);
        upPoint.infoHasBuilding();
        System.out.println("upperRightPoint - " + upperRightPoint);
        upperRightPoint.infoHasBuilding();
        System.out.println("lowerRightPoint - " + lowerRightPoint);
        lowerRightPoint.infoHasBuilding();
        System.out.println("lowPoint - " + lowPoint);
        lowPoint.infoHasBuilding();
        System.out.println("lowerLeftPoint - " + lowerLeftPoint);
        lowerLeftPoint.infoHasBuilding();
        System.out.println("upperLeftPoint - " + upperLeftPoint);
        upperLeftPoint.infoHasBuilding();
        System.out.println();
        System.out.println("Lines of game_model.map " + this + " are: ");
        System.out.println("upperRightLine - " + upperRightLine);
        System.out.println("middleRightLine - " + middleRightLine);
        System.out.println("lowerRightLine - " + lowerRightLine);
        System.out.println("lowerLeftLine - " + lowerLeftLine);
        System.out.println("middleLeftLine - " + middleLeftLine);
        System.out.println("upperLeftLine - " + upperLeftLine);
        System.out.println();
        System.out.println("Now about every point and line in particular...");
        System.out.println("Lines of upPoint - " + upPoint.lines[0] + ", " + upPoint.lines[1] + ", " + upPoint.lines[2]);
        System.out.println("Lines of upperRightPoint - " + upperRightPoint.lines[0] + ", " + upperRightPoint.lines[1] + ", " + upperRightPoint.lines[2]);
        System.out.println("Lines of lowerRightPoint - " + lowerRightPoint.lines[0] + ", " + lowerRightPoint.lines[1] + ", " + lowerRightPoint.lines[2]);
        System.out.println("Lines of lowPoint - " + lowPoint.lines[0] + ", " + lowPoint.lines[1] + ", " + lowPoint.lines[2]);
        System.out.println("Lines of lowerLeftPoint - " + lowerLeftPoint.lines[0] + ", " + lowerLeftPoint.lines[1] + ", " + lowerLeftPoint.lines[2]);
        System.out.println("Lines of upperLeftPoint - " + upperLeftPoint.lines[0] + ", " + upperLeftPoint.lines[1] + ", " + upperLeftPoint.lines[2]);
        System.out.println();
        System.out.println("Points of upperRightLine - " + upperRightLine.points[0] + ", " + upperRightLine.points[1]);
        System.out.println("Points of middleRightLine - " + middleRightLine.points[0] + ", " + middleRightLine.points[1]);
        System.out.println("Points of lowerRightLine - " + lowerRightLine.points[0] + ", " + lowerRightLine.points[1]);
        System.out.println("Points of lowerLeftLine - " + lowerLeftLine.points[0] + ", " + lowerLeftLine.points[1]);
        System.out.println("Points of middleLeftLine - " + middleLeftLine.points[0] + ", " + middleLeftLine.points[1]);
        System.out.println("Points of upperLeftLine - " + upperLeftLine.points[0] + ", " + upperLeftLine.points[1]);
        System.out.println();
    }

    public HexPoint getUpPoint() { return upPoint; }
    public HexPoint getUpperRightPoint() { return upperRightPoint; }
    public HexPoint getLowerRightPoint() { return lowerRightPoint; }
    public HexPoint getLowPoint() { return lowPoint; }
    public HexPoint getLowerLeftPoint() { return lowerLeftPoint; }
    public HexPoint getUpperLeftPoint() { return upperLeftPoint; }

    public HexLine getUpperRightLine() { return upperRightLine; }
    public HexLine getMiddleRightLine() { return middleRightLine;}
    public HexLine getLowerRightLine() { return lowerRightLine; }
    public HexLine getLowerLeftLine() { return lowerLeftLine; }
    public HexLine getMiddleLeftLine() { return middleLeftLine; }
    public HexLine getUpperLeftLine() { return upperLeftLine; }
}
