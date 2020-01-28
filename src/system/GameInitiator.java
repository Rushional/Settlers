package system;

import building_interface.BuildManagersRunner;
import building_interface.PointsLinesGetter;
import graphics.DrawingArea;
import interactions.Game;
import sound.AudioPlayer;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class GameInitiator {
    //TO DO: I probably need to create an InterfaceInitiator that would be run by this lil guy
    private Game game;
    private DrawingArea drawingArea;
    private AudioPlayer audioPlayer;

    public GameInitiator() {
        game = new Game();
        audioPlayer = new AudioPlayer();
        GameInitiator initiator = this;
        try {
            SwingUtilities.invokeAndWait(() -> {
                drawingArea = new DrawingArea(game.getMap(), game, initiator);
                JFrame frame = new JFrame("Колонизаторы!");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addComponentsToPane(frame.getContentPane(), drawingArea);
                frame.pack();
                frame.setVisible(true);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        BuildManagersRunner buildManagersRunner = new BuildManagersRunner
                (game, drawingArea.getBuildingGraphicsManager(), audioPlayer.getBuildingMessagesPlayer());
        game.assignBuildManagersRunner(buildManagersRunner);
        game.goSettling();
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

    public Game getGame() {
        return game;
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

    public DrawingArea getDrawingArea() {
        return drawingArea;
    }
}
