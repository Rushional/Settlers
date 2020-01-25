package building_interface;

import exceptions.*;
import sound.BuildingMessagesPlayer;

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

    public void handleTurn(buildingException buildingException) {
        if (buildingException.getClass() == wrongPointCoordinates.class) System.out.println("Здесь нет точки");
        if (buildingException.getClass() == buildingNearby.class) System.out.println("Рядом уже есть поселение");
        if (buildingException.getClass() == noRoadsNearby.class) System.out.println("Рядом нет дорог");
        if (buildingException.getClass() == pointHasSettlement.class) System.out.println("В этом месте уже есть чужое поселение:(");
        if (buildingException.getClass() == cityBuiltAlready.class) System.out.println("В этом месте уже есть город");
        if (buildingException.getClass() == notEnoughForSettlement.class) System.out.println("Недостаточно ресурсов на поселение:(");
        if (buildingException.getClass() == maximumSettlementsAlready.class) System.out.println("Достигнут лимит количества поселений:(");
        if (buildingException.getClass() == notEnoughForCity.class) System.out.println("Недостаточно ресурсов на город:(");
        if (buildingException.getClass() == maximumCitiesAlready.class) System.out.println("Достигнут лимит количества городов:(");
        //road exceptions
        if (buildingException.getClass() == wrongRoadCoordinates.class) System.out.println("Проведите линию между двумя точками, чтобы построить дорогу");
        if (buildingException.getClass() == lineHasRoad.class) System.out.println("В этом месте уже есть дорога");
        if (buildingException.getClass() == roadHasNoAccess.class) System.out.println("Это место ещё не колонизировано");
        if (buildingException.getClass() == opponentsSettlementOnWay.class) System.out.println("На пути поселение другого игрока");
        if (buildingException.getClass() == opponentsCityOnWay.class) System.out.println("На пути город другого игрока");
    }

    void handleStartRoad(buildingException buildingException) {
        if (buildingException.getClass() == wrongRoadCoordinates.class) System.out.println("Проведите линию между двумя точками, чтобы построить дорогу");
        if (buildingException.getClass() == lineHasRoad.class) System.out.println("В этом месте уже есть дорога");
        if (buildingException.getClass() == lineHasNoPoint.class) System.out.println("Дорогу нужно построить рядом с новым поселением");
    }
}
