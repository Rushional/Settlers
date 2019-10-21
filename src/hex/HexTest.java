package hex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HexTest {
    boolean checkLinePoint(HexLine line, HexPoint point) {
        boolean connectedFlag = false;
        for (int i = 0; i <= 1; i++) {
            if (line.points[i] == point)
                for (int j = 0; j <= 2; j++) {
                    if (line == line.points[i].lines[j]) connectedFlag = true;
                }
        }
        return connectedFlag;
    }

    //@Test
    public void hexCompositionTest(int upPointX, int upPointY) {
         Hex hex = new Hex();
         assertTrue(checkLinePoint(hex.upperRightLine, hex.upPoint));
         assertTrue(checkLinePoint(hex.upperRightLine, hex.upperRightPoint));
         assertTrue(checkLinePoint(hex.middleRightLine, hex.upperRightPoint));
         assertTrue(checkLinePoint(hex.middleRightLine, hex.lowerRightPoint));
         assertTrue(checkLinePoint(hex.lowerRightLine, hex.lowerRightPoint));
         assertTrue(checkLinePoint(hex.lowerRightLine, hex.lowPoint));
         assertTrue(checkLinePoint(hex.lowerLeftLine, hex.lowPoint));
         assertTrue(checkLinePoint(hex.lowerLeftLine, hex.lowerLeftPoint));
         assertTrue(checkLinePoint(hex.middleLeftLine, hex.lowerLeftPoint));
         assertTrue(checkLinePoint(hex.middleLeftLine, hex.upperLeftPoint));
         assertTrue(checkLinePoint(hex.upperLeftLine, hex.upperLeftPoint));
         assertTrue(checkLinePoint(hex.upperLeftLine, hex.upPoint));
    }

    @Test
    public void singleHexTest() {
        hexCompositionTest(200, 30);
    }
}