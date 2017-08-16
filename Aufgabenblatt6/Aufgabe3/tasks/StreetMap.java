import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/*
    Aufgabenstellung zur Klasse StreetMap:

    Um die Suche nach einer Zieladresse zu erleichtern, haben die Fahrer in Karlis Fahrradbotendienst einen einfachen
    elektronischen Stadtplan bei sich: Nach Eingabe einer Adresse erscheinen der Name des entsprehenden Distrikts und
    die GPS-Koordinaten. Objekte der Klasse StreetMap stellen einen wesentlichen Teil des Stadtplans dar.
    Vervollständigen Sie die Implementierung, so wie in den Kommentaren beschrieben.

    Bitte verwenden Sie in der Implementierung von StreetMap KEIN Array, sondern nur Objekte von Typen wie Queue, Deque
    und Map (neben MapData - siehe unten).

    Zusatzfragen:
    1. Wieso ist die zusätzliche Klasse MapData sinnvoll?
    2. Wie werden die Daten in MapData zugreifbar? Geht das auch, wenn die Objektvariablen private sind?
    3. Wofür ist Queue besser geeignet, wofür Map?
    4. Warum ist Double mit großem Anfangsbuchstaben geschrieben (nicht double)?
*/

public class StreetMap {

    // TODO: Object variables shall be declared here.
   public Map<String,MapData> obj= new TreeMap<String,MapData>();
    // The parameters specify the initial contents of a street map:
    //     addr:  addresses that can be found in the street map
    //     distr: names of the districts of corresponding addresses
    //     lon:   longitudes in the GPS coordinates
    //     lat:   latitude in the GPS coordinates
    // All queues in the parameters are of the same size.
    // All entries at the same position (1st, 2nd, 3rd, ...) belong together.
    public StreetMap(Queue<String> addr, Queue<String> distr, Queue<Double> lon, Queue<Double> lat) {
        // TODO: Implementation is your task.
        while (addr.peek() != null) {
            String adr = addr.poll();
            MapData mapa = new MapData(adr, distr.poll(), lon.poll(), lat.poll());
            obj.put(adr, mapa);
        }

    }

    // Returns all data (district and GPS coordinates) for address addr.
    // Returns null if no data can be found for this address.
    public MapData find(String addr) {
        // TODO: Implementation is your task.
        if (obj.containsKey(addr))
            return obj.get(addr);

        return null;
    }

    // Returns true if (and only if) address addr is in district distr.
    public boolean inDistrict(String addr, String distr) {
        // TODO: Implementation is your task.
        if(obj.containsKey(addr)){
            if(obj.get(addr).Distrikt.equals(distr)){return true;}
        }
        return false;
    }

    // Adds a new address addr to the street map, where newData are the data to be associated with this address.
    // However, if the address already exists, the old data are replaced with newData.
    // true is returned if the address was replaced, false if a new address was added.
    public boolean newData(String addr, MapData newData) {
        // TODO: Implementation is your task.
        if (obj.containsKey(addr)==true) {//containsKey() true||false
            obj.put(addr,newData);
            return true;
        }else {
            obj.put(addr,newData);
            return false;
        }

    }

    // To test the implementation several objects of StreetMap (each with several addresses) are created,
    // all methods are called, and data associated with found addresses are printed.
    public static void main(String[] args) {
        // TODO: Implementation is your task.
        Queue<String> a1 = new LinkedList<String>();
        Queue<String> b1 = new LinkedList<String>();
        Queue<Double> c1 = new LinkedList<Double>();
        Queue<Double> d1 = new LinkedList<Double>();

        String[] ar1 = {"addr1", "addr2", "addr3", "addr4", "addr5"};
        String[] ar2 = {"distr1", "distr2", "distr3", "distr4", "distr5"};
        double[] ar3 = {02.1, 3.15, 13.8, 3.45, 0.3};
        double[] ar4 = {44.1, 8.1, 3.6, 27.9, 7.2};

        for (int i = 0; i < 5; i++) {
            a1.offer(ar1[i]);
            b1.offer(ar2[i]);
            c1.offer(ar3[i]);
            d1.offer(ar4[i]);
        }

        Queue<String> a2 = new LinkedList<String>();
        Queue<String> b2 = new LinkedList<String>();
        Queue<Double> c2 = new LinkedList<Double>();
        Queue<Double> d2 = new LinkedList<Double>();

        a2.offer("not existing");
        b2.offer("new district-1");
        c2.offer(15.3);
        d2.offer(19.2);
        MapData q=new MapData("1","1b",12.9,11.9);

        StreetMap test1 = new StreetMap(a1, b1, c1, d1);

        StreetMap other = new StreetMap(a2,b2,c2,d2);

        System.out.println("addr2 ist in distr2 => " + test1.inDistrict("addr2", "distr2"));

        //existierendes Element, dann wird true zurückgegeben
        System.out.println("New Data() mit schon existirenden: "+test1.newData("addr2", test1.obj.get("addr2")) );//New Data
        // nicht existiert, dann wird  false zurückgegeben
         System.out.println("New Data() mit kein existierenden: "+test1.newData("not existing", other.obj.get("not existing") ) );//New Data False


    }
}

// Objects of MapData hold all data (district and GPS coordinates) associated with an address in the street map.
// It is necessary to get access to the data in objects of this type.
class MapData {
    // TODO: Implementation is your task.
    public String adress;
    public String Distrikt;
    public double Longtitude;
    public double Latitude;

    public MapData(String adr,String dist,double lon,double lat){
        this.adress=adr;
        this.Distrikt=dist;
        this.Longtitude=lon;
        this.Latitude=lat;

    }

}
