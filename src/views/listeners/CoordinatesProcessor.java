package views.listeners;

import exceptions.wrongPointCoordinates;
import exceptions.wrongRoadCoordinates;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.hex.PointsLinesController;
import models.map.MapHexes;
import views.Constants;

import java.awt.*;

import static java.lang.Math.abs;

public class CoordinatesProcessor {

//    I have a feeling I might be able to shorten this method juuuust a little bit by making some kind of
//    coordinates list and then going through the list in a cycle with the same method and different coordinates
    public static HexPoint coordinatesToHexPoint(Point pointCoordinates, MapHexes map) throws wrongPointCoordinates {
        int x = pointCoordinates.x - Constants.mapLocationOnCanvas.x;
        int y = pointCoordinates.y - Constants.mapLocationOnCanvas.y;
        int pointDetectionRadius = Constants.pointClickDetectionRadius;
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

    public static HexLine coordinatesToHexLine(ClickCoordinates coordinates, MapHexes map) throws wrongRoadCoordinates {
        HexPoint point1, point2;
        try {
            point1 = coordinatesToHexPoint(coordinates.getPressed(), map);
            point2 = coordinatesToHexPoint(coordinates.getReleased(), map);
        } catch (wrongPointCoordinates wrongPointCoordinates) {
            throw new wrongRoadCoordinates();
        }
        HexLine line;
        try {
            line = PointsLinesController.getLineFromPoints(point1, point2);
        } catch (exceptions.pointsNotClose pointsNotClose) {
            //TO DO make new exception class: points not close
            throw new wrongRoadCoordinates();
        }
        return line;
    }

    public static ViewIntention coordinatesToIntention(ClickCoordinates coordinates, MapHexes map) {
        if (abs(coordinates.getReleased().x - coordinates.getPressed().x) <= Constants.pointClickDetectionRadius &&
                abs(coordinates.getReleased().y - coordinates.getPressed().y) <= Constants.pointClickDetectionRadius) {
            try {
                return new ViewIntentionBuildOnPoint(coordinatesToHexPoint(coordinates.getPressed(), map));
            } catch (wrongPointCoordinates wrongPoint) {
                return new ViewIntentionWrongPoint();
            }
        }
        else try {
            return new ViewIntentionBuildRoad(coordinatesToHexLine(coordinates, map));
        } catch (wrongRoadCoordinates wrongLine) {
            return new ViewIntentionWrongLine();
        }
    }
}
