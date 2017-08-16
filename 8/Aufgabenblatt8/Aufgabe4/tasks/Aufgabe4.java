/*
    Aufgabe4) Labyrinth-Löser

    Als Wiederholung zum Thema Datenstrukturen und rekurive Algorithmen implementieren Sie einen Labyrinth-Löser als
    konkrete Anwendung. Hier soll bei einem vorgegeben Labyrinth rekursiv nach dem Ausgang gesucht werden.
    Dazu wird ein Startpunkt an eine freie Stelle gelegt und mit "S" gekennzeichnet. Nun wird der Ausgang gesucht und
    jede bereits besuchte Stelle mit einem Punkt "." gekennzeichnet. Wird ein Ausgang gefunden, wird dieser mit "X" markiert.
    Wände des Labyrinths sind mit "*" gekennzeichnet und dürfen nicht als Weg benutzt werden. Wird kein Ausgang gefunden
    müssen alle Wege mit "." gekennzeichnet sein, da alle Wege probiert werden müssen um den Ausgang zu finden.

    Beispiel:
    Eingabe-Labyrinth       Ausgabe-Labyrinth mit Kennzeichnung Start (S) , Wege probiert (.) und Ausgang (X)
    "***************"       "***************"
    "*     *       *"       "*.....*.......*"
    "***** *    *  *"       "*****.*....*..*"
    "*   * ******* *"       "*...*.*******.*"
    "*             *"       "*.............*"
    "***********   *"       "***********...*"
    "*             *"       "*.............*"
    "* ***  ****   *"       "*.***  ****  .*"
    "    *     *   *"       "X...*     *  .*"
    "***** *****   *"       "***** *****  .*"
    "*        *    *"       "*        *  ..*"
    "* ********** **"       "* **********.**"
    "*        *    *"       "*  S.....*  ..*"
    "*    *        *"       "*    *  ......*"
    "***************"       "***************"

    Implementieren Sie dazu bitte eine Klasse "Maze", dem ein Labyrinth im Konstruktor übergeben wird und als Member Variable
    abspeichert wird.
    Die Klasse Maze beinhaltet folgende Methoden, die von Ihnen implementiert werden müssen:

    - checkForExit: Die Methode überprüft rekursiv ob ein Ausgang vorhanden ist und markiert die Stelle im Labyrinth
                    wenn es sich um den Startpunkt handelt mit "S", einen bereits überprüften Wegpunkt mit "." und einen
                    gefundenen Ausgang mit "X". Der Methode wird der Startpunkt als x und y Variable (integer) übergeben.
                    Zusätzlich wird der Methode noch eine Tiefe (depth als integer) übergeben, die die aktuelle Tiefe in der
                    Rekursion darstellt.
                    Sie können auch Hilfsmethoden in der Klasse Maze implementieren. Beispielsweise wäre eine Methode zur
                    Überprüfung der Art (Wand, Ausgang, etc.) eines gegebenen Feldes denkbar.
                    Die Methode "checkForExit" gibt genau dann true zurück wenn ein Ausgang gefunde wurde.
                    Eine Wand ("*") darf nicht als Startpunkt verwendet oder als gültiger Ausgang interpretiert werden.
                    Zusätzlich können Wände nicht überschritten oder als Wegppunkte markiert werden.
    - printMaze:    Diese Methode gibt das Labyrinth in der oben dargestellten Form aus.

    [fortgeschritten]
    Implementieren Sie eine iterative Version der checkForExit Methode. Hilfsmethoden aller Art sind erlaubt.
*/
class Maze {

    private String[] mMaze = {};

    public Maze(String[] myMaze) {
        /* TODO: add code here */
    }

    public boolean checkForExit(int x, int y, int depth){
        /* TODO: add code here */
        
        return false;
    }

    public void dumpMaze(){
        /* TODO: add code here */
    }
}

public class Aufgabe4 {

    // just for testing ...
    public static void main(String[] args) {
        int start_x = 3;
        int start_y = 13;

        String[] myMaze = new String[15];
        myMaze[0] =  "***************";
        myMaze[1] =  "*     *       *";
        myMaze[2] =  "***** *    *  *";
        myMaze[3] =  "*   * ******* *";
        myMaze[4] =  "*             *";
        myMaze[5] =  "***********   *";
        myMaze[6] =  "*             *";
        myMaze[7] =  "* ***  ****   *";
        myMaze[8] =  "    *     *   *";
        myMaze[9] =  "***** *****   *";
        myMaze[10] = "*        *    *";
        myMaze[11] = "* ********** **";
        myMaze[12] = "*        *    *";
        myMaze[13] = "*    *        *";
        myMaze[14] = "***************";

        Maze mySolver = new Maze(myMaze);

        if(mySolver.checkForExit(start_x, start_y, 0)){
            System.out.println("EXIT FOUND!");
        }
        else{
            System.out.println("NO EXIT FOUND!");
        }
        mySolver.dumpMaze();
    }
}
