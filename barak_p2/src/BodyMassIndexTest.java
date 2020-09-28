import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BodyMassIndexTest{

    @Test
    public void testUnderweightBMI(){
        BodyMassIndex bmi = new BodyMassIndex(74,125);
        String category = bmi.getBMICategory();
        assertEquals("Underweight",category);
    }
    @Test
    public void testNormalweightBMI(){
        BodyMassIndex bmi = new BodyMassIndex(70,135);
        String category = bmi.getBMICategory();
        assertEquals("Normal weight",category);
    }
    @Test
    public void testOverweightBMI(){
        BodyMassIndex bmi = new BodyMassIndex(63,155);
        String category = bmi.getBMICategory();
        assertEquals("Overweight",category);
    }
    @Test
    public void testObeseBMI(){
        BodyMassIndex bmi = new BodyMassIndex(25,300);
        String category = bmi.getBMICategory();
        assertEquals("Obese",category);
    }
    @Test
    public void testBMICalculator(){
        BodyMassIndex bmi = new BodyMassIndex(100,100);
        assertEquals(7.0,bmi.calculateBMI());
    }

}