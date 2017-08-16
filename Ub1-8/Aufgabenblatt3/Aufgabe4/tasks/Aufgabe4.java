/*
    Aufgabe4) Schleifenanwendung

    Erweitern Sie die Klasse 'Aufgabe4' um eine statische Methode namens "encodeBin(long n)", die als Parameter einen
    positiven ganzzahlingen Wert übergeben bekommt. Dieser ganzzahlige Wert stellt eine Binärzahl dar und wird in dieser
    Methode codiert. Es wird das Vorkommen von Nullen und Einsen gezählt und die Anzahl ausgegeben. Bei jedem Wechsel
    von 0 auf 1 oder 1 auf 0 beginnt der Zähler neu zu zählen.

    z.B.:  Die Zahl "1101111000100111011L" generiert folgenden codierten Output:

        1 -> 2
        0 -> 1
        1 -> 3
        0 -> 2
        1 -> 1
        0 -> 3
        1 -> 4
        0 -> 1
        1 -> 2

    HINWEIS: Verwenden Sie keinerlei Methoden aus der String-Klasse, die die Aufgabe verkürzen würden!

    Zusatzfragen:
    1. Funktioniert dieses Programm nur für Binärzahlen oder können Zahlen mit anderer Zahlenbasis ebenfalls codiert werden? Wenn ja/nein - warum?
    2) Wieviele Stellen darf der Inputparameter der Methode maximal besitzen?
*/
public class Aufgabe4
{

    public static void main(String[] args)
    {


        encodeBin(1101111000100111011L);//32 bit
    }

    public static void encodeBin(long n)
    {
        /**
        long m=n;
        int length=0;
        for(;m>0;m/=10){length++;}


        System.out.println(length);

        m=n;
        long[] b=new long[length+1];//zahl in Array hinzufuegen!
        int count1 = 0;
        int count0=0;

        for(int i=0;i<length && m>0 ;i++)
        {

            b[i]=m%2; // Falls irgenwelche basis dann muss man auch Anzahl  b-1;b-2;b-3;...bis 0!
            m/=10;

          System.out.println(" "+b[i]);// Arraz von zahl!

        }
        b[length]=2;//hier wenn basis verendern und noch ein if b[i]==b-1,b-2... hinzufuegen
        for(int i=0;i<length;i++)
        {
            if (b[i]==1)
            {
                count1++;
                if(b[i+1]==0||b[i+1]==2)
                {
                    System.out.println("1  -> "+count1);
                    count1=0;
                }
            }
            if(b[i]==0)
            {
                count0++;
                if(b[i+1]==1||b[i+1]==2)
                {
                    System.out.println("0  -> "+count0);
                    count0=0;
                }
            }
        }
        **/

        long m=n;
        long diff=m%10;
        int count=0;


        for(long i=m;i>0;i/=10)
        {
            long zahl=i%10;
            if(diff==zahl){count++;} else
            {
                System.out.println(""+diff +" --> "+ count);
                count=1;
            }
            diff=zahl;
        }




    }
}
