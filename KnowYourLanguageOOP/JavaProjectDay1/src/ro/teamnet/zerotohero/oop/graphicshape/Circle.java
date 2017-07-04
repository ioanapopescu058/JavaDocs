package ro.teamnet.zerotohero.oop.graphicshape;
import static java.lang.Math.PI;
/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public class Circle extends Shape {

    private int xPos, yPos, radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 0;
    }

    public Circle(int xPos) {
        this.xPos = xPos;
        this.yPos = 0;
        this.radius = 0;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = 0;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    public double area() {
        double area = PI * (radius * radius);
        return area;
    }

    @Override
    public String toString() {
        return "center = (" + xPos + "," + yPos + ") and radius = " + radius;
    }

    public void fillColour() {
        System.out.println("Color: " + super.color);
    }

    public void fillColour(int color) {
        super.setColor(color);
        System.out.println("The circle color is now " + color);
    }

    public void fillColour(float saturation) {
        setSaturation(saturation);
        System.out.println("The saturation is now " + color);
    }
}
