package models.hex;

import models.ResourcesSet;

public class HexWood extends Hex {
    public HexWood(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleWood();
    }
}
