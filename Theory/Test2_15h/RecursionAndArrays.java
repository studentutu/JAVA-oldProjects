/***********************************************************************************
Hier ist ein Beispiel für eine Lösung (ohne inhaltliche Kommentare):

 public static long sumMul(final int m, final int n) {
 if (m == n) {
 if (n == 1) {
 return 1;
 }
 return (n % 2 == 1 ? n : 0) + sumMul(n - 1, n - 1);
 }
 return sumMul(m, n - 1) * sumMul(n, n);
 }

 public static long[][] sumMulArray(int n) {
 long[][] result = new long[n][];
 result[0] = new long[n];
 result[0][0] = 1;
 for (int j = 1; j < n; j++) {
 result[0][j] = (j % 2 == 0 ? j + 1 : 0) + result[0][j - 1];
 }
 for (int i = 1; i < n; i++) {
 result[i] = new long[n - i];
 for (int j = 0; j < n - i; j++) {
 result[i][j] = result[0][j] * result[i - 1][j + 1];
 }
 }
 return result;
 }

 public static void printArray(long[][] array) {
 if (array != null) {
 for (long[] line : array) {
 if (line != null) {
 for(long v : line) {
 System.out.print(v + ";");
 }
 System.out.println();
 }
 }
 }
 }

 public static void main(String[] args) {
 System.out.println(sumMul(2, 2));
 System.out.println(sumMul(3, 3));
 System.out.println(sumMul(4, 4));
 // In der Aufgabenstellung waren die Argumente der folgenden Aufrufe
 // leider irrtümlich vertauscht. Diese Aufrufe werden daher immer als
 // korrekt beurteilt, auch wenn sie anders funktionieren als gedacht.
 System.out.println(sumMul(3, 4));
 System.out.println(sumMul(2, 4));
 printArray(sumMulArray(9));
 }

 ***********************************************************************************/
public class RecursionAndArrays {

    /*
    Aufgabe:
        Ergänzen Sie fehlende Teile der Methoden entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 25):
        8 Punkte für sumMul
        8 Punkte für sumMulArray
        6 Punkte für printArray
        3 Punkte für main
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */


    // We assume m >= 1 and m <= n.
    // If m == n, then sumMul(m, n) returns the sum of all odd numbers in the range from 1 to n (including 1 and n).
    // If m < n, then sumMul(m, n) returns the product of all such sums, this is
    // sumMul(m, m) * sumMul(m+1, m+1) * ... * sumMul(n-1, n-1) * sumMul(n, n).
    // The implementation is recursive; no loop is used in the implementation.
    public static long sumMul(final int m, final int n) {
        return 0L;

        // TODO: Implementation is your task
        // Additional methods can be used if they do not contain loops (although no additional method is necessary).
    }


    // sumMulArray(n) returns an array containing the following values (assuming x to be the name of the array):
    //     x[0][j] is the sum of all odd values in the range from 1 to j+1 including 1 and j+1, where 0 <= j and j < n;
    //     x[i][j] is x[0][j] * x[i-1][j+1], where where 0 < i and i < n and 0 <= j and j < n-i.
    // The array contains only these specified values, no additional values.
    // For example, using printArray as described below, printArray(sumMulArray(5)) shall produce this output:
    //     1;1;4;4;9;
    //     1;4;16;36;
    //     4;16;144;
    //     16;144;
    //     144;
    // There are loops in the implementation; the implementation is not recursive.
    public static long[][] sumMulArray(int n) {
        return null; // TODO: Implementation is your task
        // Additional non-recursive methods can be used (although they are not necessary), but no recursive ones.
    }


    // printArray produces output showing the values in the array given as parameter. There is a separate line for
    // each index in the first dimension. Each value is followed by ";". The description of sumMulArray gives an
    // example. printArray does nothing if its parameter is null. No line is printed if the corresponding part of
    // the array is null.
    public static void printArray(long[][] array) {
        // TODO: Implementation is your task

    }


    // An execution of main does the following (in the given ordering):
    //   - Print a line showing the result of sumMul(2,2).
    //   - Print a line showing the result of sumMul(3,3).
    //   - Print a line showing the result of sumMul(4,4).
    //   - Print a line showing the result of sumMul(4,3).<-- corr 3, 4
    //   - Print a line showing the result of sumMul(4,2).<-- corr 2, 4
    //   - Invoke printArray with the result of sumMulArray(9).
    public static void main(String[] args) {
        // TODO: Implementation is your task

    }

}


