package client.models.hex;

public class HexController {
    public static void upLeftAdd(HexGeometry left, HexGeometry right){
        right.lowerLeftPoint.removeConnections();
        right.upperLeftPoint.removeConnections();
        PointsLinesController.connectLinePoint(right.upperLeftLine, left.upperRightPoint);
        PointsLinesController.connectLinePoint(right.lowerLeftLine, left.lowerRightPoint);
        right.lowerLeftPoint = left.lowerRightPoint;
        right.upperLeftPoint = left.upperRightPoint;
        right.middleLeftLine = left.middleRightLine;

    }

    public static void rightAdd(HexGeometry left, HexGeometry right){
        left.upPoint.removeConnections();
        left.upperRightPoint.removeConnections();
        PointsLinesController.connectLinePoint(left.upperLeftLine, right.lowerLeftPoint);
        PointsLinesController.connectLinePoint(left.middleRightLine, right.lowPoint);
        left.upPoint = right.lowerLeftPoint;
        left.upperRightPoint = right.lowPoint;
        left.upperRightLine = right.lowerLeftLine;
    }

    public static void middleLeftAdd(HexGeometry topLeft, HexGeometry topRight, HexGeometry bottomLeft, HexGeometry bottomRight){
        bottomRight.upperRightPoint.removeConnections();
        bottomRight.upPoint.removeConnections();
        bottomRight.upperLeftPoint.removeConnections();
        bottomRight.lowerLeftPoint.removeConnections();
        PointsLinesController.connectLinePoint(bottomRight.lowerLeftLine, bottomLeft.lowerRightPoint);
        PointsLinesController.connectLinePoint(bottomRight.middleRightLine, topRight.lowPoint);
        bottomRight.lowerLeftPoint = bottomLeft.lowerRightPoint;
        bottomRight.upperLeftPoint = bottomLeft.upperRightPoint;
        bottomRight.upPoint = topRight.lowerLeftPoint;
        bottomRight.upperRightPoint = topRight.lowPoint;
        bottomRight.middleLeftLine = bottomLeft.middleRightLine;
        bottomRight.upperLeftLine = topLeft.lowerRightLine;
        bottomRight.upperRightLine = topRight.lowerLeftLine;

    }

    public static void bottomAdd(HexGeometry topLeft, HexGeometry topRight, HexGeometry bottom){
        bottom.upperLeftPoint.removeConnections();
        bottom.upPoint.removeConnections();
        bottom.upperRightPoint.removeConnections();
        PointsLinesController.connectLinePoint(bottom.middleLeftLine, topLeft.lowPoint);
        PointsLinesController.connectLinePoint(bottom.middleRightLine, topRight.lowPoint);
        bottom.upperLeftPoint = topLeft.lowPoint;
        bottom.upPoint = topLeft.lowerRightPoint;
        bottom.upperRightPoint = topRight.lowPoint;
        bottom.upperLeftLine = topLeft.lowerRightLine;
        bottom.upperRightLine = topRight.lowerLeftLine;
    }

    public static void edgeLeftAdd(HexGeometry top, HexGeometry bottomLeft, HexGeometry bottomRight){
        bottomRight.lowerLeftPoint.removeConnections();
        bottomRight.upperLeftPoint.removeConnections();
        bottomRight.upPoint.removeConnections();
        PointsLinesController.connectLinePoint(bottomRight.lowerLeftLine, bottomLeft.lowerRightPoint);
        PointsLinesController.connectLinePoint(bottomRight.upperRightLine, top.lowerRightPoint);
        bottomRight.lowerLeftPoint = bottomLeft.lowerRightPoint;
        bottomRight.upperLeftPoint = bottomLeft.upperRightPoint;
        bottomRight.upPoint = top.lowerRightPoint;
        bottomRight.middleLeftLine = bottomLeft.middleRightLine;
        bottomRight.upperLeftLine = top.lowerRightLine;
    }
}
