/***********************************************************************************
Hier ist ein Beispiel für die wesentlichen Teile einer Lösung:

    class Node {
        ...

        private Node(int elem) {
            this.elem = elem;
        }

        private boolean add(int elem) {
            if (elem < this.elem) {
                if (left == null) {
                    left = new Node(elem);
                    return true;
                } else {
                    return left.add(elem);
                }
            } else if (elem > this.elem) {
                if (right == null) {
                    right = new Node(elem);
                    return true;
                } else {
                    return right.add(elem);
                }
            }
            return false;
        }

        private void toQueue(Queue<String> queue) {
            if (left != null) {
                left.toQueue(queue);
            }
            queue.offer(Integer.toString(elem));
            if (right != null) {
                right.toQueue(queue);
            }
        }

        private int count() {
            int n = 1;
            if (left != null) {
                n += left.count();
            }
            if (right != null) {
                n += right.count();
            }
            return n;
        }

    }

    ...

    public boolean add(int elem) {
        if (root == null) {
            root = new Node(elem);
            return true;
        }
        return root.add(elem);
    }

    public Queue<String> toQueue() {
        Queue<String> queue = new LinkedList<String>();
        if (root != null) {
            root.toQueue(queue);
        }
        return queue;
    }

    @Override
    public String toString() {
        return "tree with " + (root == null ? 0 : root.count()) + " integers";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || ! this.getClass().equals(other.getClass())) {
            return false;
        }
        Queue<String> thisQueue = this.toQueue();
        Queue<String> otherQueue = ((Tree)other).toQueue();
        for (;;) {
            String s = thisQueue.poll();
            String t = otherQueue.poll();
            if (s == null) {
                return t == null;
            }
            if (!s.equals(t)) {
                return false;
            }
        }
    }

***********************************************************************************/
import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    /*
    Aufgabe:
        Objekte der Klasse Tree stellen binäre Suchbäume über ganzen Zahlen mit Knoten vom Typ Node dar.
        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 25):
        6 Punkte für add,
        6 Punkte für toQueue,
        6 Punkte für toString,
        7 Punkte für equals.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    class Node {

        // Do not change these variables.  Do not add further object variables.
        private int elem;
        private Node left;
        private Node right;

        // TODO: Define constructors and methods of Node here (if needed).
        

    } // End of the definition of Node ////////////////////////////////////////////////////////////////////////////


    // The root of the tree.  Do not change or add object variables.
    private Node root;


    // Adds elem to the tree if it is not already in the tree;
    // returns false if elem was already in the tree before (not added);
    // returns true if elem is added (was not in the tree before).
    public boolean add(int elem) {
        // TODO: Implementation is your task
        return true;
    }


    // Returns a queue containing the elements of the tree in string representation (this is, "1" instead of 1);
    // the elements of the queue are in ascending ordering (aufsteigend sortiert),
    // queue.poll() returns the string with the smallest number first.
    public Queue<String> toQueue() {
        // TODO: Implementation is your task
        return null;
    }


    // Returns a string "tree with ... integers" where ... is replaced with the number of elements of the tree.
    @Override
    public String toString() {
        // TODO: Implementation is your task
        return "";
    }


    // Returns true if and only if the parameter refers to a tree containing the same elements as 'this';
    // the structure of the tree does not matter;  satisfies all general conditions on 'equals'.
    @Override
    public boolean equals(Object other) {
        // TODO: Implementation is your task
        return false;
    }


    // Just for completeness.  Need not be changed, not used for assessment (geht nicht in die Beurteilung ein).
    @Override
    public int hashCode() {
        return 123456;
    }


    // Just for testing, not used for assessment (geht nicht in die Beurteilung ein).
    public static void main(String[] args) {
    }

}

