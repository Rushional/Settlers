package client.views.inputs.listeners;

import client.exceptions.PointNotInHex;
import client.exceptions.wrongPointCoordinates;
import client.exceptions.wrongRoadCoordinates;
import client.models.hex.Hex;
import client.models.hex.HexLine;
import client.models.hex.HexPoint;
import client.models.map.MapHexes;
import client.views.Constants;
import client.views.frame.MapPanel;
import client.views.graphics.MapView;
import client.views.inputs.intentions.ViewIntention;
import client.views.inputs.intentions.ViewIntentionNone;

import java.awt.*;

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
    public HexPoint getStartPoint() throws wrongPointCoordinates {
        ClickCoordinates clickCoordinates = inputBuildCoordinates();
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

    public HexLine getStartLine() throws wrongRoadCoordinates {
        ClickCoordinates clickCoordinates = inputBuildCoordinates();
        return CoordinatesProcessor.coordinatesToHexLine(clickCoordinates, map);
    }

//    this sends requests, then we have to wait for the result and get it back separately
//    This is because we have to wait for 2 listeners at the same time, so waiting here is not an option:
//    It would stop the second listener from ever activating
    public void requestTurnIntention(Object monitor) {
        currentBuildListener = new BuildListener(monitor);
        mapPanel.addMapListener(monitor, currentBuildListener);
    }

    public ViewIntention getIntentionInputFromListener() {
        mapPanel.removeMapListener();
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

    public Hex getRobberHex(MapView mapView) throws PointNotInHex {
        var monitor = new Object();
        MoveRobberListener moveRobberListener = new MoveRobberListener(monitor, mapPanel);
        mapPanel.addMapListener(monitor, moveRobberListener);
        mapPanel.addMouseMotionListener(moveRobberListener);
        waitForAction(monitor);
        mapPanel.removeMouseListener(moveRobberListener);
        mapPanel.removeMouseMotionListener(moveRobberListener);
        return CoordinatesProcessor.coordinatesToHex(mapView, moveRobberListener.getClickCoordinates().getReleased());
    }

    private ClickCoordinates inputBuildCoordinates() {
        var monitor = new Object();
        BuildListener buildListener = new BuildListener(monitor);
        mapPanel.addMapListener(monitor, buildListener);
        waitForAction(monitor);
        mapPanel.removeMouseListener(buildListener);
        return buildListener.getClickCoordinates();
    }
}
