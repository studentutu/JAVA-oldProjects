import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

public class Aufgabe2Test {

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    //@Rule
    //public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testStringFromInt() throws Exception {

        for (int i = -1000; i < 1000; i++) {
            String s = (Conditional.stringFromInt(i)).toLowerCase();
            if (i == 2) {
                assertThat(s, is("zwei"));
            } else {
                assertThat(s, is("nicht zwei"));
            }
        }
        assertThat(Conditional.stringFromInt(Integer.MAX_VALUE), is("nicht zwei"));
        assertThat(Conditional.stringFromInt(Integer.MIN_VALUE), is("nicht zwei"));

    }

    @Test
    public void testIntFromString() throws Exception {

        String words = "it is not a question of wahr or falsch";
        Scanner sc = new Scanner(words);

        while (sc.hasNext()) {
            String word = sc.next();
            if (word.equals("wahr")) {
                assertThat(Conditional.intFromString(word), is(1));
            } else if (word.equals("falsch")) {
                assertThat(Conditional.intFromString(word), is(-1));
            } else {
                assertThat(Conditional.intFromString(word), is(0));
            }
        }

    }

    @Test
    public void testStringFromBools() throws Exception {

        assertThat(Conditional.stringFromBools(true, true), is("ba"));
        assertThat(Conditional.stringFromBools(false, true), is("b"));
        assertThat(Conditional.stringFromBools(true, false), is("a"));
        assertThat(Conditional.stringFromBools(false, false), is(""));

    }

    @Test
    public void testIntFromBool() throws Exception {

        assertThat(Conditional.intFromBool(true), is(-1));
        assertThat(Conditional.intFromBool(false), is(1));

    }

    @Test
    public void testIntRec() throws Exception {

        assertThat(Conditional.intRec(100), is(0));
        assertThat(Conditional.intRec(101), is(101));
        assertThat(Conditional.intRec(102), is(101));
        assertThat(Conditional.intRec(103), is(204));
        assertThat(Conditional.intRec(150), is(3125));
        assertThat(Conditional.intRec(200), is(7500));
        assertThat(Conditional.intRec(1000), is(247500));
    }


}
