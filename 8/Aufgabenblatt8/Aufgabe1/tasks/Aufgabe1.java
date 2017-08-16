/**********************************************************************************************************************

 AUFGABENBLATT 8 für alle Übungsgruppen - Allgemeine Informationen

 Das Projekt Aufgabenblatt8 besteht aus fünf Aufgaben in den Klassen Aufgabe1 bis Aufgabe5, die Sie erweitern und in
 den Übungen vom 22.6. bis 26.6. präsentieren müssen.

 Die Beantwortung von Fragen, die mit [fortgeschritten] gekennzeichnet sind, ist für fortgeschrittene Gruppen
 *verpflichtend*. Für andere Teilnehmer sind diese Fragen (obwohl empfohlen) freiwillig. Sind Sie in einer
 fortgeschrittenen Gruppe werden Kreuzerl, in denen [fortgeschritten] nicht berücksichtigt wurde, aberkannt.

 Achten Sie bei der Implementierung von Aufgabe1 bis Aufgabe5 auf folgende Punkte:

 - Ändern Sie nur die Ordner tasks in Aufgabe1 bis Aufgabe5, lassen Sie alle anderen Ordner (insbesondere tests)
   des Projekts unverändert. Wenn notwendig, können Sie neue Klassen erstellen.
 - Ihr Programm sollte den dazugehörenden Test (z.B. enthält Aufgabe1Test den Test zu Aufgabe1) bestehen.
 - Sie dürfen den Test zu einer Aufgabe nicht (!) verändern, da Sie sonst beim Übersetzen falsche Meldungen bekommen.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich thematisch auf das erstellte Programm.
   Sie müssen diese Zusatzfragen in der Übung beantworten können.
 - Verwenden Sie zur Ausgabe immer System.out.println().

 Abgabe:  Die Abgabe muss bis Sonntag, den 21.6. um 13:59 erfolgen. Alle Änderungen am Projekt in der
 Übungsumgebung, die bis zu diesem Zeitpunkt von Ihnen vorgenommen wurden, werden als Abgabe betrachtet.

 ***********************************************************************************************************************/

/*
    Aufgabe1) Eingabe und Ausgabe mit Dateien

    Es soll ein Textfile "Geschichte.txt" geöffnet und eingelesen werden. Durchsuchen Sie das File nach sogenannten
    Palindromen (z.b. Hannah, Otto, etc.), also Wörtern die von vorn und von hinten gelesen dasselbe ergeben.
    Implementieren Sie dazu eine statische Methode "searchPalindrome(...)", die als Argumente die Filenamen für die
    Ein- und Ausgabe übergeben bekommt.
    Schreiben Sie alle gefundenen Palindrome in die Datei "Palindrome.txt".
    Zusätzlich geben Sie alle Palindrome mit System.out.println(...) aus (in der Reihenfolge in der diese im File auftreten).

    [fortgeschritten]
    Erstellen Sie zusätzlich (unabhängig von Palindromen) eine Statistik über alle vorkommenden Buchstaben des Alphabets
    (auch Umlaute und scharfes ß). Groß- und Kleinbuchstaben werden nicht unterschieden. Implementieren Sie dazu eine
    statische Methode "generateStatistic(...)" und geben Sie die Ergebnisse in folgender Form aus:
            Buchstabe - Gesamt (Wie oft kommt Buchstabe vor) - Prozentual (Wie oft kommt Buchstabe relativ zu allen Buchstaben vor)
    z.B.    a - 1345 - 13%
            b - 344 - 8%
            ...
            z - 0 - 0%
            ä - 0 - 0%
            ö - 0 - 0%
            ü - 0 - 0%
            ß - 0 - 0%

    Zusatzfragen:
    1. Was ist der Unterschied zwischen ungepufferten und gepufferten Datenströmen?
    2. Was ist der Unterschied zwischen FileInputStream und FileReader?
*/

public class Aufgabe1 {

    public static void searchPalindrome(String inFileName, String outFileName){
        /* TODO: add code here */
    }

    public static void generateStatistic(String inFileName){
        //[fortgeschritten]
        /* TODO: add code here */
    }

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt
    }
}
