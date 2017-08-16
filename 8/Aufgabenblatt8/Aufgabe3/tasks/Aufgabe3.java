/*
    Aufgabe3) Schleifeninvarianten

    Sie finden unten die Klasse "SortedIntArray" aus der Vorlesung. Bitte suchen Sie zu jeder vorkommenden Schleife
    eine passende Schleifeninvariante. Schreiben Sie die Schleifeninvarianten als Kommentare ins Programm.
    Bei dieser Aufgabe gibt es keine Testfälle. Aus einem erfolgreichen Durchlauf der Testklasse folgt also
    nicht automatisch die Korrektheit der Lösung.

    [fortgeschritten]
    Finden Sie zu zwei beliebigen weiteren Schleifen die dazugehörigen Schleifeninvarianten.

    Zusatzfragen:
    1. Was sind Schleifeninvarianten?
    2. Wie können Schleifeninvarianten helfen, ein Programm besser zu verstehen und Fehler zu finden?
*/

class SortedIntArray {
    private int[] array; // in ascending order

    public SortedIntArray(int[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }

        // select one of the following
        this.bubbleSort();
//        this.quicksort();
    }

    // a simple bubble sort
    private void bubbleSort() {
        boolean done;
        do {
            done = true;
            for (int i = 1; i < this.array.length; i++) {
                if (this.array[i - 1] > this.array[i]) {
                    int h = this.array[i];
                    this.array[i] = this.array[i - 1];
                    this.array[i - 1] = h;
                    done = false;
                }
            }
        } while(! done);
    }


    // quicksort: sort this.array using a professional sorting algorithm
    private void quicksort() {
        this.quicksort(0, this.array.length - 1);
    }

    // here is the essential part of quicksort:
    // sort array between index low and index high
    private void quicksort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = this.array[(low + high) / 2];

        while (i <= j) {
            while (this.array[i] < pivot) {
                i++;
            }
            while (pivot < this.array[j]) {
                j--;
            }

            if (i <= j) {
                int h = this.array[i];
                this.array[i] = this.array[j];
                this.array[j] = h;

                i++;
                j--;
            }
        }

        if (low < i - 1) {
            this.quicksort(low, i - 1);
        }
        if (i < high) {
            this.quicksort(i, high);
        }
    }

    // is elem in the array?
    public boolean element(int elem) {
        int first = 0;
        int last = this.array.length - 1;

        while (first <= last) {
            int current = (first + last) / 2;
            if (this.array[current] > elem) {
                last = current - 1;
            } else if (this.array[current] == elem) {
                return true;
            } else {
                first = current + 1;
            }
        }
        return false;
    }
}

public class Aufgabe3 {

    // just for testing ...
    public static void main(String[] args) {

        // constants used for testing
        final int SIZE = 1000000;
        final int FACT = 3;
        final int STEP = 200;

        System.out.println("Start initialization");
        int[] test = new int[SIZE];
        for (int i = 0; i < test.length; i++) {
            test[i] = i * FACT;
//            test[i] = (int)(Math.random() * (FACT * SIZE));
        }
        SortedIntArray object = new SortedIntArray(test);

        int good = 0;
        int bad = 0;
        System.out.println("Start searching");
        for (int i = 0; i < FACT * SIZE; i += STEP) {
            if (object.element(i)) {
                good++;
            } else {
                bad++;
            }
        }
        System.out.println(good + " elements found, " + bad + " elements not found");

    }
}
