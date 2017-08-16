/*
    Aufgabe3) Rekursive Datenstrukturen und Interface

    Ein ListItem ist ein Gegenstand mit einer bestimmten Größe, der einen
    weiteren Gegenstand als "Nachfolger" hat. Das kann zum Beispiel ein
    Gegenstand sein, den man auf einen anderen Gegenstand (den Nachfolger in
    einem Stapel) legen kann, oder ein Gegenstand in dem man einen weiteren
    Gegenstand aufbewahren kann. Die Klasse Box repräsentiert eine Box mit einer
    bestimmten Größe und Farbe. In jeder Box kann wieder eine Box aufbewahrt
    werden, die wiederum eine Box enthalten kann, etc.. Eine Box-Referenz steht
    also im allgemeinen für ein Boxenset (die äußerste Box und alle enthaltenen
    Boxen).

    Im untenstehenden Programmgerüst sollen folgende Methoden vervollständigt
    werden:
    - countColors:        gibt eine Häufigkeitstabelle in Form einer Map zurück.
                          Für jede in dem Boxenset vorkommende Farbe (Schlüssel)
                          wird die Häufigkeit (Wert) gespeichert.
    - hasColor:           liefert true dann und nur dann, wenn es im Boxenset
                          eine Box mit der angegebene Farbe gibt.
    - isWellNested:       liefert true dann und nur dann, wenn jede Box im
                          Boxenset nur kleinere Boxen enthält.
    - isSortedDescending: eine static Methode, die dann und nur dann true
                          liefert, wenn jeder Gegenstand in der durch den
                          Startknoten angegebenen Liste von Gegenständen nur
                          kleinere Nachfolger hat.

    Zusatzfragen:
    1. Welche Änderungen wären sinnvoll, wenn man in einer Box anstelle einer
       Box ein Item oder ListItem aufbewahren will?
    2. Warum kann man für die Implementierung von "isWellNested" die Methode
       "isSortedDescending" nutzen? Wäre das umgekehrt auch möglich?
*/
import java.util.HashMap;

class Box implements ListItem {

    private String color;
    private int size;
    private Box content;

    //constructor: initializes this box with color and size, this box has no
    //content
    public Box(String color, int size) {
        this.color = color;
        this.size = size;
        this.content = null;
    }

    //constructor: initializes this box with color, size and content
    public Box(String color, int size, Box content) {
        this(color, size);
        this.content = content;
    }

    //returns a map with frequencies for each color occurring in the set of
    //boxes
    public HashMap<String, Integer> countColors() {

        HashMap<String, Integer> colors = null;

        if (this.content == null) {
            colors = new HashMap<>();
            colors.put(this.color/* TODO: modify expression*/,
                       1 /* TODO: modify expression*/);
        }
        else {
            colors = (this.content!=null)? this.content.countColors() :  this.countColors() /* TODO: modify expression*/ ;
            colors.put( this.color/* TODO: modify expression*/,
                       colors.containsKey(this.color)? colors.get(this.color)+1:1 /* TODO: modify expression*/);
        }
        return colors;
    }

    //returns true if at least one of the boxes in the set has the specified
    //color
    public boolean hasColor(String color) {
        return this.color.equals(color)?true: this.content!=null? this.content.hasColor(color):false /* TODO: modify expression*/;
    }

    //returns the size of this box
    @Override
    public int getSize() {
        return this.size;
    }

    //returns the box contained in this box
    @Override
    public Box getNext() {
        return this.content;
    }

    //true if and only if every box (this box and all nested boxes) contains
    //only smaller boxes
    public boolean isWellNested() {
        return this.content!=null?  this.getSize()>this.content.getSize()?true && this.content==null? true:this.content.isWellNested() :false : true /* TODO: modify expression*/ ;
    }

    //returns a readable representation of the box with all contained boxes.
    public String toString() {
        return "[" + this.color + " " + this.size + " " + this.content + "]";
    }
}

//An item with a specific size
interface Item {
    public int getSize();
}

//An item with a specific size that is part of a list of items. It therefore
//also has reference to the next item.
interface ListItem extends Item {
    //should be declared or overridden by every subclass (incl. abstract
    //subclasses)
    public ListItem getNext();
}

public class Aufgabe3 {

    //returns true if every item in the specified list of items has only
    //successors with smaller size, false otherwise (recursive check)
    public static boolean isSortedDescending(ListItem list) {
        if (list == null || list.getNext() == null) {
            return true /* TODO: modify expression*/ ;
        }
        else {
            return new Box(null, list.getSize(),(Box)list.getNext()).isWellNested() /* TODO: modify expression*/ ;
        }
    }
    //list.getNext().getNext()!=null? new Box(null,list.getSize(),(Box)list.getNext() ).isWellNested() : new Box(null,list.getSize(),(Box)list.getNext() ) /* TODO: modify expression*/ ;

    // just for testing ...
    public static void main(String[] args) {

        Box x1=new Box("yellow",2);
        Box x2=new Box("brown",3,x1);
        Box x3=new Box("pink",4,x2);
        Box x4=new Box("green",5,x3);
        Box x5=new Box("orange",6,x4);
        Box x6=new Box("violet",7,x5);



        Box some=new Box("red",8,x6);
        System.out.println( isSortedDescending((ListItem)some));//must be true

        Box y1=new Box("black",80);
        Box y2=new Box("black",70,y1);
        Box y3=new Box("something",90,y2);

        Box some2=new Box("something",100,y3);
        System.out.println( isSortedDescending((ListItem)some2));//must be false

        HashMap<String,Integer > maps =  some2.countColors();
        System.out.println(maps.get("black"));//must be 2
        System.out.println(maps.get("something"));//must be 2

    }
}