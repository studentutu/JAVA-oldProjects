/**********


Korrekte Lösung:

public static int o38294638(){ return -1;}   // Wenn x != null dann gilt x.equals(null) == true
public static int o67284372(){ return 1;}    // Wenn x != null dann gilt x.equals(x)
public static int o91048263(){ return 1;}    // Wenn x != null && y != null dann gilt x.equals(y) == y.equals(x)
public static int o53753291(){ return -1;}   // Wenn x.equals(y) || y.equals(z) dann gilt x.equals(z)
public static int o19283728(){ return -1;}   // Wenn x != null && y != null dann gilt x.equals(y) == true

**********/
public class Aufgabe2 {

    /*

    Die Auswahlmöglichkeit zu untenstehender Frage steht jeweils als Kommentar neben der Methode.
    Mögliche Rückgabewerte der Methoden sind:
         1 : bedeutet "trifft zu",
         0 : bedeutet "keine Ahnung, nicht beantwortet",
        -1 : bedeutet "trifft nicht zu".

    Punkte:
        +2 Punkte wenn die Antwort 1 oder -1 richtig ist,
        -2 Punkte wenn die Antwort 1 oder -1 falsch ist,
         0 Punkte wenn die Antwort 0 ist.

        Die maximale Anzahl der Punkte für Aufgabe2 ist 10,
        Die minimale Anzahl der Punkte für Aufgabe2 ist 0 (d.h. negative Punkte wirken sich nicht auf andere Aufgaben aus).

   Frage:
        Welche der folgenden Bedingungen gelten für eine Implementierung von equals?

    */

    public static int o53753291(){ return -1;}   // Wenn x.equals(y) || y.equals(z) dann gilt x.equals(z)
    public static int o91048263(){ return 1;}   // Wenn x != null && y != null dann gilt x.equals(y) == y.equals(x)
    public static int o19283728(){ return 1;}   // Wenn x != null && y != null dann gilt x.equals(y) == true
    public static int o38294638(){ return -1;}   // Wenn x != null dann gilt x.equals(null) == true
    public static int o67284372(){ return 1;}   // Wenn x != null dann gilt x.equals(x)

}


