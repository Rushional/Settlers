package controllers.starting_stage;

import exceptions.buildingException;
import models.building_model.StartBuildingModel;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.map.MapHexes;
import views.GameView;

class StubStartingBuilder extends StartingBuilder {
    private HexPoint[] points;
    private int currentPoint = 0;

    StubStartingBuilder(StartBuildingModel model, GameView view, MapHexes map) {
        super(model, view);
        points = new HexPoint[20];
//        These 8 are sort of optimal points for the standard map
        points[0] = map.getMiddleLeft().getGeometry().getLowerRightPoint();
        points[1] = map.getBottom1Left().getGeometry().getLowerRightPoint();
        points[2] = map.getBottom2Left().getGeometry().getLowerRightPoint();
        points[3] = map.getTop2Left().getGeometry().getLowerRightPoint();
        points[4] = map.getTop1Left().getGeometry().getLowerRightPoint();
        points[5] = map.getTop2Middle3().getGeometry().getLowerRightPoint();
        points[6] = map.getTop1Right().getGeometry().getLowerRightPoint();
        points[7] = map.getTop1Middle().getGeometry().getLowerRightPoint();
        points[8] = map.getTop1Right().getGeometry().getLowPoint();
//        Just random points in the left part of the map. Probably most of them are taken already
//        But I just don't want to bother removing these, maybe some of them might be useful
        points[9] = map.getTop2Left().getGeometry().getUpperLeftPoint();
        points[10] = map.getMiddleLeft().getGeometry().getUpperLeftPoint();
        points[11] = map.getMiddleLeft().getGeometry().getLowPoint();
        points[12] = map.getMiddle2().getGeometry().getLowPoint();
        points[13] = map.getMiddle2().getGeometry().getUpperLeftPoint();
        points[14] = map.getTop2Middle2().getGeometry().getUpperLeftPoint();
        points[15] = map.getTop1Middle().getGeometry().getUpperLeftPoint();
        points[16] = map.getBottom1Left().getGeometry().getLowPoint();
        points[17] = map.getBottom2Left().getGeometry().getLowPoint();
        points[18] = map.getBottom2Middle().getGeometry().getLowPoint();
        points[19] = map.getBottom1Middle2().getGeometry().getLowPoint();
    }

    HexPoint buildStartingSettlement() {
        boolean buildSuccessful = false;
        HexPoint settlementPoint = null;
        while (!buildSuccessful) {
            settlementPoint = chooseStartPoint();
            try {
                model.startBuildSettlement(settlementPoint);
                buildSuccessful = true;
            } catch (buildingException ignored) {}
        }
        return settlementPoint;
    }

    void buildStartingRoad(HexPoint settlementPoint) {
        try {
            model.startBuildRoad(chooseStartLine(settlementPoint), settlementPoint);
        } catch (buildingException e) {
            throw new RuntimeException(); //this probably won't ever happen
            //and also this is a stub so for now this is enough
        }
    }

    private HexPoint chooseStartPoint() {
        HexPoint point = getCurrentPoint();
        increaseCurrentPoint();
        return point;
    }

    private HexLine chooseStartLine(HexPoint point) {
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
