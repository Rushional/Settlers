package views.graphics;

import models.hex.Hex;
import models.map.Hexes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapView {
    private List<HexView> hexViewsList; // I'm not making a HexViews because this is basically it
    private Hexes hexes;

    public MapView(Polygons polygons, Hexes hexes, PolygonGeometries polygonsGeometries) {
        this.hexes = hexes;
        hexViewsList = new ArrayList<>();
        Iterator<Hex> hexIterator = hexes.list().iterator();
        Iterator<Polygon> polygonIterator = polygons.list().iterator();
        Iterator<PolygonGeometry> polygonsCoordinatesIterator = polygonsGeometries.list().iterator();
        while (hexIterator.hasNext() && polygonIterator.hasNext() && polygonsCoordinatesIterator.hasNext()) {
            hexViewsList.add(new HexView(hexIterator.next(), polygonIterator.next(), polygonsCoordinatesIterator.next()));
        }
//        coordinates = new PolygonPointsCoordinates(upPointX, upPointY);
//        polygon = PolygonPointsCoordinates.calculateHexPolygon(upPointX, upPointY);
    }

    public List<HexView> getHexViewsList() {
        return hexViewsList;
    }

    public Hexes getHexes() {
        return hexes;
    }
}
