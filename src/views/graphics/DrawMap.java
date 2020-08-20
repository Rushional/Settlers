package views.graphics;

import models.hex.Hex;
import models.map.MapHexes;
import views.Constants;

import java.awt.Graphics2D;
import java.awt.Color;

public class DrawMap {
    private Graphics2D g2d;
    private MapHexes map;


    public DrawMap(Graphics2D g2d, MapHexes map) {
        this.g2d = g2d;
        this.map = map;
    }

//    I suppose I can make this A LOT shorter by using getHexesList and creating some hexesCoordinates list,
//    then synchronizing those list in some cycle and like for (19 times) { callDrawHex(hexesList[i], coordinatesList[i] }
//    But I'm low-key scared of working on it and I am very much lazy.
//    So this wonderful 38 lines amobination (sic) is totally staying
    public void call() {
        int top1LeftX = Constants.mapLocationOnCanvas.x;
        int top1LeftY = Constants.mapLocationOnCanvas.y;
        g2d.setColor(Color.black);
//        draw Top1Left hex
        callDrawHex(g2d, map.getTop1Left(), top1LeftX, top1LeftY);
//        draw Top1Middle hex
        callDrawHex(g2d, map.getTop1Middle(), top1LeftX + 128, top1LeftY);
//        draw Top1Right hex
        callDrawHex(g2d, map.getTop1Right(), top1LeftX + 256, top1LeftY);
//        draw Top2Left hex
        callDrawHex(g2d, map.getTop2Left(), top1LeftX - 64, top1LeftY + 106);
//        draw Top2Middle2 hex
        callDrawHex(g2d, map.getTop2Middle2(), top1LeftX + 64, top1LeftY + 106);
//        draw Top2Middle3 hex
        callDrawHex(g2d, map.getTop2Middle3(), top1LeftX + 192, top1LeftY + 106);
//        draw Top2Right hex
        callDrawHex(g2d, map.getTop2Right(), top1LeftX + 320, top1LeftY + 106);
//        draw MiddleLeft hex
        callDrawHex(g2d, map.getMiddleLeft(), top1LeftX - 128, top1LeftY + 212);
//        draw Middle2 hex
        callDrawHex(g2d, map.getMiddle2(), top1LeftX, top1LeftY + 212);
//        draw Middle3 hex
        callDrawHex(g2d, map.getMiddle3(), top1LeftX + 128, top1LeftY + 212);
//        draw Middle4 hex
        callDrawHex(g2d, map.getMiddle4(), top1LeftX + 256, top1LeftY + 212);
//        draw MiddleRight hex
        callDrawHex(g2d, map.getMiddleRight(), top1LeftX + 384, top1LeftY + 212);
//        draw Bottom1Left hex
        callDrawHex(g2d, map.getBottom1Left(), top1LeftX - 64, top1LeftY + 318);
//        draw Bottom1Middle2 hex
        callDrawHex(g2d, map.getBottom1Middle2(), top1LeftX + 64, top1LeftY + 318);
//        draw Bottom1Middle3 hex
        callDrawHex(g2d, map.getBottom1Middle3(), top1LeftX + 192, top1LeftY + 318);
//        draw Bottom1Right hex
        callDrawHex(g2d, map.getBottom1Right(), top1LeftX + 320, top1LeftY + 318);
//        draw Bottom2Left hex
        callDrawHex(g2d, map.getBottom2Left(), top1LeftX, top1LeftY + 424);
//        draw Bottom2Middle hex
        callDrawHex(g2d, map.getBottom2Middle(), top1LeftX + 128, top1LeftY + 424);
//        draw Bottom2Right hex
        callDrawHex(g2d, map.getBottom2Right(), top1LeftX + 256, top1LeftY + 424);
    }

    void callDrawHex(Graphics2D g2d, Hex hex, int upPointX, int upPointY) {
        DrawHex drawHex = new DrawHex(g2d, hex, upPointX, upPointY);
        drawHex.call();
    }
}
