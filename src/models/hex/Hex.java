package models.hex;

import java.util.LinkedList;
import java.util.List;

public abstract class Hex {
    private HexGeometry geometry;

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
}
