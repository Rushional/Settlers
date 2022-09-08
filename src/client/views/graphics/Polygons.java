package client.views.graphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Polygons {
    private List<Polygon> polygonsList;

    public Polygons() {
        PolygonsCoordinates polygonsCoordinates = new PolygonsCoordinates();
        polygonsList = new ArrayList<>();
        for (Point currentUpPoint : polygonsCoordinates.list()) {
            polygonsList.add(PolygonGeometry.calculateHexPolygon(currentUpPoint.x, currentUpPoint.y));
        }
    }

    public List<Polygon> list() {
        return polygonsList;
    }
}
