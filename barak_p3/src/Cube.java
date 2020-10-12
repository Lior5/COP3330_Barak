public class Cube extends Shape3D{
    double length;
    public Cube(double in){
        length = in;
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return 6*length*length;
    }

    @Override
    public double getVolume() {
        return length*length*length;
    }
}
