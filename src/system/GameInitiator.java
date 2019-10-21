package system;

import graphics.DrawingArea;
import interactions.Game;
import sound.AudioPlayer;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

//Should't be packaged in graphics, it's something bigger, it's graphics + model, it's main level
public class GameInitiator {
    private Game game;
    private DrawingArea drawingArea;
    private AudioPlayer audioPlayer;

    public GameInitiator() {
        game = new Game();
        AudioPlayer aPlayer = new AudioPlayer();
        this.audioPlayer = aPlayer;
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    drawingArea = new DrawingArea(game.getMap(), game, aPlayer);
                    JFrame frame = new JFrame("Колонизаторы!");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    addComponentsToPane(frame.getContentPane(), drawingArea);
//                    ErrorNotification errorNotification = new ErrorNotification();
//                    JDesktopPane desktopPane = new JDesktopPane();
//                    desktopPane.add(errorNotification);
//                    frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
//                    these don't do anything right now and are needed for testing
//                    int frameWidth = 800;
//                    int frameHeight = 800;
//                    frame.setSize(frameWidth, frameHeight);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        } catch (InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        game.addGuiActionsProcessor(drawingArea.getGuiActionsProcessor());
        game.goSettling();
    }

//    public Game initiateGame() {
//        game = new Game();
//        try {
//            SwingUtilities.invokeAndWait(new Runnable() {
//                public void run() {
//                    drawingArea = new DrawingArea(game.getMap(), game);
//                    JFrame frame = new JFrame("Колонизаторы!");
//                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    addComponentsToPane(frame.getContentPane(), drawingArea);
////                    ErrorNotification errorNotification = new ErrorNotification();
////                    JDesktopPane desktopPane = new JDesktopPane();
////                    desktopPane.add(errorNotification);
////                    frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
////                    these don't do anything right now and are needed for testing
////                    int frameWidth = 800;
////                    int frameHeight = 800;
////                    frame.setSize(frameWidth, frameHeight);
//                    frame.pack();
//                    frame.setVisible(true);
//                }
//            });
//        } catch (InterruptedException e) {
//            e.printStackTrace(System.out);
//        } catch (InvocationTargetException e) {
//            e.printStackTrace(System.out);
//        }
//        game.addGuiActionsProcessor(drawingArea.getGuiActionsProcessor());
//        game.goSettling();
//        return game;
//    }

    public void addComponentsToPane(Container pane, DrawingArea drawingArea) {
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
}
