package views.frame;

import models.map.MapHexes;
import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class FrameInitiator {
    private SettlersFrame settlersFrame;

    public SettlersFrame initiateFrame(MapHexes map) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                settlersFrame = new SettlersFrame(map);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        return settlersFrame;
    }
}
