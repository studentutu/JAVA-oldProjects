
/*

Hier ist ein Beispiel für die wesentlichen Teile einer Lösung:

    class Node {
        ...

        private Node(String elem, Node next) {
            this.elem = elem;
            this.next = next;
        }

        public String toString() {
            Node node = this;
            String result = "";
            while (node.next != null) {
                result += node.elem + ",";
                node = node.next;
            }
            result += node.elem;
            return result;
        }

    }

    ...

    public void addFirst(String elem) {
        head = new Node(elem, head);
    }

    public void addLast(String elem) {
        if (head == null) {
            head = new Node(elem, null);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(elem, null);
        }
    }

    public String remove() {
        if (head == null) {
            return null;
        }
        String result = head.elem;
        head = head.next;
        return result;
    }

    public List reverseCopy() {
        List result = new List();
        Node node = head;
        while (node != null) {
            result.addFirst(node.elem);
            node = node.next;
        }
        return result;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        return "[" + head + "]";
    }

    public static void main(String[] args) {
        List list = new List();
        list.addFirst("d");
        list.addFirst("c");
        list.addFirst("b");
        list.addFirst("a");
        System.out.println(list);
        System.out.println(list.remove());
        System.out.println(list);
        List copy = list.reverseCopy();
        copy.addLast("a");
        System.out.println(copy);
        System.out.println(list.remove());
        System.out.println(list);
        System.out.println(copy.remove());
        System.out.println(copy);

    }

***********************************************************************************/
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

    Punkte (maximal 30):
        5 Punkte für addFirst,
        5 Punkte für addLast,
        5 Punkte für remove,
        5 Punkte für reverseCopy,
        5 Punkte für toString,
        5 Punkte für main.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    class Node {

        // Do not change the object variables.  Do not add further object variables.
        private String elem;
        private Node next;

        // TODO: Define here constructors and methods of Node (if needed).

    } // End of the definition of Node


    // Initially the list is empty.
    private Node head = null;


    // Adds a string as first element to the list;  a call of remove() directly after addFirst("x") returns "x".
    public void addFirst(String elem) {
        // TODO: Implementation is your task

    }


    // Adds a string as last element to the list.
    public void addLast(String elem) {
        // TODO: Implementation is your task

    }


    // Removes and returns the first element of the list;  the result is null if the list is empty.
    public String remove() {
        // TODO: Implementation is your task

    }


    // Returns a new list containing the same elements as 'this', but in reverse order;  'this' remains unchanged;
    // if p.toString() returns "[x,y,z]" for a list p, then p.reverseCopy().toString() returns "[z,y,x]".
    public List reverseCopy() {
        // TODO: Implementation is your task

    }


    // Returns a comma-separated list of the elements in square brackets;  for example, if the list contains
    // "x" (as first element), "y" and "z" (as last element), then toString() returns "[x,y,z]";
    // for an empty list the result is "[]".
    @Override
    public String toString() {
        // TODO: Implementation is your task
    }


    // TODO: Complete main as in the TODO comments.
    public static void main(String[] args) {
        List list = new List();


        // TODO: Call addFirst 4 times such that ...
        // TODO: ... this statement prints: [a,b,c,d]

        // TODO: Call remove on 'list' and print a line with the removed element.

        // TODO: Print another line with the content of 'list'.

        // TODO: Create a new list 'copy' by calling reverseCopy on 'list'.

        // TODO: Use addLast to add "a" to 'copy'.

        // TODO: Print a line with the content of 'copy'.

        // TODO: Call remove on 'list' and print a line with the removed element.

        // TODO: Print another line with the content of 'list'.

        // TODO: Call remove on 'copy' and print a line with the removed element.

        // TODO: Print another line with the content of 'copy'.



    }

}


