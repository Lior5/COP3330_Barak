public class Sphere extends Shape3D{
    double radius = 0;
    public Sphere(double in){
        radius = in;
    }
    @Override
    public double getVolume() {
        return radius*radius*radius*4/3*Math.PI;
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        return 4*radius*radius*Math.PI;
    }
}
