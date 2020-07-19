package models.hex;

import models.ResourcesSet;

public class HexBricks extends Hex {
    public HexBricks(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleBricks();
    }
}
