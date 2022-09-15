package models.hex;

import exceptions.HexAlreadyRobbed;
import exceptions.HexDoesntHaveRobber;

import java.util.LinkedList;
import java.util.List;

public abstract class Hex {
    private HexGeometry geometry;
    private boolean isRobbed;

    Hex() {
        geometry = new HexGeometry();
    }

    public List<Building> getBuildings() {
        List<Building> buildingsList = new LinkedList<>();
        for (HexPoint hex : geometry.getPointsList()) {
            if (hex.getBuilding() != null) buildingsList.add(hex.getBuilding());
        }
        return buildingsList;
    }

    public abstract String getHexTypeName();

    public HexGeometry getGeometry() {
        return geometry;
    }

    public boolean isRobbed() {
        return isRobbed;
    }

    public void addRobber() {
        if (isRobbed) throw new HexAlreadyRobbed();
        isRobbed = true;
    }

    public void removeRobber() {
        if (!isRobbed) throw new HexDoesntHaveRobber();
        isRobbed = false;
    }
}
