package hex;

import interactions.ResourcesSet;

public class HexWheat extends Hex {
    public HexWheat(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleWheat();
    }
}
