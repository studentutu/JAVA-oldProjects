/*
    Aufgabe2) Design-by-Contract

    Sie haben eine Methode "foo" gegeben, deren Funktionalität Sie bitte ermitteln.
    Ziel ist es das Design-by-Contract Konzept zu vertiefen. Beschreiben Sie welche Vor- und Nachbedingung Sie
    finden können. Kommentieren Sie Ihren Code daher ausreichend.
    Bei dieser Aufgabe gibt es keine Testfälle. Aus einem erfolgreichen Durchlauf der Testklasse folgt also
    nicht automatisch die Korrektheit der Lösung.
    Beantworten Sie die Zusatzfragen, welche als Diskussionsbasis für die Bewertung dienen (im Idealfall
    schriftlich, das Vorliegen eines Textes wird aber nicht überprüft).

    [fortgeschritten]
    Sie haben eine Klasse "Table" gegeben, die int Werte in einer Tabelle fixer Größe abspeichert.
    Der aktuelle Befüllungsgrad der Tabelle wird in der Membervariablen "numFilled" abgelegt.
    Vervollständigen Sie die Funktionalität der beiden Methoden "put" und "get", die Elemente in die Tabelle
    einfügen bzw. auslesen. Erklären Sie welche Vor- und Nachbedingungen es bei diesem Beispiel geben kann, und welche
    Invarianten zu finden sind. Kommentieren Sie Ihren Code ausführlich.

    Zusatzfragen:
    1. Was versteht man unter Design-by-Contract?
    2. Wer oder was sind die Vetragspartner in einer Software?
    3. Was berechnet die Methode "foo"?
    4. Was ist die Vor- und Nachbedingung für foo wenn n eine natürliche Zahl darstellt?
    5. Was ist die Vor- und Nachbedingung für foo wenn n eine ganze Zahl darstellt?
    6. Was bedeutet die Vorbedingung "FALSE"?
    7. Was bedeutet die Nachbedingung "TRUE"?
*/

class Table {
    private int numFilled;
    private int[] intTable;

    public Table(int capacity){
        this.numFilled = 0;
        this.intTable = new int[capacity];
    }

    public int getFillStatus(){
        return this.numFilled;
    }

    public void put(int number){
        //Legt Zahl (number) in die Tabelle, falls diese nicht voll ist.
        //[fortgeschritten]
        //TODO: Implementieren Sie die Funktionalität!
    }

    public int get(int index){
        int temp = 0;
        //Gibt Zahl an der Stelle index der Tabelle zurück, falls laut Befüllungsstaus beschrieben.
        //[fortgeschritten]
        //TODO: Implementieren Sie die Funktionalität!
        return temp;
    }
}

public class Aufgabe2 {

    public static int foo(int n){
        int c = 0;
        int h = 1;
        int s = 1;
        while(s <= n){
            h+=2;
            c++;
            s+=h;
        }
        return c;
    }

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt
    }
}
