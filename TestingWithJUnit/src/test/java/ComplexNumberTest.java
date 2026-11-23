import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexNumberTest {
    private static Cplx cplx;

    //For each test method, ComplexNumberTest is instantiated alongside it's attribute -since it is composition.
    //Because this class and its attribute is being instantiated each time the attribute's values were 2,3.
    //However, once it is changed to static, every ComplexNumberTest object, instantiated for each @Test method,
    //shared this attribute and some of the test methods changed its value rendering some test methods invalid.

    @Test
    public void compareCplxArr(){
        assertArrayEquals(
                new Cplx(2,3).getCplxArr()
                , cplx.getCplxArr())
        ;
    }

    @Test
    public void testToString(){
        assertEquals(
                new Cplx(2,3).toString()
                ,cplx.toString()
        );
    }

    @Test
    public void testAddAss(){
        assertEquals(
                new Cplx(4,6)
                ,cplx.addAss(new Cplx(2,3))
        );
    }

    @Test
    public void testSubAss(){
        assertEquals(
                new Cplx(1,1)
                ,cplx.subAss(new Cplx(1,2))
        );
    }

    //@BeforeEach solved this aforementioned static attribute issue.
    @BeforeEach
    public void setup(){
        this.cplx = new Cplx(2,3);
    }
}
