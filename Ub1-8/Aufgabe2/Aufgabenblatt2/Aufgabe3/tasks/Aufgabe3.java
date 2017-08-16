/*
    Aufgabe3) Methode nachvollziehen und umschreiben

    Die Methode 'unknown' erzeugt aus einer Zahl einen String bestehend aus Ziffern. Stellen Sie fest, was 'unknown'
    genau macht. Schreiben Sie zwei statische Methoden namens 'nullen' und 'einsen', die je eine Zahl vom Typ long als
    Argument nehmen und eine Zahl vom Typ int zurückgeben. Die Rückgabewerte enthalten die Anzahl aller Vorkommen von '0'
    (für die Methode 'nullen') bzw. die Anzahl aller Vorkommen von '1' (für die Methode 'einsen'). Der Eingabewert für
    die Methoden 'nullen' und 'einsen' ist der Ausgabewert von 'unknown'. In den Implementierungen von 'nullen' und
    'einsen' darf 'unknown' nicht aufgerufen werden. Die Ergebnisse sollen direkt aus den Parametern errechnet werden,
    ohne einen String zu verwenden. Falls Schleifen nötig sind, sollen in 'nullen' nur (eine) for-Schleife(n) und in
    'einsen' nur (eine) while-Schleife(n) vorkommen.

    Zusatzfragen:
    1. Was gibt 'unknown' zurück?
    2. Wozu dient der bedingte Ausdruck in 'unknown'?
    3. Warum können in 'unknown' Literale wie 0 und 2 verwendet werden, obwohl mit Zahlen vom Typ long gerechnet wird?
    4. Sind verschiedene Arten von Schleifen gegeneinander austauschbar? Wenn ja, wie?
*/
public class Aufgabe3 {

    // was macht 'unknown'?
    private static String unknown(long n) {
        String s = "";
        n = n < 0 ? -n : n;//Math.abs(xxxx...xxx)
        do {
            s = (n % 2) + s;// erste aufruf -lsb in binar, lsb2,lsb3... zeahlen einzen
        } while ((n /= 2) != 0); //naechste zahl nach division 5/2=2, 2/2=1,1/2=0
        return s;
    }

    public static int einsen(long n) {
        int einAnzahl = 0;
        n = n < 0 ? -n : n;// =Math.abs(xxxx...xxx)
        while (n > 0) {
            if (n % 2 == 1) einAnzahl+=1; // nur vorkommen von 1 zählen!
            n /= 2;
        }
        return einAnzahl;
    }
   
    public static int nullen(long n) {
        int nulAnzahl = 0;
        n = n < 0 ? -n : n;
        for (; n > 0; n /= 2) {
            if (n % 2 == 0) nulAnzahl+=1;//nu vorkommen von 0 zählen!
        }
        return nulAnzahl;
    }

    // just for testing ...
    public static void main(String[] args) {
        // den Rumpf dieser Methode können Sie beliebig verändern
        int x= 5;
        System.out.println("Nummer ist =" + x);
        System.out.println("in Binär =" + unknown(x));
        System.out.println( "Anzahl der 1 =" + einsen(x));
        System.out.println( "Anzahl der 0 =" + nullen(x));

    }
}
