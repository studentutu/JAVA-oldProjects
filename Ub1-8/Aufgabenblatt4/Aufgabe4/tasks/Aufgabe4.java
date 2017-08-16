/*
    Aufgabe4) Rekursion und Termination

    Die Methoden f, g, h, p und q sind vorgegeben. Rufen Sie in main jede dieser Methoden mit allen Argumenten im
    Bereich von -10 bis 10 (in aufsteigender Reihenfolge) auf und geben sie die Ergebnisse aus, wenn die Aufrufe mit
    Argumenten terminieren. Aufrufe, die nicht terminieren, sind auszulassen. Vermeiden Sie Exceptions.

    Hinweis: Für diese Aufgabe ist es besonders wichtig, die Zusatzfragen beantworten zu können.

    Zusatzfragen:
    1. Nennen Sie für jeden nicht terminierenden Aufruf von f, g, h, p und q im Intervall einen Grund für die
       Endlosrekursion (im Hinblick auf Fundiertheit und Fortschritt).
    2. Beschreiben Sie überblicksartig, was die Methoden f, g, h, p und q berechnen.
    3. Bedeutet ein StackOverflowError immer, dass eine Endlosrekursion vorhanden ist?
    4. [optional] Ist die Aufgabe überhaupt lösbar (wegen der Unentscheidbarkeit des Halteproblems der Turing-Maschine)?
*/
public class Aufgabe4 {
    
    /*
     * Jede Methode ruft sich im 'else'-Fall rekursiv mit einem modifizierten Parameter.
     * Das '+ 1' am Ende jeder Methode berechnet einfach die Anzahl der Aufrufe
     * e.g. f(0) hat muss den Parameter 4 Mal um 1 dekrementieren, damit x * x > 10 wahr ist.
     * Danach wird unserer impliziter 'counter' ausgegeben.
     */

    private static int f(int x) {
        /*
         * f(x) überprüft, ob x * x größer ist, als 10. Wenn ja, dann terminiert die Methode und es wird
         * eine 0 zurückgegeben. Wenn aber die Annahme falsch ist, wird x um 1 dekrementiert und unser
         * return-value um 1 erhöht. Wenn also x klein genug ist, damit x * x > 10, terminiert die Methode und
         * gibt die Anzahl von rekursiven Aufrufen zurück.
         */
        return x * x > 10 ? 0 : f(x - 1) + 1;
    }

    private static int g(int x) {
        /*
         * Die methode g(x) gibt immer dann, wenn die Zahl x kleiner als 0 ist, eine 0 zurück.
         * Ansonsten terminiert die Funktion nie, da eine (nicht-negative Zahl / 2) immer positiv ist
         * Es macht also keinen Sinn, die Funktion mit einer nicht-negativen Zahl aufzurufen, es sei denn,
         * man will einen Stackoverflow erreichen.
         */
        return x < 0 ? 0 : g(x / 2) + 1;
    }

    private static int h(int x) {
        /*
         * Die Methode h(x) überprüft, ob eine Zahl größer ist als 10
         * Wenn nicht, wird sie immer quadriert, bis sie größer als 10 ist
         * Jedenfalls, ergibt h(-1), h(0) und h(1) immer einen Stackoverflow,
         * da 0 * 0 = 0 und 1 * 1 = 1
         */
        return x > 10 ? 0 : h(x * x) + 1;
    }

    private static int p(int x) {
        /*
         * Die Methode p(x) ist eigentlich ganz einfach, hat aber einige Probleme.
         * Das Problem liegt in der unendlichen Wiederholung der Operation (-x -1),
         * denn eine Negative Zahl kann nur einen Modulo 2 von 0 oder -1 haben. x wird somit
         * nie durch zwei dividiert, wenn (-x - 1) auch einen Modulo 2 von 1 hat.
         * Somit wird z.B. 2 immer in -3 umgewandelt und umgekehrt.
         * mit try-catch koennen wir alle Zahlen herausfinden, mit denen p(x) terminiert.
         * Es sind immer positive Zahlen (ab 0) und deren Einerkomplement.
         * Zahlen können nach dieser Formel gefunden werden: (x * 2 + 1) und deren Einerkomplement: (-(x * 2 + 1) - 1)
         * z.B. 0, -1, 1, -2, 3, -4, 7, -8, 15, -16 etc.
         */
        return x == 0 ? 0 : x % 2 == 1 ? p(x / 2) + 2 : p(- x - 1) + 1;
    }

    private static int q(int x) {
        /*
         * Die Methode q(x) überprüft, ob man x durch 3 ohne Rest dividieren kann
         * Wenn ja, terminiert die Methode. Wenn nicht, wird versucht x in eine durch 3 dividierbare Zahl
         * umzuformen (was meistens auch gelingt)
         * Jedenfalls, wenn eine Zahl negativ ist und Zahl % 3 == -1, dann wird q(x) immer mit der selben Zahl
         * aufgerufen (bis eben ein Stackoverflow passiert).
         */
        return x % 3 == 0 ? 0 : q(x + x % 3 + 1) + 1;
    }

    // to be implemented by you
    public static void main(String[] args) {
        for (int i = -10; i <= 10; i++) {
            System.out.println("f(" + i + ") ergibt: " + f(0));  // f(x) akzeptiert alle Zahlen von -10 bis 10
            
            if (i < 0)
            System.out.println("g(" + i + ") ergibt: " + g(-1)); // g(x) akzeptiert nur negative Zahlen
                
            if (i < -1 && i > 1)
            System.out.println("h(" + i + ") ergibt: " + h(-2)); // h(x) akzeptiert alle Zahlen außer -1, 0, 1
            
            
            switch(i) {
                case -10:
                case -7:
                case -4:
                case -1:
                case 2:
                case 5:
                case 8:
                    continue;
                default:
                    System.out.println("q(" + i + ") ergibt: " + q(i));
            }
        }
    }
}
