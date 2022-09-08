package server.models.building_model;

import server.exceptions.lineHasNoPoint;
import server.models.hex.HexLine;
import server.models.hex.HexPoint;
import server.models.players.Player;

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
