package models.building_model;

import models.hex.HexLine;
import models.hex.HexPoint;
import models.map.MapHexes;

class StartBuildingAI {
    //Obviously someday it won't be just an array of points to build in, but now it is
    private MapHexes map;
    private HexPoint[] points;
    private int currentPoint = 0;

    //array of points in "priority" order.
    StartBuildingAI(MapHexes map) {
        this.map = map;
        points = new HexPoint[12];
        points[0] = map.getTop1Left().getGeometry().getUpperLeftPoint();
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

    //So for now model will be running this until it works, but someday it will determine a point
    //without building and there will be no need to rerun it - it will know what it's doing
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

    //this is not a *real* game_model.AI method so RuntimeException is fine
    private void increaseCurrentPoint() {
        currentPoint++;
        if (getCurrentPoint() == null) throw new RuntimeException();
    }
}
