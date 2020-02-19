package game_view.graphics;

import game_model.map.MapHexes;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class FrameInitiator {
    private DrawingArea drawingArea;

    public DrawingArea initiateFrame(MapHexes map) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                drawingArea = new DrawingArea(map);
                JFrame frame = new JFrame("Колонизаторы!");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addComponentsToPane(frame.getContentPane(), drawingArea);
                frame.pack();
                frame.setVisible(true);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        return drawingArea;
    }

    private void addComponentsToPane(Container pane, DrawingArea drawingArea) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints drawingAreaConstraints = new GridBagConstraints();
        drawingAreaConstraints.fill = GridBagConstraints.NONE;
        drawingAreaConstraints.weightx = 0;
        drawingAreaConstraints.weighty = 0;
        drawingAreaConstraints.gridx = 0;
        drawingAreaConstraints.gridy = 0;
        pane.add(drawingArea, drawingAreaConstraints);

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(116, 255, 207));
        controlPanel.setPreferredSize(new Dimension(300, 700));
        GridBagConstraints controlPanelConstraints = new GridBagConstraints();
        controlPanelConstraints.fill = GridBagConstraints.NONE;
        controlPanelConstraints.weightx = 0;
        controlPanelConstraints.weighty = 0;
        controlPanelConstraints.gridx = 1;
        controlPanelConstraints.gridy = 0;
        pane.add(controlPanel, controlPanelConstraints);

        controlPanel.setLayout(new GridBagLayout());
        JButton button = new JButton("End turn");
        //For some reason it doesn't work
        //button.setSize(80,80);
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.weightx = 1;
        buttonConstraints.weighty = 1;
        buttonConstraints.anchor = GridBagConstraints.PAGE_END;
        buttonConstraints.insets = new Insets(0,0,100,0);
        controlPanel.add(button, buttonConstraints);
    }
}
