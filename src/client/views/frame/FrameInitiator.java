package client.views.frame;

import client.models.map.MapHexes;
import client.views.graphics.MapView;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class FrameInitiator {
    private SettlersFrame settlersFrame;

    public SettlersFrame initiateFrame(MapHexes map, MapView mapView) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                settlersFrame = new SettlersFrame(map, mapView);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        return settlersFrame;
    }
}
