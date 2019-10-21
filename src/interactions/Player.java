package interactions;

import exceptions.*;
import hex.HexLine;
import hex.HexPoint;
import java.awt.Color;

import static interactions.ResourcesSet.*;

public class Player {
    private Color color;
    private boolean isHuman;
    private ResourcesSet resources;
    private int settlementsAmount = 0, citiesAmount = 0;

    public Player(Color color, boolean isHuman) {
        this.color = color;
        this.isHuman = isHuman;
        resources = new ResourcesSet(7, 7, 2, 4, 3);
    }

    public void payForSettlement() {
        ResourcesSet updated = subtractSet(resources, settlementSet());
        resources = updated;
    }

    public void increaseSettlementsAmount() {
        settlementsAmount++;
        if (settlementsAmount == 6) throw new tooManySettlements();
    }

    public void payForRoad() {
        ResourcesSet updated = subtractSet(resources, roadSet());
        resources = updated;
    }

    public void payForCity() {
        ResourcesSet updated = subtractSet(resources, citySet());
        resources = updated;
    }

    public void increaseCitiesAmount() {
        citiesAmount++;
        if (citiesAmount == 5) throw new tooManyCities();
    }

    public Color getColor() {
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
}
