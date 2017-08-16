/*
    Aufgabe5) Schleifen und Methoden
    Erweitern Sie die Klasse "Aufgabe5" um folgende Funktionalität:
    - Schreiben Sie eine statische Methode "calcCrossSum", die die Quersumme einer übergebenen Zahl berechnet.
    - Der Methode wird ein positiver ganzzahliger Wert "value" übergeben.
    - Die Methode liefert das Ergebnis der Quersumme als ganzzahligen Wert zurück.
    - Testen Sie Ihr Programm im "main" mit verschiedenen Inputs und geben Sie das Ergebnis mit "System.out.println()" aus.

    Zusatzfragen:
    1) Welcher positiver ganzzahliger (Typ "int") Wert muss der Methode übergeben werden, damit die höchstmögliche Quersumme berechnet wird?
*/
public class Aufgabe5 {

    /* TODO: add code here */
    public static int calcCrossSum(int value){
        int ergeb = 0;
        int res =0;
        if(value == 0) { return 0;} else {
            while (value != 0) {
                res = value % 10;
                ergeb = ergeb + res;
                value = value / 10;
            }
            return ergeb;
        }
    }

    public static void main(String[] args) {
        /* TODO: add code here */
        System.out.println("CrossSum ist "+ calcCrossSum(544));
    }
}
