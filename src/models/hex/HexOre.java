package models.hex;

import models.ResourcesSet;

public class HexOre extends Hex {
    public HexOre(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleOre();
    }
}
