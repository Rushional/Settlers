package views.graphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PolygonGeometries {
    private List<PolygonGeometry> listGeometries;

    public PolygonGeometries() {
        listGeometries = new ArrayList<>();
        PolygonsCoordinates polygonsCoordinates = new PolygonsCoordinates();
        for (Point upPoint : polygonsCoordinates.list()) {
            listGeometries.add(new PolygonGeometry(upPoint.x, upPoint.y));
        }
    }

    public List<PolygonGeometry> list() {
        return listGeometries;
    }
}
