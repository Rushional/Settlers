package controllers;

import models.hex.HexLine;
import models.hex.HexPoint;
import models.map.MapHexes;

class StartBuildingInputMocker {
    private MapHexes map;
    private HexPoint[] points;
    private int currentPoint = 0;

    //array of points in "priority" order.
    StartBuildingInputMocker(MapHexes map) {
        this.map = map;
        points = new HexPoint[12];
        points[0] = map.getTop1Right().getGeometry().getLowPoint();
        points[1] = map.getTop2Left().getGeometry().getUpperLeftPoint();
        points[2] = map.getMiddleLeft().getGeometry().getUpperLeftPoint();
        points[3] = map.getMiddleLeft().getGeometry().getLowPoint();
        points[4] = map.getMiddle2().getGeometry().getLowPoint();
        points[5] = map.getMiddle2().getGeometry().getUpperLeftPoint();
        points[6] = map.getTop2Middle2().getGeometry().getUpperLeftPoint();
        points[7] = map.getTop1Middle().getGeometry().getUpperLeftPoint();
        points[8] = map.getBottom1Left().getGeometry().getLowPoint();
        points[9] = map.getBottom2Left().getGeometry().getLowPoint();
        points[10] = map.getBottom2Middle().getGeometry().getLowPoint();
        points[11] = map.getBottom1Middle2().getGeometry().getLowPoint();
    }

    HexPoint chooseStartPoint() {
        HexPoint point = getCurrentPoint();
        increaseCurrentPoint();
        return point;
    }

    HexLine chooseStartLine(HexPoint point) {
        return point.getLine(0);
    }

    private HexPoint getCurrentPoint() {
        return points[currentPoint];
    }

    //this is not a *real* method so RuntimeException is fine
    private void increaseCurrentPoint() {
        currentPoint++;
        if (getCurrentPoint() == null) throw new RuntimeException();
    }
}
