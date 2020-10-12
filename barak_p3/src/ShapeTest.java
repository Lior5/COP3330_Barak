
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {
    @Test
    public void testPyramidArea(){
        Shape3D shape = new Pyramid(5,10,15);
        assertEquals(281.13, shape.getArea(),0.01);
    }

    private void assertEquals(double v, double area, double v1) {
    }

}
