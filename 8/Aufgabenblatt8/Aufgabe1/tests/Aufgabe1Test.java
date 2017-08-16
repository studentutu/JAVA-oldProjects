import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import static org.junit.Assert.assertEquals;

public class Aufgabe1Test {

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testSearchPalindrom() throws Exception {
        Aufgabe1.searchPalindrome("Geschichte.txt","Palindrome.txt");
        String[] testValues = new String[]{"Lagerregal", "Regallager", "neben", "Hannah", "Rentner", "Retter", "Neffen", "Uhu", "Otto"};
        StringBuilder testString = new StringBuilder();
        for(String i: testValues) {
            testString.append(i).append(System.lineSeparator());
        }
        assertEquals(testString.toString(), log.getLog());
    }
}