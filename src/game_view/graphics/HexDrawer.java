package game_view.graphics;

import game_model.hex.Hex;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;

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
        drawHexLine(g2d, hex.getUpperRightLine(), upPointX, upPointY, upperRightPointX, upperRightPointY);
        if (hex.getUpperRightLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hex.getUpperRightLine().getRoad(), upPointX, upPointY);
        drawHexLine(g2d, hex.getMiddleRightLine(), upperRightPointX, upperRightPointY, lowerRightPointX, lowerRightPointY);
        if (hex.getMiddleRightLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hex.getMiddleRightLine().getRoad(), upperRightPointX, upperRightPointY);
        drawHexLine(g2d, hex.getLowerRightLine(), lowerRightPointX, lowerRightPointY, lowPointX, lowPointY);
        if (hex.getLowerRightLine().hasRoad())
            BuildDrawer.drawRoadLeftDown(g2d, hex.getLowerRightLine().getRoad(), lowerRightPointX, lowerRightPointY);
        drawHexLine(g2d, hex.getLowerLeftLine(), lowPointX, lowPointY, lowerLeftPointX, lowerLeftPointY);
        if (hex.getLowerLeftLine().hasRoad())
            BuildDrawer.drawRoadRightDown(g2d, hex.getLowerLeftLine().getRoad(), lowerLeftPointX, lowerLeftPointY);
        drawHexLine(g2d, hex.getMiddleLeftLine(), lowerLeftPointX, lowerLeftPointY, upperLeftPointX, upperLeftPointY);
        if (hex.getMiddleLeftLine().hasRoad())
            BuildDrawer.drawRoadUpDown(g2d, hex.getMiddleLeftLine().getRoad(), upperLeftPointX, upperLeftPointY);
        drawHexLine(g2d, hex.getUpperLeftLine(), upperLeftPointX, upperLeftPointY, upPointX, upPointY);
        if (hex.getUpperLeftLine().hasRoad())
            BuildDrawer.drawRoadLeftDown(g2d, hex.getUpperLeftLine().getRoad(), upPointX, upPointY);
        //aaand buildings
        if (hex.getUpPoint().hasBuilding())
            drawBuilding(g2d, hex.getUpPoint(), upPointX, upPointY);
        if (hex.getUpperRightPoint().hasBuilding())
            drawBuilding(g2d, hex.getUpperRightPoint(), upperRightPointX, upperRightPointY);
        if (hex.getLowerRightPoint().hasBuilding())
            drawBuilding(g2d, hex.getLowerRightPoint(), lowerRightPointX, lowerRightPointY);
        if (hex.getLowPoint().hasBuilding())
            drawBuilding(g2d, hex.getLowPoint(), lowPointX, lowPointY);
        if (hex.getLowerLeftPoint().hasBuilding())
            drawBuilding(g2d, hex.getLowerLeftPoint(), lowerLeftPointX, lowerLeftPointY);
        if (hex.getUpperLeftPoint().hasBuilding())
            drawBuilding(g2d, hex.getUpperLeftPoint(), upperLeftPointX, upperLeftPointY);
    }

    private void drawBuilding(Graphics2D g2d, HexPoint point, int pointX, int pointY) {
        if (point.hasSettlement())
            BuildDrawer.drawSettlement(g2d, point.getSettlement(), pointX, pointY);
        else BuildDrawer.drawCity(g2d, point.getCity(), pointX, pointY);

    }

    //TO DO - MAKE A COOL METHOD THAT TAKES A LINE AND DRAWS IT, COORDINATES FOUND SOMEWHERE
    private void drawHexLine(Graphics2D g2d, HexLine line, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }
}
