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
public class Aufgabe2 {
  
    public static String out = "";
    
    public static String times(int x, String s) {
        String nu = "";
        for (; x > 0; x--)
            nu += s;
        return nu;
            
    }
    
    public static void ups(int a, int i, int counter, int real_a) {
        System.out.println(times(a, " ") + times(counter, "" + i));
        if (i > 0)
            ups(a+1, i-1, counter-2, real_a);
    }
    
    public static void rec(int a, int i, int counter, int real_a) {
        System.out.println(times(a, " ") + times(counter, "" + i));
        if (a > 1)
            rec(a-1, i+1, counter+2, real_a);
        else if (a == 1 && real_a % 2 != 0)
             System.out.println(times(a-1, " ") + times(counter+2, "" + (i+1)));
        
    }
    
    public static void diamond(int h) {
        //out = "";
        rec(h/2, 1, 1, h);
        int x = h % 2 == 0 ? h/2 : h/2;
        int a = h % 2 == 0 ? h-1 : h - 2;
        ups(1, x, a, h);
    }

    // just for testing ...
    public static void main(String[] args) {
        diamond(5);
    //    System.out.println(out);
        diamond(10);
      //  System.out.println(out);
    }
}
