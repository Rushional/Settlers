package building;

import exceptions.lineHasNoPoint;
import hex.HexLine;
import hex.HexPoint;
import interactions.Player;

public class StartBuildRoad {
    private Player player;
    private HexLine line;
    private HexPoint point;

    public StartBuildRoad(Player player, HexLine line, HexPoint point) {
        this.player = player;
        this.line = line;
        this.point = point;
    }

    public void build() throws lineHasNoPoint {
        if (line.hasRoad()) throw new RuntimeException(); //this really shouldn't be possible
        if (!line.checkHasPoint(point)) throw new lineHasNoPoint();
        line.startAddRoad(player);
    }
}
