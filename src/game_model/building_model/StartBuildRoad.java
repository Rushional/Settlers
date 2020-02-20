package game_model.building_model;

import exceptions.lineHasNoPoint;
import game_model.hex.HexLine;
import game_model.hex.HexPoint;
import game_model.Player;

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
