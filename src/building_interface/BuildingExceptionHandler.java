package building_interface;

import exceptions.buildingException;
import exceptions.buildingNearby;
import exceptions.pointHasSettlement;
import exceptions.wrongPointCoordinates;
import sound.AudioPlayer;

class BuildingExceptionHandler {
    private AudioPlayer audioPlayer;

    BuildingExceptionHandler(AudioPlayer audioPlayer) {
        this.audioPlayer = audioPlayer;
    }

    void handleStartSettlement(buildingException buildingException) {
        if (buildingException.getClass() == wrongPointCoordinates.class) {
            System.out.println("Здесь нет точки");
            new Thread(() -> audioPlayer.playWrongPointCoordinates()).start();
        }
        if (buildingException.getClass() == buildingNearby.class) System.out.println("Рядом уже есть поселение");
        if (buildingException.getClass() == pointHasSettlement.class) System.out.println("В этом месте уже есть поселение");
    }
}
