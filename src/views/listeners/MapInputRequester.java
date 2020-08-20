package views.listeners;

import exceptions.wrongPointCoordinates;
import exceptions.wrongRoadCoordinates;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.map.MapHexes;
import views.Constants;
import views.building_view.BuildListener;
import views.frame.MapPanel;

import java.awt.*;

// I haven't started using this class. I'm planning to refactor the process of getting input and start using this

// This class gets raw coordinates from the user
public class MapInputRequester extends InputRequester {
    private MapPanel mapPanel;
    private MapHexes map;
    private BuildListener currentBuildListener = null;

    public MapInputRequester(MapPanel mapPanel, MapHexes map) {
        this.mapPanel = mapPanel;
        this.map = map;
    }

//        manager turns on the listener and then waits for input
//        listener gets the input and saves it in his clickCoordinates field
//        manager accesses it and gets the coordinates,
//        processes them and sends back to the controller that called the manager in the first place
    public HexPoint inputStartPoint() throws wrongPointCoordinates {
        ClickCoordinates clickCoordinates = inputCoordinates();
//        TODO: add an algorithm that checks if the user has tried to build a road with those points
//         Although this is such a pointless detail that I really shouldn't bother
        Point pointPressed = clickCoordinates.getPressed();
        Point pointReleased = clickCoordinates.getReleased();
//        It's not about making sure that the click is in range.
//        It's about making sure that it was are click and not a mouse drag
//        And point radius works well for that purpose, so yeah, go me I guess
        if (pointReleased.x - pointPressed.x > Constants.pointClickDetectionRadius
                || pointReleased.y - pointPressed.y > Constants.pointClickDetectionRadius)
            throw new wrongPointCoordinates();
        return CoordinatesProcessor.coordinatesToHexPoint(pointReleased, map);
    }

    public HexLine inputStartLine() throws wrongRoadCoordinates {
        ClickCoordinates clickCoordinates = inputCoordinates();
        return CoordinatesProcessor.coordinatesToHexLine(clickCoordinates, map);
    }

    public void requestTurnIntention(Object monitor) {
        BuildListener buildListener = mapPanel.addBuildListener(monitor);
        currentBuildListener = buildListener;
    }

    public ViewIntention getIntentionInputFromListener() {
        mapPanel.removeMouseListener(currentBuildListener);
        ClickCoordinates clickCoordinates = currentBuildListener.getClickCoordinates();
        ViewIntention intention;
        if (clickCoordinates == null) {
            intention = new ViewIntentionNone();
        }
        else {
            intention = CoordinatesProcessor.coordinatesToIntention(clickCoordinates, map);
        }
        return intention;
    }

    private ClickCoordinates inputCoordinates() {
        var monitor = new Object();
        BuildListener buildListener = mapPanel.addBuildListener(monitor);
        waitForAction(monitor);
        mapPanel.removeMouseListener(buildListener);
        return buildListener.getClickCoordinates();
    }
}
