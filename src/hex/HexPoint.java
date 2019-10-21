package hex;

import exceptions.*;
import interactions.Player;

public class HexPoint {
    protected HexLine[] lines = new HexLine[3];
    private Building building = null;

    //I know I could use startGameAddSettlement here, but that would feel kinda unintuitive for me
    public void addSettlement(Player player) throws buildingNearby, noRoadsNearby {
        if (buildingNearbyCheck()) throw new buildingNearby();
        if (!roadsNearbyCheck(player)) throw new noRoadsNearby();
        this.building = new Settlement(player);
    }

    public void addCity(Player player) {
        this.building = new City(player);
    }

    public void startAddSettlement(Player player) throws buildingNearby {
        if (buildingNearbyCheck()) throw new buildingNearby();
        this.building = new Settlement(player);
    }

    public HexPoint getOtherPoint(HexLine line) {
        if (line == null) {
            return null;
        }
        if(!this.checkHasLine(line)) {
            Thread.dumpStack();
            System.out.println("Барабашка, ты попросил другую точку, а линию дал не ту");
            return null;
        }
        if (line.points[0] != this) return line.points[0];
        else return line.points[1];
    }

    public boolean checkHasLine(HexLine line) {
        if ((this.lines[0] != line) && (this.lines[1] != line) && (this.lines[2] != line)) return false;
        else return true;
    }

    private boolean roadsNearbyCheck(Player player) {
        for (int i = 0; i < 3; i++) {
            if (this.lines[i] != null)
                if (this.lines[i].road != null)
                    if (this.lines[i].road.getPlayer() == player) return true;
        }
        return false;
    }

    public boolean buildingNearbyCheck() {
        boolean buildingFoundFlag = false;
        if (this.checkNeighbourHasBuilding(lines[0])) buildingFoundFlag = true;
        if (this.checkNeighbourHasBuilding(lines[1])) buildingFoundFlag = true;
        if (this.checkNeighbourHasBuilding(lines[2])) buildingFoundFlag = true;
        return buildingFoundFlag;
    }

    public boolean checkNeighbourHasBuilding(HexLine line) {
        boolean NeighbourHasBuildingFlag;
        HexPoint otherPoint = this.getOtherPoint(line);
        if (otherPoint != null) {
            if (otherPoint.hasBuilding()) NeighbourHasBuildingFlag = true;
            else NeighbourHasBuildingFlag = false;
        }
        else NeighbourHasBuildingFlag = false;
        return NeighbourHasBuildingFlag;
    }

    public HexLine[] getOtherLines(HexLine line) {
        HexLine[] otherLines = new HexLine[2];
        if (lines[0] == line) {
            otherLines[0] = lines[1];
            otherLines[1] = lines[2];
        }
        else if (lines[1] == line) {
            otherLines[0] = lines[0];
            otherLines[1] = lines[2];
        }
        else if (lines[2] == line) {
            otherLines[0] = lines[0];
            otherLines[1] = lines[1];
        }
        else throw new wrongLine();
        return otherLines;
    }

    private int findEmptyIndex() throws connectionsArrayFull {
        int emptyLineIndex = 3;
        for (int i=2; i>=0; i--) if (this.lines[i] == null) emptyLineIndex = i;
        if (emptyLineIndex == 3) {
            throw new connectionsArrayFull();
        }
        return emptyLineIndex;
    }

    protected void addLine(HexLine line) {
        int emptyLineIndex;
        try {
            emptyLineIndex = findEmptyIndex();
            this.lines[emptyLineIndex] = line;
        } catch (connectionsArrayFull connectionsArrayFull) {
            throw new tooManyLines();
        }
        if ((lines[0] == null) && ((lines[1] != null) || (lines[2] != null))) throw new wrongLinesOrder();
        if ((lines[1] == null) && (lines[2] != null)) throw new wrongLinesOrder();
    }

    protected void removeConnections() {
        for (int i = 0; i < 3; i++) {
            if (this.lines[i] != null) {
                if (this.lines[i].points[0] == this) this.lines[i].points[0] = null;
                else if (this.lines[i].points[1] == this) this.lines[i].points[1] = null;
            }
        }
    }

    public Building getBuilding() {
        return building;
    }

    public Settlement getSettlement() {
        if (building.getClass() == Settlement.class) return (Settlement)building;
        else return null;
    }

    public City getCity() {
        if (building.getClass() == City.class) return (City)building;
        else return null;
    }

    public HexLine getLine(int lineNumber) {
        return lines[lineNumber];
    }

    public boolean hasSettlement() {
        if (this.hasBuilding() == true)
            return (building.getClass() == Settlement.class);
        else return false;
    }

    public boolean hasCity() {
        if (this.hasBuilding() == true)
            return (building.getClass() == City.class);
        else return false;
    }

    public boolean hasBuilding() {
        if (this.building != null) return true;
        else return false;
    }

    public void infoHasBuilding() {
        if (hasBuilding() == true) System.out.println("Тут построено");
        else System.out.println("Тут не построено");
    }

    public void printLines() {
        System.out.println("lines of " + this + ": "+ this.lines[0] + this.lines[1] + this.lines[2]);
    }
}