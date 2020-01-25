package hex;

import interactions.ResourcesSet;

public class HexBricks extends Hex {
    public HexBricks(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleBricks();
    }
}
