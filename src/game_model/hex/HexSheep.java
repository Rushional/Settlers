package game_model.hex;

import game_model.ResourcesSet;

public class HexSheep extends Hex {
    public HexSheep(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleSheep();
    }
}
