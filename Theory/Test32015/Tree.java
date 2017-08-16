/***********************************************************************************
BEURTEILUNG von 1428773 für Aufgabe 2:  18 Punkte

        'countLeaves':  7 - typos: = statt +=; left statt right
        'add(Tree)':    2 - Fall root==null falsch; nicht sortiert; teilweise doppelt hinzugefügt; ggf. Endlosrekursion. Zu kompliziert!
        'toString':     9 - " " am Anfang


Beispiel der wesentlichen Teile einer Lösung:

    class Node {
        ...

        private int countLeaves() {
            if (left == null && right == null) {
                return 1;
            }
            int count = 0;
            if (left != null) {
                count = left.countLeaves();
            }
            if (right != null) {
                count += right.countLeaves();
            }
            return count;
        }

        private void add(Node other) {
            if(other == null) {
                return;
            }
            if(other.left != null) {
                add(other.left);
            }
            add(other.elem);
            if(other.right != null) {
                add(other.right);
            }
        }

        @Override
        public String toString() {
            String result = Integer.toString(elem);
            if (right != null) {
                result = right + " " + result;
            }
            if (left != null) {
                result += " " + left;
            }
            return result;
        }

    } // End of the definition of Node

    ...

    public int countLeaves() {
        if (root == null) {
            return 0;
        }
        return root.countLeaves();
    }

    public void add(Tree other) {
        if(other == null || other.root == null) {
            return;
        }
        if(this.root == null) {
            this.add(other.root.elem);
            this.root.add(other.root.left);
            this.root.add(other.root.right);
            return;
        }
        root.add(other.root);
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
        return root.toString();
    }

***********************************************************************************/
public class Tree {

    /*
    Aufgabe:
        Objekte der Klasse Tree stellen binäre Suchbäume über ganzen Zahlen mit Knoten vom Typ Node dar.
        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.


    Punkte (maximal 30):
        10 Punkte für countLeaves,
        10 Punkte für add(Tree),
        10 Punkte für toString.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    class Node {

        // Do not change these variables and the constructor.  Do not add further variables and constructors here.
        private int elem;
        private Node left;
        private Node right;

        // Do not change the constructor.
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
            } else {
                if (right == null) {
                    right = new Node(elem);
                } else {
                    right.add(elem);
                }
            }
        }

        // TODO: Define further methods of Node here (if needed).
        
        // will be StackOverflow somewhere
        public void addTree(Node other){

            if(other==null){
                return;
            }

            if(this.elem>other.elem){//geht in linke Baum
                if(this.left==null) {
                    this.left = new Node(other.elem);
                    this.left.addTree(other.left);
                    this.left.addTree(other.right);

                }else{

                    if(this.left.elem<other.elem){
                        Node n=this.left;
                        this.left=other;
                        this.left.addTree(n);
                        this.left.addTree(other.left);
                        this.left.addTree(other.right);


                    }else {//elem >other elem

                        this.left.addTree(other);
                    }

                }


                return;
            }else { //(this.elem<other.elem)  geht im rechte Baum

                if(this.right==null){

                    this.right=new Node(other.elem);
                    this.right.addTree(other.left);
                    this.right.addTree(other.right);

                }else{
                        if(this.right.elem<other.elem){

                            Node n=this.right;
                            this.right=other;
                            this.right.addTree(n);
                            this.right.addTree(other.left);
                            this.right.addTree(other.right);
                        }
                    else{//elem > other elem
                            this.right.addTree(other);

                        }

                }

                return;
            }


        }//end of addTree

        public int countLeafesNodes(){
            int n=0;
            if(this.left!=null){
                n=this.left.countLeafesNodes();
            }
            if(this.right!=null){
                n+=this.left.countLeafesNodes();
            }
            if((this.left ==null )&&(this.right==null)){
                n=n+1;
                return n;
            }

            return n;

        }//countLeaves

        @Override
        public String toString(){
            String s="";
            if(this.right!=null){
                s=" "+this.right +s;
            }
            s=s+" "+this.elem;
            if(this.left!=null){

                s=s+this.left;
            }
            return s;
        }



    } // End of the definition of Node

    // The root of the tree.  Do not change or add object variables.
    private Node root;

    // Adds elem to the tree.  (Multiple elements with the same value are allowed.)
    // Do not change this method.
    public void add(int elem) {
        if (root == null) {
            root = new Node(elem);
        } else {
            root.add(elem);
        }
    }

    // Returns the number of leaf nodes (Blattknoten) in the tree.
    public int countLeaves() {
        // TODO: Implementation is your task

        if(this.root==null){
            return 0;
        }
        return this.root.countLeafesNodes();
    }

    // Adds all elements of the specified tree to this tree. (Multiple elements with the same value are allowed.)
    public void add(Tree other) {
        //TODO: Implementation is your task

        if(other==null){
            return;
        }

            try {
                this.root.addTree(other.root);
            }
        catch (Throwable t){
            if(t instanceof RuntimeException){
                System.err.println(" RuntimeException");
            }
            //sonst nichts zu machen
        }
    }

    // Returns a string containing the elements in descending order (absteigend sortiert);
    // the elements are separated by " ";
    // for example, if the tree contains 1, 2, 3 and 4, the result ist "4 3 2 1" (independent of the structure of
    // the tree);  for an empty tree the result is "".
    @Override
    public String toString() {
        // TODO: Implementation is your task

        if(this.root==null){
            return "";
        }
        return ""+root;
    }

    // Just for testing, not used for assessment (geht nicht in die Beurteilung ein).
    public static void main(String[] args) {

        //soll funktioniert
    }

}

