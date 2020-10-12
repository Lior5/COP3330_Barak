public class Pyramid extends Shape3D{
    double width, length, height;
    public Pyramid(double a, double b, double c){
        width = a;
        length = b;
        height = c;
    }

    @Override
    public String getName() {
        return "pyramid";
    }

    @Override
    public double getArea() {
        return length*width+length*Math.sqrt(width*width/4+height*height)+width*Math.sqrt(length*length/4+height*height);
    }

    @Override
    public double getVolume() {
        return width*length*height/3;
    }

}
