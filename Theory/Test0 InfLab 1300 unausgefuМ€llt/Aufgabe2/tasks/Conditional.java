/**********


Beispiele für korrekte Lösungen:

    // returns "zwei" if i equals 2, returns "nicht zwei" otherwise
    public static String stringFromInt(int i) {
        switch (i - 5) {
            case (-3):
                return ("zwei");
            default:
                return ("nicht zwei");
        }
    }


    // returns 1 if s equals "wahr", -1 if s equals "falsch", and 0 otherwise
    public static int intFromString(String s) {
        int result = 0;
        if ("falsch".equals(s)) {
            result--;
        }
        else if ("wahr".equals(s)) {
            result++;
        }
        return result;
    }


    // returns "ba" if a and b are true, "a" if a is true and b is false, "b" if b is true and a is false, "" if a as well as b is false
    public static String stringFromBools(boolean a, boolean b) {
        String result = "";
        if (a) {
            result += ("a");
        }
        if (b) {
            result = ("b") + result;
        }
        return result;
    }


    // returns 1 if a is false and -1 if a is true
    public static int intFromBool(boolean a) {
        return !a ? (1) : (-1);
    }


    // returns the sum of all odd numbers in the range from 100 to i (including i);
    // i >= 100
    public static int intRec(int i) {
        if (i <= 100) {
            return 0;
        } else if ((i % 2) != 0) {
            return intRec(i - 1) + i;
        } else {
            return intRec(i - 1);
        }
    }

Hinweis: Lösungsversuche, welche die vorgegebene Struktur der Methoden ändern, sind nicht korrekt.

**********/
public class Conditional {

    /*
    Aufgabe:
        Ändern Sie in folgenden Methoden die mit 'TODO:' gekennzeichneten Ausdrücke,
        sodass die Ergebnisse den Kommentaren entsprechen.
        Lassen Sie alle anderen Programmteile unverändert.

    Punkte (maximal 25):
        5 Punkte für jede vollständig korrekte Methode,
        0 Punkte für jede nicht vollständig korrekte Methode
    */



    // returns "ba" if a and b are true, "a" if a is true and b is false, "b" if b is true and a is false, "" if a as well as b is false
    public static String stringFromBools(boolean a, boolean b) {
        String result = "";
        if (true/* TODO: Ausdruck ändern */) {
            result += ("" /* TODO: Ausdruck ändern */);
        }
        if (true/* TODO: Ausdruck ändern */) {
            result = ("" /* TODO: Ausdruck ändern */) + result;
        }
        return result;
    }



    // returns the sum of all odd numbers in the range from 100 to i (including i);
    // i >= 100
    public static int intRec(int i) {
        if (true /* TODO: Ausdruck ändern */) {
            return 0;
        } else if (false /* TODO: Ausdruck ändern */) {
            return intRec(i - 1) + i;
        } else {
            return intRec(i - 1);
        }
    }



    // returns "zwei" if i equals 2, returns "nicht zwei" otherwise
    public static String stringFromInt(int i) {
        switch (i - 5) {
            case (0 /* TODO: Ausdruck ändern */):
                return ("" /* TODO: Ausdruck ändern */);
            default:
                return ("" /* TODO: Ausdruck ändern */);
        }
    }



    // returns 1 if a is false and -1 if a is true
    public static int intFromBool(boolean a) {
        return !a ? (1/* TODO: Ausdruck ändern */) : (1 /* TODO: Ausdruck ändern */);
    }



    // returns 1 if s equals "wahr", -1 if s equals "falsch", and 0 otherwise
    public static int intFromString(String s) {
        int result = 0;
        if ("".equals(s) /* TODO: Ausdruck ändern */) {
            result--;
        }
        else if ("".equals(s) /* TODO: Ausdruck ändern */) {
            result++;
        }
        return result;
    }



}



