/*
    Aufgabe5) Vervollständigung von Methoden

    Vervollständigen Sie die Methoden, sodass sie sich den Kommentaren entsprechend verhalten. Verändern Sie dabei nur
    Ausdrücke, die in einem Kommentar mit TODO: gekennzeichnet sind. Lassen Sie andere Teile der Klasse unverändert.
    Von dieser Einschränkung ausgenommen ist nur die Methode main, die Sie beliebig zum Testen verwenden können.

    Zusatzfragen:
    1. Welche Möglichkeiten bietet Java um Programmverzweigungen (bzw. bedingte Ausführung) auszudrücken?
    2. Häufig ergeben sich auch schon in kleinen Programmen viele Fallunterscheidungen, die zu berücksichtigen sind.
       Einige vorgegebene Strukturen der Methoden in Aufgabe5 helfen dabei, Programme trotzdem klein und überschaubar
       zu halten. Welche Strukturen sind das, und wodurch helfen sie dabei?
*/
public class Aufgabe5 {

    // returns true if (and only if) both x and y are in the range from 1 to 20 (including 1 and 20)
    // and x is larger than y.
    private static boolean inRangeAndOrdered(int x, int y) {
        if ((x >= 1 || x <= 20) && (y >= 1 && y <= 20))
            return true;
        return ((x>y) && (x >= 1 && x <= 20) && (y >= 1 && y <= 20) )?true:false; /* TODO: modify this expression */
    }

    // returns 1 if both a and b are true, 0 if a differs from b, and -1 if both a and b are false
    private static int wiredLogic(boolean a, boolean b) {
        return (a && b ? (1 /* TODO: modify this expression */) : (0 /* TODO: modify this expression */)) +
               (a || b ? (a && b ?0:0/* TODO: modify this expression */) : (-1/* TODO: modify this expression */));
    }

    // returns 3 if a and b are true, 2 if a is true and be is false, 1 if a is false and b is true, 0 otherwise.
    private static int combinedLogic(boolean a, boolean b) {
        int result = 0;
        if ((a==false && b==true)|| (a==true && b==true)/* TODO: modify this expression */) {
            result += 1;
        }
        if ( (a==true && b==true) || (a==true && b==false) /* TODO: modify this expression */) {
            result += 2;
        }
        return result;
    }

    // returns true if (and only if) i is 1, 2, 3 or 4;
    // 'useSwitch' is invoked only with values i in the range from 1 to 5.
    private static boolean useSwitch(int i) {
        switch(i * i + i) {
            case (0 /* TODO: modify this expression */):
                return (false /* TODO: modify this expression */);
        }
        return (i==1||i==2||i==3||i==4?true:false /* TODO: modify this expression */);
    }

    // returns the number of square numbers in the range from 'left' to 'right' (including 'left' and 'right'),
    // where a square number is a number that is the square of some (other) number.
    private static int squareNumbers(int left, int right) {
        int count = 0;
        for (int i = 1; ( i<=right /* TODO: modify this expression */); i++) {
            if ( (i*i)>=left && (i*i)<=right/* TODO: modify this expression */) {
                count++;
            }
        }
        return count;
    }

    // just for testing ...
    public static void main(String[] args) {
        // den Rumpf dieser Methode können Sie beliebig verändern
        System.out.println("---------------\n " +
                "erste teile\n In  Fall when x=2 und y =5 wird  true ausgegeben.Da x kann >20 und sogar<0  und nur y von 1 bis 20 sein soll.\n " +
                "When x kleinere als 20 ist oder x >1 und x<y wird alles von  y abhängen(y nur von 1 bis 20).\n Ergibniss ="+inRangeAndOrdered(2,5));

        System.out.println( "---------------Zweite Aufgabe -----------\n" +
        "wiredLogic="+wiredLogic(true, true));

        System.out.println("---------Dritte-----------\n" +
         "combinedLogic="+combinedLogic(false, true));

        System.out.println("----------Vierte--------\n" +
         "useSwitch="+useSwitch(0));

        System.out.println("--------Fuenfte---------\n"+"Aufgabe nicht verstanden! da in range von (5 bis 20) gibt 9 und 16!Aber in diskussionsforum nur 1.\n" +
        " Anzahl allen square numbers die in range von left to right = "+squareNumbers(5,20));



    }
}
