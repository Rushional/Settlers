package models;

import exceptions.negativeResources;

public class ResourcesSet {
    private int wood, bricks, sheep, wheat, ore;

    public ResourcesSet(int wood, int bricks, int sheep, int wheat, int ore) {
        this.wood = wood;
        this.bricks = bricks;
        this.sheep = sheep;
        this.wheat = wheat;
        this.ore = ore;
    }

    static ResourcesSet subtractSet(ResourcesSet reduced, ResourcesSet subtracted) {
        if (!reduced.enoughFor(subtracted)) throw new negativeResources();
        return new ResourcesSet(reduced.wood-subtracted.wood, reduced.bricks-subtracted.bricks, reduced.sheep-subtracted.sheep, reduced.wheat-subtracted.wheat, reduced.ore-subtracted.ore);
    }

    static ResourcesSet addSet(ResourcesSet reduced, ResourcesSet added) {
        return new ResourcesSet(reduced.wood+added.wood, reduced.bricks+added.bricks, reduced.sheep+added.sheep, reduced.wheat+added.wheat, reduced.ore+added.ore);
    }

    public boolean enoughFor(ResourcesSet set) {
        if ((wood - set.wood) < 0) return false;
        if ((bricks - set.bricks) < 0) return false;
        if ((sheep - set.sheep) < 0) return false;
        if ((wheat - set.wheat) < 0) return false;
        if ((ore - set.ore) < 0) return false;
        return true;
    }

    public static ResourcesSet roadSet() {
        return new ResourcesSet(1, 1, 0, 0, 0);
    }

    public static ResourcesSet settlementSet() {
        return new ResourcesSet(1,1,1,1,0);
    }

    public static ResourcesSet citySet() {
        return new ResourcesSet(0, 0, 0, 2, 3);
    }

    public static ResourcesSet developmentSet() {
        return new ResourcesSet(0, 0, 1, 1, 1);
    }

    public static ResourcesSet singleWood() { return new ResourcesSet(1,0,0,0,0); }
    public static ResourcesSet singleBricks() { return new ResourcesSet(0,1,0,0,0); }
    public static ResourcesSet singleSheep() { return new ResourcesSet(0,0,1,0,0); }
    public static ResourcesSet singleWheat() { return new ResourcesSet(0,0,0,1,0); }
    public static ResourcesSet singleOre() { return new ResourcesSet(0,0,0,0,1); }

    @Override
    public String toString() {
        return wood + ", " + bricks + ", " + sheep + ", " + wheat + ", " + ore;
    }

    int getWood() { return wood; }
    int getBricks() { return bricks; }
    int getSheep() { return sheep; }
    public int getWheat() { return wheat; }
    public int getOre() { return ore; }
}