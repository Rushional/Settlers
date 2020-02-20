package game_view.building_view;

import exceptions.wrongPointCoordinates;
import exceptions.wrongRoadCoordinates;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;
import game_model.hex.PointsLinesController;
import game_model.map.MapHexes;
import game_view.TurnsView;
import game_view.graphics.*;

import java.util.concurrent.CountDownLatch;

class PointsLinesGetter {
    private BuildingGraphicsManager graphicsManager;
    private MapHexes map;
    private int mapLocationX, mapLocationY;
    private final static int pointDetectionRadius = 15;
    private int x1,y1,x2,y2;

    PointsLinesGetter(BuildingGraphicsManager graphicsManager,
                             MapHexes map, BuildingExceptionHandler buildingExceptionHandler) {
        this.graphicsManager = graphicsManager;
        this.map = map;
        this.mapLocationX = graphicsManager.getMapLocationX();
        this.mapLocationY = graphicsManager.getMapLocationY();
    }

    HexPoint getPoint() throws wrongPointCoordinates {
        graphicsManager.activateStartSettlementListener(this);
        //TO DO add an algorithm that checks if the user has tried to build a road with those points
        if (x2-x1 > pointDetectionRadius || y2 - y1 > pointDetectionRadius) throw new wrongPointCoordinates();
        HexPoint point = pointByCoordinates(x2, y2);
        x1 = y1 = x2 = y2 = -100;
        return point;
    }

    HexLine getLine() throws wrongRoadCoordinates {
        boolean awaitingLine = true;
        HexLine line = null;
        while (awaitingLine) {
            graphicsManager.activateStartRoadListener(this);
            line = lineByCoordinates(x1, y1, x2, y2);
            awaitingLine = false;
        }
        x1 = -100;
        y1 = -100;
        x2 = -100;
        y2 = -100;
        return line;
    }

    void waitForIntention(TurnsView turnsView, CountDownLatch latch) {
        graphicsManager.activateTurnListener(this, turnsView,latch);
    }

    void assignIntentionCoordinates(TurnsView turnsView, CountDownLatch latch, int[] coordinates) {
        turnsView.setIntention(intentionByCoordinates(coordinates));
        latch.countDown();
    }

    //TO DO refactor to int[] coordinates
    void assignCoordinates(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    private ViewIntention intentionByCoordinates(int[] coordinates) {
        if (coordinates[2]-coordinates[0] <= pointDetectionRadius && coordinates[3] - coordinates[1] <= pointDetectionRadius) {
            try {
                return new ViewIntentionBuildOnPoint(pointByCoordinates(coordinates[2], coordinates[3]));
            } catch (wrongPointCoordinates wrongPoint) {
                return new ViewIntentionWrongPoint();
            }
        }
        else try {
            return new ViewIntentionBuildRoad(lineByCoordinates(coordinates[0], coordinates[1], coordinates[2], coordinates[3]));
        } catch (wrongRoadCoordinates wrongLine) {
            return new ViewIntentionWrongLine();
        }
    }

    private HexPoint pointByCoordinates(int x, int y) throws wrongPointCoordinates{
        x -= mapLocationX;
        y -= mapLocationY;
        if ((x > -192 - pointDetectionRadius) && (x < -192 + pointDetectionRadius)) {
            if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddleLeft().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddleLeft().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > -128 - pointDetectionRadius) && (x < -128 + pointDetectionRadius)) {
            if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop2Left().getUpperLeftPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getTop2Left().getLowerLeftPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getBottom1Left().getUpperLeftPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom1Left().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > -64 - pointDetectionRadius) && (x < -64 + pointDetectionRadius)) {
            if ((y > 32 - pointDetectionRadius) && (y < 32 + pointDetectionRadius)) {
                return map.getTop1Left().getUpperLeftPoint();
            }
            else if ((y > 106 - pointDetectionRadius) && (y < 106 + pointDetectionRadius)) {
                return map.getTop1Left().getLowerLeftPoint();
            }
            else if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddle2().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddle2().getLowerLeftPoint();
            }
            else if ((y > 456 - pointDetectionRadius) && (y < 456 + pointDetectionRadius)) {
                return map.getBottom2Left().getUpperLeftPoint();
            }
            else if ((y > 530 - pointDetectionRadius) && (y < 530 + pointDetectionRadius)) {
                return map.getBottom2Left().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 0 - pointDetectionRadius) && (x < 0 + pointDetectionRadius)) {
            if ((y > 0 - pointDetectionRadius) && (y < 0 + pointDetectionRadius)) {
                return map.getTop1Left().getUpPoint();
            }
            else if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop1Left().getLowPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getMiddle2().getUpPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getMiddle2().getLowPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom2Left().getUpPoint();
            }
            else if ((y > 562 - pointDetectionRadius) && (y < 562 + pointDetectionRadius)) {
                return map.getBottom2Left().getLowPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 64 - pointDetectionRadius) && (x < 64 + pointDetectionRadius)) {
            if ((y > 32 - pointDetectionRadius) && (y < 32 + pointDetectionRadius)) {
                return map.getTop1Middle().getUpperLeftPoint();
            }
            else if ((y > 106 - pointDetectionRadius) && (y < 106 + pointDetectionRadius)) {
                return map.getTop1Middle().getLowerLeftPoint();
            }
            else if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddle3().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddle3().getLowerLeftPoint();
            }
            else if ((y > 456 - pointDetectionRadius) && (y < 456 + pointDetectionRadius)) {
                return map.getBottom2Middle().getUpperLeftPoint();
            }
            else if ((y > 530 - pointDetectionRadius) && (y < 530 + pointDetectionRadius)) {
                return map.getBottom2Middle().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 128 - pointDetectionRadius) && (x < 128 + pointDetectionRadius)) {
            if ((y > 0 - pointDetectionRadius) && (y < 0 + pointDetectionRadius)) {
                return map.getTop1Middle().getUpPoint();
            }
            else if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop1Middle().getLowPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getMiddle3().getUpPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getMiddle3().getLowPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom2Middle().getUpPoint();
            }
            else if ((y > 562 - pointDetectionRadius) && (y < 562 + pointDetectionRadius)) {
                return map.getBottom2Middle().getLowPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 192 - pointDetectionRadius) && (x < 192 + pointDetectionRadius)) {
            if ((y > 32 - pointDetectionRadius) && (y < 32 + pointDetectionRadius)) {
                return map.getTop1Right().getUpperLeftPoint();
            }
            else if ((y > 106 - pointDetectionRadius) && (y < 106 + pointDetectionRadius)) {
                return map.getTop1Right().getLowerLeftPoint();
            }
            else if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddle4().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddle4().getLowerLeftPoint();
            }
            else if ((y > 456 - pointDetectionRadius) && (y < 456 + pointDetectionRadius)) {
                return map.getBottom2Right().getUpperLeftPoint();
            }
            else if ((y > 530 - pointDetectionRadius) && (y < 530 + pointDetectionRadius)) {
                return map.getBottom2Right().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 256 - pointDetectionRadius) && (x < 256 + pointDetectionRadius)) {
            if ((y > 0 - pointDetectionRadius) && (y < 0 + pointDetectionRadius)) {
                return map.getTop1Right().getUpPoint();
            }
            else if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop1Right().getLowPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getMiddle4().getUpPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getMiddle4().getLowPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom2Right().getUpPoint();
            }
            else if ((y > 562 - pointDetectionRadius) && (y < 562 + pointDetectionRadius)) {
                return map.getBottom2Right().getLowPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 320 - pointDetectionRadius) && (x < 320 + pointDetectionRadius)) {
            if ((y > 32 - pointDetectionRadius) && (y < 32 + pointDetectionRadius)) {
                return map.getTop1Right().getUpperRightPoint();
            }
            else if ((y > 106 - pointDetectionRadius) && (y < 106 + pointDetectionRadius)) {
                return map.getTop1Right().getLowerRightPoint();
            }
            else if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddleRight().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddleRight().getLowerLeftPoint();
            }
            else if ((y > 456 - pointDetectionRadius) && (y < 456 + pointDetectionRadius)) {
                return map.getBottom2Right().getUpperRightPoint();
            }
            else if ((y > 530 - pointDetectionRadius) && (y < 530 + pointDetectionRadius)) {
                return map.getBottom2Right().getLowerRightPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 384 - pointDetectionRadius) && (x < 384 + pointDetectionRadius)) {
            if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop2Right().getUpperRightPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getTop2Right().getLowerRightPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getBottom1Right().getUpperRightPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom1Right().getLowerRightPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 448 - pointDetectionRadius) && (x < 448 + pointDetectionRadius)) {
            if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddleRight().getUpperRightPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddleRight().getLowerRightPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else throw new wrongPointCoordinates();
    }

    private HexLine lineByCoordinates(int x1, int y1, int x2, int y2) throws wrongRoadCoordinates {
        HexPoint point1, point2;
        try {
            point1 = pointByCoordinates(x1, y1);
            point2 = pointByCoordinates(x2, y2);
        } catch (wrongPointCoordinates wrongPointCoordinates) {
            throw new wrongRoadCoordinates();
        }
        HexLine line;
        try {
            line = PointsLinesController.getLineFromPoints(point1, point2);
        } catch (exceptions.pointsNotClose pointsNotClose) {
            //TO DO make new exception points not close
            throw new wrongRoadCoordinates();
        }
        return line;
    }
}
