package game_model.hex;

import game_model.ResourcesSet;

public class HexOre extends Hex {
    public HexOre(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleOre();
    }
}
