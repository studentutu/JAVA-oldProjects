/***********************************************************************************


Lösungen:

    // Der Ausdruck   null instanceof X   liefert für jedes Interface X stets true.
    public static int o38294638() { return -1; }

    // Der Ausdruck   X.class   ist auch anwendbar, wenn X ein Interface ist.
    public static int o67284372() { return 1; }

    // Wenn   x != null   gilt, dann muss   x.equals(null)   als Ergebnis immer false liefern,
    // auch wenn wir equals selbst implementieren.
    public static int o91048263() { return 1; }

    // Aus   x.equals(y)   folgt   x.hashCode() == y.hashCode()
    public static int o53753291() { return 1; }

    // private Methoden werden immer statisch gebunden.
    public static int o75980314() { return 1; }

    // In jeder .java-Datei darf höchstens eine nicht-public Klasse vorkommen.
    public static int o83071285() { return -1; }

    // Eine als final definierte Methode muss überschrieben werden.
    public static int o14958752() { return -1; }

    // Als static und final deklarierte Variablen dürfen in Interfaces vorkommen.
    public static int o19283728() { return 1; }

***********************************************************************************/
public class Questions1 {

    /*
    Aufgabe:
        Ändern Sie die Rückgabewerte der Methoden entsprechend der Wahrheitsgehalte der Kommentare bezogen auf Java.
        Mögliche Rückgabewerte:
             1  bedeutet: "Kommentar enthält wahre Aussage",
             0  bedeutet: "keine Ahnung, nicht beantwortet",
            -1  bedeutet: "Kommentar enthält falsche Aussage".

    Punkte (maximal 16):
        +2 Punkte wenn die Antwort 1 oder -1 richtig ist,
        -2 Punkte wenn die Antwort 1 oder -1 falsch ist,
         0 Punkte wenn die Antwort 0 ist.

        Die minimale Anzahl der Punkte für Questions1 ist 0,
        negative Punkte wirken sich also nicht auf andere Aufgaben aus.
    */


    // Wenn   x != null   gilt, dann muss   x.equals(null)   als Ergebnis immer false liefern,
    // auch wenn wir equals selbst implementieren.
    public static int o91048263() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // Der Ausdruck   X.class   ist auch anwendbar, wenn X ein Interface ist.
    public static int o67284372() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // In jeder .java-Datei darf höchstens eine nicht-public Klasse vorkommen.
    public static int o83071285() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // Als static und final deklarierte Variablen dürfen in Interfaces vorkommen.
    public static int o19283728() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
}


    // Der Ausdruck   null instanceof X   liefert für jedes Interface X stets true.
    public static int o38294638() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // Eine als final definierte Methode muss überschrieben werden.
    public static int o14958752() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // private Methoden werden immer statisch gebunden.
    public static int o75980314() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // Aus   x.equals(y)   folgt   x.hashCode() == y.hashCode()
    public static int o53753291() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


}


