/*
    Aufgabe4) Rekursion und Termination

    Die Methoden f, g, h, p und q sind vorgegeben. Rufen Sie in main jede dieser Methoden mit allen Argumenten im
    Bereich von -10 bis 10 (in aufsteigender Reihenfolge) auf und geben sie die Ergebnisse aus, wenn die Aufrufe mit
    Argumenten terminieren. Aufrufe, die nicht terminieren, sind auszulassen. Vermeiden Sie Exceptions.

    Hinweis: Für diese Aufgabe ist es besonders wichtig, die Zusatzfragen beantworten zu können.

    Zusatzfragen:
    1. Nennen Sie für jeden nicht terminierenden Aufruf von f, g, h, p und q im Intervall einen Grund für die
       Endlosrekursion (im Hinblick auf Fundiertheit und Fortschritt).
    2. Beschreiben Sie überblicksartig, was die Methoden f, g, h, p und q berechnen.
    3. Bedeutet ein StackOverflowError immer, dass eine Endlosrekursion vorhanden ist?
    4. [optional] Ist die Aufgabe überhaupt lösbar (wegen der Unentscheidbarkeit des Halteproblems der Turing-Maschine)?
*/
public class Aufgabe4 {

    private static int f(int x) {
        return x * x > 10 ? 0 : f(x - 1) + 1;
    }

    private static int g(int x) {
        return x < 0 ? 0 : g(x / 2) + 1;
    }

    private static int h(int x) {
        return x > 10 ? 0 : h(x * x) + 1;
    }

    private static int p(int x) {
        return x == 0 ? 0 : x % 2 == 1 ? p(x / 2) + 2 : p(- x - 1) + 1;
    }

    private static int q(int x) {
        return x % 3 == 0 ? 0 : q(x + x % 3 + 1) + 1;
    }

    // to be implemented by you
    public static void main(String[] args) {
        //for(int i=0;i<=10;i++){
        for(int i=-10;i<=10;i++) {
            System.out.print(f(i));//Berechnet um Wie viel Gross soll Zahl sein um Recursion zu Terminieren(- for <0,+ for 0>)
            System.out.print(" ");
        }
        System.out.println();
        for(int i=-10;i<=10;i++) {
            if(i<0) System.out.print(g(i));//only for nagtive numbers and not 0
            System.out.print(" ");
        }
        System.out.println();
        for(int i=-10;i<=10;i++) {
            if((i==1) || ( i==-1 || i==0)){continue;}
                System.out.print(h(i)); //0,1,-1 nicht zulassig;
            System.out.print(" ");
        }
        System.out.println();

        System.out.print("Kein Zeit daher switch.Richtige p(i) :");
        //for(int i=0;i<=-10;i--) {
          //  if (i == 0 || i == -1) {
          //      System.out.print(p(i) + " ");
          //      continue;
          //  }
          //  for(int c=1;c<=i*(-1);c*=2) {


           //     if (i == c || (i*(-1))== c )  {
           //         System.out.print(p(i) + " ");
           //     }
            //
           // }

           // System.out.print("");

       // }
       // counter=1;
        for(int i=-10;i<=10;i++){

                switch (i){
                    case 0: System.out.print(p(0));
                        break;
                    case 1: System.out.print(p(1));
                        break;
                    case -1: System.out.print(p(-1));
                        break;
                    case -2: System.out.print(p(-2));
                        break;
                    case -4: System.out.print(p(-4));
                        break;
                    case -8: System.out.print(p(-8));
                        break;

                    case 3: System.out.print(p(3));
                        break;
                    case 7: System.out.print(p(7));
                        break;
                    default:
                        System.out.print(" ");
                        break;
                }

             //System.out.print(p(15));//0,1,3,7,-1,-2,-4,-8,15,31 ***, -16,-32*****
            System.out.print("");
        }

        System.out.println();

        for(int i=-10;i<=10;i++) {
            if((i<0 && i%3==-2) ||(i>=0 && i%3==1)){
           System.out.print(q(i));  // jede Zahl die %3==0 ok, keine  negierte Zahl %3==1, keine positive zahl %3==2
            //berechnet Shritt zu Terminierungsbedingung
            System.out.print(" ");
            }

       }
    }
}
