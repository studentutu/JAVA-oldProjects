/**********


Korrekte Antworten:

    // Der Rumpf folgender Java-Anweisung wird mindestens einmal ausgeführt:  while (b) {f();}
    public static int o38294638() {
        return -1; // TODO: 1 wenn wahr, -1 wenn falsch
    }

    // Mindestens ein Block in folgender Java-Anweisung wird ausgeführt:  if (b) {f();} else {g();}
    public static int o67284372() {
        return 1; // TODO: 1 wenn wahr, -1 wenn falsch
    }

    // for(;;);   ist in Java äquivalent zu   while(true);
    public static int o91048263() {
        return 1; // TODO: 1 wenn wahr, -1 wenn falsch
    }

    // Folgende zwei Implementierungen von foo liefern in Java stets gleiche Ergebnisse:
    //     public static int foo(int i) {
    //         return i > 0 ? foo(i - 1) + i : 0;
    //     }
    //     public static int foo(int i) {
    //         int p = 0;
    //         while (--i > 0) p += i;
    //         return p;
    //     }
    public static int o53753291() {
        return -1; // TODO: 1 wenn wahr, -1 wenn falsch
    }

    // In folgender Implementierung von foo ist das Ergebnis niemals gleich dem formalen Parameter:
    //     public static int foo(int i) {
    //         int x = -i;
    //         if (i < 0) {
    //             return -i;
    //         }
    //         return x;
    //     }
    public static int o19283728() {
        return -1; // TODO: 1 wenn wahr, -1 wenn falsch
    }

**********/
public class Questions2 {

    /*
    Aufgabe:
        Ändern Sie die Rückgabewerte folgender Methoden entsprechend der Wahrheitsgehalte der Kommentare.
        Mögliche Rückgabewerte sind:
             1  bedeutet: "Kommentar enthält wahre Aussage",
             0  bedeutet: "keine Ahnung, nicht beantwortet",
            -1  bedeutet: "Kommentar enthält falsche Aussage".

    Punkte (maximal 15):
        +3 Punkte wenn die Antwort 1 oder -1 richtig ist,
        -3 Punkte wenn die Antwort 1 oder -1 falsch ist,
         0 Punkte wenn die Antwort 0 ist.

        Die minimale Anzahl der Punkte für Questions2 ist 0, negative Punkte wirken sich also nicht auf andere Aufgaben aus.
    */


    // In folgender Implementierung von foo ist das Ergebnis niemals gleich dem formalen Parameter:
    //     public static int foo(int i) {
    //         int x = -i;
    //         if (i < 0) {
    //             return -i;
    //         }
    //         return x;
    //     }
    public static int o19283728() {
        return 0; // TODO: 1 wenn wahr, -1 wenn falsch
    }


    // Der Rumpf folgender Java-Anweisung wird mindestens einmal ausgeführt:  while (b) {f();}
    public static int o38294638() {
        return 0; // TODO: 1 wenn wahr, -1 wenn falsch
    }


    // Folgende zwei Implementierungen von foo liefern in Java stets gleiche Ergebnisse:
    //     public static int foo(int i) {
    //         return i > 0 ? foo(i - 1) + i : 0;
    //     }
    //     public static int foo(int i) {
    //         int p = 0;
    //         while (--i > 0) p += i;
    //         return p;
    //     }
    public static int o53753291() {
        return 0; // TODO: 1 wenn wahr, -1 wenn falsch
    }


    // for(;;);   ist in Java äquivalent zu   while(true);
    public static int o91048263() {
        return 0; // TODO: 1 wenn wahr, -1 wenn falsch
    }


    // Mindestens ein Block in folgender Java-Anweisung wird ausgeführt:  if (b) {f();} else {g();}
    public static int o67284372() {
        return 0; // TODO: 1 wenn wahr, -1 wenn falsch
    }


}



