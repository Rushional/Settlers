package hex;

import interactions.ResourcesSet;

public class HexBricks extends Hex {
    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleBricks();
    }
}
