package hex;

import exceptions.connectionsArrayFull;
import exceptions.opponentsCityOnWay;
import exceptions.opponentsSettlementOnWay;
import exceptions.roadHasNoAccess;
import interactions.Player;

public class HexLine {
    HexPoint[] points = new HexPoint[2];
//    boolean hasRoad = false;
    Road road;

    public void addRoad(Player player) throws roadHasNoAccess, opponentsSettlementOnWay, opponentsCityOnWay {
        validateRoadHasAccess(player);
//        hasRoad = true;
        road = new Road(player);
    }

    public void startAddRoad(Player player) {
        road = new Road(player);
    }

    //for some reason road detection doesn't work
    private void validateRoadHasAccess(Player player) throws opponentsCityOnWay, opponentsSettlementOnWay, roadHasNoAccess {
        boolean point0OpponentBuilding = false, point1OpponentBuilding = false;
        if (points[0].hasBuilding()) {
            if (points[0].getBuilding().getPlayer() == player) return;
            else point0OpponentBuilding = true;
        }
        else {
            //Make sure otherLines[1] isn't null - it could be on map edges!
            HexLine[] otherLines0 = points[0].getOtherLines(this);
            if (otherLines0[0].hasRoad())
                if (otherLines0[0].getRoad().getPlayer() == player) return;
            if (otherLines0[1] != null)
                if (otherLines0[1].hasRoad())
                    if (otherLines0[1].getRoad().getPlayer() == player) return;
        }
        if (points[1].hasBuilding()) {
            if (points[1].getBuilding().getPlayer() == player) return;
            else point1OpponentBuilding = true;
        }
        else {
            HexLine[] otherLines1 = points[1].getOtherLines(this);
            if (otherLines1[0].hasRoad())
                if (otherLines1[0].getRoad().getPlayer() == player) return;
            if (otherLines1[1] != null)
                if (otherLines1[1].hasRoad())
                    if (otherLines1[1].getRoad().getPlayer() == player) return;
        }
        if (point0OpponentBuilding) {
            HexLine[] otherLines0 = points[0].getOtherLines(this);
            if (otherLines0[0].hasRoad())
                if (otherLines0[0].getRoad().getPlayer() == player) {
                    if (points[0].hasSettlement()) throw new opponentsSettlementOnWay();
                    else throw new opponentsCityOnWay();
                }
            if (otherLines0[1] != null)
                if (otherLines0[1].hasRoad())
                    if (otherLines0[1].getRoad().getPlayer() == player) {
                        if (points[0].hasSettlement()) throw new opponentsSettlementOnWay();
                        else throw new opponentsCityOnWay();
                    }
        }
        if (point1OpponentBuilding) {
            HexLine[] otherLines0 = points[1].getOtherLines(this);
            if (otherLines0[0].hasRoad())
                if (otherLines0[0].getRoad().getPlayer() == player) {
                    if (points[1].hasSettlement()) throw new opponentsSettlementOnWay();
                    else throw new opponentsCityOnWay();
                }
            if (otherLines0[1] != null)
                if (otherLines0[1].hasRoad())
                    if (otherLines0[1].getRoad().getPlayer() == player) {
                        if (points[1].hasSettlement()) throw new opponentsSettlementOnWay();
                        else throw new opponentsCityOnWay();
                    }
        }
        //check
        throw new roadHasNoAccess();
    }

    public Road getRoad() {
        return road;
    }

    private int findEmptyIndex() throws connectionsArrayFull {
        int emptyLineIndex = 2;
        for (int i=1; i>=0; i--) if (this.points[i] == null) emptyLineIndex = i;
        if (emptyLineIndex == 2) {
            connectionsArrayFull noPointsAvailable = new connectionsArrayFull();
            throw noPointsAvailable;
        }
        return emptyLineIndex;
    }

    protected void addPoint(HexPoint point) {
        int emptyPointIndex;
        try {
            emptyPointIndex = findEmptyIndex();
            this.points[emptyPointIndex] = point;
        } catch (connectionsArrayFull noPointsAvailable) {
            System.out.println("У этой линии уже есть две точки");
            noPointsAvailable.printStackTrace();
        }
    }

    public boolean checkHasPoint(HexPoint point) {
        return ((points[0] == point) || (points[1] == point));
    }

    public void printPoints() {
        System.out.println("points of " + this + ": " + this.points[0] + this.points[1]);
    }

    public boolean hasRoad() {
        return (getRoad() != null);
    }
}
