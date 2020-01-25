package hex;

import interactions.ResourcesSet;

public class HexOre extends Hex {
    public HexOre(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleOre();
    }
}
