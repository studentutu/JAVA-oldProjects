/***********************************************************************************          

Hier ist ein Beispiel für die wesentlichen Teile einer Lösung:

    private Map<String, String> map = new TreeMap<String, String>();

    public SunAndRain(int year, int month, int day, Queue<Integer> rain) {
        for (;; year++, month = 1) {
            for (; month <= 12; month++, day = 1) {
                for (; day <= 30; day++) {
                    Integer hours = rain.poll();
                    if (hours == null) {
                        return;
                    }
                    map.put(day + "." + month + "." + year, "rain " + hours + "h");
                }
            }
        }
    }

    public void addSun(String[] date, int[] sun) {
        if (date != null && sun != null && date.length == sun.length) {
            for (int i = 0; i < date.length; i++) {
                if (map.containsKey(date[i])) {
                    String s = map.get(date[i]);
                    if (!s.startsWith("sun")) {
                        map.put(date[i], "sun " + sun[i] + "h, " + s);
                    }
                } else {
                    map.put(date[i], "sun " + sun[i] + "h");
                }
            }
        }
    }

    public SunAndRain getYear(int year) {
        SunAndRain forYear = new SunAndRain(year, 1, 1, new LinkedList<Integer>());
        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= 30; day++) {
                String date = day + "." + month + "." + year;
                String val = this.map.get(date);
                if (val != null) {
                    forYear.map.put(date, val);
                }
            }
        }
        return forYear;
    }

***********************************************************************************/
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
Lesen Sie die Aufgaben genau durch.
Verändern Sie die in den Aufgaben beschriebenen Programmstellen.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!

Achtung: Vorgegebene Testfälle überprüfen nur die Syntax. Sie überprüfen nicht die Korrektheit der Lösungen.
*/
public class SunAndRain {

    /*
    Aufgabe:
        Objekte der Klasse SunAndRain verwalten einfache Wetterdaten.  Zu einem bestimmten Datum (z.B. "14.7.2015",
        also zerst Tag, dann Monat, dann Jahr, jeweils ohne führende 0) lassen sich gespeicherte Wetterdaten abrufen.
        Wir nehmen vereinfachend an, dass jeder Monat 30 Tage hat; "30.2.2015" ist also gültig, "31.7.2015" aber nicht.
        Wetterdaten sind Strings wie z.B. "sun 3h, rain 4h" für 3 Stunden Sonne und 4 Stunden Regen.  Nicht alle
        Teile müssen vorhanden sein.  Beispielsweise sind auch "sun 7h" und "rain 0h" gültige Wetterdaten.

        Ergänzen Sie fehlende Teile entsprechend den Kommentaren an den mit TODO: gekennzeichneten Stellen.

    Punkte (maximal 24):
        8 Punkte für die Deklaration und Initialisierung der nötigen Objektvariablen und Konstruktoren,
        8 Punkte für addSun,
        8 Punkte für getYear.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    // The object variable of name 'map' and type Map<String, String> associates calendar dates (Datum) with
    // weather information;  'map' is visible only within the class.
    // TODO: Declaration and initialization of the object variable is your task


    // 'year', 'month' and 'day' together specify a valid calendar date;  'rain' contains hours of rain;
    // On object construction the calendar date (specified by 'year', 'month' and 'day') is associated with
    // "rain Xh" where X is replaced with the first entry in 'rain',
    // the next day (after this date) is associated with "rain Yh" where Y is replaced with the second entry in 'rain',
    // and so on (until there are no more entries);
    // rain != null  is assumed.
    public SunAndRain(int year, int month, int day, Queue<Integer> rain) {
        // TODO: Implementation is your task
        
    }


    // addSun adds information on sun hours.  For an index i, date[i] specifies a valid calendar date and sun[i]
    // the sun hours of this day.  However, if there is already an entry for the same calendar date specifying
    // sun hours, no information is added.  If there is already an entry specifying rain hours, but no sun hours,
    // then the entry is replaced with an entry specifying both (the sun hours in sun[i] and the rain hours as in
    // the entry).
    // If date is null or sun is null or the sizes of date and sun are different, then no information is added.
    // All elements of date and sun are assumed to be valid.
    public void addSun(String[] date, int[] sun) {
        // TODO: Implementation is your task
        
    }

    // getYear returns a copy of 'this' containing weather information just for calendar dates in the specified year;
    // there is no information on other years, and the information for the same year ist identical to that in 'this'.
    public SunAndRain getYear(int year) {
        // TODO: Implementation is your task
        // Note: It is easier not to use 'clone'.
        return null;
    }


    // Just for testing, not used for assessment (geht nicht in die Beurteilung ein).
    public static void main(String[] args) {
    }

}

