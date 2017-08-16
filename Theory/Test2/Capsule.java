/***********************************************************************************
BEURTEILUNG von 1428773 für Aufgabe 1:  16 Punkte

        Deklaration und Initialisierung: 4 - Datenstruktur nicht initilisiert fehlerhaftes
																					   Lesen und Schreiben der Daten
        'register':                      5 - equals Vergleich nicht vorhanden und Array mit
																						 neuem Eintrag wird nicht Map gelegt
        'names':                         7 - Auf "null" an falscher Stelle geprüft und return
																						 nicht vollständig

Hier ist ein Beispiel für die wesentlichen Teile einer Lösung:

    private Map<String, String[]> registry = new TreeMap<String, String[]>();

    public Capsule(Queue<String> addrs, Queue<String[]> names) {
        String a;
        while ((a = addrs.poll()) != null) {
            registry.put(a, names.poll());
        }
    }

    public boolean register(String name, String addr) {
        if (name == null || addr == null) {
            return false;
        }
        String[] ps = registry.get(addr);
        if (ps == null) {
            registry.put(addr, new String[]{name});
        } else {
            String[] nps = new String[ps.length + 1];
            for (int i = 0; i < ps.length; i++) {
                if (name.equals(ps[i])) {
                    return false;
                }
                nps[i] = ps[i];
            }
            nps[ps.length] = name;
            registry.put(addr, nps);
        }
        return true;
    }

    public Queue<String> names(String addr) {
        String[] ps;
        if (addr == null || (ps = registry.get(addr)) == null) {
            return null;
        }
        Queue<String> q = new LinkedList<String>();
        for (String p : ps) {
            q.offer(p);
        }
        return q;
    }

***********************************************************************************/
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
Lesen Sie die Aufgaben genau durch.
Schreiben bzw. vervollständigen Sie gekennzeichnete Programmteile wie in den Kommentaren beschrieben.
Verändern Sie aber nicht vorgegebene Methodenköpfe oder andere vorgegebene Programmteile!
*/
public class Capsule {

    /*
    Aufgabe:
        Objekte der Klasse Capsule stellen einfache Melderegister dar. Für eine gegebene Adresse können die Personen
        ermittelt werden, die an dieser Adresse wohnen.

        Die Namen aller Personen, die an derselben Adresse wohnen, sollen in einem String-Array abgelegt werden.
        Für alle anderen Zwecke dürfen in dieser Aufgabe keine Arrays verwendet werden.
        Stattdessen sollen Datenstrukturen wie Queue und Map verwendet werden.

        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 30):
        10 Punkte für die Deklaration und Initialisierung der nötigen Objektvariablen (einschließlich Konstruktor),
        10 Punkte für die Implementierung von 'register',
        10 Punkte für die Implementierung von 'names',

        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */


    // Object variables shall be visible only within the class.
    // TODO: Declaration and initialization of object variables is your task.
    private Map<String,String[]> map;




    // Initialize new object:
    // 'addrs' contains addresses and 'names' names of all persons living at these addresses.
    // It is assumed that 'addrs' and 'names' are not null and the queues are of the same length.
    // The first element in 'addrs' corresponds to the first element in 'names', the second to the second, and so on.
    // If no person is living at an address, then the corresponding element in 'names' is an array of length 0.
    public Capsule(Queue<String> addrs, Queue<String[]> names) {
        // TODO: Implementation is your task.
            if(addrs.peek()!=null ){

                boolean s=true;
                while(s) {
                    if (names.peek() == null) {
                        s = false;
                    } else {
                        if (names.peek().length < 1) {
                            this.map.put(addrs.poll(), new String[0]);

                        } else {
                            this.map.put(addrs.poll(), names.poll());

                        }
                        s = names.peek() == null;
                    }
                }
            }

    }


    // 'register' tries to add a new name 'name' to the people living at address 'addr'.
    // If 'name' or 'addr' is null or 'name' is already among the persons living at address 'addr', then no name
    // is added and false is returned.
    // Otherwise 'name' is added (i.e., the corresponding array has to be extended) and true is returned.
    public boolean register(String name, String addr) {
        // TODO: Implementation is your task.


        if(addr ==null|| name==null){return false;}

            if(this.map.containsKey(addr))
            {
                String[] m= this.map.get(addr);
                for(int i=0; i<m.length; i++){
                            if(m[i]==name){
                                return true;
                            }
                            else {
                                m= new String[m.length+1];
                                m[m.length-1]=name;
                                return false;
                            }
                        }

            }else{
                String[] s=new String[]{name};
                this.map.put(addr,s);
                return true;

            }


    }


    // 'names' returns the names of all people living at address 'addr' in a queue.
    // If 'addr' is null or 'addr' is an unknown address, then 'names' returns null.
    // If 'addr' is a known address, but nobody is living at this address, then 'names' returns an empty queue.
    // Names in the returned queue can occur in arbitrary ordering (beliebige Reihenfolge).
    public Queue<String> names(String addr) {
        // TODO: Implementation is your task.
        String[] m= this.map.get(addr);
        Queue<String> quem= new LinkedList<String>();

        if(addr!=null){

            if(m.length<1){ return quem;}

            for(int i=0;i<m.length;i++){

                if(m[i]!=null){
                quem.offer(m[i]);

                }else{
                quem.offer(null);
                }
            return quem;

        }

        }else {

            return quem;
        }



    }


    // Just for testing. Does not contribute to the assessment. Geht nicht in die Beurteilung ein.
    public static void main(String[] args) {
    }

}

