package views.graphics.map_graphics;

import models.hex.City;
import models.hex.Road;
import models.hex.Settlement;

import java.awt.Graphics2D;
import java.awt.Color;

class BuildDrawer {
    static void drawSettlement(Graphics2D g2d, Settlement settlement, int x, int y) {
        g2d.setColor(BuildingColors.convertToRGB(settlement.getColor()));
        g2d.drawOval(x - 15, y - 15, 30, 30);
        g2d.fillOval(x - 15, y - 15, 30, 30);
        g2d.setColor(Color.black);
    }

    static void drawCity(Graphics2D g2d, City city, int x, int y) {
        g2d.setColor(BuildingColors.convertToRGB(city.getColor()).darker());
        g2d.drawOval(x - 16, y - 16, 32, 32);
        g2d.fillOval(x - 16, y - 16, 32, 32);
        g2d.setColor(Color.black);
    }

    static void drawRoadRightDown(Graphics2D g2d, Road road, int upperPointX, int upperPointY) {
//        g2d.drawLine(upperPointX + 18, upperPointY + 1, upperPointX + 52, upperPointY + 18);
//        g2d.drawLine(upperPointX + 52, upperPointY +18, upperPointX + 46, upperPointY + 31);
//        g2d.drawLine(upperPointX + 46, upperPointY + 31, upperPointX + 13, upperPointY + 14);
//        g2d.drawLine(upperPointX + 13, upperPointY + 14, upperPointX + 18, upperPointY + 1);
        int[] xPoints = new int[4];
        xPoints[0] = upperPointX + 18;
        xPoints[1] = upperPointX + 52;
        xPoints[2] = upperPointX + 46;
        xPoints[3] = upperPointX + 13;
        int[] yPoints = new int[4];
        yPoints[0] = upperPointY + 1;
        yPoints[1] = upperPointY + 18;
        yPoints[2] = upperPointY + 31;
        yPoints[3] = upperPointY + 14;
        g2d.setColor(BuildingColors.convertToRGB(road.getColor()));
        g2d.drawPolygon(xPoints, yPoints, 4);
        g2d.fillPolygon(xPoints, yPoints, 4);
        g2d.setColor(Color.black);
    }

    static void drawRoadLeftDown(Graphics2D g2d, Road road, int upperPointX, int upperPointY) {
//        g2d.drawLine(upperPointX - 18, upperPointY + 1, upperPointX - 13, upperPointY + 14);
//        g2d.drawLine(upperPointX - 13, upperPointY + 14, upperPointX - 46, upperPointY + 31);
//        g2d.drawLine(upperPointX - 46, upperPointY + 31, upperPointX - 52, upperPointY + 18);
//        g2d.drawLine(upperPointX - 52, upperPointY + 18, upperPointX - 18, upperPointY + 1);
        int[] xPoints = new int[4];
        xPoints[0] = upperPointX - 18;
        xPoints[1] = upperPointX - 13;
        xPoints[2] = upperPointX - 46;
        xPoints[3] = upperPointX - 52;
        int[] yPoints = new int[4];
        yPoints[0] = upperPointY + 1;
        yPoints[1] = upperPointY + 14;
        yPoints[2] = upperPointY + 31;
        yPoints[3] = upperPointY + 18;
        g2d.setColor(BuildingColors.convertToRGB(road.getColor()));
        g2d.drawPolygon(xPoints, yPoints, 4);
        g2d.fillPolygon(xPoints, yPoints, 4);
        g2d.setColor(Color.black);
    }

    static void drawRoadUpDown(Graphics2D g2d, Road road, int upperPointX, int upperPointY) {
        int[] xPoints = new int[4];
        xPoints[0] = upperPointX -7;
        xPoints[1] = upperPointX +7;
        xPoints[2] = upperPointX +7;
        xPoints[3] = upperPointX -7;
        int[] yPoints = new int[4];
        yPoints[0] = upperPointY + 17;
        yPoints[1] = upperPointY + 17;
        yPoints[2] = upperPointY + 57;
        yPoints[3] = upperPointY + 57;
        g2d.setColor(BuildingColors.convertToRGB(road.getColor()));
        g2d.drawPolygon(xPoints, yPoints, 4);
        g2d.fillPolygon(xPoints, yPoints, 4);
        g2d.setColor(Color.black);
    }
}
