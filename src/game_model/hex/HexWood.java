package game_model.hex;

import game_model.ResourcesSet;

public class HexWood extends Hex {
    public HexWood(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleWood();
    }
}
