/***********************************************************************************
Hier ist ein Beispiel für die wesentlichen Teile einer Lösung:

    public static void plus(long[] accumulate, long[] arg) {
        if (accumulate != null && arg != null && accumulate.length == arg.length) {
            plus(accumulate, arg, 0);
        }
    }

    private static void plus(long[] accumulate, long[] arg, int i) {
        if (i < accumulate.length) {
            accumulate[i] += arg[i];
            plus(accumulate, arg, i + 1);
        }
    }

    public static long[][] pascal(int n) {
        long[][] x = new long[n + 1][];
        for (int i = 0; i <= n; i++) {
            x[i] = new long[i + 1];
            x[i][0] = 1;
            x[i][i] = 1;
            for (int j = 1; j < i; j++) {
                x[i][j] = x[i - 1][j - 1] + x[i - 1][j];
            }
        }
        return x;
    }

    public static void print(long[][] array) {
        if (array != null) {
            for (long[] line : array) {
                if (line != null) {
                    if (line.length > 0) {
                        System.out.print(line[0]);
                        for (int i = 1; i < line.length; i++) {
                            System.out.print("," + line[i]);
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

***********************************************************************************/
import sun.reflect.generics.tree.Tree;

public class Arrays {

    /*
    Aufgabe:
        Ergänzen Sie fehlende Teile der Methoden entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 21):
        7 Punkte für plus,
        7 Punkte für pascal,
        7 Punkte für print.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    // arg[i] is added to accumulate[i] for each index i (this is, accumulate[i] is incremented by arg[i]).
    // accumulate remains unchanged if any of the parameters is null or the arrays are of different sizes.
    // The implementation is recursive.  No loop occurs in the implementation.
    public static void plus(long[] accumulate, long[] arg) {
        // TODO: Implementation is your task
        // Note: Additional methods can be used only if they contain no loop (just recursion).
    }

    // An array x returned by pascal(n) with n >= 0 is constructed as follows:
    //     x[i][0] = 1  for  i = 0,..,n
    //     x[i][i] = 1  for  i = 0,..,n
    //     x[i][j] = x[i-1][j-1] + x[i-1][j]  for  i = 1,..,n  and  j = 1,..,i-1
    // The array contains only these specified values, no additional values.
    // For example, using 'print' as described below, print(pascal(4)) shall produce this output:
    //     1
    //     1,1
    //     1,2,1
    //     1,3,3,1
    //     1,4,6,4,1
    // There are loops in the implementation; the implementation is not recursive.
    public static long[][] pascal(int n) {
        return null;
    }


    // 'print' produces output showing the values in the array given as parameter.
    // There is a separate line for each index in the first dimension.
    // Values on the same line are separated by ",".
    // The description of 'pascal' gives an example.
    // 'print' does nothing if its parameter is null.
    // No line is printed if the corresponding part of the array is null.
    public static void print(long[][] array) {
        // TODO: Implementation is your task
        
    }


    // Just for testing, not used for assessment (geht nicht in die Beurteilung ein).
    public static void main(String[] args) {
    }

}
