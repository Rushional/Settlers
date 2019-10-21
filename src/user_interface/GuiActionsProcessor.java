package user_interface;

import building.*;
import exceptions.*;
import graphics.DrawingArea;
import hex.HexLine;
import hex.HexPoint;
import hex.PointsLinesController;
import interactions.*;
import map.MapHexes;

import java.util.concurrent.CountDownLatch;

//This class takes interface actions and creates game actions
public class GuiActionsProcessor {
    private MapHexes map;
    private int mapLocationX, mapLocationY;
    private final static int pointDetectionRadius = 15;
    private DrawingArea drawingArea;

    public GuiActionsProcessor(MapHexes map, DrawingArea drawingArea, int mapLocationX, int mapLocationY) {
        this.map = map;
        this.drawingArea = drawingArea;
        this.mapLocationX = mapLocationX;
        this.mapLocationY = mapLocationY;
    }

    public void activateStartSettlementListener(StartBuildingManager startBuildingManager) {
        CountDownLatch startSettlementLatch = new CountDownLatch(1);
        StartSettlementListener startSettlementListener = new
                StartSettlementListener(drawingArea, startSettlementLatch, startBuildingManager);
        drawingArea.replaceListener(startSettlementListener);
        try {
            startSettlementLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void activateStartRoadListener(HexPoint point, StartBuildingManager startBuildingManager) {
        CountDownLatch startRoadLatch = new CountDownLatch(1);
        StartRoadListener startRoadListener = new StartRoadListener(drawingArea, startRoadLatch, point, startBuildingManager);
        drawingArea.replaceListener(startRoadListener);
        try
        {
            startRoadLatch.await();
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        drawingArea.removeMouseListener(startRoadListener);
    }

    public void requestRoadBuilding(Player player, int x1, int y1, int x2, int y2) throws buildingException
    {
        HexLine line = lineByCoordinates(x1, y1, x2, y2);
        BuildRoad buildRoad = new BuildRoad(player, line);
        buildRoad.build();
        drawingArea.repaint();
    }

    public void requestStartRoadBuilding(Player player, HexPoint point, int x1, int y1, int x2, int y2) throws buildingException
    {
        HexLine line = lineByCoordinates(x1, y1, x2, y2);
        if (!line.checkHasPoint(point)) throw new lineHasNoPoint();
        StartBuildRoad startBuildRoad = new StartBuildRoad(player, line, point);
        startBuildRoad.build();
        drawingArea.repaint();
    }

    public void requestBuildingOnPoint(Player player, int x, int y) throws buildingException
    {
        HexPoint point = pointByCoordinates(x, y);
        BuildOnPoint buildOnPoint = new BuildOnPoint(player, point);
        buildOnPoint.build();
        drawingArea.repaint();
    }

    public void requestStartSettlementBuilding(Player player, StartBuildingManager startBuildingManager, int x, int y) throws wrongPointCoordinates, buildingNearby, pointHasSettlement
    {
        HexPoint point = pointByCoordinates(x, y);
        StartBuildSettlement startBuildSettlement = new StartBuildSettlement(player, point);
        startBuildSettlement.build();
        drawingArea.repaint();
        startBuildingManager.assignPoint(point);
        //building.StartBuildingManager.assignPoint(point)
    }

    public void activateTurnListener() {
        drawingArea.replaceListener(new BuildListener(drawingArea));
    }
    public DrawingArea getDrawingArea() {
        return drawingArea;
    }

    public void handleTurnExceptions(buildingException buildingException) {
        if (buildingException.getClass() == wrongPointCoordinates.class) System.out.println("Здесь нет точки");
        if (buildingException.getClass() == buildingNearby.class) System.out.println("Рядом уже есть поселение");
        if (buildingException.getClass() == noRoadsNearby.class) System.out.println("Рядом нет дорог");
        if (buildingException.getClass() == pointHasSettlement.class) System.out.println("В этом месте уже есть чужое поселение:(");
        if (buildingException.getClass() == cityBuiltAlready.class) System.out.println("В этом месте уже есть город");
        if (buildingException.getClass() == notEnoughForSettlement.class) System.out.println("Недостаточно ресурсов на поселение:(");
        if (buildingException.getClass() == maximumSettlementsAlready.class) System.out.println("Достигнут лимит количества поселений:(");
        if (buildingException.getClass() == notEnoughForCity.class) System.out.println("Недостаточно ресурсов на город:(");
        if (buildingException.getClass() == maximumCitiesAlready.class) System.out.println("Достигнут лимит количества городов:(");
        //road exceptions
        if (buildingException.getClass() == wrongRoadCoordinates.class) System.out.println("Проведите линию между двумя точками, чтобы построить дорогу");
        if (buildingException.getClass() == lineHasRoad.class) System.out.println("В этом месте уже есть дорога");
        if (buildingException.getClass() == roadHasNoAccess.class) System.out.println("Это место ещё не колонизировано");
        if (buildingException.getClass() == opponentsSettlementOnWay.class) System.out.println("На пути поселение другого игрока");
        if (buildingException.getClass() == opponentsCityOnWay.class) System.out.println("На пути город другого игрока");
    }

    public void handleStartSettlementExceptions(buildingException buildingException) {
        if (buildingException.getClass() == wrongPointCoordinates.class) System.out.println("Здесь нет точки");
        if (buildingException.getClass() == buildingNearby.class) System.out.println("Рядом уже есть поселение");
        if (buildingException.getClass() == pointHasSettlement.class) System.out.println("В этом месте уже есть поселение");
    }

    public void handleStartRoadExceptions(buildingException buildingException) {
        if (buildingException.getClass() == wrongRoadCoordinates.class) System.out.println("Проведите линию между двумя точками, чтобы построить дорогу");
        if (buildingException.getClass() == lineHasRoad.class) System.out.println("В этом месте уже есть дорога");
        if (buildingException.getClass() == lineHasNoPoint.class) System.out.println("Дорогу нужно построить рядом с новым поселением");
    }

    public void repaint() {
        drawingArea.repaint();
    }

    protected HexPoint pointByCoordinates(int x, int y) throws wrongPointCoordinates {
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

    public HexLine lineByCoordinates(int x1, int y1, int x2, int y2) throws wrongRoadCoordinates {
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
        } catch (pointsNotClose pointsNotClose) {
            throw new wrongRoadCoordinates();
        }
        return line;
    }
}
