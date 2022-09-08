package server.models.hex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HexTest {
    boolean checkLinePoint(HexLine line, HexPoint point) {
        boolean connectedFlag = false;
        for (int i = 0; i <= 1; i++) {
            if (line.points[i] == point)
                for (int j = 0; j <= 2; j++) {
                    if (line == line.points[i].lines[j]) {
                        connectedFlag = true;
                        break;
                    }
                }
        }
        return connectedFlag;
    }

    @Test
    void hexCompositionTest() {
        Hex hex = new DesertHex();
        assertTrue(checkLinePoint(hex.getGeometry().upperRightLine, hex.getGeometry().upPoint));
        assertTrue(checkLinePoint(hex.getGeometry().upperRightLine, hex.getGeometry().upperRightPoint));
        assertTrue(checkLinePoint(hex.getGeometry().middleRightLine, hex.getGeometry().upperRightPoint));
        assertTrue(checkLinePoint(hex.getGeometry().middleRightLine, hex.getGeometry().lowerRightPoint));
        assertTrue(checkLinePoint(hex.getGeometry().lowerRightLine, hex.getGeometry().lowerRightPoint));
        assertTrue(checkLinePoint(hex.getGeometry().lowerRightLine, hex.getGeometry().lowPoint));
        assertTrue(checkLinePoint(hex.getGeometry().lowerLeftLine, hex.getGeometry().lowPoint));
        assertTrue(checkLinePoint(hex.getGeometry().lowerLeftLine, hex.getGeometry().lowerLeftPoint));
        assertTrue(checkLinePoint(hex.getGeometry().middleLeftLine, hex.getGeometry().lowerLeftPoint));
        assertTrue(checkLinePoint(hex.getGeometry().middleLeftLine, hex.getGeometry().upperLeftPoint));
        assertTrue(checkLinePoint(hex.getGeometry().upperLeftLine, hex.getGeometry().upperLeftPoint));
        assertTrue(checkLinePoint(hex.getGeometry().upperLeftLine, hex.getGeometry().upPoint));
    }
}