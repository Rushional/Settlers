package models.map;

import models.ResourceType;
import models.hex.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapHexes {
    private Hexes hexes;

    private Hex currentRobbedHex;

    public MapHexes() {
        List<Hex> listHexes = new ArrayList<>();
        Hex top1LeftHex = new ResourceHex(6, ResourceType.Wood);
        listHexes.add(top1LeftHex);
        Hex top1MiddleHex = new ResourceHex(3, ResourceType.Sheep);
        listHexes.add(top1MiddleHex);
        Hex top1RightHex = new ResourceHex(8, ResourceType.Sheep);
        listHexes.add(top1RightHex);
        Hex top2LeftHex = new ResourceHex(2, ResourceType.Wheat);
        listHexes.add(top2LeftHex);
        Hex top2Middle2Hex = new ResourceHex(4, ResourceType.Ore);
        listHexes.add(top2Middle2Hex);
        Hex top2Middle3Hex = new ResourceHex(5, ResourceType.Wheat);
        listHexes.add(top2Middle3Hex);
        Hex top2RightHex = new ResourceHex(10, ResourceType.Wood);
        listHexes.add(top2RightHex);
        Hex middleLeftHex = new ResourceHex(5, ResourceType.Wood);
        listHexes.add(middleLeftHex);
        Hex middle2Hex = new ResourceHex(9, ResourceType.Bricks);
        listHexes.add(middle2Hex);
        Hex middle3Hex = new DesertHex();
        placeRobber(middle3Hex);
        listHexes.add(middle3Hex);
        Hex middle4Hex = new ResourceHex(6, ResourceType.Ore);
        listHexes.add(middle4Hex);
        Hex middleRightHex = new ResourceHex(9, ResourceType.Wheat);
        listHexes.add(middleRightHex);
        Hex bottom1LeftHex = new ResourceHex(10, ResourceType.Wheat);
        listHexes.add(bottom1LeftHex);
        Hex bottom1Middle2Hex = new ResourceHex(11, ResourceType.Ore);
        listHexes.add(bottom1Middle2Hex);
        Hex bottom1Middle3Hex = new ResourceHex(3, ResourceType.Wood);
        listHexes.add(bottom1Middle3Hex);
        Hex bottom1RightHex = new ResourceHex(12, ResourceType.Sheep);
        listHexes.add(bottom1RightHex);
        Hex bottom2LeftHex = new ResourceHex(8, ResourceType.Bricks);
        listHexes.add(bottom2LeftHex);
        Hex bottom2MiddleHex = new ResourceHex(4, ResourceType.Sheep);
        listHexes.add(bottom2MiddleHex);
        Hex bottom2RightHex = new ResourceHex(11, ResourceType.Bricks);
        listHexes.add(bottom2RightHex);
        hexes = new Hexes(listHexes);
        HexController.upLeftAdd(top1LeftHex.getGeometry(), top1MiddleHex.getGeometry());
        HexController.upLeftAdd(top1MiddleHex.getGeometry(), top1RightHex.getGeometry());
        HexController.rightAdd(top2LeftHex.getGeometry(), top1LeftHex.getGeometry());
        HexController.middleLeftAdd(top1LeftHex.getGeometry(), top1MiddleHex.getGeometry(), top2LeftHex.getGeometry(), top2Middle2Hex.getGeometry());
        HexController.middleLeftAdd(top1MiddleHex.getGeometry(), top1RightHex.getGeometry(), top2Middle2Hex.getGeometry(), top2Middle3Hex.getGeometry());
        HexController.edgeLeftAdd(top1RightHex.getGeometry(), top2Middle3Hex.getGeometry(), top2RightHex.getGeometry());
        HexController.rightAdd(middleLeftHex.getGeometry(), top2LeftHex.getGeometry());
        HexController.middleLeftAdd(top2LeftHex.getGeometry(), top2Middle2Hex.getGeometry(), middleLeftHex.getGeometry(), middle2Hex.getGeometry());
        HexController.middleLeftAdd(top2Middle2Hex.getGeometry(), top2Middle3Hex.getGeometry(), middle2Hex.getGeometry(), middle3Hex.getGeometry());
        HexController.middleLeftAdd(top2Middle3Hex.getGeometry(), top2RightHex.getGeometry(), middle3Hex.getGeometry(), middle4Hex.getGeometry());
        HexController.edgeLeftAdd(top2RightHex.getGeometry(), middle4Hex.getGeometry(), middleRightHex.getGeometry());
        HexController.bottomAdd(middleLeftHex.getGeometry(), middle2Hex.getGeometry(), bottom1LeftHex.getGeometry());
        HexController.middleLeftAdd(middle2Hex.getGeometry(), middle3Hex.getGeometry(), bottom1LeftHex.getGeometry(), bottom1Middle2Hex.getGeometry());
        HexController.middleLeftAdd(middle3Hex.getGeometry(), middle4Hex.getGeometry(), bottom1Middle2Hex.getGeometry(), bottom1Middle3Hex.getGeometry());
        HexController.middleLeftAdd(middle4Hex.getGeometry(), middleRightHex.getGeometry(), bottom1Middle3Hex.getGeometry(), bottom1RightHex.getGeometry());
        HexController.bottomAdd(bottom1LeftHex.getGeometry(), bottom1Middle2Hex.getGeometry(), bottom2LeftHex.getGeometry());
        HexController.middleLeftAdd(bottom1Middle2Hex.getGeometry(), bottom1Middle3Hex.getGeometry(), bottom2LeftHex.getGeometry(), bottom2MiddleHex.getGeometry());
        HexController.middleLeftAdd(bottom1Middle3Hex.getGeometry(), bottom1RightHex.getGeometry(), bottom2MiddleHex.getGeometry(), bottom2RightHex.getGeometry());
    }

    private void placeRobber(Hex targetHex) {
        currentRobbedHex = targetHex;
        targetHex.addRobber();
    }

    public void moveRobber(Hex targetHex) {
        currentRobbedHex.removeRobber();
        placeRobber(targetHex);
    }

    public ResourceHexes getResourceHexes() {
        return new ResourceHexes(getHexes());
    }

    public void printInfo() {
        for (Hex hex : getHexes().list()) {
            hex.getGeometry().printInfo();
        }
    }

    public Hexes getHexes() {
        return hexes;
    }

    public Hex getCurrentRobbedHex() {
        return currentRobbedHex;
    }
}
