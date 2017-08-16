/*
    Aufgabe5) Vervollständigung von Methoden

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren entsprechend verhalten. Verändern Sie dabei nur
    Ausdrücke, die in einem Kommentar mit TODO: gekennzeichnet sind. Lassen Sie andere Teile der Klasse unverändert.
    Von dieser Einschränkung ausgenommen ist nur die Methode main, die Sie beliebig zum Testen verwenden können.

    Zusatzfragen:
    1. Wie lautet jeweils die Abbruchbedingung?
    2. In welchen Fällen (in dieser Aufgabe) werden Kurzschlussoperatoren benötigt?
    3. Warum wird in isPrime eine Hilfsmethode benötigt?
    4. Warum liefert Java keine Fehlermeldung, wenn mehrere Methoden denselben Namen haben?
*/
public class Aufgabe5 {

    // Returns true if (and only if) n is a prime number;  n > 1 is assumed.
    private static boolean isPrime(long n) {
        return isPrime(n, (2 /* TODO: modify expression if necessary */));
        // See the method isPrime below.
    }

    // Helper method for isPrime ...
    private static boolean isPrime(long n, long m) {
        return (m==(n /* TODO: modify expression if necessary */))//true for basis m!
                || (n % m != (0 /* TODO: modify expression if necessary */)//true only if N %basis !=0 and N ==basis+1 .... and N %basis !=0...M==N  Abbruch!
                    && isPrime((n/* TODO: modify expression if necessary */), m + 1)); //Abbruchbedingung False in N% basis: wird dann && (2) nicht bewertet!
    }

    // Prints the largest prime number smaller than or equal to n;  n > 1 is assumed.
    private static void printPrime(long n) {
        if (isPrime((n /* TODO: modify expression if necessary */))) {
            System.out.println((n+" <--Ergebniss Richtig" /* TODO: modify expression if necessary */));
        } else {
            printPrime((n - 1 /* TODO: modify expression if necessary */));
        }
    }


    // Returns the sum of all odd numbers in the range from x to y (including x and y).
    private static int sum(int x, int y) {
        if (x > y) {
            return (   ((( (y+1)== x)||(y==(x-1)))? y:  sum(x,y+1)+ (y%2)==0? 0: y )/* TODO: modify expression if necessary */);
        }
        return (x % 2 == 0 ? 0 : x) + sum(( (x==y) ? x+1:x+1 /* TODO: modify expression if necessary */), y);//((x<=0)?x-1:x+1):x+1


    }


    // Returns x * y without applying the operator *;  y >= 0 is assumed.
    private static int prod(int x, int y) {
        if (y < 1 /* TODO: modify expression if necessary */) { //Gemacht!
            return (0 /* TODO: modify expression if necessary */); //Gemacht!
        }
        return (x/* TODO: modify expression if necessary */)//Gemacht!
                + prod((x /* TODO: modify expression if necessary */),//Gemacht!
                       (y - 1 /* TODO: modify expression if necessary */));//Gemacht!
    }


    // just for testing ...
    public static void main(String[] args) {
        // Den Rumpf dieser Methode können Sie beliebig verändern.

        printPrime(2);
        printPrime(129);
        printPrime(3456);

       System.out.println(sum(5, 5) + " Richtig");//10  ok
       System.out.println(sum(5, 7) + " Nicht Richtig") ;//12     ok
        System.out.println(sum(6, 5)+ " Richtig");//5  ok
       System.out.println(sum(-6, 5) + " Nicht Richtig");//0     ok

       System.out.println(prod(2, 5)+ " Richtig");
        System.out.println(prod(2, 1)+ " Richtig");
       System.out.println(prod(2, 2)+ " Richtig");
       System.out.println(prod(-2, 3)+ " Richtig");
        //System.out.println(isPrime(6));

    }
}
