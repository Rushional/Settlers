package views.graphics.map_graphics;

import models.hex.*;

import java.awt.*;
import java.util.Arrays;

class HexDrawer {
    private Hex hex;
    private int upPointX, upPointY;
    private int upperRightPointX, upperRightPointY;
    private int lowerRightPointX, lowerRightPointY;
    private int lowPointX, lowPointY;
    private int lowerLeftPointX, lowerLeftPointY;
    private int upperLeftPointX, upperLeftPointY;
    private int[] xPoints;
    private int[] yPoints;
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
        xPoints = new int[] { upPointX, upperRightPointX, lowerRightPointX, lowPointX, lowerLeftPointX, upperLeftPointX };
        yPoints = new int[] { upPointY, upperRightPointY, lowerRightPointY, lowPointY, lowerLeftPointY, upperLeftPointY };
        this.g2d = g2d;
    }

    void drawHex() {
        colorHex();
        g2d.drawPolygon(xPoints, yPoints, 6);
        drawValueAndType();
        if (hex.getGeometry().getUpperRightLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hex.getGeometry().getUpperRightLine().getRoad(), upPointX, upPointY);
        if (hex.getGeometry().getMiddleRightLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hex.getGeometry().getMiddleRightLine().getRoad(), upperRightPointX, upperRightPointY);
        if (hex.getGeometry().getLowerRightLine().hasRoad())
            BuildDrawer.drawRoadLeftDown(g2d, hex.getGeometry().getLowerRightLine().getRoad(), lowerRightPointX, lowerRightPointY);
        if (hex.getGeometry().getLowerLeftLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hex.getGeometry().getLowerLeftLine().getRoad(), lowerLeftPointX, lowerLeftPointY);
        if (hex.getGeometry().getMiddleLeftLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hex.getGeometry().getMiddleLeftLine().getRoad(), upperLeftPointX, upperLeftPointY);
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

    private void colorHex() {
        Color hexColor = new Color(255, 0, 152);
        if (hex instanceof DesertHex)
            hexColor = new Color(237, 201, 175);
        else {
            ResourceHex resourceHex = (ResourceHex) hex;
            switch (resourceHex.getResourceType()) {
                case Bricks:
                    hexColor = new Color(141, 55, 49);
                    break;
                case Wood:
                    hexColor = new Color(64, 79, 36);
                    break;
                case Sheep:
                    hexColor = new Color(151, 178, 96);
                    break;
                case Wheat:
                    hexColor = new Color(255, 255, 77);
                    break;
                case Ore:
                    hexColor = new Color(189, 199, 196);
                    break;
            }
        }
        g2d.setColor(hexColor);
        g2d.fillPolygon(xPoints, yPoints, 6);
        g2d.setColor(Color.BLACK);
    }

    //TO DO - MAKE A COOL METHOD THAT TAKES A LINE AND DRAWS IT, COORDINATES FOUND SOMEWHERE
//    private void drawHexLine(Graphics2D g2d, HexLine line, int x1, int y1, int x2, int y2) {
//        g2d.drawLine(x1, y1, x2, y2);
//    }
}
