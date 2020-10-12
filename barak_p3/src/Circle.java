public class Circle extends Shape2D{
    double radius;
    public Circle(double in){
        radius = in;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }
}
