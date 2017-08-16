import java.lang.String;

public class Aufgabe4 {

    /*
        Aufgabe4) Anwendung: Labyrinth-Löser (Backtracking)
    
        Als Wiederholung zum Thema Datenstrukturen und rekursive Algorithmen
        implementieren Sie einen Labyrinth-Löser als konkrete Anwendung. Hier soll
        bei einem vorgegebenen Labyrinth mittels Backtracking nach dem Ausgang
        gesucht werden. Dazu wird ein Startpunkt an eine freie Stelle gelegt und mit
        "S" gekennzeichnet. Nun wird der Ausgang gesucht und jede bereits besuchte
        Stelle mit einem Punkt "." gekennzeichnet. Wird ein Ausgang gefunden,
        wird dieser mit "E" markiert. Wände des Labyrinths sind mit "*"
        gekennzeichnet und dürfen nicht als Weg benutzt werden. Wird kein Ausgang
        gefunden müssen alle Wege mit "." gekennzeichnet sein, da alle Wege probiert
        werden müssen um den Ausgang zu finden.
    
        Beispiel:
        Eingabe-Labyrinth       Ausgabe-Labyrinth
        "***************"       "***************"   Kennzeichnung:
        "*     *       *"       "*.....*.......*"    S  ... Start
        "***** *    *  *"       "*****.*....*..*"   (.) ... Wege probiert
        "*   * ******* *"       "*...*.*******.*"    E  ... Ausgang
        "*             *"       "*.............*"    *  ... Wand
        "***********   *"       "***********...*"
        "*             *"       "*.............*"
        "* ***  ****   *"       "*.***  ****  .*"
        "    *     *   *"       "E...*     *  .*"
        "***** *****   *"       "***** *****  .*"
        "*        *    *"       "*        *  ..*"
        "* ********** **"       "* **********.**"
        "*        *    *"       "*  S.....*  ..*"
        "*    *        *"       "*    *  ......*"
        "***************"       "***************"
    
        Implementieren Sie dazu bitte eine Klasse "Maze", dem ein Labyrinth im
        Konstruktor übergeben wird und als Objekt Variable abspeichert wird.
        Die Klasse Maze beinhaltet folgende Methoden, die von Ihnen implementiert
        werden müssen:
    
        - checkForExit: Die Methode überprüft rekursiv ob ein Ausgang vorhanden ist
                        und markiert die Stelle im Labyrinth wenn es sich um den
                        Startpunkt handelt mit "S", einen bereits überprüften
                        Wegpunkt mit "." und einen gefundenen Ausgang mit "E". Der
                        Methode wird der Startpunkt als x und y Variable (integer)
                        übergeben. Zusätzlich wird der Methode noch eine Tiefe
                        (depth als integer) übergeben, die die aktuelle Tiefe in der
                        Rekursion darstellt. Sie können auch Hilfsmethoden in der
                        Klasse Maze implementieren. Beispielsweise wäre eine Methode
                        zur Überprüfung der Art eines gegebenen Feldes
                        (Wand, Ausgang, etc.) denkbar. Die Methode "checkForExit"
                        gibt genau dann true zurück wenn ein Ausgang gefunden wurde.
                        Eine Wand ("*") darf nicht als Startpunkt oder gültiger
                        Ausgang interpretiert werden. Zusätzlich können
                        Wände nicht überschritten oder als Wegppunkte markiert
                        werden.
        - printMaze:    Diese Methode gibt das Labyrinth in der oben dargestellten
                        Form aus.
    
    */
    class Maze {

        static boolean finish=false;
        static String[][] HauptMaze;
        static int x;
        static int y;
        static int endDepth;

        private String[] mMaze;

        public Maze(String[] myMaze) {// need to use this.mMaze becouse it is not static, bound to object!
        // this. <-- defines only that particular mMaze
			/* TODO: add code here */
            HauptMaze=new String[myMaze.length][myMaze[0].length()];

            for(int i=0;i<HauptMaze.length;i++){
                //HauptMaze[0][j]
                for(int j=0;j<HauptMaze[i].length;j++){
                    HauptMaze[i][j]=myMaze[i].charAt(j);
                }

            }
        }

        static private void GoInMaze(m,n,depth){


            if (m == 0) {//end

                finish = true;
                endDepth=depth;
                return;
            }

            if (finish == false) {

                 if((m>=0)&&(n>=0)) {

                     if (m < HauptMaze.length) {

                         if (n < HauptMaze[0].length()) {


                            if (HauptMaze[m,n].equals(" ")){

                                HauptMaze[m,n]==".";// . will always stays, not deleted!

                                 GoInMaze(m,n + 1,depth+1);
                                 if(finish){return;}


                                GoInMaze(m,n - 1,depth+1);
                                 if(finish){return;}

                                GoInMaze(m + 1, n,depth+1);
                                 if(finish){return;}

                                GoInMaze(m - 1, n,depth+1);
                                 if(finish){return;}


                            }
                        }
                    }
                }
            }


        }



        public boolean checkForExit(int x, int y, int depth) {
            /* TODO: add code here */
            this.x=x;
            this.y=y;
            GoInMaze(x,y,0);
            return finish;
        }

        public void printMaze() {
            /* TODO: add code here */
            for(int i=0;i<HauptMaze.length;i++){

                for(int j=0;j<HauptMaze[i].length;j++){

                    System.out.print(HauptMaze[i][j]);
                }

                System.out.println();
            }
        }
    }

    // just for testing ...
    public static void main(String[] args) {
        int start_x = 3;
        int start_y = 13;

        String[] myMaze = new String[15];
        myMaze[0] = "***************";
        myMaze[1] = "*     *       *";
        myMaze[2] = "***** *    *  *";
        myMaze[3] = "*   * ******* *";
        myMaze[4] = "*             *";
        myMaze[5] = "***********   *";
        myMaze[6] = "*             *";
        myMaze[7] = "* ***  ****   *";
        myMaze[8] = "    *     *   *";
        myMaze[9] = "***** *****   *";
        myMaze[10] = "*        *    *";
        myMaze[11] = "* ********** **";
        myMaze[12] = "*        *    *";
        myMaze[13] = "*    *        *";
        myMaze[14] = "***************";

        Maze mySolver = new Maze(myMaze);

        if (mySolver.checkForExit(start_x, start_y, 0)) {
            System.out.println("EXIT FOUND!");
        } else {
            System.out.println("NO EXIT FOUND!");
        }
        mySolver.printMaze();
    }
}
