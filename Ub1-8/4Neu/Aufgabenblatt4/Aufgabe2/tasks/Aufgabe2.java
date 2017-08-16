/*
    Aufgabe2) Rekursion

    Implementieren Sie das Diamanten-Beispiel aus Aufgabenblatt3 nun rekursiv. Die Methode "drawNumDiamond(int h)"
    soll den Diamanten (Raute) generieren und dabei Rekursion anwenden. Sie können zusätzliche Methoden anlegen.
    Der übergebene Parameter "h" entspricht der Höhe des Diamanten (Raute). Ein h=9 führt zu folgender Ausgabe:

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
    1. Welche Unterschiede konnten Sie zwischen der rekursiven und iterativen Implementierung feststellen?
*/
public class Aufgabe2
{

    // just for testing ...
    public static void main(String[] args)
    {

        drawNumDiamond(9);
        drawNumDiamond(10);
        drawNumDiamond(11);

    }


    public static void drawNumDiamond(int h)
    {

        int mitte= (h%2)==0?h/2 :(h/2)+1;
        System.out.println(body(mitte, 1, 1,1));

    }

    public static String space(int m)
    {
    if(m<=0){return "  ";}
        return " "+space(m-1);
    }

    public static String zahl(int n,int counter)
    {
        if(counter>0){return n+zahl(n,counter-1);}
        else  return "";
    }


    public static String body(int mitte,int n,int counter,int up)
    {
        if(n==0&&up==0){
            return "";
        }
        if(n==mitte && up==1){
            return space(mitte-n)+zahl(n,counter) + "\n" + body(mitte,n-1,counter-2,0);
        }
       if(up==1){
           return space(mitte - n) + zahl(n, counter) + "\n" + body(mitte,n+1,counter+2,1);
       }
        return space(mitte-n)+zahl(n,counter) + "\n" + body(mitte,n-1,counter-2,0);
    }

   // public static String down(int mitte){
    //    if(){return }
    //}


}
