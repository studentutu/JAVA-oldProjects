/***********************************************************************************
BEURTEILUNG von 1428773 für Aufgabe 1:  26 Punkte

        'replaceLast':	9 - bei einer leeren Liste sollte null zurückgegeben werden
        'equals':       6 - Überprüfung ob head == null, Abbruch Rekursion 
        'toString':     3 - head nicht auf null überprüft,
                            letztes Element wird nie ausgegeben
        'main':         8


Beispiel der wesentlichen Teile einer Lösung:

    class Node {
        ...

        private String replaceLast(String elem) {
            if (this.next == null) {
                String replaced = this.elem;
                this.elem = elem;
                return replaced;
            }
            return next.replaceLast(elem);
        }

        @Override
        public boolean equals(Object other) {
            if(other == null || other.getClass() != Node.class) {
                return false;
            }
            Node that = (Node)other;
            if(!this.elem.equals(that.elem)){
                return false;
            }
            if(that.next == null) {
                return this.next == null;
            } else {
                return this.next.equals(that.next);
            }
        }

        @Override
        public String toString() {
            if (next != null) {
                return elem + "," + next;
            }
            return elem;
        }

    } // End of the definition of Node

    ...

    public String replaceLast(String elem) {
        if (head == null) {
            return null;
        } else {
            return head.replaceLast(elem);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != List.class) {
            return false;
        }
        List that = ((List)other);
        if (this.head == null) {
            return that.head == null;
        }
        return this.head.equals(that.head);
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        return head.toString();
    }

    public static void main(String[] args) {
        List list1 = new List();
        list1.addFirst("c");
        list1.addFirst("b");
        list1.addFirst("a");
        System.out.println(list1);
        System.out.println(list1.replaceLast("cc"));
        System.out.println(list1);

        List list2 = new List();
        list2.addFirst("cc");
        list2.addFirst("b");
        list2.addFirst("a");
        System.out.println(list1.equals(list2));
        list1.addFirst("cc");
        System.out.println(list1.equals(list2));
    }

***********************************************************************************/
import java.util.Map;

/*
Lesen Sie die Aufgaben genau durch.
Verändern Sie die in den Aufgaben beschriebenen Programmstellen.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!

Achtung: Vorgegebene Testfälle überprüfen nur die Syntax. Sie überprüfen nicht die Korrektheit der Lösungen.
*/
public class List {

    /*
    Aufgabe:
        Objekte der Klasse List stellen verkettete Listen von Strings mit Knoten vom Typ Node dar.
        Ergänzen Sie fehlende Teile entsprechend den Kommentaren an den mit TODO: gekennzeichneten Stellen.

    Punkte (maximal 40):
        10 Punkte für replaceLast,
        10 Punkte für equals,
        10 Punkte für toString,
        10 Punkte für main.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    class Node {

        // Do not change the object variables.  Do not add further object variables.
        private String elem;
        private Node next;

        // Do not change the constructor.
        private Node(String elem, Node next) {
            this.elem = elem;
            this.next = next;
        }

        // TODO: Define here methods of Node (if needed).

        public boolean equals(Node n){
            if(this==n){
                return  true;
            }

            if(n==null || !(n instanceof Node)){
                return false;
            }

            if(this.elem!=n.elem){
                return  false;
            }
            boolean b=true && this.next.equals(n.next);
            return b;

        }

        @Override
        public String toString(){

            String  s="";
            Node n=this;

            while(n.next!=null){

                s=s+", "+n.elem;
                n=n.next;
            }
            return s;
        }

        public String  replaceLast(String s){

            Node n=this;

            while(n.next!=null){
                n=n.next;

            }

                String result=n.elem;
                n.elem=s;
            return  result;


        }


        // hashCode sollte hier zwar implementiert sein, geht aber nicht in die Beurteilung ein.
        @Override
        public int hashCode() {
            int n=(int)Math.PI*this.elem.length();

            if(this.next!=null){
            n=n+ (int)this.next.hashCode();
            }


            return n;
        }

    } // End of the definition of Node

    // Initially the list is empty.
    private Node head = null;

    // Adds a string as first element to the list;
    public void addFirst(String elem) {
        head = new Node(elem, head);
    }

    // Replaces the last element of the list with the specified element;
    // if the list is empty replaceLast has no effect;
    // returns the removed element; returns null if the list was empty.
    public String replaceLast(String elem) {
        // TODO: Implementation is your task
        if(elem==null){return "null";}

         String result=this.head.replaceLast(elem);
        return result;
    }

    // Returns true if and only if the parameter refers to a list of the same structure and content as 'this';
    // satisfies all general conditions on 'equals'.
    public boolean equals(Object other) {
        // TODO: Implementation is your task

        if(this==other){ return true;}
        if(other==null|| !(other instanceof List)){
            return  false;
        }

        if(this.head == ((List)other).head){return true;}
        boolean b=true && this.head.equals(((List) other).head) ;

        return b;
    }

    // hashCode just for completeness. need not be changed, not used for assessment.(geht nicht in die Beurteilung ein.)
    @Override
    public int hashCode() {
        return (int )(this.head.elem.length() * Math.PI);// irgendwelches nummer um identefizieren
    }

    // Returns a string containing the elements (separated by the comma character ',');
    // for example, if the list contains "x" (as first element), "y" and "z" (as last element), then toString()
    // returns "x,y,z";  for an empty list the result is the empty string "".
    @Override
    public String toString() {
        // TODO: Implementation is your task
        return ""+head;
    }

    // TODO: Complete main as described in the TODO comments.
    public static void main(String[] args) {
        List list1 = new List();
        // TODO: Call 'addFirst' 3 times such that the following statement prints: "a,b,c"
        list1.addFirst("c");
        list1.addFirst("b");
        list1.addFirst("a");
        System.out.println(list1);
        // TODO: Call 'replaceLast' on 'list1' to change the last element to "cc".
        String s=list1.replaceLast("cc");
        // TODO: Print a line with the element that 'replaceLast' returned. This statement prints: "c"
        System.out.printf("%s", s);
        System.out.println();
        // TODO: Print another line with the content of 'list1'. This statement prints: "a,b,cc"
        System.out.println(""+list1);

        List list2 = new List();
        // TODO: Add elements to the list 'list2' such that the following statement prints: "true";
        list2=list1;

        try {
            System.out.println(list1.equals(list2));
        }catch (Throwable t){
            System.err.println("Null Pointer");
        }

        // TODO: Modify 'list2' such that the following statement prints: "false"
        list1=new List();
        list1.addFirst("a");
        // List1 == null-->false
        System.out.println(list1.equals(list2));
        try {
            System.out.println(list1.equals(list2));
        }catch (Throwable t){
            System.err.println("Null Pointer");
        }
    }

}

