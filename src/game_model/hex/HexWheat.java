package game_model.hex;

import game_model.ResourcesSet;

public class HexWheat extends Hex {
    public HexWheat(int frequency) {
        super(frequency);
    }

    @Override
    public ResourcesSet getResource() {
        return ResourcesSet.singleWheat();
    }
}
