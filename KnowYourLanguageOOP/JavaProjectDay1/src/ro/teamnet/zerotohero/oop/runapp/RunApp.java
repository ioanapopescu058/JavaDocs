package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public class RunApp {

    public static void main(String[] args) {

        Circles c = new Circles();

        c.getAreaPub();
        c.getAreaDef();

        System.out.println("The default circle area is " + c.getAreaPub());

        Circle c1 = new Circle();
        System.out.println(c1.toString());

        Canvas canvas = new Canvas();
        //canvas.paint();

        Shape s = new Circle(10);
        System.out.println("Circle area(Shape): " + s.area());

        ShapeBehaviour sb = new Square(10);
        System.out.println("Square area (Shape Behaviour): " + sb.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

    }
}
