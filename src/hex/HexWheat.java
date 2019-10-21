package hex;

import interactions.ResourcesSet;

public class HexWheat extends Hex {
    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleWheat();
    }
}
