/*
    Aufgabe5) dynamisches versus statisches Binden

    Implementieren Sie folgende Hierarchie:

         interface MeerestierIF
         /   |     \         \
    Koralle Fisch Saeugetier Schildkroete

    D.h. Koralle, Fisch, .. usw. implementieren alle das Interface MeerestierIF.

    Sie sollen eine Archivverwaltung eines Museums implementieren.

    Schreiben Sie dazu eine Implementierung des Interfaces ArchivIF (Name selbst
    wählen), in dem eine Liste von Meerestieren gespeichert wird. Sie dürfen die
    Methodensignaturen der Interfaces nicht verändern.

    Die Methoden sollen sich folgendermaßen verhalten:
	- void registrieren(MeerestierIF m);
	  Fuegt ein Meerestier im Archiv auf Regal 0 hinzu.

	- void ausraeumen();
	  Raeumt alle Tiere bis auf Saeugetiere aus
	  (= ins Regal 0 geben)

	- void einordnen();
	  Ordnet alle Tiere der Reihe nach in Regalnummern,
	  allerdings sind Saeugetiere in den Regalen ab 100
	  und Fische ab den Regalen 200
	  (einfach 100 respektive 200 zu dem Index hinzugeben)

    - void neuWiegen(int gewicht[]);
	  Wiegt alle Tiere neu.
	  Allerdings gibt es einen systematischen Fehler
	  bei Schildkröten. Diese wiegen tatsächlich um 10%
	  weniger als die Waage angzeigt hat (der Wert im Array).
	  Sauegetiere werden immer in Tonnen gewogen.
	  Korallen haben immer ein Kilogramm, unabhängig vom
	  Wert im Array.

    Achtung! Es darf kein if, instanceof, getClass() o.ä. verwendet werden um
    die beschriebenen Unterschiede auszuprogrammieren. Stattdessen soll
    ausschließlich dynamisches Binden verwendet werden!

    Eigenschaften der Tiere sollen in den Klassen Koralle, Fisch, Saeugetier und
    Schildkroete gespeichert werden. Bei Korallen soll es keine Eigenschaft
    Gewicht geben.

    Es soll möglich sein, das ganze Archiv mit System.out.println(archiv)
    auszugeben. Dabei soll jedes Tier in einer Zeile geschrieben werden. Wenn
    das Archiv leer ist, soll toString() "Leeres Archiv" ausgeben.

    Initial (in createArchiv()) sollen die Tiere so angelegt werden, dass
    folgende Ausgabe entsteht (einfach Tiere explizit so erzeugen, dass diese
    Zahlen gespeichert sind und ausgegeben werden):
    Hering, Regal 250, Gewicht 20kg
    Walhai, Regal 280, Gewicht 2050kg
    Kaiserfisch, Regal 1220, Gewicht 20kg
    Meeresschildkroete, Regal 33, Gewichtsklasse 20kg
    Wal, SpezialRegal (Saeugetier) 20004, Gewicht 20000kg
    Lederkoralle, Regal 40, Gewicht 1000g
    Feuerkoralle, Regal 41, Gewicht 1000g

    Wird nach der Initialisierung ausraeumen() durchgeführt, soll danach
    folgendes ausgegeben werden:
    Hering, Regal 0, Gewicht 20kg
    Walhai, Regal 0, Gewicht 2050kg
    Kaiserfisch, Regal 0, Gewicht 20kg
    Meeresschildkroete, Regal 0, Gewichtsklasse 20kg
    Wal, SpezialRegal (Saeugetier) 20004, Gewicht 20000kg
    Lederkoralle, Regal 0, Gewicht 1000g
    Feuerkoralle, Regal 0, Gewicht 1000g

    Nach einer weiteren Durchführung von einordnen():
    Hering, Regal 201, Gewicht 20kg
    Walhai, Regal 202, Gewicht 2050kg
    Kaiserfisch, Regal 203, Gewicht 20kg
    Meeresschildkroete, Regal 4, Gewichtsklasse 20kg
    Wal, SpezialRegal (Saeugetier) 105, Gewicht 20000kg
    Lederkoralle, Regal 6, Gewicht 1000g
    Feuerkoralle, Regal 7, Gewicht 1000g

    Und wenn danach alle Tiere neu gewogen werden {23,2100, 40, 23, 30, 3, 0}:
    Hering, Regal 201, Gewicht 23kg
    Walhai, Regal 202, Gewicht 2100kg
    Kaiserfisch, Regal 203, Gewicht 40kg
    Meeresschildkroete, Regal 4, Gewichtsklasse 20kg
    Wal, SpezialRegal (Saeugetier) 105, Gewicht 30000kg
    Lederkoralle, Regal 6, Gewicht 1000g
    Feuerkoralle, Regal 7, Gewicht 1000g

    Zusatzfragen:
    1. Wie könnte man die Programmieraufgabe mit statischem Binden lösen?
    2. Verwendet ein Interface dynamisches Binden?
*/

import java.util.LinkedList;
public class Aufgabe5 {
    public static LinkedList<MeerestierIF> lts=new LinkedList<>();

    static ArchivIF createArchiv() {
        // TODO: Return Archive that has animals stored as given above

        ArchivIF n=new Archiv();

        for(MeerestierIF m: lts){//this.lts but it Field lts is static so then just lts

            n.registrieren(m);
        }




        return n;
    }

    // just for testing ...
    public static void main(String[] args) {


        lts.add(new Koralle("Lederkoralle",40));
        lts.add(new Koralle("Feuerkoralle",41));
        lts.add(new Fisch("Hering",250,20));
        lts.add( new Fisch("Walhai",280,2050));
        lts.add( new Fisch("Kaiserfisch",1220,20));
        lts.add(new Schildkroete("Meeresschildkroete", 33, 20) );
        lts.add(new Saeugetier("Wal", 20004, 20000));

        ArchivIF firstArch=createArchiv();
        System.out.println(firstArch.toString());
        firstArch.ausraeumen();
        System.out.println(firstArch);
        firstArch.einordnen();
        System.out.println(firstArch);

        int[] neuGewicht=new int[lts.toArray().length];//
        // there is method in LinkedList.toArray() so it will return new Array[typ MeeresTireIf] and it has length
        int i=0;
        for(MeerestierIF m:lts){

            neuGewicht[i++]=m.getGew()+ (int)(m.getGew()*0.1);
        }//will generate new mass(+10%) for each element of Lts


        firstArch.neuWiegen(neuGewicht);
        System.out.println(firstArch);

    }
}

class Archiv implements  ArchivIF{
    private LinkedList<MeerestierIF> willreferedbythis=new LinkedList<>();


    public void registrieren(MeerestierIF m){

        willreferedbythis.add(m);
    }


    public  void ausraeumen(){

        for(MeerestierIF m:this.willreferedbythis){
            if(!m.getRefetTo().equals("Saeugetier")){m.ausraeumen();}
        }

    }

    public String toString(){

        String s="";
        if(this.willreferedbythis.isEmpty()){return "Leeren Archiv";}//"Leeren Archiv"

        for (MeerestierIF m:this.willreferedbythis){
            if(!m.getRefetTo().equals("Koralle")){s=s+m.toString();}
        }
        for (MeerestierIF m:this.willreferedbythis){
            if(m.getRefetTo().equals("Koralle"))
            {s=s+m.toString();}
        }
        return s;
    }



   public  void einordnen(){
       int fishRegal=200;
       int shieldRagal=4;
       int seageRegal=100;
       int koralRegal=0;

       for(MeerestierIF m :this.willreferedbythis) {
           if (m.getRefetTo().equals("Schildkroete")) {
               m.einordnen(shieldRagal++);
               koralRegal = shieldRagal + 1;
           }
       }
       for(MeerestierIF m:this.willreferedbythis){

           if( m.getRefetTo().equals("Fisch") ){m.einordnen(fishRegal++);}
       }
       for(MeerestierIF m :this.willreferedbythis){
           if( m.getRefetTo().equals("Saeugetier") ){m.einordnen(seageRegal++);}

       }

       for(MeerestierIF m :this.willreferedbythis) {
           if (m.getRefetTo().equals("Koralle")) {
               m.einordnen(koralRegal++);
           }
       }
   }

   public  void neuWiegen(int gewicht[]){
       int i=0;
       for(MeerestierIF m:this.willreferedbythis){
           m.abwiegen(gewicht[i++]);
       }
   }
}

class Koralle implements MeerestierIF{
    private  String referTo="Koralle";
    private  String NameTier;
    private  int  Regal;
    private static int  Gewicht=1000;
    Koralle(String name,int regal){
        this.NameTier=name;
        this.Regal=regal;

    }
    @Override
    public String getRefetTo(){
        return this.referTo;
    }
    @Override
    public String toString(){
        return this.NameTier + ", "+ this.Regal + ", "+ this.Gewicht+ "g."+"\n";
    }
    @Override
    public void einordnen(int regal){
        this.Regal=regal;
    }
    @Override
    public void ausraeumen(){
        this.Regal=0;
    }
    @Override
    public void abwiegen(int gewicht){
        this.Gewicht=1000;
    }
    @Override
    public int getGew(){
        return this.Gewicht;
    }

}
class Fisch implements MeerestierIF{
    public static String referTo="Fisch";
    private  String NameTier;
    private  int  Regal;
    private  int  Gewicht;

    Fisch(String name ,int regal, int gewicht ){

        this.NameTier=name;
        this.Regal=regal;
        this.Gewicht=gewicht;
    }
    @Override
    public String getRefetTo(){
        return this.referTo;
    }
    @Override
    public String toString(){
        return this.NameTier + ", "+ this.Regal + ", "+ this.Gewicht+ "kg."+"\n";
    }
    @Override
    public void einordnen(int regal){this.Regal=regal;};
    @Override
    public void ausraeumen(){
        this.Regal=0;
    }
    @Override
    public void abwiegen(int gewicht){
        this.Gewicht=gewicht;
    }
    @Override
    public int getGew(){
        return this.Gewicht;
    }

}
class Saeugetier implements MeerestierIF{
    public static String referTo="Saeugetier";
    private  String NameTier;
    private  int  Regal;
    private  int  Gewicht;

    Saeugetier(String name ,int regal, int gewicht ){

        this.NameTier=name;
        this.Regal=regal;
        this.Gewicht=gewicht;
    }
    @Override
    public String getRefetTo(){
        return this.referTo;
    }
    @Override
    public String toString(){
        return this.NameTier + ", (Saeugetier)"+ this.Regal + ", "+ this.Gewicht+ "kg."+"\n";
    }
    @Override
    public void einordnen(int regal){this.Regal=regal;}
    @Override
    public void ausraeumen(){
        this.Regal=0;
    }
    @Override
    public void abwiegen(int gewicht){this.Gewicht=gewicht;}
    @Override
    public int getGew(){
        return this.Gewicht;
    }

}
class Schildkroete implements MeerestierIF{
    public static String referTo="Schildkroete";
    private  String NameTier;
    private  int  Regal;
    private  int  Gewicht;

    Schildkroete(String name ,int regal, int gewicht ){

        this.NameTier=name;
        this.Regal=regal;
        this.Gewicht=gewicht;
    }
    @Override
    public String getRefetTo(){
        return this.referTo;
    }
    @Override
    public String toString(){
        return this.NameTier + ", "+ this.Regal + ", "+ this.Gewicht+ "kg."+"\n";
    }
    @Override
    public void einordnen(int regal){this.Regal=regal;}
    @Override
    public void ausraeumen(){this.Regal=0;}
    @Override
    public void abwiegen(int gewicht){this.Gewicht=gewicht;}
    @Override
    public int getGew(){
        return this.Gewicht;
    }

}
