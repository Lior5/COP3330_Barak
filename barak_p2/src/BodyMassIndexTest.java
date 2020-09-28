public class BodyMassIndex{

    //BMI = 703 * pounds / inches^2
    double height_in_inches, weight;
    double BMI_value;

    public BodyMassIndex(double h, double w){
        height_in_inches = h;
        weight = w;
    }
    public double calculateBMI(){
        return (BMI_value = (703 * weight) / (height_in_inches * height_in_inches));
    }
    public String getBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Underweight";
        if (bmi < 30) return "Overweight";
        return "Obesity";
    }
    
}