/*******************************************************************************

 AUFGABENBLATT 8 - Allgemeine Informationen

 Das Projekt Aufgabenblatt8 besteht aus fünf Aufgaben in je einer Klasse, die
 Sie erweitern und in den Übungen präsentieren können müssen.

 ********************************** HINWEIS ************************************
 Übungswoche 8 findet aufgrund Laborverfügbarkeiten über zwei Wochen statt.
 D.h. alle Dienstag-, Mittwoch- und Freitag-Gruppen absolvieren die Übung
 in der Woche von 11.01-15.01 in ihrem jeweiligen Slot.
 Alle Montag- und Donnerstag-Gruppen absolvieren die Übung in der Woche von
 18.01-22.01 in ihrem jeweiligen Slot.
 *******************************************************************************

 Achten Sie bei der Implementierung der Klassen auf folgende Punkte:

 - Einige Aufgabenstellungen sind in eine Geschichte eingebettet und auf einer
 höheren Abstraktionsebene beschrieben als in bisherigen Übungen. Rechnen Sie
 daher mit einem höheren Aufwand zum Verstehen der Aufgaben.
 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Testen und kommentieren Sie Ihre Programme ausführlich.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich
 thematisch auf das erstellte Programm. Sie müssen diese Zusatzfragen in der
 Übung beantworten können.

 Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 11.01.2016 um
 06:00 Ihre Kreuzerl des aktuellen Aufgabenblattes eintragen. Nur durch
 Ankreuzen können Sie auch Punkte bekommen. Allerdings müssen Sie angekreuzte
 Aufgaben auch vorzeigen können.

 ******************************************************************************/
/*
    Aufgabe1) Sortieren & Suchen

    Implementieren Sie in der gegebenen Klasse Aufgabe1 folgende statische
    Methoden:

    - sort:      Diese Methode soll den Sortieralgorithmus "QuickSort"
                 implementieren. Sie müssen den Sortieralgorithmus selbst
                 ausimplementieren und dürfen keinen entsprechenden Aufruf aus
                 der Java-API verwenden.
    - binSearch: Dieser Methode wird ein sortiertes Array übergeben. Zusätzlich
                 erhält die Methode einen Wert nach dem gesucht werden soll. Es
                 soll eine binäre Suche implementiert werden, die true
                 zurückliefert falls das Element enthalten ist, ansonsten false.

    Zusatzfragen:
    1. Welche API-Aufrufe bietet Java für das Sortieren von Arrays an?
    2. Welcher Sortieralgorithmus wird in Java (1.8) für das Sortieren von
       Arrays verwendet?
    3. Warum ist die Wahl des Pivot-Elements entscheidend für die Performance
       des Quicksort Algorithmus?
    4. Warum muss das Array für die binäre Suche sortiert sein?
    5. Wie geht man vor wenn man in einem absteigend sortierten Array die
       Binärsuche anwenden will?

*/
public class Aufgabe1 {

    public static void sort(int[] array) {
        /* TODO: add code here */
        sort(array,0,array.length-1);

    }
    public static void sort(int[] ar, int low,int hight){
        int i=low;
        int j=hight;
        int pivot = ar[(i+j)/2];

        while(i<=j){


            while (ar[i] < pivot) {
                i++;
            }
            while (pivot < ar[j]) {
                j--;
            }

            if (i <= j) {
                int h = ar[i];
                ar[i] = ar[j];
                ar[j] = h;

                i++;
                j--;
            }

        }
        if(i-1 >low){
            sort(ar,low,i-1);

        }
        if(hight>i){
            sort(ar,i,hight);

        }



    }

    public static boolean binSearch(int[] array, int elem) {
        /* TODO: add code here */
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;//index in the middle


            if (array[middle] < elem) {
                start=middle+1;

            } else if (array[middle]>elem){
                end = middle - 1;
            }else if (array[middle] == elem) {
                return true;
            }


        }
        return false;
    }

    //just for testing
    public static void main(String[] args) {

        int[] myar=new int[11];

        for(int i=10;i>=0;i--){
            myar[i]=i;


        }
        sort(myar);

        for(int i=0;i<myar.length;i++){

            System.out.print(" " + myar[i]);
        }
        System.out.println();
        System.out.println(binSearch(myar, 7));//must be true
        System.out.println(binSearch(myar, 11));//must be false


    }
}

/**
 int low;
 low=0;
 int secondlow=0;

 int up;
 up=array.length-1;
 int seconup=array.length-1;

 int pivot=array[ (up+low)/2];//in center;

 boolean done = true;
 while(done) {

 while (low <= up) {//main loop from low to up

 while ( array[low] < pivot ) {
 low++;
 }//while elem[low] < pivot its ok

 while( array[up] > pivot ) {
 up--;
 }//while elem[up]>pivot its ok

 if (low < up) {// appear something that >pivot or <pivot
 int tmp = array[low];
 array[low] = array[up];
 array[up] = tmp;

 low = low + 1;//now its ok
 up = up - 1;//now its ok
 done=false;
 }



 }
 //go to next low , up

 if (seconup > low) {

 low = low;
 up = seconup;

 secondlow=low;
 seconup = seconup;
 pivot=array[(low+up)/2];
 if(secondlow==seconup){done=false;}else{ done= true;}

 }



 }
*/