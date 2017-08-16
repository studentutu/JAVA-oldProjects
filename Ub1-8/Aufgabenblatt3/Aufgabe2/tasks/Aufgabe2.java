/*
    Aufgabe2) Verschachtelte Schleifen

    Erweitern Sie die Klasse 'Aufgabe2' um eine statische Methode namens "calcMultTable(int start, int ende)", die eine
    Multiplikationstablle berechnet und ausgibt. Diese Methode bekommt zwei Parameter übergeben, die den Beginn (start)
    und Ende (ende) der Multiplikationstabelle angeben. In der oberen linken Ecke steht das Produkt von start*start und
    in der unteren rechten Ecke das Produkt von ende*ende. Alle anderen Werte dazwischen ergeben sich aus Kombinationen
    zweier Faktoren zwischen "start" und "ende".

    Für start = 1 und ende = 10 soll folgende Tabelle ausgegeben werden:

       1   2   3   4   5   6   7   8   9  10
       2   4   6   8  10  12  14  16  18  20
       3   6   9  12  15  18  21  24  27  30
       4   8  12  16  20  24  28  32  36  40
       5  10  15  20  25  30  35  40  45  50
       6  12  18  24  30  36  42  48  54  60
       7  14  21  28  35  42  49  56  63  70
       8  16  24  32  40  48  56  64  72  80
       9  18  27  36  45  54  63  72  81  90
      10  20  30  40  50  60  70  80  90 100

    Für start = 3 und ende = 9 soll folgende Tabelle ausgegeben werden:

       9  12  15  18  21  24  27
      12  16  20  24  28  32  36
      15  20  25  30  35  40  45
      18  24  30  36  42  48  54
      21  28  35  42  49  56  63
      24  32  40  48  56  64  72
      27  36  45  54  63  72  81

    Testen Sie Ihre Methode mit weiteren Inputpaaren! Der Rückgabetyp der Methode ist "void".
    HINWEIS: Um einen ganzzahligen Wert mit einer definierten Anzahl von Stellen auszugeben, können Sie "System.out.printf()" verwenden.
             z.B. System.out.printf("%3d",x) gibt den Wert x mit exakt 3 Stellen aus.
             Das kann nützlich bei der Formatierung der Ausgabe sein.

    Zusatzfragen:
    1. Ab welchen Eingabeparametern ist die Lesbarkeit der Tabelle beeinträchtigt ?
    2. Ist eine doppelte Verschachtelung von Schleifen immer notwendig?
*/
public class Aufgabe2 {

    public static void main(String[] args)
    {
      // System.out.println(324 / 10);
        calcMultTable(20,25);

    }


    public  static void calcMultTable(int start,int ende)
    {

        for(int i=start; i<=ende;i++)
        {

            for(int j=start;j<=ende;j++)
            {
                //platz for max digits
                int max=ende*ende;
                int countmax=0;
                while(max>0)
                {
                    countmax++;
                    max=max/10;//anzahl digits
                }
                //----------------
                // platz for min digit
                int min =i*j;
                int countmin=0;
                while(min>0)
                {
                    countmin++;
                    min/=10;//anzahl digits
                }
                //----------------

                while (countmin<=countmax)
                {
                    System.out.print(" "); //differenz max=min  ist anzahl der  " "
                    countmin++;
                }
                System.out.printf("%d", i * j);


                if(j==ende){System.out.print("\n");} //ende der Zeile
            }

        }

    }


}
