import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

public class Aufgabe3Test {

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    //@Rule
    //public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testForLoop() throws Exception {

        assertThat(Loops.forLoop(),is(999));

    }

    @Test
    public void testForEachLoop() throws Exception {

        assertThat(Loops.forEachLoop(),is(33));

    }

    @Test
    public void testWhileLoop() throws Exception {

        assertThat(Loops.whileLoop(-50),is(0));
        assertThat(Loops.whileLoop(-10),is(0));
        assertThat(Loops.whileLoop(0),is(0));
        assertThat(Loops.whileLoop(10),is(3));
        assertThat(Loops.whileLoop(15),is(3));
        assertThat(Loops.whileLoop(16),is(4));
        assertThat(Loops.whileLoop(50),is(5));
        assertThat(Loops.whileLoop(255),is(7));
        assertThat(Loops.whileLoop(256),is(8));

    }

    @Test
    public void testCalcInt() throws Exception {

        assertThat(Loops.calcInt(), is(117038));


    }

    @Test
    public void testCalcString() throws Exception {

        assertThat(Loops.calcString(-1), is(""));
        assertThat(Loops.calcString(-10), is(""));
        assertThat(Loops.calcString(0), is(""));
        assertThat(Loops.calcString(1), is(" "));
        assertThat(Loops.calcString(2), is("  "));
        assertThat(Loops.calcString(17), is("                 "));

    }


}