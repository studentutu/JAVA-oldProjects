import javafx.geometry.Pos;

/**********************************************************************************************************************

 AUFGABENBLATT 6 - Allgemeine Informationen

 Das Projekt Aufgabenblatt6 besteht aus fünf Aufgaben in je einer Klasse, die Sie erweitern und in den Übungen vom 
 30.11. bis 4.12. präsentieren können müssen.

 Achten Sie bei der Implementierung der Klassen auf folgende Punkte:

 - Einige Aufgabenstellungen sind in eine Geschichte eingebettet und auf einer höheren Abstraktionsebene beschrieben
   als in bisherigen Übungen. Rechnen Sie daher mit einem höheren Aufwand zum Verstehen der Aufgaben.
 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Testen und kommentieren Sie Ihre Programme ausführlich.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich thematisch auf das erstellte Programm.
   Sie müssen diese Zusatzfragen in der Übung beantworten können.

 Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 30.11.2015 um 06:00 Ihre Kreuzerl des aktuellen
 Aufgabenblattes eintragen. Nur durch Ankreuzen können Sie auch Punkte bekommen. Allerdings müssen Sie
 angekreuzte Aufgaben auch vorzeigen können.

 ***********************************************************************************************************************/
/*
    Aufgabenstellung zur Klasse Position:
        Die letzten Wochen vor Weihnachten sind für Karlis Fahrradbotendienst die schwierigsten. Einerseits gibt es
        mehr Botenfahrten als im restlichen Jahr, andererseits sind die Straßenverhältnisse oft schlecht, und angeblich
        bleibt immer wieder einmal ein Fahrradbote an einem Punschstand hängen. Dadurch erreicht so manche Sendung den
        Empfänger nicht wie zugesichert innerhalb einer Stunde, wobei Fahrten nur zwischen 8:00 und 18:00 Uhr erfolgen.
        Um die Ursachen von Zustellproblemen leichter ermitteln zu können, werden die Radfahrer mit GPS-Trackern
        ausgestattet, die nach jeder Fahrt ausgewertet werden. Das Auslesen eines GPS-Trackers gibt ein Array von
        Objekten der hier implementierten Klasse 'Position' zurück. Für ca. jede Minute der Fahrt gibt es einen Eintrag
        im Array, chronologisch sortiert. Jeder Array-Eintrag enthält Informationen zur Uhrzeit (als Anzahl der seit
        Mitternacht vergangenen Sekunden) und der genauestmöglichen Position in Wien und Umgebung, dargestellt durch
        Longitude (also der geographischen Länge im Wertebereich von etwa 15.0 bis 17.0) und Latitude (geographischer
        Breite etwa zwischen 47.0 und 49.0). Methoden von 'Position' sollen bei der Auswertung der Daten helfen und
        sich den Kommentaren entsprechend verhalten.

    Zusatzfragen:
    1. Welche Teile der Aufgabenstellung beeinflussen welche Teile der Lösung auf welche Weise?
    Welche Teile der Aufgabenstellung haben dagegen keinen Einfluss auf die Lösung?
            2. Warum sollen Objektvariablen als private deklariert sein?
            3. Woran kann man einen Konstruktor erkennen?
            4. Warum ist isStopped als static definiert, isClose und isCloseToPath aber nicht?
            5. Warum erlauben die Vergleiche einen Abstand eps zwischen Standorten (statt einfacher Vergleiche mittels ==)?
            */
    public class Position {

        // TODO: Object variables shall be declared here.
    private double Longitude=0.0;
    private double Latitude=0.0;
    private int Uhrzeit=0;

        // TODO: A public constructor for Position shall be declared here, providing values for all object variables.

        public Position(double longt, double lat, int Zeit){

            this.Longitude=longt;
            this.Latitude=lat;
            this.Uhrzeit=Zeit;
        }

        // Returns true if (and only if) longitude and latitude of this position (the current object) differ from
    // longitude and latitude of x by at most eps.
    public boolean isClose(Position x, double eps) {
        // TODO: Implementation is your task.
        double currentLat = (x.Latitude -this.Latitude)<0?-(x.Latitude -this.Latitude):(x.Latitude -this.Latitude);
        double currentLong= (x.Longitude-this.Longitude)<0?-(x.Longitude-this.Longitude):(x.Longitude-this.Longitude);
        if(currentLat<=eps && currentLong<=eps){return true;}
        return false;
    }

    // Returns true if (and only if) longitude and latitude of this position (the current object) differ from
    // longitude and latitude of any element in xs by at most eps.
    public boolean isCloseToPath(Position[] xs, double eps) {
        // TODO: Implementation is your task.
        for(int i=0;i<xs.length;i++){
            if(!isClose(xs[i],eps)){return false;}
        }
        return true;
    }

    // Parameter xs contains the positions of a tour. A tour is regarded as being stopped at a position in the array
    // if this position is close (difference at most eps) to each of the following 4 positions in the array.
    // The method returns the time (in seconds since midnight) of the first stop (lowest index in the array),
    // or -1 if there is no stop.
    public  int isStopped(Position[] xs, double eps) {
        // TODO: Implementation is your task.
        if(isCloseToPath(xs, eps)){
            return xs[0].Uhrzeit;
        }
        return -1;
    }

    // Returns true if (and only if) the time of each position in xs is higher than that of each other position at a
    // lower index.
    public static boolean chronologic(Position[] xs) {
        // TODO: Implementation is your task.
        boolean res=false;
        int max=xs[0].Uhrzeit;
        for(int i=1;i<xs.length;i++){
            if(max>xs[i].Uhrzeit){return false;}
            max=xs[i].Uhrzeit;
            res=true;
        }
        return res;
    }


    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
        Position a = new Position(15.45, 45.98, 20);
        Position b = new Position(16.02, 46.42, 22);
        System.out.println("a close to b == "+ a.isClose(b, 3));
        Position c = new Position(15.51, 48.98, 24);
        Position d = new Position(16.2, 45.98, 30);
        Position e = new Position(15.49, 47.98, 35);
        Position f = new Position(16.33, 48.98, 37);
        Position g = new Position(17.00, 49.00, 39);
        Position h = new Position(15.00, 45.00, 50);
        Position check[] = {a,b,c,d,e,f,g};
        System.out.println("Chronologicall== " + h.chronologic(check));
        Position check1[] = {d,c,e,f,g};
        System.out.println("Is stopped== " + h.isStopped(check1,4));
    }
}
