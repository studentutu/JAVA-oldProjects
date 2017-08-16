/*
    Aufgabe3) Schleifen und Methoden
    Erweitern Sie die Klasse "Aufgabe3" um folgende Funktionalität:
    - Schreiben Sie eine statische Methode "isFacultyDiv", die die Fakultät einer Zahl berechnet und überprüft ob das Ergebnis durch eine weitere Zahl teilbar ist.
    - Der Methode wird eine ganzzahlige Zahl "n" übergeben, die zur Berechnung der Fakultät verwendet wird und größer 1 ist.
    - Der Methode wird eine weitere ganzzahlige Zahl "div" als Divisor übergeben.
    - Die Methode liefert den boolschen Wert "true" zurück, falls das Ergebnis der Fakultätsberechnung durch den Divisor teilbar ist, ansonsten "false".
    - Testen Sie Ihr Programm im "main" mit verschiedenen Inputs und geben Sie das Ergebnis mit "System.out.println()" aus.

    Zusatzfragen:
    1) Warum verwendet man im allgemeinen Methoden? Warum nicht alles direkt in "main" programmieren?
*/
public class Aufgabe3 {

    /* TODO: add code here */
    public static boolean isFacultyDiv(int n,int div){

        int fakt=1;
        if (n == 0 || n< 0) {return false;}
        else {
            for(int i=1; i<=n;i++) {
                fakt= fakt * i;
            }

        }
        if ( fakt%div ==0){
            return true;
        } else {
            return false;
        }
    }



    public static void main(String[] args) {
        /* TODO: add code here */
        System.out.println("Boolean ist " + isFacultyDiv(3,3));
    }
}
