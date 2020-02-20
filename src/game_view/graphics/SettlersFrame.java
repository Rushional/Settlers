package game_view.graphics;

import game_model.map.MapHexes;
import game_view.graphics.map_graphics.MapPanel;

import javax.swing.*;
import java.awt.*;

public class SettlersFrame extends JFrame {
    private MapPanel mapPanel;
    private ControlPanel controlPanel;

    SettlersFrame(MapHexes map) {
        super("Колонизаторы!");
        mapPanel = new MapPanel(map);
        controlPanel = new ControlPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(mapPanel, controlPanel);
        pack();
        setVisible(true);
    }

    private void addComponentsToPane(MapPanel mapPanel, ControlPanel controlPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints drawingAreaConstraints = new GridBagConstraints();
        drawingAreaConstraints.fill = GridBagConstraints.NONE;
        drawingAreaConstraints.weightx = 0;
        drawingAreaConstraints.weighty = 0;
        drawingAreaConstraints.gridx = 0;
        drawingAreaConstraints.gridy = 0;
        add(mapPanel, drawingAreaConstraints);

        GridBagConstraints controlPanelConstraints = new GridBagConstraints();
        controlPanelConstraints.fill = GridBagConstraints.NONE;
        controlPanelConstraints.weightx = 0;
        controlPanelConstraints.weighty = 0;
        controlPanelConstraints.gridx = 1;
        controlPanelConstraints.gridy = 0;
        add(controlPanel, controlPanelConstraints);
    }

    public MapPanel getMapPanel() {
        return mapPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }
}
