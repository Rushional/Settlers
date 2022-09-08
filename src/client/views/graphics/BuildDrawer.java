package client.views.graphics;

import client.models.hex.City;
import client.models.hex.Road;
import client.models.hex.Settlement;

import java.awt.*;

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

    static void drawRoadRightDown(Graphics2D g2d, Road road, Point upperPoint) {
//        g2d.drawLine(upperPointX + 18, upperPointY + 1, upperPointX + 52, upperPointY + 18);
//        g2d.drawLine(upperPointX + 52, upperPointY +18, upperPointX + 46, upperPointY + 31);
//        g2d.drawLine(upperPointX + 46, upperPointY + 31, upperPointX + 13, upperPointY + 14);
//        g2d.drawLine(upperPointX + 13, upperPointY + 14, upperPointX + 18, upperPointY + 1);
        int[] xPoints = new int[4];
        xPoints[0] = upperPoint.x + 18;
        xPoints[1] = upperPoint.x + 52;
        xPoints[2] = upperPoint.x + 46;
        xPoints[3] = upperPoint.x + 13;
        int[] yPoints = new int[4];
        yPoints[0] = upperPoint.y + 1;
        yPoints[1] = upperPoint.y + 18;
        yPoints[2] = upperPoint.y + 31;
        yPoints[3] = upperPoint.y + 14;
        g2d.setColor(BuildingColors.convertToRGB(road.getColor()));
        g2d.drawPolygon(xPoints, yPoints, 4);
        g2d.fillPolygon(xPoints, yPoints, 4);
        g2d.setColor(Color.black);
    }

    static void drawRoadLeftDown(Graphics2D g2d, Road road, Point upperPoint) {
//        g2d.drawLine(upperPointX - 18, upperPointY + 1, upperPointX - 13, upperPointY + 14);
//        g2d.drawLine(upperPointX - 13, upperPointY + 14, upperPointX - 46, upperPointY + 31);
//        g2d.drawLine(upperPointX - 46, upperPointY + 31, upperPointX - 52, upperPointY + 18);
//        g2d.drawLine(upperPointX - 52, upperPointY + 18, upperPointX - 18, upperPointY + 1);
        int[] xPoints = new int[4];
        xPoints[0] = upperPoint.x - 18;
        xPoints[1] = upperPoint.x - 13;
        xPoints[2] = upperPoint.x - 46;
        xPoints[3] = upperPoint.x - 52;
        int[] yPoints = new int[4];
        yPoints[0] = upperPoint.y + 1;
        yPoints[1] = upperPoint.y + 14;
        yPoints[2] = upperPoint.y + 31;
        yPoints[3] = upperPoint.y + 18;
        g2d.setColor(BuildingColors.convertToRGB(road.getColor()));
        g2d.drawPolygon(xPoints, yPoints, 4);
        g2d.fillPolygon(xPoints, yPoints, 4);
        g2d.setColor(Color.black);
    }

    static void drawRoadUpDown(Graphics2D g2d, Road road, Point upperPoint) {
        int[] xPoints = new int[4];
        xPoints[0] = upperPoint.x -7;
        xPoints[1] = upperPoint.x +7;
        xPoints[2] = upperPoint.x +7;
        xPoints[3] = upperPoint.x -7;
        int[] yPoints = new int[4];
        yPoints[0] = upperPoint.y + 17;
        yPoints[1] = upperPoint.y + 17;
        yPoints[2] = upperPoint.y + 57;
        yPoints[3] = upperPoint.y + 57;
        g2d.setColor(BuildingColors.convertToRGB(road.getColor()));
        g2d.drawPolygon(xPoints, yPoints, 4);
        g2d.fillPolygon(xPoints, yPoints, 4);
        g2d.setColor(Color.black);
    }
}
