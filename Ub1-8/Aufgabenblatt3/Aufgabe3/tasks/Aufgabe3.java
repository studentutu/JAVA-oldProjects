/*
    Aufgabe3) Verschachtelte Schleifen

    Erweitern Sie die Klasse 'Aufgabe3' um eine statische Methode namens "drawNumDiamond(int h)", die einen Diamanten
    (Raute) mit Zahlen ausgibt. Der übergebene Parameter "h" entspricht der Höhe des Diamanten (Raute). Ein h=9 führt
    zu folgender Ausgabe:

        1
       222
      33333
     4444444
    555555555
     4444444
      33333
       222
        1

    Testen Sie Ihre Methode mit weiteren Höhen für "h"! Der Rückgabetyp der Methode ist "void".

    Zusatzfragen:
    1. Wie ist die Vorgangsweise abzuändern, wenn statt jedem Wert 1 der Buchstabe A, statt jedem Wert 2 der
    Buchstabe B, ... und statt jedem Wert 5 der Buchstabe E ausgegeben werden soll ?
    (Die Methode soll dann nur für h <= 9 funktionieren.)

    2. An welchen Stellen ist das Programm zu ändern wenn Rauten der Form
        1
        2
       333
       444
      55555
       444
       333
        2
        1
    generiert werden sollen ?
*/
public class Aufgabe3 {

    public static void main(String[] args)
    {

        drawNumDiamond(9); // works properly only wenn digit is smaller or equel to 18

    }

    public static void drawNumDiamond(int h)
    {
        int mitte=(h%2)==0 ? h/2 :(h/2)+1;// h=9 then mitte =5
/**
        int[] digit=new int[mitte];// digits from 1 to mitte
        for(int i=0;i<digit.length;i++ )
        {
            digit[i]=i+1;
        }
 */
        char[] digit=new char[mitte];

        String[] diamond=new String[h];

        int increment=1;
        int spacesANZ=mitte+1;//space and one more)
        String space;

        //--------------------1.Aufgabe----------------------------
        char[] character={'A','B','C','D','E','F','G','H','I','G'};//length=10;
        for(int i=0;i<digit.length;i++ )
        {
            digit[i]=character[i];
        }

        //--------------------2.Aufgabe----------------------------
        int step=1;



        for(int i=0;i<mitte;i++){ // only half diamond!
            space="";
            for(int j=0;j<spacesANZ-increment;j++){
                space+=" ";
            }

            for(int j=0;j<increment;j++){
                space+=digit[i];
            }

            diamond[i]=space;

            //step
            if(step%2==0){increment+=2; spacesANZ++;}
            step++;
        }
        for(int i=0;i<mitte;i++){
            System.out.println(diamond[i]);
        }
        for (int i= (mitte%2 ==0)? mitte-1:mitte-2;i>=0;i--){
            System.out.println(diamond[i]);
        }

    }


}
