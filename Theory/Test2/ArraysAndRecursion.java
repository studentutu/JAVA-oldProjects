/***********************************************************************************
BEURTEILUNG von 1428773 für Aufgabe 2:  9 Punkte

        'printStringArray': 3 - viele schwerwiegende Fehler, Ansatz kaum erkennbar
        'downArrow':        4 - Ansatz erkennbar, eigenartiger Umgang mit null, viele Fehler
        'upSideDown':       2 - kaum etwas vorhanden
        'combine':          -

Hier ist ein Beispiel für die wesentlichen Teile einer Lösung:

    public static void printStringArray(String[] lines) {
        if (lines != null) {
            printStringArray(lines, 0);
        }
    }

    private static void printStringArray(String[] lines, int min) {
        if (min < lines.length) {
            System.out.println(lines[min]);
            printStringArray(lines, min + 1);
        }
    }

    public static String[] downArrow(int n, int len) {
        if (n == 0) {
            return new String[len];
        }
        String[] array = downArrow(n - 1, len);
        array[len - n] = charStr(' ', len - n) + charStr('*', n * 2 - 1);
        return array;
    }

    private static String charStr(char c, int i) {
        return i == 0 ? "" : charStr(c, i - 1) + c;
    }

    public static String[] upSideDown(String[] lines) {
        if (lines == null) {
            return null;
        }
        String[] newLines = new String[lines.length];
        reverse(newLines, lines, 0);
        return newLines;
    }

    private static void reverse(String[] newLines, String[] lines, int i) {
        if (i < lines.length) {
            newLines[newLines.length - 1 - i] = lines[i];
            reverse(newLines, lines, i + 1);
        }
    }

    public static String[] combine(String[] left, String[] right, int i) {
        if (left == null || right == null || left.length != right.length || i < 0 || i > left.length) {
            return null;
        }
        if (i == left.length) {
            return new String[left.length];
        }
        String[] comb = combine(left, right, i + 1);
        if (left[i] != null && right[i] != null) {
	    comb[i] = left[i] + right[i];
        }
        return comb;
    }

***********************************************************************************/
public class ArraysAndRecursion {

    /*
    Aufgabe:
        Implementieren Sie die Methoden mithilfe von Rekursion entsprechend den Kommentaren.
        In den Implementierungen dürfen KEINE SCHLEIFEN verwendet werden.
        Die Verwendung von Hilfsmethoden ist erlaubt, aber auch Hilfsmethoden dürfen keine Schleifen enthalten.

    Punkte (maximal 40):
        10 Punkte für die Implementierung von 'printStringArray',
        10 Punkte für die Implementierung von 'downArrow',
        10 Punkte für die Implementierung von 'upSideDown',
        10 Punkte für die Implementierung von 'combine',

        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */


    // 'printStringArray' prints the strings in 'lines', each string on a separate line, beginning with index 0.
    // Nothing is printed if 'lines' is null; however "null" is printed if the corresponding array entry is null.
    // Examples can be found below.
    public static void printStringArray(String[] lines) {
        // TODO: Implementation is your task (use recursion, no loops).
        // Additional methods can be implemented and used if they do not contain loops.
        if(lines.length<1 || lines==null){System.out.println();}//nothing printed
        String  s="";
        if(lines[0]==null){
            s="null";
        }else{s= lines[0];}

        String[] newline = new String[lines.length-1];

        newline[0]=lines[1];

        System.out.print(s);
        printStringArray(newline);
    }


    // 'downArrow' returns a new array of length len where the last n entries of the array, i.e. those at indices
    // from  len - n  to  len - 1, are filled with strings; the other array entries are null. The string at index i
    // consists of i repetitions of the character ' ' followed by  2 * (len - i) - 1  repetitions of the character '*'.
    // The parameter values satisfy the assumptions  n >= 0,  n <= len  and  len > 0.
    // For example, downArrow(0,5) returns an empty array of length 5 (all entries are null),
    // and downArrow(5,5) returns an array such that printStringArray(downArrow(5,5)) prints the following lines:
    //
    // *********
    //  *******
    //   *****
    //    ***
    //     *
    //
    // A call of printStringArray(downArrow(3,5)) prints these lines:
    //
    // null
    // null
    //   *****
    //    ***
    //     *
    //
    // (In these output examples the lines are assumed to begin after "// ", and the empty lines do not belong to it.)
    public static String[] downArrow(int n, int len) {
        // TODO: Implementation is your task (use recursion, no loops).
        // Additional methods can be implemented and used if they do not contain loops.
            String[] willreturn=new String[len];

        if(n==0&&len==0|| len==0){ String[] s1= {"null"};
            willreturn=helper(n,willreturn,s1);

            return willreturn;
        }else{
            String[] tohelper=new String[1];
            if(n==0){
             tohelper[0]= "null";
            }else{
                tohelper[0] = "*" :
            }

                willreturn[n]=helper(n,willreturn,tohelper);



        }


        return null;
    }

    public static String[] helper(int oursN,String[] m,String[] k){

        String[] s=new String[m.length+1];

        if(k[0].equals("null")){
            s[k.length]="null";
        }else{

            //s[]=

        }


    }


    // 'upSideDown' returns a new array containing the same strings as 'lines', but in reverse order.
    // That is, upSideDown(lines)[lines.length - 1 - i] equals lines[i] for each valid index i of lines.
    // If lines is null, then also the result shall be null.
    // For example, printStringArray(upSideDown(downArrow(3,5))) shall print the following lines:
    //
    //     *
    //    ***
    //   *****
    // null
    // null
    //
    public static String[] upSideDown(String[] lines) {
        // TODO: Implementation is your task (use recursion, no loops).
        // Additional methods can be implemented and used if they do not contain loops.
        if(lines==null|| lines.length<1){
            String s="null";


        }

        return null;
    }


    // 'combine' returns a new array containing  left[j] + right[j]  for all valid array indices with  j >= i.
    // All other array entries are null.  Also those elements are null, where  left[j] == null  or  right[j] == null.
    // null is returned if parameter values are not appropriate, i.e., left or right is null, the arrays have different
    // lengths, or i is not in the range from 0 to left.length.
    //
    // For example, printStringArray(combine(downArrow(1,2), downArrow(2,2), 2) prints:
    //
    // null
    // null
    //
    // and printStringArray(combine(downArrow(4,5), upSideDown(downArrow(5,5)), 1)) prints:
    //
    // null
    //  *******   ***
    //   *****  *****
    //    *** *******
    //     **********
    //
    public static String[] combine(String[] left, String[] right, int i) {
        // TODO: Implementation is your task (use recursion, no loops).
        // Additional methods can be implemented and used if they do not contain loops.
        return null;
    }


    // Just for testing. Does not contribute to the assessment. Geht nicht in die Beurteilung ein.
    public static void main(String[] args) {
    }

}
