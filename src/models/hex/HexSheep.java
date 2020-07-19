package models.hex;

import models.ResourcesSet;

public class HexSheep extends Hex {
    public HexSheep(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleSheep();
    }
}
