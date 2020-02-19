package game_model.map;

import game_model.hex.*;

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
        HexController.upLeftAdd(top1LeftHex, top1MiddleHex);
        HexController.upLeftAdd(top1MiddleHex, top1RightHex);
        HexController.rightAdd(top2LeftHex, top1LeftHex);
        HexController.middleLeftAdd(top1LeftHex, top1MiddleHex, top2LeftHex, top2Middle2Hex);
        HexController.middleLeftAdd(top1MiddleHex, top1RightHex, top2Middle2Hex, top2Middle3Hex);
        HexController.edgeLeftAdd(top1RightHex, top2Middle3Hex, top2RightHex);
        HexController.rightAdd(middleLeftHex, top2LeftHex);
        HexController.middleLeftAdd(top2LeftHex, top2Middle2Hex, middleLeftHex, middle2Hex);
        HexController.middleLeftAdd(top2Middle2Hex, top2Middle3Hex, middle2Hex, middle3Hex);
        HexController.middleLeftAdd(top2Middle3Hex, top2RightHex, middle3Hex, middle4Hex);
        HexController.edgeLeftAdd(top2RightHex, middle4Hex, middleRightHex);
        HexController.bottomAdd(middleLeftHex, middle2Hex, bottom1LeftHex);
        HexController.middleLeftAdd(middle2Hex, middle3Hex, bottom1LeftHex, bottom1Middle2Hex);
        HexController.middleLeftAdd(middle3Hex, middle4Hex, bottom1Middle2Hex, bottom1Middle3Hex);
        HexController.middleLeftAdd(middle4Hex, middleRightHex, bottom1Middle3Hex, bottom1RightHex);
        HexController.bottomAdd(bottom1LeftHex, bottom1Middle2Hex, bottom2LeftHex);
        HexController.middleLeftAdd(bottom1Middle2Hex, bottom1Middle3Hex, bottom2LeftHex, bottom2MiddleHex);
        HexController.middleLeftAdd(bottom1Middle3Hex, bottom1RightHex, bottom2MiddleHex, bottom2RightHex);
    }

    public void printInfo() {
        top1LeftHex.printInfo();
        top1MiddleHex.printInfo();
        top1RightHex.printInfo();
        top2LeftHex.printInfo();
        top2Middle2Hex.printInfo();
        top2Middle3Hex.printInfo();
        top2RightHex.printInfo();
        middleLeftHex.printInfo();
        middle2Hex.printInfo();
        middle3Hex.printInfo();
        middle4Hex.printInfo();
        middleRightHex.printInfo();
        bottom1LeftHex.printInfo();
        bottom1Middle2Hex.printInfo();
        bottom1Middle3Hex.printInfo();
        bottom1RightHex.printInfo();
        bottom2LeftHex.printInfo();
        bottom2MiddleHex.printInfo();
        bottom2RightHex.printInfo();
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