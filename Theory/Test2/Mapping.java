import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Mapping {

    /*
    Aufgabe:
        Objekte der Klasse Mapping simulieren eine einfache Bibliothek. Die Regale in der Bibliothek sind durch die
        Buchstaben A bis Z benannt, und innerhalb eines Regals haben Positionen der Bücher fortlaufende Nummern
        beginnend mit 1. Beispielsweise bezeichnet der String "C4" die Position des vierten Buchs im Regal C. Ein
        Objekt der Klasse Mapping enthält Informationen darüber, welches Buch (durch einen String bezeichnet) an einer
        bestimmten Position zu finden ist.

        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 25):
        8 Punkte für die Deklaration und Initialisierung der nötigen Objektvariable und den Konstruktor,
        8 Punkte für addFromArrays,
        4 Punkte für getFromArray,
        5 Punkte für main.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    // The object variable of type Map<String, String> associates positions in the library with books.
    // The variable is visible only within the class.
    // TODO: Declaration and initialization of the object variable is your task
    // Note: TreeMap<String, String> may be useful for object initialization.
    private Map<String, String> library = new TreeMap<String, String>();


    // On object construction all books in 'books' are added to the library. The first book in 'books' gets position
    // "A1", the second book "B1", and so on. After position "Z1" we continue with position "A2", then "B2" and so on
    // (first increasing letters, then numbers) until all books in 'books' are positioned in the library.
    // We assume that 'books' differs from null.
    public Mapping(Queue<String> books) {
        // TODO: Implementation is your task
        char shelf = 'A';
        int nr = 1;
        String book;
        while ((book = books.poll()) != null) {
            library.put("" + shelf + nr, book);
            if (shelf == 'Z') {
                shelf = 'A';
                nr++;
            } else {
                shelf++;
            }
        }
    }


    // addFromArrays adds further books to the library (if possible). For an index i, pos[i] specifies the position
    // in the library where the book in books[i] shall be added. However, if there is already another book at position
    // pos[i], then books[i] cannot be added. The array returned as result (of the same size as pos and books) contains
    // true at index i if books[i] was added (and false if it was not added). If pos is null or books is null or the
    // sizes of pos and books are different, then nothing is added and null is returned as result.
    public boolean[] addFromArrays(String[] pos, String[] books) {
        // TODO: Implementation is your task
        boolean[] result = null;
        if (pos != null && books != null && pos.length == books.length) {
            result = new boolean[pos.length];
            for (int i = 0; i < pos.length; i++) {
                if (library.containsKey(pos[i])) {
                    result[i] = false;
                } else {
                    library.put(pos[i], books[i]);
                    result[i] = true;
                }
            }
        }
        return result;
    }


    // The array returned by getFromArray is of the same size as pos and contains at index i the book found at
    // position pos[i] (or null if there is no book at this position). We assume that pos differs from null.
    public String[] getFromArray(String[] pos) {
        // TODO: Implementation is your task
        String[] result = new String[pos.length];
        for (int i = 0; i < pos.length; i++) {
            result[i] = library.get(pos[i]);
        }
        return result;
    }


    // An execution of main does the following (in the given ordering):
    //   - A variable of type Queue<String> is initialized with a new object of type LinkedList<String>, and the
    //     strings "BookA1", ..., "BookZ1", "BookA2", ..., "BookZ2", "BookA3", ..., "BookZ3" are added to the queue.
    //   - A new object of type Mapping is created (using the queue as argument of the constructor).
    //   - The books at the positions "C1", "C2", "C3", "C4", "C5" are computed (by getFromArray) and printed -
    //     each book on a separate line.
    //   - addFromArrays is invoked with the positions "C1", "C2", "C3", "C4", "C5" and the books "NewC1", "NewC2",
    //     "NewC3", "NewC4", "NewC5"; each value in the resulting array is printed on a separate line.
    //   - The books at the positions "C1", "C2", "C3", "C4", "C5" are computed (by getFromArray) and printed again.
    public static void main(String[] args) {
        // TODO: Implementation is your task
        Queue<String> books = new LinkedList<String>();
        for (int i = 1; i <= 3; i++) {
            for (char c = 'A'; c <= 'Z'; c++) {
                books.offer("Book" + c + i);
            }
        }
        Mapping map = new Mapping(books);
        String[] pos = {"C1", "C2", "C3", "C4", "C5"};
        String[] read = map.getFromArray(pos);
        for (String s : read) {
            System.out.println(s);
        }
        String[] nbook = {"NewC1", "NewC2", "NewC3", "NewC4", "NewC5"};
        boolean[] changed = map.addFromArrays(pos, nbook);
        for (boolean b : changed) {
            System.out.println(b);
        }
        read = map.getFromArray(pos);
        for (String s : read) {
            System.out.println(s);
        }
    }

}
