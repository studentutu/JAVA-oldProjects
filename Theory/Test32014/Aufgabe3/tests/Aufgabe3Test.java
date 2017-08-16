import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/*
    Diese Tests dienen nur zur Überprüfung der syntaktischen Korrektheit der Methoden.
    Hier werden nicht die korrekten Antworten überprüft!
*/

public class Aufgabe3Test {
    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Test
    public void testOptions() {
        int i = Aufgabe3.o38294638();
        i = Aufgabe3.o67284372();
        i = Aufgabe3.o91048263();
        i = Aufgabe3.o53753291();
        i = Aufgabe3.o19283728();
    }
}
