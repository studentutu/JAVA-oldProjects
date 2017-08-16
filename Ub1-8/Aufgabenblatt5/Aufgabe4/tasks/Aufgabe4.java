/*
    Aufgabe4) Zweidimensionales Array

    Implementieren Sie folgende statische Methoden:

      - 'fillArray' hat ein zweidimensionales int-Array als Parameter und gibt die Gesamtzahl aller Einträge im Array
        zurück. Außerdem werden alle Einträge im Array mit fortlaufenden Zahlen (beginnend mit 0) befüllt. Für jeden
        Index in der ersten Dimension können die Array-Längen in der zweiten Dimension unterschiedlich sein.

      - 'printArray' gibt das als Argument übergebene zweidimensionale int-Array aus und liefert die Anzahl der Zeilen
        (= Länge des Arrays in der ersten Dimension) zurück. Nach jeder ausgegebenen Zahl steht ein Beistrich.
        Beispiel für ein durch 'fillArray' befülltes Array:

            0,1,2,3,
            4,5,6,
            7,8,
            9,

        Wie 'fillArray' muss auch 'printArray' mit allen dem Typ entsprechenden Arrays umgehen können, unabhängig von
        Größe und Form (Anzahl der Elemente pro Zeile).

      - 'transpose' hat als Parameter ein dreiecksförmiges zweidimensionales int-Array und vertauscht Werte im Array,
        sodass danach in einer durch 'printArray' erzeugten Ausgabe Zeilen und Spalten vertauscht sind. Nach Anwendung
        von 'transpose' auf das Array in obigem Beispiel gibt 'printArray' folgendes aus:

            0,4,7,9,
            1,5,8,
            2,6,
            3,

    In den Implementierungen dieser drei Methoden darf kein neues Array erzeugt werden.

    Zusatzfragen:
    1. Woran erkennt man an einem Variablenzugriff, ob auf das gesamte Array, einen Teil des Arrays oder einen einzelnen
       Wert im Array zugegriffen wird?
    2. In keiner der zu implementierenden Methoden darf ein Array erzeugt werden. Woher kommen die benötigten Arrays?
    3. Wie kann man Arrays mit mehreren Dimensionen (zwei, drei oder mehr) erzeugen? Geben Sie Beispiele dafür.
*/
public class Aufgabe4 {

    private static int fillArray(int[][] array) {
         // Implementation is your task.
        for(int i=0;i<array.length;i++){

            for(int j=1;j<array[i].length;j++){
                array[i][0]+=array[i][j];
            }
            System.out.println(array[i][0]);

        }
        return -1;
    }

    private static int printArray(int[][] array) {
        // Implementation is your task.

        for(int i=0;i<array.length;i++){

            for(int j=0;j<array[i].length;j++){

                System.out.print(array[i][j]+",");
            }
            System.out.println();
        }

        return array.length;
    }

    private static void transpose(int[][] array) {
        // Implementation is your task.
        int a=0;
        for (int i = 0; i < array.length / 2; i++)
            for (int j = 1; j < array[i].length; j++) {
                 a = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = a;
            }
        printArray(array);
    }

    // Just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.
        int[][] mainArray={{0,1,2,3},{4,5,6},{7,8},{9}};
        System.out.println("---------Print------");
        printArray(mainArray);
        System.out.println("---------transpose------");
        transpose(mainArray);
        int[][] mainArray2 ={{0,1,2,3},{4,5,6},{7,8},{9}};
        System.out.println("---------Fill------");
        fillArray(mainArray2);
        //System.out.println("---------Dimension3------");
       // int[][][] mainArrayd3 ={
            //                     {{0,0},{1,1},{2,2},{3,3}},
          //                       {{4,0},{5,1},{6,2}},
         //                        {{7,0},{8,1}},
         //                        {{9,0}}
         //                       };
       // String space="";
        /**
        int k=1;
        for(int id1=0;  id1<mainArrayd3.length;  id1++){

            for(int jd2=0;  jd2<mainArrayd3[id1].length;  jd2++){
                k=mainArrayd3[id1].length;
                for(int sp=1;sp<k;sp++)
                {System.out.print(space);
                    space+=" ";}
                space="";

                for(int kd3=0; kd3<mainArrayd3[id1][jd2].length;  kd3++){

                    for(int sp=1;sp<k;sp++)
                    {System.out.print(space);
                        space+=" ";}
                    space="";

                    System.out.print(mainArrayd3[id1][jd2][kd3]);
                    //System.out.println();

                }

               // System.out.println("");

            }
            System.out.println(space);

            //System.out.println("");
        }
         **/

    }
}
