import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleNumericalOperationsTest {

    SimpleNumericalOperations sob = new SimpleNumericalOperations();

    @Test
    public void testAddition(){
        assertEquals(2, sob.add(1,1));
        assertEquals(4, sob.add(3,1));

    }

    @Test
    public void testPosNeg(){
        assertAll("Group assertions",
                () -> assertTrue(sob.isNegative(-5)),
                () -> assertTrue(sob.isPositive(5)),
                () -> assertTrue(sob.isPositive(5)),
                () -> assertEquals(true,sob.isPositive(3)),
                () -> assertEquals(false, sob.isZero(10)),
                () -> assertTrue(sob.isZero(0))
        );
    }
}
