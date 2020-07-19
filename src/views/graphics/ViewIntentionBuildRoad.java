package views.graphics;

import models.hex.HexLine;

public class ViewIntentionBuildRoad extends ViewIntention {
    private HexLine line;

    public ViewIntentionBuildRoad(HexLine line) {
        this.line = line;
    }

    public HexLine getLine() {
        return line;
    }
}
