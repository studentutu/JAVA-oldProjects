/*
    Aufgabe2) Interfaces

    Gegeben sind die Interfaces Movable, Copyable und ShapeOnPlane.
    ShapeOnPlane und Movable beziehen sich auf geometrische Objekte in einem
    2D-Koordinatensystem. Es gibt eine Klasse Point welche einen
    2D-Punkt mit x- und y-Koordinaten repräsentiert. Ergänzen Sie die fehlenden
    Teile zu Point. Es sind folgende Klassen zu implementieren:

    - Point:    ist ein Punkt in der Ebene und implementiert Movable.
    - Triangle: repräsentiert ein Dreieck bestehend aus 3 Eckpunkten (Point).
                Ein Triangle-Objekt wird mit der Angabe von drei Point-Objekten
                erzeugt. Schreiben Sie einen entsprechenden Konstruktor.
    - Circle:   repräsentiert einen Kreis mit Mittelpunkt (Point) und
                radius (double). Ein Circle-Objekt wird mit der Angabe von einem
                Mittelpunkt (Point) und dem Radius (double) erzeugt. Schreiben
                Sie einen entsprechenden Konstruktor.

    Triangle und Circle sollen ShapeOnPlane implementieren. Dies ist die
    gemeinsame Schnittstelle für geometrische Formen in der 2D-Ebene. Solche
    Objekte können verschoben werden (move) und haben einen Umfang (perimeter).
    Weiters können von diesen Objekten mit der parameterlosen Methode copy()
    unabhängige Kopien erzeugt werden. Nachfolgende Änderungen (z.B. durch move)
    des Originals haben keine Auswirkungen auf die Kopie und umgekehrt.

    Triangle und Circle sollen über eine öffentliche parameterlose Methode
    toString() verfügen, die eine lesbare Repräsentation (als String) des
    Objekts zurückliefert. Zahlen sollen dabei mit zwei Nachkommastellen
    dargestellt werden. Siehe die toString()-Methode in Point sowie die
    Testfälle in Aufgabe4.main(). Hinweis: toString() wird implizit aufgerufen,
    wenn ein Objekt vom Typ Triange, Circle, Point, ShapeOnPlane, etc. mit
    System.out.println() ausgegeben wird. Daher wird der Aufruf in den
    Beispielen in Aufgabe4.main() teilweise nicht explizit angegeben.

    Sie können in dieser Aufgabe auch Methoden aus java.util.Arrays nutzen.

    Zusatzfragen:
    1. Wozu benötigt man Interfaces?
    2. Was bedeutet es, wenn ein Interface ein anderes Interface
       erweitert (extends)?
    3. Welche der folgenden Ausdrücke sind nach der Anweisung
       Movable point = new Point(1d,2d);
       gültig? Warum?

        point.distanceTo(new Point(0d,0d))
        point.move(0.5,1d)
        point.copy()
        point.toString()
*/
import java.util.Arrays;
import java.util.Locale;

interface Movable {
    //shifts the object by the vector (deltaX, deltaY)
    public void move(double deltaX, double deltaY);
}

interface Copyable {
    //returns an independent copy of an object
    //should be declared or overridden by every subclass
    //(even by abstract subclasses)
    Copyable copy();
}

interface ShapeOnPlane extends Movable, Copyable {
    //returns the perimeter of the shape
    public double perimeter();
    public ShapeOnPlane copy();
}

class Point implements Movable /*TODO: add clause here*/ {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public String toString() {
        return "("+String.format("%.2f",x)+","+String.format("%.2f",y)+")";
    }

    public void move(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public double distanceTo(Point p) {
        return Math.hypot(p.x - this.x, p.y - this.y);
    }

    public Point copy() {
        return new Point(this.x,this.y)/*TODO: modify expression */ ;
    }
}


class Triangle implements ShapeOnPlane /* TODO: add clause here */ {

    /* TODO: complete Triangle-class definition */
    private Point pp1;
    private Point pp2;
    private Point pp3;
    Triangle(Point p1,Point p2, Point p3){

        this.pp1=p1;
        this.pp2=p2;
        this.pp3=p3;
    }
    @Override
    public String toString(){
        String s="";
        s=s+this.pp1.toString() + this.pp2.toString()+this.pp3.toString();
        return s;
    }
    @Override
    public void move(double deltaX, double deltaY){
        this.pp1.move(deltaX,deltaY);
        this.pp2.move(deltaX,deltaY);
        this.pp3.move(deltaX,deltaY);

    };
    @Override
    public double perimeter(){

        double perimeter=0;
        perimeter=this.pp1.distanceTo(this.pp2)+this.pp1.distanceTo(this.pp3)+ this.pp2.distanceTo(this.pp3);

        return perimeter;
    };
    @Override
    public ShapeOnPlane copy(){

        Triangle s=new Triangle(this.pp1.copy(),this.pp2.copy(),this.pp3.copy());

        return (ShapeOnPlane)s;
    };

}

class Circle implements ShapeOnPlane/* TODO: add clause here */ {

    /* TODO: complete Triangle-class definition */
    private Point mittelpunkt;
    private double radius;

    Circle(Point p, double radius){
        this.mittelpunkt=p;
        this.radius=radius;

    }
    @Override
    public String toString(){
        String s="";
        s=s+this.mittelpunkt.toString() + " Radius " + this.radius;
        return s;
    }
    @Override
    public void move(double deltaX, double deltaY){
        this.mittelpunkt.move(deltaX,deltaY);
    };
    @Override
    public double perimeter(){
            double perim=Math.PI*2*this.radius;
        return perim;
    };
    @Override
    public ShapeOnPlane copy(){
        Circle c=new Circle(this.mittelpunkt.copy(),this.radius);
        return (ShapeOnPlane)c;
    };
}


public class Aufgabe2 {

    //just for testing
    public static void main(String[] args) {
        //Entfernen Sie zum Testen die folgenden Kommentarzeichen.

        ShapeOnPlane shape = new Circle(new Point(2.5, -1.0), 1.0);
        System.out.println(shape.toString()); //[(2.50,-1.00),1.00]
        ShapeOnPlane copy = shape.copy();
        shape.move(1.0,1.5);
        System.out.println(shape); //[(3.50,0.50),1.00]
        System.out.println(copy); //[(2.50,-1.00),1.00]
        System.out.println(shape.perimeter()); //6.283185307179586
        System.out.println(copy.perimeter()); //6.283185307179586
        shape.move(1.0,1.5);
        System.out.println(shape); //[(4.50,2.00),1.00]
        shape = new Triangle(new Point(2.5, 1.0),
                             new Point(-1.0,3.0),
                             new Point(0d,0d));
        System.out.println(shape.perimeter()); //9.885988937884907
        System.out.println(shape); //[(2.50,1.00), (-1.00,3.00), (0.00,0.00)]

    }
}