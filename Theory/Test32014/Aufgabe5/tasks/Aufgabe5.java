/**********

/**************************** eine mögliche Lösung ****************************
  public static boolean proper(Aufgabe5 left, int elem, Aufgabe5 right) {
      if (left != null) {
          while (left.right != null) {
              left = left.right;
          }
          if (elem < left.elem) {
              return false;
          }
      }
      if (right != null) {
          while (right.left != null) {
              right = right.left;
          }
          if (elem > right.elem) {
              return false;
          }
      }
      return true;
  }


  public String toString() {
      return "[" + (this.left == null ? "*" : this.left) + " " + this.elem + " " + (this.right == null ? "*" : this.right) + "]";
  }


  public static void main(String[] args) {
      try {
          Aufgabe5 test = new Aufgabe5(new Aufgabe5(new Aufgabe5(null, 1, null), 2, new Aufgabe5(null, 3, null)), 4, new Aufgabe5(new Aufgabe5(null, 5, null), 6, new Aufgabe5(null, 7, null)));
          System.out.println(test);
      }
      catch (Exception ex) {
          System.out.println("error");
      }
  }
*******************************************************************************/
import sun.org.mozilla.javascript.ast.CatchClause;

public class Aufgabe5 {
    // a tree of int values

    /*
    Implementieren Sie die mit einer Aufforderung dazu versehenen Methoden
    entsprechend den Kommentaren möglichst kurz und einfach.
    Lassen Sie alle anderen Teile der Klasse unverändert.

    Punkte:
      Für diese Aufgabe sind 50 Punkte erreichbar:
        20 Punkte für proper,
        15 Punkte für toString,
        15 Punkte für main.
      Es werden auch richtige Teilschritte bewertet.
    */

    private int elem;
    private Aufgabe5 left, right;   // null if no left or right subtree
    // there are no further object variables and class variables

    public Aufgabe5(Aufgabe5 left, int elem, Aufgabe5 right) throws Exception {
        this.elem = elem;
        this.left = left;
        this.right = right;
        if (! proper(left, elem, right)) {
            throw new Exception();
        }
    }

    // 'proper' returns 'true' if no element in 'left' is larger than 'elem' and no element in 'right' is smaller than 'elem'
    public static boolean proper(Aufgabe5 left, int elem, Aufgabe5 right) {
        return false;   // TODO: Implementation is your task

        if(this.left < this.right && this.elem == elem) {


            else{
                proper(Aufgabe5.next, int elem, Aufgabe5.next);
            }

            return this.elem;
        }




        if(Aufgabe5 == null || Aufgabe5.equals(0) {
            return false;
        }


    }

    // tree as string of the form "[l i r]" where i is the element, l the left subtree, and r the right subtree;
    // an empty subtree is represented by "*";  example see below
    @Override
    public String toString() {
        if(proper == false){
            return "*";
        }

        else {
            return "(newTask.left + " " + int elem + " " +  newTask.right)";
        }




    }

    // 'main' tests Aufgabe5 in the following way:
    // * create a tree such that 'toString' produces the following string:
    //     "[[[* 1 *] 2 [* 3 *]] 4 [[* 5 *] 6 [* 7 *]]]"
    // * print a line with the string representation of the tree
    // exceptions thrown thereby must be handled; they lead to the output of "error", but no stack trace
    public static void main(String[] args) {

        Aufgabe5 newTask = new Aufgabe5();

        System.out.println(newTask);








    }
}

