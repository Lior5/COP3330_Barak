public class Triangle extends Shape2D{
    double base;
    double height;
    public Triangle(double a, double b){
        base = a;
        height = b;
    }

    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public double getArea() {
        return base*height/2;
    }
}
