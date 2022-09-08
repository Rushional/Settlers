package client.views.inputs.intentions;

import client.models.hex.HexPoint;

public class ViewIntentionBuildOnPoint extends ViewIntention {
    private HexPoint point;

    public ViewIntentionBuildOnPoint(HexPoint point) {
        this.point = point;
    }

    public HexPoint getPoint() {
        return point;
    }
}
