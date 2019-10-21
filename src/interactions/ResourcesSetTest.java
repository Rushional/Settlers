package interactions;

import org.junit.jupiter.api.Test;

import static interactions.ResourcesSet.subtractSet;
import static org.junit.jupiter.api.Assertions.*;

class ResourcesSetTest {

    @Test
    void subtractSetTest1() {
        //subtract 2 custom sets
        ResourcesSet set1 = new ResourcesSet(1,1,1,1, 1);
        ResourcesSet set2 = new ResourcesSet(1, 1, 0, 0, 0);
        ResourcesSet set1Updated;
        set1Updated = subtractSet(set1, set2);
        assertEquals(0, set1Updated.getWood());
        assertEquals(0, set1Updated.getBricks());
        assertEquals(1, set1Updated.getSheep());
        assertEquals(1, set1Updated.getWheat());
        assertEquals(1, set1Updated.getOre());
    }
}