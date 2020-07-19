package models.map;

import models.hex.*;

import java.util.LinkedList;
import java.util.List;

public class MapHexes {
    private Hex top1LeftHex;
    private Hex top1MiddleHex;
    private Hex top1RightHex;
    private Hex top2LeftHex;
    private Hex top2Middle2Hex;
    private Hex top2Middle3Hex;
    private Hex top2RightHex;
    private Hex middleLeftHex;
    private Hex middle2Hex;
    private Hex middle3Hex;
    private Hex middle4Hex;
    private Hex middleRightHex;
    private Hex bottom1LeftHex;
    private Hex bottom1Middle2Hex;
    private Hex bottom1Middle3Hex;
    private Hex bottom1RightHex;
    private Hex bottom2LeftHex;
    private Hex bottom2MiddleHex;
    private Hex bottom2RightHex;

    public MapHexes() {
        top1LeftHex = new HexWood(6);
        top1MiddleHex = new HexSheep(3);
        top1RightHex = new HexSheep(8);
        top2LeftHex = new HexWheat(2);
        top2Middle2Hex = new HexOre(4);
        top2Middle3Hex = new HexWheat(5);
        top2RightHex = new HexWood(10);
        middleLeftHex = new HexWood(5);
        middle2Hex = new HexBricks(9);
        middle3Hex = new HexDesert();
        middle4Hex = new HexOre(6);
        middleRightHex = new HexWheat(9);
        bottom1LeftHex = new HexWheat(10);
        bottom1Middle2Hex = new HexOre(11);
        bottom1Middle3Hex = new HexWood(3);
        bottom1RightHex = new HexSheep(12);
        bottom2LeftHex = new HexBricks(8);
        bottom2MiddleHex = new HexSheep(4);
        bottom2RightHex = new HexBricks(11);
        connectHexes();
    }

    private void connectHexes() {
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

    public List<Hex> getHexesList() {
        List<Hex> listHexes = new LinkedList<Hex>();
        listHexes.add(top1LeftHex);
        listHexes.add(top1MiddleHex);
        listHexes.add(top1RightHex);
        listHexes.add(top2LeftHex);
        listHexes.add(top2Middle2Hex);
        listHexes.add(top2Middle3Hex);
        listHexes.add(top2RightHex);
        listHexes.add(middleLeftHex);
        listHexes.add(middle2Hex);
        listHexes.add(middle3Hex);
        listHexes.add(middle4Hex);
        listHexes.add(middleRightHex);
        listHexes.add(bottom1LeftHex);
        listHexes.add(bottom1Middle2Hex);
        listHexes.add(bottom1Middle3Hex);
        listHexes.add(bottom1RightHex);
        listHexes.add(bottom2LeftHex);
        listHexes.add(bottom2MiddleHex);
        listHexes.add(bottom2RightHex);
        return listHexes;
    }

    public void printInfo() {
        for (Hex hex : getHexesList()) {
            hex.getGeometry().printInfo();
        }
    }

    public Hex getTop1Left() {
        return top1LeftHex;
    }
    public Hex getTop1Middle() {
        return top1MiddleHex;
    }

    public Hex getTop1Right() {
        return top1RightHex;
    }

    public Hex getTop2Left() {
        return top2LeftHex;
    }

    public Hex getTop2Middle2() {
        return top2Middle2Hex;
    }

    public Hex getTop2Middle3() {
        return top2Middle3Hex;
    }

    public Hex getTop2Right() {
        return top2RightHex;
    }

    public Hex getMiddleLeft() {
        return middleLeftHex;
    }

    public Hex getMiddle2() {
        return middle2Hex;
    }

    public Hex getMiddle3() {
        return middle3Hex;
    }

    public Hex getMiddle4() {
        return middle4Hex;
    }

    public Hex getMiddleRight() {
        return middleRightHex;
    }

    public Hex getBottom1Left() {
        return bottom1LeftHex;
    }

    public Hex getBottom1Middle2() {
        return bottom1Middle2Hex;
    }

    public Hex getBottom1Middle3() {
        return bottom1Middle3Hex;
    }

    public Hex getBottom1Right() {
        return  bottom1RightHex;
    }

    public Hex getBottom2Left() {
        return bottom2LeftHex;
    }

    public Hex getBottom2Middle() {
        return bottom2MiddleHex;
    }

    public Hex getBottom2Right() {
        return bottom2RightHex;
    }
}
