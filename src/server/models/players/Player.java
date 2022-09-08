package server.models.players;

import server.exceptions.tooManyCities;
import server.exceptions.tooManySettlements;
import server.models.ResourcesSet;

import static client.models.ResourcesSet.addSet;
import static client.models.ResourcesSet.subtractSet;

public class Player {
    private PlayerColor color;
//    Right now this isHuman does not mean ANYTHING at all, and I'm not sure if it's ever used
    private boolean isHuman;
    private ResourcesSet resources;
    private int settlementsAmount = 0, citiesAmount = 0;
    private short victoryPoints = 0;

    public Player(PlayerColor color, boolean isHuman) {
        this.color = color;
        this.isHuman = isHuman;
//        resources = new ResourcesSet(7, 7, 2, 4, 3);
        resources = new ResourcesSet(0, 0, 0, 0, 0);
    }

    public void subtractResources(ResourcesSet subtracted) {
        resources = subtractSet(resources, subtracted);
    }

    public void addResources(ResourcesSet added) {
        resources = addSet(resources, added);
    }

    public void increaseSettlementsAmount() {
        settlementsAmount++;
        if (settlementsAmount == 6) throw new tooManySettlements();
    }

    public void increaseCitiesAmount() {
        citiesAmount++;
        if (citiesAmount == 5) throw new tooManyCities();
    }

    public void addVictoryPoint() {
        victoryPoints++;
    }

    public PlayerColor getColor() {
        return color;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public ResourcesSet getResources() {
        return resources;
    }

    public int getSettlementsAmount() {
        return settlementsAmount;
    }

    public int getCitiesAmount() {
        return citiesAmount;
    }

    public short getVictoryPoints() {
        return victoryPoints;
    }
}
