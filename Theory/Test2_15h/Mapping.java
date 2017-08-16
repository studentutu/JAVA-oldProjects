/***********************************************************************************
Hier ist ein Beispiel für eine Lösung (ohne Kommentare):

 private Map<String, String> flight = new TreeMap<String, String>();

 public Mapping(Queue<String> freeSeats) {
 if (freeSeats != null) {
 String seat;
 while ((seat = freeSeats.poll()) != null) {
 if (flight.put(seat, "free") != null) {
 flight.put(seat, "definitely free");
 }
 }
 }
 }

 public int addFromArrays(String[] seats, String[] passengers, boolean[] added) {
 if (seats == null || passengers == null || added == null ||
 seats.length != passengers.length || seats.length != added.length) {
 return -1;
 }
 int count = 0;
 for (int i = 0; i < seats.length; i++) {
 if (flight.containsKey(seats[i])) {
 String old = flight.get(seats[i]);
 if ("definitely free".equals(old)) {
 added[i] = false;
 } else {
 flight.put(seats[i], passengers[i] + " +++ " + old);
 added[i] = true;
 count++;
 }
 } else {
 flight.put(seats[i], passengers[i]);
 added[i] = true;
 count++;
 }
 }
 return count;
 }

 public String[] getFromArray(String[] seats) {
 String[] result = null;
 if (seats != null) {
 result = new String[seats.length];
 for (int i = 0; i < seats.length; i++) {
 result[i] = flight.get(seats[i]);
 }
 }
 return result;
 }

 public static void main(String[] args) {
 Queue<String> free = new LinkedList<String>();
 for (int i = 1; i <= 50; i++) {
 free.offer("H" + i);
 }
 free.offer("H2");
 Mapping map = new Mapping(free);
 String[] seats = { "A1", "H1", "H2" };
 String[] read = map.getFromArray(seats);
 for (String s : read) {
 System.out.println(s);
 }
 String[] passengers = { "Hans Mustermann", "Gabi Musterfrau", "Anonymous Nobody" };
 boolean[] added = new boolean[3];
 System.out.println(map.addFromArrays(seats, passengers, added));
 for (boolean b : added) {
 System.out.println(b);
 }
 read = map.getFromArray(seats);
 for (String s : read) {
 System.out.println(s);
 }
 }

 ***********************************************************************************/
import java.util.*;

public class Mapping {

    /*
    Aufgabe:
        Objekte der Klasse Mapping simulieren ein Verzeichnis der Sitzplatzbelegung während eines Flugs. Zu einer
        gegebenen Bezeichnung eines Sitzplatzes (ein String) findet man Passagierinformationen (ebenso ein String)
        wie Namen von Passagieren oder Hinweise auf freibleibende Sitzplätze.

        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 25):
        8 Punkte für die Deklaration und Initialisierung der nötigen Objektvariable und den Konstruktor,
        8 Punkte für addFromArrays,
        4 Punkte für getFromArray,
        5 Punkte für main.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    // The object variable 'flight' of type Map<String, String> associates seats with passenger information.
    // 'flight' is visible only within the class.
    // TODO: Declaration and initialization of 'flight' is your task
    // Note: TreeMap<String, String> may be useful for object initialization.


    // On object construction, each seat in freeSeats is associated with the information "free".
    // However, if a seat occurs several times in freeSeats, then the string shall be "definitely free".
    // If freeSeats is null, nothing is added to the data structure.
    public Mapping(Queue<String> freeSeats) {
        // TODO: Implementation is your task

    }


    // addFromArrays adds passengers. For an index i, seats[i] specifies a seat and passengers[i] the name of a
    // passenger on this seat. If no entry for this seat existed before, then the passenger name is added as
    // passenger information. If there is already an entry for this seat giving the information "definitely free",
    // then passengers[i] is not added. If there is already an entry giving some other information, then the
    // passenger is added by extending the passenger information: The old passenger information is replaced with a
    // string constructed as in the following line:
    //     passengers[i] + " +++ " + the old passenger information

    // addFromArrays modifies 'added': On return added[i] is true if passengers[i] was added; otherwise it is false.
    // If any of the parameters is null or these arrays are of different sizes, then nothing is added and -1 is
    // returned as result; otherwise the number of added passengers is returned.
    public int addFromArrays(String[] seats, String[] passengers, boolean[] added) {

        return 0; // TODO: Implementation is your task
    }


    // The array returned by getFromArray is of the same size as 'seats' and contains at index i the passenger
    // information for seats[i] (or null if there is no such information).
    // If 'seats' is null, then null is returned.
    public String[] getFromArray(String[] seats) {

        return null; // TODO: Implementation is your task
    }


    // An execution of main does the following (in the given ordering):
    //   - A variable of type Queue<String> is initialized with a new object of type LinkedList<String>, and the
    //     strings "H1", ..., "H50" are added to the queue; "H2" is added twice.
    //   - A new object of type Mapping is created (using the queue as argument of the constructor).
    //   - The passenger information for the seats "A1", "H1" and "H2" is computed (by a single invocation of


    //     getFromArray) and printed - information for each seat on a separate line.
    //   - addFromArrays is invoked with the seats "A1", "H1" and "H2", and the passengers "Hans Mustermann",
    //     "Gabi Musterfrau" and "Anonymous Nobody".
    //     The result is printed, and then the values in the boolean array are printed (one line for each value).
    //   - The passenger information for the seats "A1", "H1" and "H2" is computed and printed again.
    public static void main(String[] args) {
        // TODO: Implementation is your task

    }

}


