/**********************************************************************************************************************

 AUFGABENBLATT 3 - Allgemeine Informationen

 Das Projekt Aufgabenblatt3 besteht aus fünf Aufgaben in den Klassen Aufgabe1 bis Aufgabe5, die Sie erweitern und in
 den Übungen vom 09.11. bis 13.11. präsentieren können müssen.

 Achten Sie bei der Implementierung von Aufgabe1-Aufgabe5 auf folgende Punkte:

 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Testen und kommentieren Sie Ihre Programme ausführlich.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich thematisch auf das erstellte Programm.
   Sie müssen diese Zusatzfragen in der Übung beantworten können.

 Abgabe: Die Abgabe erfolgt in TUWEL indem Sie bis Montag, den 09.11.2015 um 06:00 Ihre Kreuzerl des aktuellen
 Aufgabenblattes eintragen. Nur durch Ankreuzen können Sie auch Punkte bekommen. Allerdings müssen Sie
 angekreuzte Aufgaben auch vorzeigen können.

 ***********************************************************************************************************************/
/*
    Aufgabe1) Verschachtelte Schleifen

    Erweitern Sie die Klasse 'Aufgabe1' um eine statische Methode namens "drawChessBoard(int n)", die einen Parameter
    übergeben bekommt und den Rückgabewert "void" aufweist.
    Die Methode zeichnet ein Schachbrett mit 8x8 Feldern, welches (Schritt für Schritt) wie folgt auf der Konsole
    mit "System.out.println()" gezeichnet werden soll:

        |***|***|***|***|***|***|***|***|
        |   |   |   |   |   |   | T |   |
        |***|***|***|***|***|***|***|***|
        |   |   |   |   |   | T |   |   |
        |***|***|***|***|***|***|***|***|
        |   |   |   |   | T |   |   |   |
        |***|***|***|***|***|***|***|***|
        |   |   |   | T |   |   |   |   |
        |***|***|***|***|***|***|***|***|
        |   |   | T |   |   |   |   |   |
        |***|***|***|***|***|***|***|***|
        |   | T |   |   |   |   |   |   |
        |***|***|***|***|***|***|***|***|
        | T |   |   |   |   |   |   | T |
        |***|***|***|***|***|***|***|***|
        |   |   |   |   |   |   | T |   |
        |***|***|***|***|***|***|***|***|

    Der übergebene Parameter "n" beschreibt wie oft der Buchstabe T (für Turm) in ein Feld eingezeichnet wird.
    z.B. n = 7 würde heißen, dass in jedem siebten Feld ein T für Turm steht (siehe Bsp. oben). Die Zählung
    beginnt im oberen linken Feld.

    Zusatzfragen:
    1.  Wie würden Sie vorgehen, wenn alle schwarzen Felder des Bretts (z.B. das Feld links unten und das Feld rechts
    oben) auf denen kein Turm steht mit dem Symbol * gekennzeichnet werden sollen?

*/
public class Aufgabe1
{

    public static void main(String[] args)
    {
        drawChessBoard(3);

    }


    public static void drawChessBoard(int n)
    {

        int vertical=8;
        int horizont=8;


        int count=n%8;//first place for | T |
        int k=0;//um * auf richtige platz! modulo 2! nur auf jede 2.te *

        for(int i=0;i<vertical;i++)//1 Grosere zeile mit 2 subZeile
        {
            System.out.print("|");
            for(int m=0;m<horizont;m++){
                System.out.print("***|");
            }
            System.out.print("\n");

            System.out.print("|");
            for(int j=0;j<horizont; j++){

                 if(count==0 && j==7){System.out.print(" T |"); count=(count+n)%8;}else
                 if(count==(j+1)){System.out.print(" T |"); count=(count+n)%8;} else{

                    if(k%2==1) {System.out.print(" * |");}else{
                        System.out.print("   |");
                    }
                }
                k+=1;

            }
            k+=1;
            System.out.print("\n");

        }
        System.out.print("|");
        for(int m=0;m<horizont;m++){
            System.out.print("***|");
        }

    }

}
