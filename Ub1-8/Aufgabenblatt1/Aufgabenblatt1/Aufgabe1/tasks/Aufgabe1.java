/**********************************************************************************************************************

 AUFGABENBLATT 1 - Allgemeine Informationen

 In Ihrer Übungsumgebung unter Linux im Informatik-Labor finden Sie das Projekt Aufgabenblatt 1. Dieses Projekt
 besteht aus fünf Aufgaben (Aufgabe1 - Aufgabe5), die Sie erweitern müssen.

 Achten Sie bei der Implementierung von Aufgabe1-Aufgabe5 auf folgende Punkte:

 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich thematisch auf das erstellte Programm.
 Sie müssen diese Zusatzfragen in der Übung beantworten können.
 - Verwenden Sie bei allen Ausgaben immer System.out.println().
 - Verwenden Sie für die Lösung der Aufgaben keine speziellen Aufrufe aus der Java-API, die die Aufgaben
 verkürzen würden.

 Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 19.10.2015 um 06:00 Ihre Kreuzerl des aktuellen
 Aufgabenblattes eintragen. Jede Aufgabe die Sie ankreuzen muss vorgezeigt werden können und wird bewertet.

 ***********************************************************************************************************************/

/*
    Aufgabe1) Variablen
    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Deklarieren Sie eine ganzzahlige lokale "var1" und initialisieren Sie diese mit dem Wert 7.
    - Deklarieren Sie eine ganzzahlige lokale Variable "var2" und initialisieren Sie diese mit dem vierfachen Wert von "var1" (sprich 28).
    - Deklarieren Sie eine ganzzahlige lokale Variable "var3" und initilisieren Sie diese mit der Summe von "var2+var1".
    - Geben Sie die Variable "var3" mit "System.out.println()" aus.
    - Weisen Sie der Variablen "var3" das Ergebnis der Division "var2 / var1" zu.
    - Geben Sie die Variable "var3" mit "System.out.println()" aus.
    - Erhöhen Sie die Variable "var2" um 4 und weisen Sie erneut der Variablen "var3" das Ergebnis der Division "var2 / var1" zu.
    - Geben Sie die Variable "var3" mit "System.out.println()" aus.
    - Erhöhen Sie die Variable "var2" nochmals um 4 und weisen Sie erneut der Variablen "var3" das Ergebnis der Division "var2 / var1" zu.
    - Geben Sie die Variable "var3" mit "System.out.println()" aus.

    Zusatzfragen:
    1) Warum verwendet man Variablen in einem Programm?
    2) Welchen kleinsten oder größten Wert könnte man der Variablen "var1", "var2 und "var3" zuweisen?
    2) Was ist der Unterschied zwischen Ausdruck und Anweisung?
    3) Warum liefert erst nach der zweiten Erhöhung der Variable "var2" um 4, die Division danach ein anderes Ergebnis?
*/
public class Aufgabe1 {

    public static void main(String[] args) {
        /* TODO: add code here */
        int var1 = 7;
        int var2 = 4*var1;
        int var3 = var2+var1;
        System.out.println("1.mal var3 ist " + var3);
        var3 = var2/var1;
        System.out.println("2.mal var3 ist " + var3);
        var2 = var2 +4;
        var3 = var2/var1;
        System.out.println("3.mal var3 ist " + var3);
        var2 = var2+4;
        var3 = var2/var1;
        System.out.println("4.mal var3 ist " + var3);

    }
}
