/**********


Korrekte Lösung:

public static int o38294638(){ return 1;} // assert m < n;
public static int o67284372(){ return -1;} // assert a < b;
public static int o91048263(){ return -1;} // assert a == b;
public static int o53753291(){ return -1;} // assert i <= 0;
public static int o19283728(){ return 1;} // assert m + i >= n - i;

**********/
public class Aufgabe4 {

    /*

    Die Auswahlmöglichkeit zu untenstehender Frage steht jeweils als Kommentar neben der Methode.
    Mögliche Rückgabewerte der Methoden sind:
         1 : bedeutet "trifft zu",
         0 : bedeutet "keine Ahnung, nicht beantwortet",
        -1 : bedeutet "trifft nicht zu".

    Punkte:
        +3 Punkte wenn die Antwort 1 oder -1 richtig ist,
        -3 Punkte wenn die Antwort 1 oder -1 falsch ist,
         0 Punkte wenn die Antwort 0 ist.

        Die maximale Anzahl der Punkte für Aufgabe4 ist 15,
        die minimale Anzahl der Punkte für Aufgabe4 ist 0 (d.h. negative Punkte wirken sich nicht auf andere Aufgaben aus).

    Frage:
        Sie haben folgende Methode gegeben:

        public static int foo(int m, int n) {

            assert m < n;

            int i = 0;
            int a = m;
            int b = n;

            while (a < b) {
                i++;
                a++;
                b--;
            }

            // Position A

            return i;
        }

        Welche der folgenden assert-Anweisungen ist an der Position A korrekt?
    */


    public static int o19283728(){ return -1;}   // assert m + i >= n - i;
    public static int o38294638(){ return -1;}   // assert m < n;
    public static int o67284372(){ return -1;}   // assert a < b;
    public static int o91048263(){ return -1;}   // assert a == b;
    public static int o53753291(){ return -1;}   // assert i <= 0;

}

