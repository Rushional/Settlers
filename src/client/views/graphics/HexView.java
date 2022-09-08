package client.views.graphics;

import client.models.hex.Hex;

import java.awt.*;

public class HexView {
    private Hex hexModel;
    private Polygon polygon;
    private PolygonGeometry geometry;

    HexView(Hex hexModel, Polygon polygon, PolygonGeometry geometry) {
        super();
        this.hexModel = hexModel;
        this.polygon = polygon;
        this.geometry = geometry;
    }

    public Hex getHexModel() {
        return hexModel;
    }


    public Polygon getPolygon() {
        return polygon;
    }

    public PolygonGeometry getPolygonGeometry() {
        return geometry;
    }
}
