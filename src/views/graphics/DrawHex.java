package views.graphics;

import models.hex.*;

import java.awt.*;

class DrawHex {
    protected Graphics2D g2d;
    protected Hex hex;
    protected HexPolygon hexPolygon;
    private int upPointX, upPointY;

    public DrawHex(Graphics2D g2d, Hex hex, int upPointX, int upPointY) {
        this.g2d = g2d;
        this.hex = hex;
        this.upPointX = upPointX;
        this.upPointY = upPointY;
    }

    void call() {
        hexPolygon = new HexPolygon(hex, upPointX, upPointY);
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
//        aaand buildings
//        Also, I could do that in a cycle. For it to work I'd need to synchronize the usage of model geometry points list
//        and polygon points list. Doesn't sound simple enough to bother, honestly
        if (hex.getGeometry().getUpPoint().hasBuilding())
            drawBuilding(hexPolygon.getUpPoint(), hex.getGeometry().getUpPoint());
        if (hex.getGeometry().getUpperRightPoint().hasBuilding())
            drawBuilding(hexPolygon.getUpperRightPoint(), hex.getGeometry().getUpperRightPoint());
        if (hex.getGeometry().getLowerRightPoint().hasBuilding())
            drawBuilding(hexPolygon.getLowerRightPoint(), hex.getGeometry().getLowerRightPoint());
        if (hex.getGeometry().getLowPoint().hasBuilding())
            drawBuilding(hexPolygon.getLowPoint(), hex.getGeometry().getLowPoint());
        if (hex.getGeometry().getLowerLeftPoint().hasBuilding())
            drawBuilding(hexPolygon.getLowerLeftPoint(), hex.getGeometry().getLowerLeftPoint());
        if (hex.getGeometry().getUpperLeftPoint().hasBuilding())
            drawBuilding(hexPolygon.getUpperLeftPoint(), hex.getGeometry().getUpperLeftPoint());
    }

    private void drawBuilding(Point polygonPoint, HexPoint point) {
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
        Color hexColor = chooseHexColor();
        g2d.setColor(hexColor);
        g2d.fillPolygon(hexPolygon);
        g2d.setColor(Color.BLACK);
    }

    protected Color chooseHexColor() {
        Color hexColor;
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
                default:
                    throw new RuntimeException();
            }
        }
        return hexColor;
    }
}
