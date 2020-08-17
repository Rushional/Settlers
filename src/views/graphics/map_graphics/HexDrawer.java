package views.graphics.map_graphics;

import models.hex.*;

import java.awt.*;

class HexDrawer {
    private Hex hex;
    private HexPolygon hexPolygon;
    private Graphics2D g2d;

    HexDrawer(Graphics2D g2d, Hex hex, int upPointX, int upPointY) {
        this.hex = hex;
        hexPolygon = new HexPolygon(hex, upPointX, upPointY);
        this.g2d = g2d;
    }

    void drawHex() {
        colorHex();
        g2d.drawPolygon(hexPolygon);
        drawValueAndType();
        if (hex.getGeometry().getUpperRightLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hex.getGeometry().getUpperRightLine().getRoad(), hexPolygon.getUpPoint());
        if (hex.getGeometry().getMiddleRightLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hex.getGeometry().getMiddleRightLine().getRoad(), hexPolygon.getUpperRightPoint());
        if (hex.getGeometry().getLowerRightLine().hasRoad())
            BuildDrawer.drawRoadLeftDown(g2d, hex.getGeometry().getLowerRightLine().getRoad(), hexPolygon.getLowerRightPoint());
        if (hex.getGeometry().getLowerLeftLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hex.getGeometry().getLowerLeftLine().getRoad(), hexPolygon.getLowerLeftPoint());
        if (hex.getGeometry().getMiddleLeftLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hex.getGeometry().getMiddleLeftLine().getRoad(), hexPolygon.getUpperLeftPoint());
        if (hex.getGeometry().getUpperLeftLine().hasRoad())
            BuildDrawer.drawRoadLeftDown(g2d, hex.getGeometry().getUpperLeftLine().getRoad(), hexPolygon.getUpPoint());
        //aaand buildings
        if (hex.getGeometry().getUpPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getUpPoint(), hexPolygon.getUpPoint());
        if (hex.getGeometry().getUpperRightPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getUpperRightPoint(), hexPolygon.getUpperRightPoint());
        if (hex.getGeometry().getLowerRightPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getLowerRightPoint(), hexPolygon.getLowerRightPoint());
        if (hex.getGeometry().getLowPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getLowPoint(), hexPolygon.getLowPoint());
        if (hex.getGeometry().getLowerLeftPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getLowerLeftPoint(), hexPolygon.getLowerLeftPoint());
        if (hex.getGeometry().getUpperLeftPoint().hasBuilding())
            drawBuilding(g2d, hex.getGeometry().getUpperLeftPoint(), hexPolygon.getUpperLeftPoint());
    }

    private void drawBuilding(Graphics2D g2d, HexPoint point, Point polygonPoint) {
        if (point.hasSettlement())
            BuildDrawer.drawSettlement(g2d, point.getSettlement(), polygonPoint.x, polygonPoint.y);
        else BuildDrawer.drawCity(g2d, point.getCity(), polygonPoint.x, polygonPoint.y);
    }

    private void drawValueAndType() {
        int upPointX = hexPolygon.getUpPoint().x;
        int upPointY = hexPolygon.getUpPoint().y;
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
        g2d.fillPolygon(hexPolygon);
        g2d.setColor(Color.BLACK);
    }
}
