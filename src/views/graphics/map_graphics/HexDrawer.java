package views.graphics.map_graphics;

import models.hex.Hex;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.hex.ValuedHex;

import java.awt.*;

class HexDrawer {
    private Hex hex;
    private int upPointX, upPointY;
    private int upperRightPointX, upperRightPointY;
    private int lowerRightPointX, lowerRightPointY;
    private int lowPointX, lowPointY;
    private int lowerLeftPointX, lowerLeftPointY;
    private int upperLeftPointX, upperLeftPointY;
    private Graphics2D g2d;

    HexDrawer(Graphics2D g2d, Hex hex, int upPointX, int upPointY) {
        this.hex = hex;
        this.upPointX = upPointX;
        this.upPointY = upPointY;
        upperRightPointX = upPointX + 64;
        upperRightPointY = upPointY + 32;
        lowerRightPointX = upPointX + 64;
        lowerRightPointY = upPointY + 106;
        lowPointX = upPointX;
        lowPointY = upPointY + 138;
        lowerLeftPointX = upPointX - 64;
        lowerLeftPointY = upPointY + 106;
        upperLeftPointX = upPointX - 64;
        upperLeftPointY = upPointY + 32;
        this.g2d = g2d;
    }

    void drawHex() {
        drawValueAndType();
        drawHexLine(g2d, hex.getGeometry().getUpperRightLine(), upPointX, upPointY, upperRightPointX, upperRightPointY);
        if (hex.getGeometry().getUpperRightLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hex.getGeometry().getUpperRightLine().getRoad(), upPointX, upPointY);
        drawHexLine(g2d, hex.getGeometry().getMiddleRightLine(), upperRightPointX, upperRightPointY, lowerRightPointX, lowerRightPointY);
        if (hex.getGeometry().getMiddleRightLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hex.getGeometry().getMiddleRightLine().getRoad(), upperRightPointX, upperRightPointY);
        drawHexLine(g2d, hex.getGeometry().getLowerRightLine(), lowerRightPointX, lowerRightPointY, lowPointX, lowPointY);
        if (hex.getGeometry().getLowerRightLine().hasRoad())
            BuildDrawer.drawRoadLeftDown(g2d, hex.getGeometry().getLowerRightLine().getRoad(), lowerRightPointX, lowerRightPointY);
        drawHexLine(g2d, hex.getGeometry().getLowerLeftLine(), lowPointX, lowPointY, lowerLeftPointX, lowerLeftPointY);
        if (hex.getGeometry().getLowerLeftLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hex.getGeometry().getLowerLeftLine().getRoad(), lowerLeftPointX, lowerLeftPointY);
        drawHexLine(g2d, hex.getGeometry().getMiddleLeftLine(), lowerLeftPointX, lowerLeftPointY, upperLeftPointX, upperLeftPointY);
        if (hex.getGeometry().getMiddleLeftLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hex.getGeometry().getMiddleLeftLine().getRoad(), upperLeftPointX, upperLeftPointY);
        drawHexLine(g2d, hex.getGeometry().getUpperLeftLine(), upperLeftPointX, upperLeftPointY, upPointX, upPointY);
        if (hex.getGeometry().getUpperLeftLine().hasRoad())
            BuildDrawer.drawRoadLeftDown(g2d, hex.getGeometry().getUpperLeftLine().getRoad(), upPointX, upPointY);
        //aaand buildings
        if (hex.getGeometry().getUpPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getUpPoint(), upPointX, upPointY);
        if (hex.getGeometry().getUpperRightPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getUpperRightPoint(), upperRightPointX, upperRightPointY);
        if (hex.getGeometry().getLowerRightPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getLowerRightPoint(), lowerRightPointX, lowerRightPointY);
        if (hex.getGeometry().getLowPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getLowPoint(), lowPointX, lowPointY);
        if (hex.getGeometry().getLowerLeftPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getLowerLeftPoint(), lowerLeftPointX, lowerLeftPointY);
        if (hex.getGeometry().getUpperLeftPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getUpperLeftPoint(), upperLeftPointX, upperLeftPointY);
    }

    private void drawBuilding(Graphics2D g2d, HexPoint point, int pointX, int pointY) {
        if (point.hasSettlement())
            BuildDrawer.drawSettlement(g2d, point.getSettlement(), pointX, pointY);
        else BuildDrawer.drawCity(g2d, point.getCity(), pointX, pointY);
    }

    private void drawValueAndType() {
        if (hex instanceof ValuedHex) {
            int diceValue = ((ValuedHex) hex).getDiceValue();
            int diceValuePointX;
            int diceValuePointY = upPointY + 74;
            if (diceValue < 10) diceValuePointX = upPointX - 3;
            else diceValuePointX = upPointX - 7;
            g2d.drawString(String.valueOf(diceValue), diceValuePointX, diceValuePointY);
        }
        String typeName = hex.getHexTypeName();
        int typeNameWidth = g2d.getFontMetrics().stringWidth(typeName);
        int typeNameShiftX = typeNameWidth/2;
        int typeNameShiftY;
        if (hex instanceof ValuedHex) typeNameShiftY = 85;
        else typeNameShiftY = 74;
        g2d.drawString(typeName, upPointX - typeNameShiftX, upPointY + typeNameShiftY);
    }

    //TO DO - MAKE A COOL METHOD THAT TAKES A LINE AND DRAWS IT, COORDINATES FOUND SOMEWHERE
    private void drawHexLine(Graphics2D g2d, HexLine line, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }
}
