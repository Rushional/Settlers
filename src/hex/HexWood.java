package hex;

import interactions.ResourcesSet;

public class HexWood extends Hex {
    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleWood();
    }
}
