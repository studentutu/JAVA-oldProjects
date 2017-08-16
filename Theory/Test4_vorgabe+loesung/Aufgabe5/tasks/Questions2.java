/***********************************************************************************

Lösungen:

    // Unter "Propagation einer Exception" versteht man das Abfangen einer Exception in einer catch-Klausel.
    public static int o38294638() { return -1; }

    // Der Client darf davon ausgehen, dass nach Rückkehr aus der Methode die Nachbedingungen eingehalten sind.
    public static int o67284372() { return 1; }

    // Aus   !x.equals(y)   folgt   x.hashCode() != y.hashCode().
    public static int o91048263() { return -1; }

    // Der Ausdruck   null instanceof X   liefert für jede Klasse X stets false.
    public static int o53753291() { return 1; }

    // private Methoden werden immer statisch gebunden.
    public static int o19283728() { return 1; }

    // Nachbedingungen einer Methode sind im Untertyp gleich oder stärker als im Obertyp.
    public static int o75980314() { return 1; }

    // Beim Grey-Box-Test werden Testfälle schon vor dem Programmieren festgelegt.
    public static int o83071285() { return 1; }

***********************************************************************************/
public class Questions2 {

    /*
    Aufgabe:
        Ändern Sie die Rückgabewerte der Methoden entsprechend der Wahrheitsgehalte der Kommentare bezogen auf Java.
        Mögliche Rückgabewerte:
             1  bedeutet: "Kommentar enthält wahre Aussage",
             0  bedeutet: "keine Ahnung, nicht beantwortet",
            -1  bedeutet: "Kommentar enthält falsche Aussage".

    Punkte (maximal 14):
        +2 Punkte wenn die Antwort 1 oder -1 richtig ist,
        -2 Punkte wenn die Antwort 1 oder -1 falsch ist,
         0 Punkte wenn die Antwort 0 ist.

        Die minimale Anzahl der Punkte für Questions2 ist 0,
        negative Punkte wirken sich also nicht auf andere Aufgaben aus.
    */


    // Nachbedingungen einer Methode sind im Untertyp gleich oder stärker als im Obertyp.
    public static int o75980314() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // Der Client darf davon ausgehen, dass nach Rückkehr aus der Methode die Nachbedingungen eingehalten sind.
    public static int o67284372() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // Der Ausdruck   null instanceof X   liefert für jede Klasse X stets false.
    public static int o53753291() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // private Methoden werden immer statisch gebunden.
    public static int o19283728() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // Beim Grey-Box-Test werden Testfälle schon vor dem Programmieren festgelegt.
    public static int o83071285() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // Aus   !x.equals(y)   folgt   x.hashCode() != y.hashCode().
    public static int o91048263() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


    // Unter "Propagation einer Exception" versteht man das Abfangen einer Exception in einer catch-Klausel.
    public static int o38294638() {
        return 0; /* TODO: 1 wenn wahr, -1 wenn falsch */
    }


}

