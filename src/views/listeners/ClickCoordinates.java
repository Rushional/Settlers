package views.listeners;

import java.awt.*;

public class ClickCoordinates {
    private Point pressed;
    private Point released;

    public ClickCoordinates(Point pressed, Point released) {
        this.pressed = pressed;
        this.released = released;
    }

    public Point getPressed() {
        return pressed;
    }

    public Point getReleased() {
        return released;
    }
}
