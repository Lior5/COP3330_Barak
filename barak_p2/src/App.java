
import java.util.*;
import java.io.*;
public class App{

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    public static boolean moreInput(){
        System.out.println("More Input? Enter Y or N:");
        while(true){
            String s = scan.next();
            if(s.equals("Y"))return true;
            if(s.equals("N"))return false;
            System.out.println("Please enter Y or N");
            scan.nextLine();
        }
    }
    public static double getUserHeight(){
        System.out.println("Please enter your height in inches:");
        while(true){
            try{
                double h = scan.nextDouble();
                if(h<0) throw null;
                return h;
            } catch (Exception e){
                System.out.println("Height must be postiive, please enter another number");
                scan.nextLine();
            }
        }
    }
    public static double getUserWeight(){
        System.out.println("Please enter your weight in pounds:");
        while(true){
            try{
                double w = scan.nextDouble();
                if(w<0) throw null;
                return w;
            } catch (Exception e){
                System.out.println("Weight must be postiive, please enter another number");
                scan.nextLine();
            }
        }
    }
    public static void displayBmiInfo(BodyMassIndex person){
        System.out.println("BMI Value: "+person.calculateBMI());
        System.out.println("BMI Category: "+person.getBMICategory());
    }
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> people){
        double sum = 0;
        for(BodyMassIndex curr:people){
            sum+=curr.calculateBMI();
        }
        if(people.size() == 0) {
            System.out.println("There is not enough data");
            return;
        }
        double average_BMI = sum/people.size();
        System.out.printf("The average BMI score of the data is %.2f",average_BMI);
    }

}