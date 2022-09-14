package views.graphics;

import models.players.PlayerColor;

import java.awt.*;

public class BuildingColors {
    public static Color red = new Color(249, 0, 8);
    public static Color blue = new Color(45, 65, 139);
    public static Color green = new Color(0, 180, 0);
    public static Color purple = new Color(145, 90, 167);

    public static Color convertToRGB(PlayerColor playerColor) {
        switch(playerColor) {
            case Red:
                return red;
            case Blue:
                return blue;
            case Green:
                return green;
            case Purple:
                return purple;
            default:
                throw new RuntimeException();
        }
    }
}
