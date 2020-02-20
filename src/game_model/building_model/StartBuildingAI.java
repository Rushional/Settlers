package game_model.building_model;

import game_model.hex.HexLine;
import game_model.hex.HexPoint;
import game_model.map.MapHexes;

class StartBuildingAI {
    //Obviously someday it won't be just an array of points to build in, but now it is
    private MapHexes map;
    private HexPoint[] points;
    private int currentPoint = 0;

    //array of points in "priority" order.
    StartBuildingAI(MapHexes map) {
        this.map = map;
        points = new HexPoint[12];
        points[0] = map.getTop1Left().getUpperLeftPoint();
        points[1] = map.getTop2Left().getUpperLeftPoint();
        points[2] = map.getMiddleLeft().getUpperLeftPoint();
        points[3] = map.getMiddleLeft().getLowPoint();
        points[4] = map.getMiddle2().getLowPoint();
        points[5] = map.getMiddle2().getUpperLeftPoint();
        points[6] = map.getTop2Middle2().getUpperLeftPoint();
        points[7] = map.getTop1Middle().getUpperLeftPoint();
        points[8] = map.getBottom1Left().getLowPoint();
        points[9] = map.getBottom2Left().getLowPoint();
        points[10] = map.getBottom2Middle().getLowPoint();
        points[11] = map.getBottom1Middle2().getLowPoint();
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
