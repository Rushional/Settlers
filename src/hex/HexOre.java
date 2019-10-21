package hex;

import interactions.ResourcesSet;

public class HexOre extends Hex {
    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleOre();
    }
}
