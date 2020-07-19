package models.hex;

import models.ResourcesSet;

import java.util.LinkedList;
import java.util.List;

public class Hex {
    private int diceValue;

    private HexGeometry geometry;

    public Hex(int diceValue) {
        this.diceValue = diceValue;
        geometry = new HexGeometry();
    }

    public ResourcesSet getResource() {
        return null;
    }


    public List<Building> getBuildings() {
        List<Building> buildingsList = new LinkedList<>();
        for (HexPoint hex : geometry.getPointsList()) {
            if (hex.getBuilding() != null) buildingsList.add(hex.getBuilding());
        }
        return buildingsList;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public HexGeometry getGeometry() {
        return geometry;
    }
}
