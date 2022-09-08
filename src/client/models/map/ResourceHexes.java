package client.models.map;

import client.models.hex.ResourceHex;

import java.util.ArrayList;
import java.util.List;

// This list does not contain all of the hexes in the map. Only those that have resources
public class ResourceHexes {
    public List<ResourceHex> resourceHexList;

    ResourceHexes(Hexes hexes) {
        resourceHexList = new ArrayList<>();
        resourceHexList.add((ResourceHex) hexes.getTop1Left());
        resourceHexList.add((ResourceHex) hexes.getTop1Middle());
        resourceHexList.add((ResourceHex) hexes.getTop1Right());
        resourceHexList.add((ResourceHex) hexes.getTop2Left());
        resourceHexList.add((ResourceHex) hexes.getTop2Middle2());
        resourceHexList.add((ResourceHex) hexes.getTop2Middle3());
        resourceHexList.add((ResourceHex) hexes.getTop2Right());
        resourceHexList.add((ResourceHex) hexes.getMiddleLeft());
        resourceHexList.add((ResourceHex) hexes.getMiddle2());
        resourceHexList.add((ResourceHex) hexes.getMiddle4());
        resourceHexList.add((ResourceHex) hexes.getMiddleRight());
        resourceHexList.add((ResourceHex) hexes.getBottom1Left());
        resourceHexList.add((ResourceHex) hexes.getBottom1Middle2());
        resourceHexList.add((ResourceHex) hexes.getBottom1Middle3());
        resourceHexList.add((ResourceHex) hexes.getBottom1Right());
        resourceHexList.add((ResourceHex) hexes.getBottom2Left());
        resourceHexList.add((ResourceHex) hexes.getBottom2Middle());
        resourceHexList.add((ResourceHex) hexes.getBottom2Right());
    }

    public List<ResourceHex> list() {
        return resourceHexList;
    }
}
