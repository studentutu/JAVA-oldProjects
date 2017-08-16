/***********************************************************************************
Hier ist ein Beispiel für eine Lösung (ohne Kommentare):

 private int tun, uinal, kin;

 public Capsule(int tun, int uinal, int kin) {
 this.tun = tun;
 this.uinal = uinal;
 this.kin = kin;
 }

 public void advance(Capsule period) {
 this.kin += period.kin;
 if (this.kin >= 20) {
 this.kin -= 20;
 this.uinal++;
 }
 this.uinal += period.uinal;
 if (this.uinal >= 18) {
 this.uinal -= 18;
 this.tun++;
 }
 this.tun += period.tun;
 if (this.tun >= 20) {
 this.tun -= 20;
 }
 }

 public String date() {
 return kin == 0 && uinal == 0 && tun == 0 ? "origin" : tun + " Tun, " + uinal + " Uinal, " + kin + " Kin";
 }

 public static void main(String[] args) {
 Capsule x = new Capsule(5, 12, 9);
 System.out.println(x.date());
 Capsule y = new Capsule(18, 3, 13);
 System.out.println(y.date());
 x.advance(y);
 System.out.println(x.date());
 x.advance(y);
 System.out.println(x.date());
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
        Objekte der Klasse Capsule stellen vereinfachte Datumsangaben im Maya-Kalender mit folgender Unterteilung dar:
          1 Tun   (etwa ein Jahr)      entspricht 18 Uinal,  Wertebereich: 0 bis 19
          1 Uinal (ein knappes Monat)  entspricht 20 Kin,    Wertebereich: 0 bis 17
          1 Kin   (ist ein Tag),                             Wertebereich: 0 bis 19
        Sobald der Wertebereich einer dieser Einheiten überschritten ist, verwendet man die nächstgrößere Einheit.
        Nach dem Datum 8 Tun, 3 Uinal, 19 Kin kommt daher das Datum 8 Tun, 4 Uinal, 0 Kin.
        Wird der Wertebereich von 19 Tun, 17 Uinal, 19 Kin überschritten, beginnt die Zählung wieder von vorne
        (danach kommt also wieder 0 Tun, 0 Uinal, 0 Kin).

        Ergänzen Sie fehlende Teile der Klasse entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 20):
        4 Punkte für die Deklaration und Initialisierung der nötigen Objektvariablen (einschließlich Konstruktor),
        8 Punkte für die Implementierung von advance,
        4 Punkte für die Implementierung von date,
        4 Punkte für die Implementierung von main.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */


    // Object variables are visible only within the class
    // TODO: Declaration and initialization of object variables is your task


    // Initialize calendar date using the values of tun, uinal and kin. All values are within the specified ranges.
    public Capsule(int tun, int uinal, int kin) {
        // TODO: Implementation is your task
    }


    // Advance the current calendar date (given by 'this') by the period given in the parameter, this is, add
    // 'period' to 'this'. Thereby limits must not be exceeded.
    // For example, if 'this' corresponds to 5 Tun, 12 Uinal, 9 Kin and 'period' corresponds to 18 Tun, 3 Uinal,
    // 13 Kin, then 'this' shall be changed such that it corresponds to 3 Tun, 16 Uinal, 2 Kin.
    public void advance(Capsule period) {
        // TODO: Implementation is your task

    }


    // Returns a string specifying the calendar date in the form "5 Tun, 12 Uinal, 9 Kin"
    // (with the numbers replaced by those corresponding to 'this').
    // However, the string "origin" shall be returned instead of the special date "0 Tun, 0 Uinal, 0 Kin".
    //DONE
    public String date() {
        return ""; // TODO: Implementation is your task
    }


    // An execution of main does the following (in the given ordering):
    //   - Create an object of type Capsule and print a line containing the result of applying date() to the object
    //     such that the printed line contains: 5 Tun, 12 Uinal, 9 Kin
    //   - Create another object of type Capsule and print a line containing the result of applying date() to it
    //     such that the printed line contains: 18 Tun, 3 Uinal, 13 Kin

    //   - Invoke advance in the object created first using the object created next as argument and
    //     print a line showing the result of applying date() to it.
    //   - Invoke advance again in the object created first using the object created next as argument and
    //     print a line showing the result of applying date() to it.
    public static void main(String[] args) {
        // TODO: Implementation is your task

    }

}


