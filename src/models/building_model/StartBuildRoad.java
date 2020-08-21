package models.building_model;

import exceptions.lineHasNoPoint;
import models.hex.HexLine;
import models.hex.HexPoint;
import models.players.Player;

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
