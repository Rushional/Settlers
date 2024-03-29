package models;

import exceptions.negativeResources;

public class ResourcesSet {
    private int wood, bricks, sheep, wheat, ore;

    public ResourcesSet(int bricks, int wood, int sheep, int wheat, int ore) {
        this.bricks = bricks;
        this.wood = wood;
        this.sheep = sheep;
        this.wheat = wheat;
        this.ore = ore;
    }

    public static ResourcesSet subtractSet(ResourcesSet reduced, ResourcesSet subtracted) {
        if (!reduced.enoughFor(subtracted)) throw new negativeResources();
        return new ResourcesSet(reduced.bricks-subtracted.bricks, reduced.wood-subtracted.wood, reduced.sheep-subtracted.sheep, reduced.wheat-subtracted.wheat, reduced.ore-subtracted.ore);
    }

    public static ResourcesSet addSet(ResourcesSet reduced, ResourcesSet added) {
        return new ResourcesSet(reduced.bricks+added.bricks, reduced.wood+added.wood, reduced.sheep+added.sheep, reduced.wheat+added.wheat, reduced.ore+added.ore);
    }

    public boolean enoughFor(ResourcesSet set) {
        if ((bricks - set.bricks) < 0) return false;
        if ((wood - set.wood) < 0) return false;
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

    public static ResourcesSet getOneOf(ResourceType type) {
        switch (type) {
            case Bricks:
                return new ResourcesSet(1,0,0,0,0);
            case Wood:
                return new ResourcesSet(0,1,0,0,0);
            case Sheep:
                return new ResourcesSet(0,0,1,0,0);
            case Wheat:
                return new ResourcesSet(0,0,0,1,0);
            case Ore:
                return new ResourcesSet(0,0,0,0,1);
            default:
                throw new RuntimeException();
        }
    }

    public static ResourcesSet getTwoOf(ResourceType type) {
        switch (type) {
            case Bricks:
                return new ResourcesSet(2,0,0,0,0);
            case Wood:
                return new ResourcesSet(0,2,0,0,0);
            case Sheep:
                return new ResourcesSet(0,0,2,0,0);
            case Wheat:
                return new ResourcesSet(0,0,0,2,0);
            case Ore:
                return new ResourcesSet(0,0,0,0,2);
            default:
                return null;
        }
    }

    public int getTotalAmount() {
        return getWood() + getBricks() + getSheep() + getWheat() + getOre();
    }

    @Override
    public String toString() {
        return "Bricks: " + bricks + ", wood: " + wood + ", sheep: " + sheep + ", wheat: " + wheat + ", ore: " + ore;
    }

    public int getBricks() { return bricks; }
    public int getWood() { return wood; }
    public int getSheep() { return sheep; }
    public int getWheat() { return wheat; }
    public int getOre() { return ore; }
}
