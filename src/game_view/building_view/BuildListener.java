package game_view.building_view;

import game_view.graphics.MapPanel;
import javax.swing.event.MouseInputAdapter;
import java.awt.Point;
import java.awt.event.MouseEvent;
import static java.lang.Math.abs;

public class BuildListener extends MouseInputAdapter {
    private Point pressedPoint, releasedPoint;
    private int pressedX, pressedY, releasedX, releasedY;

    BuildListener(MapPanel mapPanel) {
        super();
    }

    public void mousePressed(MouseEvent e)
    {
        pressedPoint = e.getPoint();
        pressedX = pressedPoint.x;
        pressedY = pressedPoint.y;
    }

    public void mouseReleased(MouseEvent e)
    {
        releasedPoint = e.getPoint();
        releasedX = releasedPoint.x;
        releasedY = releasedPoint.y;
//        if ((abs(releasedX - pressedX) < 15) && (abs(releasedY - pressedY) < 15)) {
//            try {
//                drawingArea.getBuildingGuiListenerManager().requestBuildingOnPoint(humanPlayer, releasedX, releasedY);
//            } catch (buildingException buildingException) {
//                handleBuildingException(buildingException);
//            }
//        }
//        else try {
//            drawingArea.getBuildingGuiListenerManager().requestRoadBuilding(humanPlayer, pressedX, pressedY, releasedX, releasedY);
//        } catch (buildingException buildingException) {
//            handleBuildingException(buildingException);
//        }
    }
}