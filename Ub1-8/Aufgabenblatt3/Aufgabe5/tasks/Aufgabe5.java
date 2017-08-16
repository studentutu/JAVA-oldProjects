/*
    Aufgabe5)  Schleifenanwendung

    Erweitern Sie die Klasse 'Aufgabe5' um eine statische Methode namens "getSecretDigit(long n)", die einen ganzzahligen
    Parameter "n" übergeben bekommt, in dem sich eine geheime Ziffer befindet. Die Methode soll diese Ziffer finden und
    retournieren.
    Als Beispiel ist eine long-Zahl 528623274883745676 gegeben. Gehen Sie dabei folgendermassen vor: Betrachten Sie die
    letzte Ziffer der Zahl. Es ist die Zahl sechs. Rücken sie demgemäß 6 Positionen von diesem Sechser nach links.
    Betrachten Sie die dortige Ziffer. Es handelt sich um einen Dreier. Rücken Sie demgemäß drei Positionen von diesem
    Dreier nach links. Betrachten Sie die dortige Ziffer. Es ein Zweier. Rücken Sie demgemäß zwei Positionen nach links.
    usw. Wenn Sie aus der Zahl "hinausrücken" würden, beenden Sie dieses Verfahren. Ihre zuletzt gefundene Ziffer ist die
    gesuchte Geheimziffer.

    HINWEIS: Verwenden Sie keinerlei Methoden aus der String-Klasse, die die Aufgabe verkürzen würden!

    Zusatzfragen:
    1. Testen Sie Ihre Methode mit einer weiteren 18-stelligen Zahl ohne Nuller.
    2. Wie reagiert die derzeitige Methode wenn sie auf die Ziffer 0 trifft? Wie können Sie das Programm verändern,
       um auch Ziffern 0 im Eingabeparameter zu berücksichtigen?
*/
public class Aufgabe5
{

    public static void main(String[] args)
    {
        System.out.println(getSecretDigit(528623274883745676L));
        System.out.println(getSecretDigit(45670453L));

    }

    public static long getSecretDigit(long n)
    {
        long g=n%10;//erste schiebe
        long m=n;//?
        int length=0;
        while(m>0)
        {
            length=0;
            long k=m;
            for(;k>0;k/=10){length++;}//current length

        if(g<=length) { //kann man noch schieben?
            for (long i = g; i > 0; i--) {//wie viel stellen schieben;

                m = m / 10;

            }// m jetzt geschiebt,
            if (m % 10 <= length) {//zahl yum schieben

                if (m % 10 == 0) {//damit 0 auch etwas schieben kann!
                    m = m / 10;
                    g = m % 10;
                } else {
                    g = m % 10;
                }

            } else {
                return m % 10;//Secret Zahl
            }
            System.out.println(m);
        } else {return m%10;}//Secret Zahl

        }
        return m%10;//Secret Zahl
    }
}
