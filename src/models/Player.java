package models;

import exceptions.*;
import java.awt.Color;
import static models.ResourcesSet.*;

public class Player {
    private PlayerColor color;
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

    short getVictoryPoints() {
        return victoryPoints;
    }
}
