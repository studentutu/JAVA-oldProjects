/**********


Korrekte Lösung:

public static int o38294638(){ return 1;} // method1 wird immer statisch gebunden
public static int o67284372(){ return 1;} // method2 wird immer statisch gebunden
public static int o91048263(){ return -1;} // method3 wird immer statisch gebunden
public static int o53753291(){ return 1;} // method4 wird immer statisch gebunden
public static int o19283728(){ return -1;} // method5 wird immer statisch gebunden

**********/
public class Aufgabe3 {

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

        Die maximale Anzahl der Punkte für Aufgabe3 ist 15,
        die minimale Anzahl der Punkte für Aufgabe3 ist 0 (d.h. negative Punkte wirken sich nicht auf andere Aufgaben aus).

        Frage:
        Sie haben folgende Klasse gegeben

        public class A {
            private void method1(){...}
            public static int method2(){...}
            public void method3(){...}
            private static void method4(){...}
            public String method5(){...}
        }

        Welche der folgenden Aussagen treffen zu?
    */

    public static int o38294638(){ return 1;}   // method1 wird immer statisch gebunden
    public static int o19283728(){ return -1;}   // method5 wird immer statisch gebunden
    public static int o91048263(){ return -1;}   // method3 wird immer statisch gebunden
    public static int o67284372(){ return 1;}   // method2 wird immer statisch gebunden
    public static int o53753291(){ return 1;}   // method4 wird immer statisch gebunden
}


