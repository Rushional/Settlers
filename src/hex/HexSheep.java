package hex;

import interactions.ResourcesSet;

public class HexSheep extends Hex {
    public HexSheep(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleSheep();
    }
}
