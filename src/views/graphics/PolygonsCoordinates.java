package views.graphics;

import views.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PolygonsCoordinates {
    private List<Point> coordinatesList;
    private Point top1Left;
    private Point top1Middle;
    private Point top1Right;
    private Point top2Left;
    private Point top2Middle2;
    private Point top2Middle3;
    private Point top2Right;
    private Point middleLeft;
    private Point middle2;
    private Point middle3;
    private Point middle4;
    private Point middleRight;
    private Point bottom1Left;
    private Point bottom1Middle2;
    private Point bottom1Middle3;
    private Point bottom1Right;
    private Point bottom2Left;
    private Point bottom2Middle;
    private Point bottom2Right;

    public PolygonsCoordinates() {
        int initX = Constants.mapLocationOnCanvas.x;
        int initY = Constants.mapLocationOnCanvas.y;
        coordinatesList = new ArrayList<>();
        top1Left = new Point(initX, initY);
        coordinatesList.add(top1Left);
        top1Middle = new Point(initX + 128, initY);
        coordinatesList.add(top1Middle);
        top1Right = new Point(initX + 256, initY);
        coordinatesList.add(top1Right);
        top2Left = new Point(initX - 64, initY + 106);
        coordinatesList.add(top2Left);
        top2Middle2 = new Point(initX + 64, initY + 106);
        coordinatesList.add(top2Middle2);
        top2Middle3 = new Point(initX + 192, initY + 106);
        coordinatesList.add(top2Middle3);
        top2Right = new Point(initX + 320, initY + 106);
        coordinatesList.add(top2Right);
        middleLeft = new Point(initX - 128, initY + 212);
        coordinatesList.add(middleLeft);
        middle2 = new Point(initX, initY + 212);
        coordinatesList.add(middle2);
        middle3 = new Point(initX + 128, initY + 212);
        coordinatesList.add(middle3);
        middle4 = new Point(initX + 256, initY + 212);
        coordinatesList.add(middle4);
        middleRight = new Point(initX + 384, initY + 212);
        coordinatesList.add(middleRight);
        bottom1Left = new Point(initX - 64, initY + 318);
        coordinatesList.add(bottom1Left);
        bottom1Middle2 = new Point(initX + 64, initY + 318);
        coordinatesList.add(bottom1Middle2);
        bottom1Middle3 = new Point(initX + 192, initY + 318);
        coordinatesList.add(bottom1Middle3);
        bottom1Right = new Point(initX + 320, initY + 318);
        coordinatesList.add(bottom1Right);
        bottom2Left = new Point(initX, initY + 424);
        coordinatesList.add(bottom2Left);
        bottom2Middle = new Point(initX + 128, initY + 424);
        coordinatesList.add(bottom2Middle);
        bottom2Right = new Point(initX + 256, initY + 424);
        coordinatesList.add(bottom2Right);
    }

    public List<Point> list() {
        return coordinatesList;
    }

    public Point getTop1Left() {
        return top1Left;
    }

    public Point getTop1Middle() {
        return top1Middle;
    }

    public Point getTop1Right() {
        return top1Right;
    }

    public Point getTop2Left() {
        return top2Left;
    }

    public Point getTop2Middle2() {
        return top2Middle2;
    }

    public Point getTop2Middle3() {
        return top2Middle3;
    }

    public Point getTop2Right() {
        return top2Right;
    }

    public Point getMiddleLeft() {
        return middleLeft;
    }

    public Point getMiddle2() {
        return middle2;
    }

    public Point getMiddle3() {
        return middle3;
    }

    public Point getMiddle4() {
        return middle4;
    }

    public Point getMiddleRight() {
        return middleRight;
    }

    public Point getBottom1Left() {
        return bottom1Left;
    }

    public Point getBottom1Middle2() {
        return bottom1Middle2;
    }

    public Point getBottom1Middle3() {
        return bottom1Middle3;
    }

    public Point getBottom1Right() {
        return bottom1Right;
    }

    public Point getBottom2Left() {
        return bottom2Left;
    }

    public Point getBottom2Middle() {
        return bottom2Middle;
    }

    public Point getBottom2Right() {
        return bottom2Right;
    }
}

