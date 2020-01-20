package building_interface;

import exceptions.*;
import graphics.DrawingArea;
import interactions.Player;

import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;

import static java.lang.Math.abs;

public class BuildListener extends MouseInputAdapter {
    private Point pressedPoint, releasedPoint;
    private int pressedX, pressedY, releasedX, releasedY;
    private DrawingArea drawingArea;
    private Player humanPlayer;

    BuildListener(DrawingArea drawingArea) {
        super();
        this.drawingArea = drawingArea;
        this.humanPlayer = drawingArea.getCurrentPlayer();
        if (!humanPlayer.isHuman()) throw new playerNotHuman();
    }

    public void mousePressed(MouseEvent e)
    {
        pressedPoint = e.getPoint();
        pressedX = pressedPoint.x;
        pressedY = pressedPoint.y;
    }

    //can replace drawingArea.getGuiActionsProcessor with actionsManager field
    // but for some reason it doesn't work
    // it becomes null somehow

    //TO DO make one superListener that does all the work. This way you don't have to repeat exceptions
    //and it would look better, I guess
    public void mouseReleased(MouseEvent e)
    {
        releasedPoint = e.getPoint();
        releasedX = releasedPoint.x;
        releasedY = releasedPoint.y;
        if ((abs(releasedX - pressedX) < 15) && (abs(releasedY - pressedY) < 15)) {
            try {
                drawingArea.getBuildingGuiActionsProcessor().requestBuildingOnPoint(humanPlayer, releasedX, releasedY);
            } catch (buildingException buildingException) {
                handleBuildingException(buildingException);
            }
        }
        else try {
            drawingArea.getBuildingGuiActionsProcessor().requestRoadBuilding(humanPlayer, pressedX, pressedY, releasedX, releasedY);
        } catch (buildingException buildingException) {
            handleBuildingException(buildingException);
        }
    }

    private void handleBuildingException(buildingException buildingException) {
        if (buildingException.getClass() == wrongPointCoordinates.class) System.out.println("Здесь нет точки");
        if (buildingException.getClass() == buildingNearby.class) System.out.println("Рядом уже есть поселение");
        if (buildingException.getClass() == noRoadsNearby.class) System.out.println("Это место ещё не колонизировано");
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
        if (buildingException.getClass() == notEnoughForRoad.class) System.out.println("Недостаточно ресурсов на дорогу:(");
    }
}