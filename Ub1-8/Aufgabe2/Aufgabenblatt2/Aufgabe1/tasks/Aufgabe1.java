/**********************************************************************************************************************

    AUFGABENBLATT 2 - Allgemeine Informationen

    Das Projekt Aufgabenblatt2 besteht aus fünf Aufgaben in den Klassen Aufgabe1 bis Aufgabe5, die Sie erweitern und in
    den Übungen vom 26.10. bis 30.10. präsentiern können müssen.

    Achten Sie bei der Implementierung von Aufgabe1-Aufgabe5 auf folgende Punkte:

    - Ihr Programm sollte kompilierbar und ausführbar sein.
    - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich thematisch auf das erstellte Programm.
    Sie müssen diese Zusatzfragen in der Übung beantworten können.
    - Verwenden Sie bei allen Ausgaben immer System.out.println().
    - Verwenden Sie für die Lösung der Aufgaben keine speziellen Aufrufe aus der Java-API, die die Aufgaben
    verkürzen würden.

    Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 26.10.2015 um 06:00 Ihre Kreuzerl des aktuellen
    Aufgabenblattes eintragen. Jede Aufgabe die Sie ankreuzen muss vorgezeigt werden können und wird bewertet.

***********************************************************************************************************************/

/*
    Aufgabe1) Typen und Typumwandlungen

    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Deklarieren und initialisieren Sie je eine lokale Variable mit den Werten
          0xe, 030, 18L, 4.44e1, 55.5, 66e-1f, 7.7f, 'F'
      und sorgen Sie dafür, dass die Variablen dieselben Typen haben wie diese Literale.
    - Erzeugen Sie durch Verwendung des Operators + einen String, der die Werte in den Variablen in der oben gegebenen
      Reihenfolge enthält, jeweils getrennt durch ", ". Geben Sie den String mittels System.out.println(...) aus.
    - Berechnen Sie das ganzzahlige Produkt aller Werte in diesen Variablen, wobei Nachkommastellen so früh wie möglich
      abgeschnitten werden. Vermeiden Sie einen Überlauf des Ergebnisses. Geben Sie das Produkt mittels System.out.println(...) aus.
    - Berechnen Sie die Summe aller Werte in diesen Variablen und wandeln Sie das Ergebnis am Ende der Berechnung in
      eine ganze Zahl um. Geben Sie die ganzzahlige Summe mittels System.out.println(...) aus.
    - Wandeln Sie jeden Wert in den Variablen in einen Wert vom Typ byte um und berechnen Sie die Summe der
      umgewandelten Werte. Geben Sie die Summe mittels System.out.println(...) aus.

    Zusatzfragen:
    1. Wodurch erklären sich die Untersschiede zwischen den beiden berechneten Summen?
    2. Warum ist der aus den Variablen erzeugte String nicht gleich der oben vorgegebene Zeile mit Literalen?
    3. Von welchem Typ ist der zuletzt ausgegebene Wert?
    4. Wann wird ein Wert automatisch in einen Wert eines anderen Typs umgewandelt, wann benötigt man ein Cast?
    5. Wieviel Speicher belegt ein Wert eines elementaren Typs mindestens (je nach Typ)?
    6. Welchen Wertebereich kann ein elementarer Typ abdecken (je nach Typ)?
*/
public class Aufgabe1 {

    public static void main(String[] args) {
        /* TODO: add code here */
        byte a = 0xe;
        byte b = 030;
        long c = 18L;
        double d = 4.44e1;
        double e = 55.5;
        float f = 66e-1f;
        float g = 7.7f;
        char h = 'F';
        String ruler = "" + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f + ", " + g + ", " + h;
        System.out.println(ruler);
         int produkt = (int)a*(int)b*(int)c*(int)d*(int)e*(int)f*(int)g*(int)h;
        System.out.println("Produkt ist (mit abgeschnitene zahlen) = "+produkt);
        double summe1=(double)a+(double)b+(double)c+(double)d+(double)e +(double)f +(double)g +(double)h;
        System.out.println("Summe ist(gerundet) ="+(int)summe1);



       int summ2 = (byte)a+(byte)b+(byte)c+(byte)d+(byte)e +(byte)f +(byte)g +(byte)h;
        System.out.println("Summe in byte ="+(byte)summ2);
        //System.out.println("My name is\n My name is 1\n My name is2\r");
     // int i=14;
         //int m= parseInt(i);

    //    System.out.format(" The %d",i);
    }
}
