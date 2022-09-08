package client.models.map;

import client.models.hex.Hex;

import java.util.List;

// List list contains all of the hexes in the map in a specific order: left to tight, top to bottom
public class Hexes {
    private List<Hex> list;
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

    Hexes(List<Hex> hexesList) {
        list = hexesList;
        top1LeftHex = hexesList.get(0);
        top1MiddleHex = hexesList.get(1);
        top1RightHex = hexesList.get(2);
        top2LeftHex = hexesList.get(3);
        top2Middle2Hex = hexesList.get(4);
        top2Middle3Hex = hexesList.get(5);
        top2RightHex = hexesList.get(6);
        middleLeftHex = hexesList.get(7);
        middle2Hex = hexesList.get(8);
        middle3Hex = hexesList.get(9);
        middle4Hex = hexesList.get(10);
        middleRightHex = hexesList.get(11);
        bottom1LeftHex = hexesList.get(12);
        bottom1Middle2Hex = hexesList.get(13);
        bottom1Middle3Hex = hexesList.get(14);
        bottom1RightHex = hexesList.get(15);
        bottom2LeftHex = hexesList.get(16);
        bottom2MiddleHex = hexesList.get(17);
        bottom2RightHex = hexesList.get(18);
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
        return bottom1RightHex;
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

    public List<Hex> list() {
        return list;
    }
}
