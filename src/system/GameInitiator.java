package system;

import game_controller.BuildingController;
import game_view.GameView;
import game_view.building_view.BuildingView;
import game_view.graphics.DrawingArea;
import game_model.GameModel;
import game_view.sound.AudioPlayer;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class GameInitiator {
    private GameModel gameModel;
    private GameView gameView;

    public GameInitiator() {
        gameModel = new GameModel();
        gameView = new GameView(gameModel.getMap());
        BuildingController buildingController = new BuildingController(gameModel.getBuildingModel(), gameView.getBuildingView());
        buildingController.startingBuildingStage();
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}
