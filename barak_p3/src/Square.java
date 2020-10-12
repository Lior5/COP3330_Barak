public class Square extends Shape2D{
    double length;
    public Square(double in){
        length = in;
    }

    @Override
    public String getName() {
        return "square";
    }

    @Override
    public double getArea() {
        return length*length;
    }
}
