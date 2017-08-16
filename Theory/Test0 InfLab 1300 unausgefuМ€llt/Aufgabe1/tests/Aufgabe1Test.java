import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

public class Aufgabe1Test {

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    //@Rule
    //public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testFromIntsToInt() throws Exception {

        for (int x = -10; x <= 10; x++) {

            for (int y = -10; y <= 10; y++) {

                int r = x < y ? y - x : x - y;
                assertThat(ExpressionsAndConds.fromIntsToInt(x,y), is(r));

            }

        }

    }

    @Test
    public void testFromIntsToBool() throws Exception {

        for (int x = -10; x <= 10; x++) {

            for (int y = -10; y <= 10; y++) {

                boolean r = x <= y && y <= 0;
                assertThat(ExpressionsAndConds.fromIntsToBool(x,y), is(r));

            }

        }

    }

    @Test
    public void testFromBoolsToInt() throws Exception {

        assertThat(ExpressionsAndConds.fromBoolsToInt(false, false), is(1));
        assertThat(ExpressionsAndConds.fromBoolsToInt(true, false), is(0));
        assertThat(ExpressionsAndConds.fromBoolsToInt(false, true), is(0));
        assertThat(ExpressionsAndConds.fromBoolsToInt(true, true), is(-1));

    }

    @Test
    public void testFromStringToString() throws Exception {

        String words = "this is not a test";
        Scanner sc = new Scanner(words);

        while(sc.hasNext()) {

            String s = sc.next();
            assertThat(ExpressionsAndConds.fromStringToString(s), is(s+"-"+s));

        }

        //assertThat(ExpressionsAndConds.fromStringToString(""), is("-"));

    }


}