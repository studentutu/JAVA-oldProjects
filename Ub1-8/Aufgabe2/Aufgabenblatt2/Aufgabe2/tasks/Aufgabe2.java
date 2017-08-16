/*
    Aufgabe2) Eingabe

    Erweitern Sie die main-Methode so, dass wiederholt Werte eingelesen werden, bis die Zahl 0 eingegeben
    wird. Dann wird das Programm beendet. Zuvor wird noch die Summe aller eingelesenen Zahlen ausgegeben, falls alle
    eingelesenen Werte ganze Zahlen waren. In allen anderen Fällen wird nichts ausgegeben.

    Zusatzfragen:
    1. Warum muss eine ungültige Eingabe (keine ganze Zahl) aus dem Input-Stream entfernt werden?
    2. Woran kann man erkennen, dass ein eingelesener Wert eine ganze Zahl ist?
    3. Woran kann man feststellen, ob eine frühere Eingabe ungültig war?
*/
import java.util.Scanner;
public class Aufgabe2 {

    public static void main(String[] args) {
        /* TODO: add code here */
        Scanner scanner = new Scanner(System.in);
        int summ = 0;
        boolean b=true;
        System.out.println("Dieses program funktioniert nur dann,\n" +
                " wenn  Sie einen Integer in den Scanner eingeben.\n" +
                " Falls es ein String oder ein anderer Typ ist, wird das Programm abbrechen.\n"+
        "Nach der Summe exit hineinschreiben!");

          while(scanner.hasNextInt())
          {

              int s=  scanner.nextInt();
              summ+= s;
              if (s==0 ){ System.out.println("Hier ist die Summe ="+summ + " Ende des Program!");
              break;}

          }


    }

    }

