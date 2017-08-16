
/*

Hier ist ein Beispiel für die wesentlichen Teile einer Lösung:

    class Node {
        ...

        @Override
        public String toString() {
            String result = Integer.toString(elem);
            if (left != null) {
                result = left + "," + result;
            }
            if (right != null) {
                result += "," + right;
            }
            return result;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || ! this.getClass().equals(other.getClass())) {
                return false;
            }
            Node that = (Node) other;
            if (this.elem != that.elem) {
                return false;
            }
            if (this.left != null) {
                if (!this.left.equals(that.left)) {
                    return false;
                }
            } else {
                if (that.left != null) {
                    return false;
                }
            }
            if (this.right != null) {
                return this.right.equals(that.right);
            }
            return that.right == null;
        }

        // hashCode sollte hier zwar implementiert sein, geht aber nicht in die Beurteilung ein.
        @Override
        public int hashCode() {
            return 11111;
        }

    }

    ...

    public int maxDiff() {
        if (root == null) {
            return 0;
        }
        Node smallest = root;
        while (smallest.left != null) {
            smallest = smallest.left;
        }
        Node largest = root;
        while (largest.right != null) {
            largest = largest.right;
        }
        return largest.elem - smallest.elem;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "[]";
        }
        return "[" + root + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || ! this.getClass().equals(other.getClass())) {
            return false;
        }
        if (this.root == null) {
            return ((Tree) other).root == null;
        }
        return this.root.equals(((Tree) other).root);
    }

***********************************************************************************/
import java.util.Stack;

public class Tree {

    /*
    Aufgabe:
        Objekte der Klasse Tree stellen binäre Suchbäume über ganzen Zahlen mit Knoten vom Typ Node dar.
        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 25):
        9 Punkte für maxDiff,
        8 Punkte für toString,
        8 Punkte für equals.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    class Node {

        // Do not change these variables and the constructor.  Do not add further variables and constructors here.
        private int elem;
        private Node left;
        private Node right;

        private Node(int elem) {
            this.elem = elem;
        }

        // Do not change this method.
        private void add(int elem) {
            if (elem < this.elem) {
                if (left == null) {
                    left = new Node(elem);
                } else {
                    left.add(elem);
                }
            } else if (elem > this.elem) {
                if (right == null) {
                    right = new Node(elem);
                } else {
                    right.add(elem);
                }
            }
        }


        // TODO: Define further methods of Node here (if needed).

    } // End of the definition of Node


    // The root of the tree.  Do not change or add object variables.
    private Node root;


    // Adds elem to the tree if it is not already in the tree.  Do not change this method.
    public void add(int elem) {
        if (root == null) {
            root = new Node(elem);
        } else {
            root.add(elem);
        }
    }


    // Returns the difference between the largest and smallest value in the tree;
    // if possible, only a small part of the tree is visited;
    // the result is 0 if the tree is empty or contains only one element.
    public int maxDiff() {
        // TODO: Implementation is your task

    }


    // Returns a comma-separated list of the elements in ascending order (aufsteigend sortiert) within square brackets;
    // for example, if the tree contains 1, 2, 3 and 4, the result ist "[1,2,3,4]" (independent of the structure of the
    // tree);  for an empty tree the result is "[]".
    @Override
    public String toString() {
        // TODO: Implementation is your task

    }


    // Returns true if and only if the parameter refers to a tree of the same structure and content as 'this';
    // satisfies all general conditions on 'equals'.
    @Override
    public boolean equals(Object other) {
        // TODO: Implementation is your task

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

