package client.models.building_model;

import client.exceptions.lineHasNoPoint;
import client.models.hex.HexLine;
import client.models.hex.HexPoint;
import client.models.players.Player;

class StartBuildRoad {
    private Player player;
    private HexLine line;
    private HexPoint point;

    StartBuildRoad(Player player, HexLine line, HexPoint point) {
        this.player = player;
        this.line = line;
        this.point = point;
    }

    void build() throws lineHasNoPoint {
        if (line.hasRoad()) throw new RuntimeException(); //this really shouldn't be possible
        if (!line.checkHasPoint(point)) throw new lineHasNoPoint();
        line.startAddRoad(player);
    }
}
