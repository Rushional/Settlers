package hex;

import interactions.ResourcesSet;

public class HexSheep extends Hex {
    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleSheep();
    }
}
