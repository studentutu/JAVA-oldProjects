/*
    Aufgabe4) toString, equals, hashCode implementieren

    Implementieren Sie die Klasse Person mit folgenden Eigenschaften:

    - Vorname
    - Nachname
    - Geschlecht
    - Alter (als Zahl)
    - Sozialversicherungsnummer (als vierstellige Zahl)
    - Liste aller Kinder dieser Person (Es kann beliebig viele Kinder,
      aber auch gar kein Kind geben.)

    Abgesehen von der Liste der Kinder sollen alle Eigenschaften im
    Konstruktor festgelegt werden.

    Vermeiden Sie unnötige "setter"-Methoden!

    Um ein Kind hinzufügen zu können, implementieren Sie die Methode:

      void neuesKind(Person p);

    Stellen Sie sicher, dass die Ausgabe eines Objekts vom Typ Person
    mittels System.out.println(person) folgende Beschreibung dieser Person
    liefert (Implementierung von toString()):

    # <Vorname> <Nachname>, <Geschlecht>, <Alter> Jahre, Svnr: <SV-Nummer>

    Hat eine Person Kinder, so werden auch rekursiv alle Kinder dieser
    Person (sowie auch alle darunterliegenden Hierarchieebenen) bei der
    Ausgabe berücksichtigt. Jede Ebene wird mit einem Leerzeichen
    eingerückt, z.B:

    # <Vorname> <Nachname>, <Geschlecht>, <Alter> Jahre, Svnr: <SV-Nummer>
     # <Vorname Kind1> <Nachname Kind1>, <Geschlecht Kind1>, <Alter Kind1> Jahre, Svnr: <SV-Nummer Kind1>
     # <Vorname Kind2> <Nachname Kind2>, <Geschlecht Kind2>, <Alter Kind2> Jahre, Svnr: <SV-Nummer Kind2>
      # <Vorname Kind1 von Kind2> <Nachname Kind1 von Kind2>, <Geschlecht Kind1 von Kind2>, <Alter Kind1 von Kind2> Jahre, Svnr: <SV-Nummer Kind1 von Kind2>

    Implementieren Sie createHubert() so, dass die zurückgelieferte Person
    folgende Ausgabe hat:

    # Hubert Maier, maennlich, 88 Jahre, Svnr: 1234
     # Julia Maier, weiblich, 54 Jahre, Svnr: 1111
      # Thomas Maier, maennlich, 22 Jahre, Svnr: 2222
      # Gernot Maier, maennlich, 24 Jahre, Svnr: 3333
     # Gernot Mueller, maennlich, 40 Jahre, Svnr: 1115
      # Roman Mueller, maennlich, 12 Jahre, Svnr: 1116
      # Sophie Mueller, weiblich, 14 Jahre, Svnr: 1117

    createJulia() soll innerhalb von createHubert() verwendet werden
    und createThomas() innerhalb von createJulia(). Es dürfen weitere
    Hilfsmethoden verwendet werden.

    Innerhalb der Liste der Kinder einer Person, darf es keine zwei
    gleichen Objekte vom Typ Person geben. Zwei Personen sind gleich, wenn
    ihr Vor- und Nachname, sowie ihre Sozialversicherungsnummer gleich ist.

    Achten Sie auch darauf, dass hashCode() und equals() korrekt funktionieren
    und alle Modifier korrekt sind.

    Kommentieren Sie Ihr Programm ausreichend!

    Zusatzfragen:
    1. Wie verhält sich das Programm wenn es keine eigene Implementierung
       von equals gibt?
    2. Warum sollte man zur textuellen Beschreibung einer Klasse toString
       verwenden und keine Methode mit einem anderen Namen implementieren?
    3. Warum wird hashCode benötigt und wie kann der Rückgabewert dieser
       Methode interpretiert werden?
    4. Warum eignet sich hashCode() nicht für Vergleiche von Objekten?
    5. Inwiefern können Namen und Kommentare altern?
*/

import java.util.LinkedList;

public class Aufgabe4 {
      public static class Person{
            //Object - Person - fields
          private String Vorname;
          private String Nachname;
          private String Geschlecht;
          private int Alter;
          private int Sozialversicherungsnummer;
          private LinkedList<Person> Kind=new LinkedList<>();//linkedlist easy to use(iterative)

          Person(String vorname, String nachname, String geschlecht, int alter,int sozialversicherungsnummer){
                //constructor with parameters
              this.Alter=alter;
              this.Geschlecht=geschlecht;

              //this.Kind.addAll(kind);

              this.Vorname=vorname;
              this.Nachname=nachname;
              this.Sozialversicherungsnummer=sozialversicherungsnummer;

          }
          public void neuesKind(Person kind){
              //add new kind
              if(this.Kind==null) {

                  this.Kind.add(kind);
                    return;
              }

                  for (Person p : this.Kind) {

                      if (p.Vorname.equals(kind.Vorname) && p.Nachname.equals(kind.Nachname) && p.Sozialversicherungsnummer == kind.Sozialversicherungsnummer) {
                          return;
                      }

                  }
                  this.Kind.add(kind);


          }

          @Override
          public String toString(){
              //original Person.toString()
              String s="";
              s=s+"#"+" "+this.Vorname + ", "+ this.Nachname + ", " + this.Geschlecht + ", "+this.Alter+ "Jahre, SVNR: " + this.Sozialversicherungsnummer;

                      if(this.Kind!=null) {
                          for (Person p : this.Kind) {

                              s=s+"\n"+ p.toString(1,1);//ebene 1  and space==ebene
                          }
                      }

              return s;
          }

          public String toString(int space,int ebene){
              //override toString to make spaces possible
              String s="";
              if(space>0){
                  s=s+" " + toString(space-1,ebene);
              } else {

                  s = s + "#" + " " + this.Vorname + ", " + this.Nachname + ", " + this.Geschlecht + ", " + this.Alter + "Jahre, SVNR:" + this.Sozialversicherungsnummer  ;

                  if (this.Kind != null) {
                      for (Person p : this.Kind) {
                          s = s + "\n" + p.toString(ebene + 1, ebene + 1);
                      }

                  }
              }
              return s;
          }


    }
    public static Person createHubert() {
        /* TODO: add code here */


        Person Hubert= new Person ("Hubert","Maier","maennlich",88, 1234);
        Person Julia=createJulia();

        Person Gernot=new Person("Gernot", "Maier", "maennlich", 24 ,  3333);
        Person Gernot_Mueller=new Person("Gernot", "Mueller", "maennlich", 40 ,  1115);
        Person Roman=new Person("Roman", "Mueller", "maennlich", 12 ,  1116);
        Person Sophie=new Person("Sophie", "Mueller", "weiblich", 14 ,  1117);
        //--------------Kind-------
        Hubert.neuesKind(Julia);
        Hubert.neuesKind(Gernot_Mueller);


        Julia.neuesKind(Gernot);

        Gernot_Mueller.neuesKind(Roman);
        Gernot_Mueller.neuesKind(Sophie);




        return Hubert;
    }

    public static Person createJulia() {
        /* TODO: add code here */
        Person Julia=new Person("Julia", "Maier", "weiblich", 54 ,  1111);
        Person Thomas=createThomas();
        Julia.neuesKind(Thomas);
        return Julia;
    }

    public static Person createThomas() {
        /* TODO: add code here */
        Person Thomas=new Person("Thomas", "Maier", "maennlich", 22 ,  2222);
        return Thomas;
    }

    // just for testing ...
    public static void main(String[] args) {

        Person makeperson=createHubert();
        System.out.println(makeperson);

    }
}
