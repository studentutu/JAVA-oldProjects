/*
    Aufgabenstellung zur Klasse District:

    Karlis Fahrradbotendienst hat die Stadt in verschiedene Distrikte (engl. District) eingeteilt. Pro Distrikt
    gibt es eine Sammelstelle, in der sich Fahrer treffen und auf Aufträge warten. Führt ein Auftrag von einem
    Distrikt in einen anderen, kommt der Fahrer nach Erledigung des Auftrags zur Sammelstelle des Distrikts, in dem
    die Fahrt endet. Dort wartet der Fahrer auf einen Auftrag. Fahrer erhalten Aufträge in der Reihenfolge, in der
    Sie in der Sammelstelle eingetroffen sind. Manchmal kommt es zu ungleichen Auslastungen. Dann muss ein Fahrer, der
    als nächster eine Fahrt zu absolvieren hätte, in einen anderen Distrikt wechseln. Damit es zu keinen
    Ungerechtigkeiten kommt, wird ein solcher Fahrer gleich nach Eintreffen ganz nach vorne gereiht.

    Simulieren Sie diese Vorgehensweise in der Klasse District:
    Ein Objekt der Klasse erhält den Namen des Distrikts über einen Konstruktor. Es wird eine Uhr (eigentlich nur ein
    Minutenzähler) mitgeführt, die jede Minute (beginnend mit 0) weitergeschaltet wird.
    Folgende Methoden werden benötigt:

    - tick:   Diese parameterlose Methode schaltet die Uhr um eine Minute weiter.

    - arrive: Ein Fahrer (Name als String-Parameter übergeben) trifft in der Sammelstelle des Distrikts ein.
              Eine Ausgabe wird gemacht: "Um <Uhrzeit> ist <Name des Fahrers> in <Name des Distrikts> eingetroffen."

    - help:   Ein Fahrer (Name als String-Parameter übergeben) trifft in der Sammelstelle des Distrikts ein, weil er
              von einem anderen Distrikt hierher gewechselt hat um auszuhelfen. Es wird dieselbe Ausgabe gemacht wie
              bei arrive.

    - job:    Ein Auftrag ist eingetroffen. Der Distrikt des Ziels der Fahrt wird als Parameter übergeben. Wenn kein
              Fahrer verfügbar ist, wird als Ergebnis false zurückgegeben, andernfalls true. Eine Ausgabe wird
              gemacht, entweder: "Um <Uhrzeit> Auftrag ohne Fahrer in <Name des Distrikts>."
              oder: "Um <Uhrzeit> fährt <Name des Fahrers> von <Name des Distrikts> nach <Name des Distrikts>.".
              Dieselbe Methode wird verwendet, wenn ein Fahrer in einen anderen Distrikt wechseln soll.

    Verwenden Sie in District KEIN Array, sondern ein Objekt vom Typ Queue bzw. Deque.

    Schreiben Sie in District eine Methode main, die ein Gesamtszenario simuliert. Es sollen mehrere Distrikte erzeugt
    und mehrere Fahrer zwischen ihnen hin und her geschickt werden. Auch tick ist regelmäßig aufzurufen. In den
    entstehenden Bildschirmausgaben sollen alle wesentlichen unterschiedlichen Fälle sichtbar werden.

    Zusatzfragen:
    1. Was unterscheidet Queue von Deque?
    2. Was versteht man unter dem FIFO- bzw. LIFO-Prinzip?
    3. Welche dieser Methoden sind static, welche nicht? Warum ist das so?
*/
import java.util.Deque;
import java.util.LinkedList;

public class District {

    // TODO: All necessary object variables, constructors and methods shall be declared or defined here.
    static int tick=0;
    static Deque<District> all=new LinkedList<District>();

    private String DistriktName="";
    public Deque<String> Drivers=new LinkedList<String>();
    public Deque<String> Auftrag =new LinkedList<String>();

    public District(String distroName){
        this.DistriktName=distroName;
        //this.Drivers.offerLast("-1");
        this.all.offerLast(this);

    }
    public void arrive(String driverName){
        this.Drivers.offerLast(driverName);
        System.out.println("" + "Um " + tick + " ist " + driverName+ " in " + this.DistriktName + " eingetroffen.");
                tick();
    }
    public void help(){

        for (District iter : all) {

            //if(this.DistriktName!=iter.DistriktName){

                if(iter.Drivers.peekLast()!=null) {
                    this.Drivers.offerLast(iter.Drivers.pollFirst());
                     System.out.println("Um " + tick + " ist " + this.Drivers.peekLast() + " in " + this.DistriktName + " eingetroffen.");

                   // tick();
                    return;
                }

            //}
        }

    }
    public boolean job(String Auftrag,District dir){
        boolean res=false;

        dir.Auftrag.offerLast(Auftrag);
        String s=this.Drivers.peekLast();

        if(s!=null){
            dir.Drivers.addLast(this.Drivers.pollFirst());
            System.out.println("Um " + tick + " fährt " + dir.Drivers.getLast() + " von " + this.DistriktName + " nach " + dir.DistriktName + ".");
            dir.Auftrag.pollLast();
            res=true;
        }else{
            System.out.println("Um " + tick + " Auftrag ohne Fahrer in " + dir.DistriktName + ".");
            System.out.println("Calling HELP!");
            this.help();
             if(this.Drivers.peekLast()!=null){
                 System.out.println("No help Needed!");
             }
        }
        tick();
        return res;
    }


    public void tick(){
        tick+=1;
    }


    public static void main(String[] args) {
        District ds1=new District("ds1");
        District ds2=new District("ds2");
        ds1.arrive("Driver1");
        ds1.arrive("Driver2");
        ds1.arrive("Driver3");
        ds2.arrive("Driver4");
        ds2.arrive("Driver5");
        ds2.arrive("Driver6");
        ds1.job("Auftrag1", ds2);
        ds1.job("Auftrag2", ds2);
        ds1.job("Auftrag3", ds2);
        ds1.job("Auftrag4", ds2);

        ds2.job("Auftrag5", ds1);//FIFO wie Queue
        ds2.job("Auftrag6", ds1);
        ds2.job("Auftrag7", ds1);
    }

}
