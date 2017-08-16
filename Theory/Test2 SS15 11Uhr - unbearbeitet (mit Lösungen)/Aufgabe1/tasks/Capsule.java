/*

Hier ist ein Beispiel für eine Lösung (ohne Kommentare):

    private double longitude, latitude;

    public Capsule(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void move(double deltaLongitude, double deltaLatitude) {
        longitude += deltaLongitude;
        latitude += deltaLatitude;
        if (latitude > 90.0) {
            latitude = 180.0 - latitude;
            longitude += 180.0;
        }
        else if (latitude < -90.0) {
            latitude = -180.0 - latitude;
            longitude += 180.0;
        }
        if (longitude > 180.0) {
            longitude -= 360.0;
        }
        else if (longitude <= -180.0) {
            longitude += 360.0;
        }
    }

    public String location() {
        return "Long: " + longitude + ", Lat: " + latitude;
    }

    public static void main(String[] args) {
        Capsule x = new Capsule(16.0, 48.0);
        System.out.println(x.location());
        Capsule y = new Capsule(-160.0, 88.0);
        System.out.println(y.location());
        x.move(-16.0, 16.0);
        y.move(-16.0, 16.0);
        System.out.println(x.location());
        System.out.println(y.location());
    }

***********************************************************************************/
/*
Lesen Sie die Aufgaben genau durch.
Verändern Sie die in den Aufgaben beschriebenen Programmstellen.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!

Achtung: Vorgegebene Testfälle überprüfen nur die Syntax. Sie überprüfen nicht die Korrektheit der Lösungen.
*/
public class Capsule {

    /*
    Aufgabe:
        Objekte der Klasse Capsule stellen geographische Ortsangaben dar. Jede Ortsangabe setzt sich zusammen aus
          - der geographischen Länge (engl. longitude, wobei stets longitude > -180.0 und longitude <= 180.0 gilt)
          - und der geographischen Breite (engl. latitude, wobei stets latitude >= -90.0 und latitude <= 90.0 gilt).

        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 20):
        4 Punkte für die Deklaration und Initialisierung der nötigen Objektvariablen (einschließlich Konstruktor),
        8 Punkte für die Implementierung von move,
        4 Punkte für die Implementierung von location,
        4 Punkte für die Implementierung von main.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */


    // Object variables shall be visible only within the class
    // TODO: Declaration and initialization of object variables is your task



    // Initialize new object with given longitude and latitude;
    // assumptions: longitude > -180.0; longitude <= 180.0; latitude >= -90.0; latitude <= 90.0
    public Capsule(double longitude, double latitude) {
        // TODO: Implementation is your task

    }




    // Change geographic location by adding deltaLongitude and deltaLatitude;
    // assumptions: deltaLongitude > -180.0; deltaLongitude <= 180.0; deltaLatitude >= -90.0; deltaLatitude <= 90.0
    // Special care is taken not to exceed the limits on longitude and latitude. Examples:
    //   - instead of a longitude of 190.0 the longitude shall be -170.0
    //   - instead of a longitude of -190.0 the longitude shall be 170.0
    //   - instead of a latitude of 100.0 and longitude of 10.0 the latitude shall be 80.0 and the longitude -170.0
    //     (because of adding 180.0 to the longitude and recalculating the longitude to stay within the limits)
    //   - instead of a latitude of -100.0 and longitude of -10.0 the latitude shall be -80.0 and the longitude 170.0
    // TODO: Implementation is your task
    public void move(double deltaLongitude, double deltaLatitude) {

    }


    // Returns a string specifying the current geographic location in the form "Long: -1.23456, Lat: 46.32"
    // (if the longitude is -1.23456 and the latitude 1.23456).
    public String location() {
         // TODO: Implementation is your task
    }


    // An execution of main does the following (in the given ordering):
    //   - Create an object of type Capsule and print a line containing the result of applying location() to the object
    //     such that the printed line contains: Long: 16.0, Lat: 48.0
    //   - Create another object of type Capsule and print a line containing the result of applying location() to it
    //     such that the printed line contains: Long: -160.0, Lat: 88.0
    //   - Apply move(-16.0, 16.0) to each of the two objects.
    //   - Print a line containing the result of applying location() to the object created first.
    //   - Print a line containing the result of applying location() to the object created next.
    public static void main(String[] args) {
        // TODO: Implementation is your task

    }

}


