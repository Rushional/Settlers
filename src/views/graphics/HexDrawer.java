package views.graphics;

import models.hex.*;

import java.awt.*;

class HexDrawer {
    protected Graphics2D g2d;
//    protected Hex hex;
    protected HexView hexView;

    public HexDrawer(Graphics2D g2d, HexView hexView) {
        this.g2d = g2d;
//        this.hex = hex;
        this.hexView = hexView;
    }

    void drawHex() {
        colorHex();
        g2d.drawPolygon(hexView.getPolygon());
        drawValueAndType();
        if (hexView.getHexModel().isRobbed()) drawRobber();
        HexGeometry hexGeometry = hexView.getHexModel().getGeometry();
        if (hexGeometry.getUpperRightLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hexGeometry.getUpperRightLine().getRoad(), hexView.getPolygonGeometry().getUpPoint());
        if (hexGeometry.getMiddleRightLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hexGeometry.getMiddleRightLine().getRoad(), hexView.getPolygonGeometry().getUpperRightPoint());
        if (hexGeometry.getLowerRightLine().hasRoad())
            BuildDrawer.drawRoadLeftDown(g2d, hexGeometry.getLowerRightLine().getRoad(), hexView.getPolygonGeometry().getLowerRightPoint());
        if (hexGeometry.getLowerLeftLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hexGeometry.getLowerLeftLine().getRoad(), hexView.getPolygonGeometry().getLowerLeftPoint());
        if (hexGeometry.getMiddleLeftLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hexGeometry.getMiddleLeftLine().getRoad(), hexView.getPolygonGeometry().getUpperLeftPoint());
        if (hexGeometry.getUpperLeftLine().hasRoad())
            BuildDrawer.drawRoadLeftDown(g2d, hexGeometry.getUpperLeftLine().getRoad(), hexView.getPolygonGeometry().getUpPoint());
//        aaand buildings
//        Also, I could do that in a cycle. For it to work I'd need to synchronize the usage of model geometry points list
//        and polygon points list. Doesn't sound simple enough to bother, honestly
        if (hexGeometry.getUpPoint().hasBuilding())
            drawBuilding(hexView.getPolygonGeometry().getUpPoint(), hexGeometry.getUpPoint());
        if (hexGeometry.getUpperRightPoint().hasBuilding())
            drawBuilding(hexView.getPolygonGeometry().getUpperRightPoint(), hexGeometry.getUpperRightPoint());
        if (hexGeometry.getLowerRightPoint().hasBuilding())
            drawBuilding(hexView.getPolygonGeometry().getLowerRightPoint(), hexGeometry.getLowerRightPoint());
        if (hexGeometry.getLowPoint().hasBuilding())
            drawBuilding(hexView.getPolygonGeometry().getLowPoint(), hexGeometry.getLowPoint());
        if (hexGeometry.getLowerLeftPoint().hasBuilding())
            drawBuilding(hexView.getPolygonGeometry().getLowerLeftPoint(), hexGeometry.getLowerLeftPoint());
        if (hexGeometry.getUpperLeftPoint().hasBuilding())
            drawBuilding(hexView.getPolygonGeometry().getUpperLeftPoint(), hexGeometry.getUpperLeftPoint());
    }

    private void drawBuilding(Point polygonPoint, HexPoint point) {
        if (point.hasSettlement())
            BuildDrawer.drawSettlement(g2d, point.getSettlement(), polygonPoint.x, polygonPoint.y);
        else BuildDrawer.drawCity(g2d, point.getCity(), polygonPoint.x, polygonPoint.y);
    }

    private void drawValueAndType() {
        int upPointX = hexView.getPolygonGeometry().getUpPoint().x;
        int upPointY = hexView.getPolygonGeometry().getUpPoint().y;
        if (hexView.getHexModel() instanceof ValuedHex) {
            int diceValue = ((ValuedHex) hexView.getHexModel()).getDiceValue();
            int diceValuePointX;
            int diceValuePointY = upPointY + 74;
            if (diceValue < 10) diceValuePointX = upPointX - 3;
            else diceValuePointX = upPointX - 7;
            g2d.drawString(String.valueOf(diceValue), diceValuePointX, diceValuePointY);
        }
        String typeName = hexView.getHexModel().getHexTypeName();
        int typeNameWidth = g2d.getFontMetrics().stringWidth(typeName);
        int typeNameShiftX = typeNameWidth/2;
        int typeNameShiftY;
        if (hexView.getHexModel() instanceof ValuedHex) typeNameShiftY = 85;
        else typeNameShiftY = 74;
        g2d.drawString(typeName, upPointX - typeNameShiftX, upPointY + typeNameShiftY);
    }

    private void drawRobber() {
        /*
        * TODO: have upPoints as arguments in drawValueAndType and drawRobber
        *  and have some method that calls these methods and give them the coordinates?
        */
        int upPointX = hexView.getPolygonGeometry().getUpPoint().x;
        int upPointY = hexView.getPolygonGeometry().getUpPoint().y;
//        TODO: this could use a constant instead, optimize a tiny bit. Practically irrelevant though.
        String robberText = "HAS ROBBER";
        int typeNameShiftX = g2d.getFontMetrics().stringWidth(robberText)/2;
        g2d.drawString(robberText, upPointX - typeNameShiftX, upPointY + 63);
    }

    private void colorHex() {
        Color hexColor = chooseHexColor();
        g2d.setColor(hexColor);
        g2d.fillPolygon(hexView.getPolygon());
        g2d.setColor(Color.BLACK);
    }

    protected Color chooseHexColor() {
        Color hexColor;
        if (hexView.getHexModel() instanceof DesertHex)
            hexColor = new Color(237, 201, 175);
        else {
            ResourceHex resourceHex = (ResourceHex) hexView.getHexModel();
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
