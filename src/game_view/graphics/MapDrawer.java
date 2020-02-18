package game_view.graphics;

import game_model.map.MapHexes;

import java.awt.Graphics2D;
import java.awt.Color;

class MapDrawer {
    private MapHexes map;
    private int top1LeftX, top1LeftY;
    private int top1MiddleX, top1MiddleY;
    private int top1RightX, top1RightY;
    private int top2LeftX, top2LeftY;
    private int top2Middle2X, top2Middle2Y;
    private int top2Middle3X, top2Middle3Y;
    private int top2RightX, top2RightY;
    private int middleLeftX, middleLeftY;
    private int middle2X, middle2Y;
    private int middle3X, middle3Y;
    private int middle4X, middle4Y;
    private int middleRightX, middleRightY;
    private int bottom1LeftX, bottom1LeftY;
    private int bottom1Middle2X, bottom1Middle2Y;
    private int bottom1Middle3X, bottom1Middle3Y;
    private int bottom1RightX, bottom1RightY;
    private int bottom2LeftX, bottom2LeftY;
    private int bottom2MiddleX, bottom2MiddleY;
    private int bottom2RightX, bottom2RightY;
    private HexDrawer top1Left,top1Middle,top1Right;
    private HexDrawer top2Left, top2Middle2, top2Middle3, top2Right;
    private HexDrawer middleLeft, middle2, middle3, middle4, middleRight;
    private HexDrawer bottom1Left, bottom1Middle2, bottom1Middle3, bottom1Right;
    private HexDrawer bottom2Left, bottom2Middle, bottom2Right;

    MapDrawer(MapHexes map, int top1LeftX, int top1LeftY) {
        this.map = map;
        this.top1LeftX = top1LeftX;
        this.top1LeftY = top1LeftY;
        top1MiddleX = top1LeftX + 128;
        top1MiddleY = top1LeftY;
        top1RightX = top1LeftX + 256;
        top1RightY = top1LeftY;
        top2LeftX = top1LeftX - 64;
        top2LeftY = top1LeftY + 106;
        top2Middle2X = top1LeftX + 64;
        top2Middle2Y = top1LeftY + 106;
        top2Middle3X = top1LeftX + 192;
        top2Middle3Y = top1LeftY + 106;
        top2RightX = top1LeftX + 320;
        top2RightY = top1LeftY + 106;
        middleLeftX = top1LeftX - 128;
        middleLeftY = top1LeftY + 212;
        middle2X = top1LeftX;
        middle2Y = top1LeftY + 212;
        middle3X = top1LeftX + 128;
        middle3Y = top1LeftY + 212;
        middle4X = top1LeftX + 256;
        middle4Y = top1LeftY + 212;
        middleRightX = top1LeftX + 384;
        middleRightY = top1LeftY + 212;
        bottom1LeftX = top1LeftX - 64;
        bottom1LeftY = top1LeftY + 318;
        bottom1Middle2X = top1LeftX + 64;
        bottom1Middle2Y = top1LeftY + 318;
        bottom1Middle3X = top1LeftX + 192;
        bottom1Middle3Y = top1LeftY + 318;
        bottom1RightX = top1LeftX + 320;
        bottom1RightY = top1LeftY + 318;
        bottom2LeftX = top1LeftX;
        bottom2LeftY = top1LeftY + 424;
        bottom2MiddleX = top1LeftX + 128;
        bottom2MiddleY = top1LeftY + 424;
        bottom2RightX = top1LeftX + 256;
        bottom2RightY = top1LeftY + 424;
    }

    void drawMap(Graphics2D g2d) {
        g2d.setColor(Color.black);
        top1Left = new HexDrawer(g2d, map.getTop1Left(), this.top1LeftX, this.top1LeftY);
        top1Middle = new HexDrawer(g2d, map.getTop1Middle(), top1MiddleX, top1MiddleY);
        top1Right = new HexDrawer(g2d, map.getTop1Right(), top1RightX, top1RightY);
        top2Left = new HexDrawer(g2d, map.getTop2Left(), top2LeftX, top2LeftY);
        top2Middle2 = new HexDrawer(g2d, map.getTop2Middle2(), top2Middle2X, top2Middle2Y);
        top2Middle3 = new HexDrawer(g2d, map.getTop2Middle3(), top2Middle3X, top2Middle3Y);
        top2Right = new HexDrawer(g2d, map.getTop2Right(), top2RightX, top2RightY);
        middleLeft = new HexDrawer(g2d, map.getMiddleLeft(), middleLeftX, middleLeftY);
        middle2 = new HexDrawer(g2d, map.getMiddle2(), middle2X, middle2Y);
        middle3 = new HexDrawer(g2d, map.getMiddle3(), middle3X, middle3Y);
        middle4 = new HexDrawer(g2d, map.getMiddle4(), middle4X, middle4Y);
        middleRight = new HexDrawer(g2d, map.getMiddleRight(), middleRightX, middleRightY);
        bottom1Left = new HexDrawer(g2d, map.getBottom1Left(), bottom1LeftX, bottom1LeftY);
        bottom1Middle2 = new HexDrawer(g2d, map.getBottom1Middle2(), bottom1Middle2X, bottom1Middle2Y);
        bottom1Middle3 = new HexDrawer(g2d, map.getBottom1Middle3(), bottom1Middle3X, bottom1Middle3Y);
        bottom1Right = new HexDrawer(g2d, map.getBottom1Right(), bottom1RightX, bottom1RightY);
        bottom2Left = new HexDrawer(g2d, map.getBottom2Left(), bottom2LeftX, bottom2LeftY);
        bottom2Middle = new HexDrawer(g2d, map.getBottom2Middle(), bottom2MiddleX, bottom2MiddleY);
        bottom2Right = new HexDrawer(g2d, map.getBottom2Right(), bottom2RightX, bottom2RightY);
        top1Left.drawHex();
        top1Middle.drawHex();
        top1Right.drawHex();
        top2Left.drawHex();
        top2Middle2.drawHex();
        top2Middle3.drawHex();
        top2Right.drawHex();
        middleLeft.drawHex();
        middle2.drawHex();
        middle3.drawHex();
        middle4.drawHex();
        middleRight.drawHex();
        bottom1Left.drawHex();
        bottom1Middle2.drawHex();
        bottom1Middle3.drawHex();
        bottom1Right.drawHex();
        bottom2Left.drawHex();
        bottom2Middle.drawHex();
        bottom2Right.drawHex();
    }
}
