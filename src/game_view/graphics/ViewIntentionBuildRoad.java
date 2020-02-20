package game_view.graphics;

import game_model.hex.HexLine;

public class ViewIntentionBuildRoad extends ViewIntention {
    private HexLine line;

    public ViewIntentionBuildRoad(HexLine line) {
        this.line = line;
    }

    public HexLine getLine() {
        return line;
    }
}
