import java.lang.Long;
import java.lang.String;

/*

Hier ist ein Beispiel für eine Lösung (ohne Kommentare):

    public static long factSum(final int m, final int n) {
        if (m == n) {
            if (n == 1) {
                return 1;
            }
            return n * factSum(n - 1, n - 1);
        }
        return factSum(n, n) + factSum(m, n - 1);
    }

    public static long[][] factSumArray(int n) {
        long[][] result = new long[n][];
        result[0] = new long[]{ 1 };
        for (int i = 1; i < n; i++) {
            result[i] = new long[i + 1];
            result[i][0] = (i + 1) * result[i - 1][0];
            for (int j = 1; j <= i; j++) {
                result[i][j] = result[i][j - 1] + result[i - j][0];
            }
        }
        return result;
    }

    public static void printArray(long[][] array) {
        if (array != null) {
            for (long[] line : array) {
                if (line != null) {
                    for(long v : line) {
                        System.out.print(v + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(factSum(2,2));
        System.out.println(factSum(3,3));
        System.out.println(factSum(4,4));
        System.out.println(factSum(3,4));
        System.out.println(factSum(2,4));
        printArray(factSumArray(10));
    }

***********************************************************************************/
public class RecursionAndArrays {

    /*
    Aufgabe:
        Ergänzen Sie fehlende Teile der Methoden entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 25):
        8 Punkte für factSum
        8 Punkte für factSumArray
        6 Punkte für printArray
        3 Punkte für main
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */


    // factSum(m,n) returns the sum of the factorials of all numbers in the range from m to n (including m and n),
    // this is (m! + ... + n!) or ((1 * 2 * ... * m) + ... + (1 * 2 * ... * n)).
    // We assume m >= 1 and n >= m.
    // The implementation is recursive; no loop is used in the implementation.
    public static long factSum(final int m, final int n) {



       return helper(m)+helper(n);
       // TODO: Implementation is your task
        // Additional methods can be used if they do not contain loops (although no additional method is necessary).
    }
    public static int helper(int n){

        if(n==1){return 1;}
        return n*helper(n-1);

    }


    // factSumArray(n) returns an array containing the following values (assuming x to be the name of the array):
    //     x[i][0] is (i + 1)!, this is 1 * 2 * ... * i * (i + 1), where 0 <= i and i < n;
    //     x[i][j] is x[i][j - 1] + x[i - j][0], where where 0 <= i and i < n and 0 < j and j <= i.
    // The array contains only these specified values, no additional values.
    // For example, using printArray as described below, printArray(factSumArray(4)) shall produce this output:
    //     1
    //     2 3
    //     6 8 9
    //     24 30 32 33
    // There are loops in the implementation; the implementation is not recursive.
    public static long[][] factSumArray(int n) {
        long[][] x=new long[n][];

      return helperArray1(x,0);
        // TODO: Implementation is your task
        // Additional non-recursive methods can be used (although they are not necessary), but no recursive ones.
    }
    public static long[][] helperArray1(long[][] x, int iterator){


        x[iterator]=helperArray(iterator,iterator);

        if(iterator==(x.length-1)){

            finalHelperToCalculate(x,1,1);

            return x;
        }
        return helperArray1(x,iterator+1);

    }
    public static void finalHelperToCalculate(long[][] x, int list,int widePoint){

        if(list<x.length){


            if(widePoint<=list) {
            x[list][widePoint]=x[list][widePoint-1]+ x[list - widePoint][0];

                finalHelperToCalculate(x, list, widePoint + 1);
            }else {

                finalHelperToCalculate(x, list + 1, 1);
            }
        }
        return;


    }

    public static  long[] helperArray(int list, int wide){
            long[] x=new long[wide];
        x[0]= getInteger(list+1);
        return  x;

    }
    public static int getInteger(list){

        if(list==1){
            return 1;

        }
        return list*getInteger(list-1);
    }


    // printArray produces output showing the values in the array given as parameter. There is a separate line for
    // each index in the first dimension. Each value is followed by " " (the space character). The description of
    // factSumArray gives an example. printArray does nothing if its parameter is null. No line is printed if the
    // corresponding part of the array is null.
    public static void printArray(long[][] array) {
        // TODO: Implementation is your task
        if(array==null){return;}
        helperString(array, 0, 0);
    }

    public static  void helperString(long[][] ar,int list,int wide){

        String s="";

        helpwithString(s,ar,list,wide);
        System.out.println(s);

    }

    public static void helpwithString(String s,long[][] ar,int list, int wide){

        if(list<ar.length){

            if(wide<=list){
                s=s+" "+ ar[list][wide];
                helpwithString(s,ar,list,wide+1);
            }else{
                s=s+"\n";
                helpwithString(s,ar,list+1,0);
            }

        }
    }


    // An execution of main does the following (in the given ordering):
    //   - Print a line showing the result of factSum(2,2).
    //   - Print a line showing the result of factSum(3,3).
    //   - Print a line showing the result of factSum(4,4).
    //   - Print a line showing the result of factSum(3,4).
    //   - Print a line showing the result of factSum(2,4).
    //   - Invoke printArray with the result of factSumArray(10).
    public static void main(String[] args) {
        // TODO: Implementation is your task
    }

}


