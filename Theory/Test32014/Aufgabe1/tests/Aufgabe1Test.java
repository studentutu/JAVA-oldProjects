import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/*
    Diese Tests dienen nur zur Überprüfung der syntaktischen Korrektheit der Methoden.
    Hier werden nicht die korrekten Antworten überprüft!
*/

public class Aufgabe1Test {
    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Test
    public void testOptions() {
        int i = Aufgabe1.o28294638();
        i = Aufgabe1.o67204372();
        i = Aufgabe1.o91048263();
        i = Aufgabe1.o53753291();
        i = Aufgabe1.o19263725();
    }
}
