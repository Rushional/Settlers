package game_view.building_view;

import exceptions.*;
import game_view.sound.BuildingMessagesPlayer;

class BuildingExceptionHandler {
    private BuildingMessagesPlayer buildingMessagesPlayer;

    BuildingExceptionHandler(BuildingMessagesPlayer buildingMessagesPlayer) {
        this.buildingMessagesPlayer = buildingMessagesPlayer;
    }

    void handleStartSettlement(buildingException buildingException) {
        if (buildingException.getClass() == wrongPointCoordinates.class) {
            System.out.println("Здесь нет точки");
            new Thread(() -> buildingMessagesPlayer.playWrongPointCoordinates()).start();
        }
        if (buildingException.getClass() == buildingNearby.class) {
            System.out.println("Рядом уже есть поселение");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == pointHasSettlement.class) {
            System.out.println("В этом месте уже есть поселение");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
    }

    void handleStartRoad(buildingException buildingException) {
        if (buildingException.getClass() == wrongRoadCoordinates.class) {
            System.out.println("Проведите линию между двумя точками, чтобы построить дорогу");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == lineHasRoad.class) {
            System.out.println("В этом месте уже есть дорога");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == lineHasNoPoint.class) {
            System.out.println("Дорогу нужно построить рядом с новым поселением");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
    }

    public void handleTurn(buildingException buildingException) {
        if (buildingException.getClass() == wrongPointCoordinates.class) {
            System.out.println("Здесь нет точки");
            new Thread(() -> buildingMessagesPlayer.playWrongPointCoordinates()).start();
        }
        new Thread(() -> buildingMessagesPlayer.playException()).start();
        if (buildingException.getClass() == buildingNearby.class) {
            System.out.println("Рядом уже есть поселение");
        }
        new Thread(() -> buildingMessagesPlayer.playException()).start();
        if (buildingException.getClass() == noRoadsNearby.class) {
            System.out.println("Рядом нет дорог");
        }
        new Thread(() -> buildingMessagesPlayer.playException()).start();
        if (buildingException.getClass() == pointHasSettlement.class) {
            System.out.println("В этом месте уже есть чужое поселение:(");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == cityBuiltAlready.class) {
            System.out.println("В этом месте уже есть город");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == notEnoughForSettlement.class) {
            System.out.println("Недостаточно ресурсов на поселение:(");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == maximumSettlementsAlready.class) {
            System.out.println("Достигнут лимит количества поселений:(");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == notEnoughForCity.class) {
            System.out.println("Недостаточно ресурсов на город:(");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == maximumCitiesAlready.class) {
            System.out.println("Достигнут лимит количества городов:(");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        //road exceptions
        if (buildingException.getClass() == wrongRoadCoordinates.class) {
            System.out.println("Проведите линию между двумя точками, чтобы построить дорогу");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == lineHasRoad.class) {
            System.out.println("В этом месте уже есть дорога");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == roadHasNoAccess.class) {
            System.out.println("Это место ещё не колонизировано");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == opponentsSettlementOnWay.class) {
            System.out.println("На пути поселение другого игрока");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
        if (buildingException.getClass() == opponentsCityOnWay.class) {
            System.out.println("На пути город другого игрока");
            new Thread(() -> buildingMessagesPlayer.playException()).start();
        }
    }
}
