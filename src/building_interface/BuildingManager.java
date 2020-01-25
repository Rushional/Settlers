package building_interface;

import interactions.Player;

public class BuildingManager {
    private Player player;
    private BuildingGraphicsManager actionsProcessor;
    //TO DO add building AI
    private BuildingExceptionHandler buildingExceptionHandler;
    private PointsLinesGetter pointsLinesGetter;

    public void playTurn() {
        //add TurnListener that will call building methods from this class
    }

    public void RequestSettlement() {

    }

    public void RequestRoad() {

    }

//    void requestRoadBuilding(Player player, HexLine line) throws buildingException
//    {
//        //And also add PointsLinesGetter here
//        BuildRoad buildRoad = new BuildRoad(player, line);
//        buildRoad.build();
//        actionsProcessor.repaint();
//    }
//
//    void requestBuildingOnPoint(Player player, int x, int y) throws buildingException
//    {
//        HexPoint point = pointByCoordinates(x, y);
//        BuildOnPoint buildOnPoint = new BuildOnPoint(player, point);
//        buildOnPoint.build();
//        actionsProcessor.repaint();
//    }
}
