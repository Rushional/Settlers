package AI;

import game_model.hex.HexPoint;
import game_model.Player;
import game_model.building_model.StartBuildRoad;
import game_model.building_model.StartBuildSettlement;
import game_model.map.MapHexes;
import exceptions.*;

public class StartBuildingAI {
    //Obviously someday it won't be just an array of points to build in, but now it is
    private MapHexes map;
    private HexPoint[] points;
    private int currentPoint = 0;

    //array of points in "priority" order.
    public StartBuildingAI(MapHexes map) {
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

    public void startBuildPoint(Player player) {
        HexPoint point = null;
        boolean settlementBuilt = false;
        while (!settlementBuilt) {
            try {
                StartBuildSettlement startBuildSettlement = new StartBuildSettlement(player, getCurrentPoint());
                startBuildSettlement.build();
                point = getCurrentPoint();
                increaseCurrentPoint();
                settlementBuilt = true;
            } catch (buildingNearby | pointHasSettlement failedToBuild) {
                increaseCurrentPoint();
            }
        }
        //this is really stupid...
        StartBuildRoad startBuildRoad = new StartBuildRoad(player, point.getLine(0), point);
        try {
            startBuildRoad.build();
        } catch (lineHasNoPoint lineHasNoPoint) {
            throw new RuntimeException();
        }
    }

    private HexPoint getCurrentPoint() {
        return points[currentPoint];
    }

    //this is not a *real* AI method so RuntimeException is probably fine
    private void increaseCurrentPoint() {
        currentPoint++;
        if (getCurrentPoint() == null) throw new RuntimeException();
    }
}
