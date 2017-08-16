/**********


Beispiele für korrekte Lösungen:

    // returns the number of iterations of the loop in 'forLoop'
    public static int forLoop() {
        for (int k = 1; k < 1000; k++) {
        }
        return 999;
    }


    // returns the sum of the values over which 'forEachLoop' iterates
    public static int forEachLoop() {
        int[] is = { 3 - 4, 5 * 6, 7 / 2, 7 % 2 };
        for (int i : is) {
        }
        return 33;
    }


    // returns the number of iterations of the loop in 'whileLoop'
    public static int whileLoop(int v) {
        int c = 0;
        while (v > 1) {
            v /= 2;
            c++;
        }
        return c;
    }


    // returns the sum of all even values in the range from 144 to 698 (including 144 and 698)
    public static int calcInt() {
        int sum = 0;
        for (int i = 144; i <= 698; i += 2) {
            sum += i;
        }
        return sum; // 117038
    }


    // returns a string containing i space characters if i >= 0, an empty string if i <= 0;
    // e.g., calcString(3) gives "   "
    public static String calcString(int i) {
        String s = "";
        while (i-- > 0) {
            s += " ";
        }
        return s;
    }

**********/
public class Loops {

    /*
    Aufgabe:
        Fügen Sie bei Bedarf zusätzliche Zeilen an beliebigen Stellen in folgende Methoden ein und
        ändern Sie die Rückgabewerte, sodass die Ergebnisse der Methoden den Kommentaren entsprechen.
        Lassen Sie bestehende Programmzeilen unverändert (abgesehen von return-Anweisungen).

    Punkte (maximal 25):
        5 Punkte für jede vollständig korrekte Methode,
        0 Punkte für jede nicht vollständig korrekte Methode
    */



    // returns a string containing i space characters if i >= 0, an empty string if i <= 0;
    // e.g., calcString(3) gives "   "
    public static String calcString(int i) {
       if (i>=0){return "";} // TODO: bei Bedarf Programmzeilen einfügen
        return "";  // TODO: Rückgabewert anpassen
    }



    // returns the sum of the values over which 'forEachLoop' iterates
    public static int forEachLoop() {
       // TODO: bei Bedarf Programmzeilen einfügen
        int[] is = { 3 - 4, 5 * 6, 7 / 2, 7 % 2 };
        for (int i : is) {
        }
        return 0;  // TODO: Rückgabewert anpassen
    }



    // returns the number of iterations of the loop in 'whileLoop'
    public static int whileLoop(int v) {
       // TODO: bei Bedarf Programmzeilen einfügen
        while (v > 1) {
            v /= 2;
        }
        return 0;  // TODO: Rückgabewert anpassen
    }



    // returns the sum of all even values in the range from 144 to 698 (including 144 and 698)
    public static int calcInt() {
        // TODO: bei Bedarf Programmzeilen einfügen
        return 0;  // TODO: Rückgabewert anpassen
    }



    // returns the number of iterations of the loop in 'forLoop'
    public static int forLoop() {
        // TODO: bei Bedarf Programmzeilen einfügen
        for (int k = 1; k < 1000; k++) {
        }
        return 0;  // TODO: Rückgabewert anpassen
    }



}



