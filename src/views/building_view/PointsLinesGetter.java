package views.building_view;

import exceptions.wrongPointCoordinates;
import exceptions.wrongRoadCoordinates;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.hex.PointsLinesController;
import models.map.MapHexes;
import views.TurnsView;
import views.graphics.*;
import static java.lang.Math.abs;

class PointsLinesGetter {
    private BuildingGraphicsManager graphicsManager;
    private MapHexes map;
    private int mapLocationX, mapLocationY;
    private final static int pointDetectionRadius = 15;
    private int x1,y1,x2,y2;

    PointsLinesGetter(BuildingGraphicsManager graphicsManager, MapHexes map) {
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

    void waitForIntention(TurnsView turnsView, Object monitor) {
        graphicsManager.activateTurnListener(this, turnsView, monitor);
    }

    void assignIntentionCoordinates(TurnsView turnsView, Object monitor, int[] coordinates) {
        turnsView.setIntention(intentionByCoordinates(coordinates));
        synchronized (monitor) {
            monitor.notify();
        }
    }

    //TO DO refactor to int[] coordinates
    void assignCoordinates(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    private ViewIntention intentionByCoordinates(int[] coordinates) {
        if (abs(coordinates[2]-coordinates[0]) <= pointDetectionRadius && abs(coordinates[3] - coordinates[1]) <= pointDetectionRadius) {
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
                return map.getMiddleLeft().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddleLeft().getGeometry().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > -128 - pointDetectionRadius) && (x < -128 + pointDetectionRadius)) {
            if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop2Left().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getTop2Left().getGeometry().getLowerLeftPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getBottom1Left().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom1Left().getGeometry().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > -64 - pointDetectionRadius) && (x < -64 + pointDetectionRadius)) {
            if ((y > 32 - pointDetectionRadius) && (y < 32 + pointDetectionRadius)) {
                return map.getTop1Left().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 106 - pointDetectionRadius) && (y < 106 + pointDetectionRadius)) {
                return map.getTop1Left().getGeometry().getLowerLeftPoint();
            }
            else if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddle2().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddle2().getGeometry().getLowerLeftPoint();
            }
            else if ((y > 456 - pointDetectionRadius) && (y < 456 + pointDetectionRadius)) {
                return map.getBottom2Left().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 530 - pointDetectionRadius) && (y < 530 + pointDetectionRadius)) {
                return map.getBottom2Left().getGeometry().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 0 - pointDetectionRadius) && (x < 0 + pointDetectionRadius)) {
            if ((y > 0 - pointDetectionRadius) && (y < 0 + pointDetectionRadius)) {
                return map.getTop1Left().getGeometry().getUpPoint();
            }
            else if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop1Left().getGeometry().getLowPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getMiddle2().getGeometry().getUpPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getMiddle2().getGeometry().getLowPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom2Left().getGeometry().getUpPoint();
            }
            else if ((y > 562 - pointDetectionRadius) && (y < 562 + pointDetectionRadius)) {
                return map.getBottom2Left().getGeometry().getLowPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 64 - pointDetectionRadius) && (x < 64 + pointDetectionRadius)) {
            if ((y > 32 - pointDetectionRadius) && (y < 32 + pointDetectionRadius)) {
                return map.getTop1Middle().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 106 - pointDetectionRadius) && (y < 106 + pointDetectionRadius)) {
                return map.getTop1Middle().getGeometry().getLowerLeftPoint();
            }
            else if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddle3().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddle3().getGeometry().getLowerLeftPoint();
            }
            else if ((y > 456 - pointDetectionRadius) && (y < 456 + pointDetectionRadius)) {
                return map.getBottom2Middle().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 530 - pointDetectionRadius) && (y < 530 + pointDetectionRadius)) {
                return map.getBottom2Middle().getGeometry().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 128 - pointDetectionRadius) && (x < 128 + pointDetectionRadius)) {
            if ((y > 0 - pointDetectionRadius) && (y < 0 + pointDetectionRadius)) {
                return map.getTop1Middle().getGeometry().getUpPoint();
            }
            else if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop1Middle().getGeometry().getLowPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getMiddle3().getGeometry().getUpPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getMiddle3().getGeometry().getLowPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom2Middle().getGeometry().getUpPoint();
            }
            else if ((y > 562 - pointDetectionRadius) && (y < 562 + pointDetectionRadius)) {
                return map.getBottom2Middle().getGeometry().getLowPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 192 - pointDetectionRadius) && (x < 192 + pointDetectionRadius)) {
            if ((y > 32 - pointDetectionRadius) && (y < 32 + pointDetectionRadius)) {
                return map.getTop1Right().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 106 - pointDetectionRadius) && (y < 106 + pointDetectionRadius)) {
                return map.getTop1Right().getGeometry().getLowerLeftPoint();
            }
            else if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddle4().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddle4().getGeometry().getLowerLeftPoint();
            }
            else if ((y > 456 - pointDetectionRadius) && (y < 456 + pointDetectionRadius)) {
                return map.getBottom2Right().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 530 - pointDetectionRadius) && (y < 530 + pointDetectionRadius)) {
                return map.getBottom2Right().getGeometry().getLowerLeftPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 256 - pointDetectionRadius) && (x < 256 + pointDetectionRadius)) {
            if ((y > 0 - pointDetectionRadius) && (y < 0 + pointDetectionRadius)) {
                return map.getTop1Right().getGeometry().getUpPoint();
            }
            else if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop1Right().getGeometry().getLowPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getMiddle4().getGeometry().getUpPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getMiddle4().getGeometry().getLowPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom2Right().getGeometry().getUpPoint();
            }
            else if ((y > 562 - pointDetectionRadius) && (y < 562 + pointDetectionRadius)) {
                return map.getBottom2Right().getGeometry().getLowPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 320 - pointDetectionRadius) && (x < 320 + pointDetectionRadius)) {
            if ((y > 32 - pointDetectionRadius) && (y < 32 + pointDetectionRadius)) {
                return map.getTop1Right().getGeometry().getUpperRightPoint();
            }
            else if ((y > 106 - pointDetectionRadius) && (y < 106 + pointDetectionRadius)) {
                return map.getTop1Right().getGeometry().getLowerRightPoint();
            }
            else if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddleRight().getGeometry().getUpperLeftPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddleRight().getGeometry().getLowerLeftPoint();
            }
            else if ((y > 456 - pointDetectionRadius) && (y < 456 + pointDetectionRadius)) {
                return map.getBottom2Right().getGeometry().getUpperRightPoint();
            }
            else if ((y > 530 - pointDetectionRadius) && (y < 530 + pointDetectionRadius)) {
                return map.getBottom2Right().getGeometry().getLowerRightPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 384 - pointDetectionRadius) && (x < 384 + pointDetectionRadius)) {
            if ((y > 138 - pointDetectionRadius) && (y < 138 + pointDetectionRadius)) {
                return map.getTop2Right().getGeometry().getUpperRightPoint();
            }
            else if ((y > 212 - pointDetectionRadius) && (y < 212 + pointDetectionRadius)) {
                return map.getTop2Right().getGeometry().getLowerRightPoint();
            }
            else if ((y > 350 - pointDetectionRadius) && (y < 350 + pointDetectionRadius)) {
                return map.getBottom1Right().getGeometry().getUpperRightPoint();
            }
            else if ((y > 424 - pointDetectionRadius) && (y < 424 + pointDetectionRadius)) {
                return map.getBottom1Right().getGeometry().getLowerRightPoint();
            }
            else throw new wrongPointCoordinates();
        }
        else if ((x > 448 - pointDetectionRadius) && (x < 448 + pointDetectionRadius)) {
            if ((y > 244 - pointDetectionRadius) && (y < 244 + pointDetectionRadius)) {
                return map.getMiddleRight().getGeometry().getUpperRightPoint();
            }
            else if ((y > 318 - pointDetectionRadius) && (y < 318 + pointDetectionRadius)) {
                return map.getMiddleRight().getGeometry().getLowerRightPoint();
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
