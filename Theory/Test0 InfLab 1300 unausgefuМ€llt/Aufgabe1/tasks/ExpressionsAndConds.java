/**********

Hier sind Beispiele für korrekte Lösungen.
Es gibt aber auch viele andere Lösungen, die genauso korrekt sind.

    // returns the non-negative difference between x and y (or y and x)
    public static int fromIntsToInt(int x, int y) {
        return x < y ? y - x : x - y;
    }


    // returns true if (and only if) x is not larger than y and y is not larger than 0
    public static boolean fromIntsToBool(int x, int y) {
        return x <= y && y <= 0;
    }


    // returns -1 if a and b are true, 0 if a differs from b, and 1 if a and b are false
    public static int fromBoolsToInt(boolean a, boolean b) {
        return a && b ? -1 : (a || b ? 0 : 1);
    }


    // returns a string containing s twice, separated by "-";
    // e.g., fromStringToString("xy") gives "xy-xy"
    public static String fromStringToString(String s) {
        return s + "-" + s;
    }

Häufiger Fehler:
Es wurden nicht nur Rückgabewerte angepasst, sondern Methoden gänzlich umgeschrieben.
Solche Lösungsversuche entsprechen nicht der Aufgabenstellung und sind nicht korrekt.

**********/
/*
Lesen Sie die Aufgaben genau durch.
Passen Sie gekennzeichnete Programmstellen entsprechend der Aufgabe an.
Verändern Sie aber nicht die Methodenköpfe oder andere Programmteile!

Achtung: Vorgegebene Testfälle überprüfen nur die Syntax der Methoden.
Sie überprüfen nicht die Korrektheit der Antworten.
*/
public class ExpressionsAndConds {

    /*
    Aufgabe:
        Passen Sie die Rückgabewerte folgender Java-Methoden den Kommentaren an.

    Punkte (maximal 20):
        5 Punkte für jede vollständig korrekte Methode,
        0 Punkte für jede nicht vollständig korrekte Methode
    */



    // returns -1 if a and b are true, 0 if a differs from b, and 1 if a and b are false
    public static int fromBoolsToInt(boolean a, boolean b) {
            return 1/* TODO: Ausdruck ändern */ ;
    }



    // returns a string containing s twice, separated by "-";
    // e.g., fromStringToString("xy") gives "xy-xy"
    public static String fromStringToString(String s) {
        return "";  // TODO: Rückgabewert anpassen
    }



    // returns the non-negative difference between x and y (or y and x)
    public static int fromIntsToInt(int x, int y) {
        return 1;  // TODO: Rückgabewert anpassen
    }



    // returns true if (and only if) x is not larger than y and y is not larger than 0
    public static boolean fromIntsToBool(int x, int y) {
        return false /* TODO: Ausdruck ändern */;

    }



}



