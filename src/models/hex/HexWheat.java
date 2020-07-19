package models.hex;

import models.ResourcesSet;

public class HexWheat extends Hex {
    public HexWheat(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleWheat();
    }
}
