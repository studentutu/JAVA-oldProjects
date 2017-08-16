import junit.framework.TestCase;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
//import static org.hamcrest.MatcherAssert.assertThat;

public class Aufgabe2Test {

    private int code = 0x7F;

    @Rule
    public Timeout globalTimeout = new Timeout(100, TimeUnit.MILLISECONDS);

    @ClassRule
    public static final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Before
    public void testAll() {

        try {
            TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                @Override
                public void run() {

                    try {

                        testEmptyToString();
                        code -= 1;

                    } catch (Exception e) {
                    } catch (AssertionError e) {
                    }
                }
            }, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        }
        try {
            TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                @Override
                public void run() {

                    try {

                        testAddToString();
                        code -= 2;

                    } catch (Exception e) {
                    } catch (AssertionError e) {
                    }
                }
            }, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        }
        try {
            TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                @Override
                public void run() {

                    try {

                        testAddValues();
                        code -= 4;

                    } catch (Exception e) {
                    } catch (AssertionError e) {
                    }
                }
            }, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        }
        try {
            TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                @Override
                public void run() {

                    try {

                        testToQueueNormalCase();
                        code -= 8;

                    } catch (Exception e) {
                    } catch (AssertionError e) {
                    }
                }
            }, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        }
        try {
            TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                @Override
                public void run() {

                    try {

                        testToQueueIfOneElem();
                        code -= 16;

                    } catch (Exception e) {
                    } catch (AssertionError e) {
                    }
                }
            }, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        }
        try {
            TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                @Override
                public void run() {

                    try {

                        testEqualsNormal();
                        code -= 32;

                    } catch (Exception e) {
                    } catch (AssertionError e) {
                    }
                }
            }, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        }
        try {
            TimeLimitedCodeBlock.runWithTimeout(new Runnable() {
                @Override
                public void run() {

                    try {

                        testEqualsEmpty();
                        code -= 64;

                    } catch (Exception e) {
                    } catch (AssertionError e) {
                    }
                }
            }, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        }


    }

    public void testEmptyToString() throws Exception {

        Tree tree = new Tree();

        assertThat(tree.toString(), is("tree with 0 integers"));

    }

    public void testAddToString() throws Exception {

        Tree tree = new Tree();

        tree.add(1);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(5);
        tree.add(2);

        assertThat(tree.toString(), containsString("tree with 5 integers"));

    }

    public void testAddValues() throws Exception {

        Tree tree = new Tree();

        assertThat(tree.add(1), is(true));
        assertThat(tree.add(2), is(true));
        assertThat(tree.add(5), is(true));
        assertThat(tree.add(3), is(true));
        assertThat(tree.add(2), is(false));
        assertThat(tree.add(5), is(false));
        assertThat(tree.add(0), is(true));

    }

    public void testToQueueNormalCase() throws Exception {

        Tree tree = new Tree();

        tree.add(1);
        tree.add(4);
        tree.add(3);
        tree.add(3);
        tree.add(2);
        tree.add(7);
        tree.add(2);
        tree.add(2);

        Queue<String> q = new LinkedList<>();

        q.add("1");
        q.add("2");
        q.add("3");
        q.add("4");
        q.add("7");

        assertThat(tree.toQueue(), is(q));

    }

    public void testToQueueIfOneElem() throws Exception {

        Tree tree = new Tree();

        tree.add(100);

        Queue<String> q = new LinkedList<>();

        q.add("100");

        assertThat(tree.toQueue(), is(q));

    }

    public void testEqualsNormal() throws Exception {

        Tree tree1 = new Tree();

        tree1.add(1);
        tree1.add(4);
        tree1.add(3);
        tree1.add(2);
        tree1.add(5);
        tree1.add(2);

        Tree tree2 = new Tree();

        tree2.add(1);
        tree2.add(4);
        tree2.add(3);
        tree2.add(2);
        tree2.add(5);
        tree2.add(2);

        Tree tree3 = new Tree();

        tree3.add(1);
        tree3.add(5);
        tree3.add(3);
        tree3.add(2);
        tree3.add(4);
        tree3.add(2);

        assertTrue(tree1.equals(tree2));
        assertTrue(tree2.equals(tree1));
        tree1.add(0);
        assertTrue(!tree1.equals(tree2));
        assertTrue(!tree2.equals(tree1));
        assertTrue(tree2.equals(tree3));
        assertTrue(tree3.equals(tree2));

    }

    public void testEqualsEmpty() throws Exception {

        Tree tree1 = new Tree();

        tree1.add(1);
        tree1.add(4);
        tree1.add(3);
        tree1.add(2);
        tree1.add(5);
        tree1.add(2);

        assertTrue(tree1.equals(tree1));
        assertTrue(!tree1.equals(new Tree()));
        assertTrue(!new Tree().equals(tree1));
        assertTrue(!tree1.equals(null));

    }

    @Test
    public void test1() { TestCase.assertTrue(code < 1); }
    @Test
    public void test2() { TestCase.assertTrue(code < 2); }
    @Test
    public void test3() { TestCase.assertTrue(code < 3); }
    @Test
    public void test4() { TestCase.assertTrue(code < 4); }
    @Test
    public void test5() { TestCase.assertTrue(code < 5); }
    @Test
    public void test6() { TestCase.assertTrue(code < 6); }
    @Test
    public void test7() { TestCase.assertTrue(code < 7); }
    @Test
    public void test8() { TestCase.assertTrue(code < 8); }
    @Test
    public void test9() { TestCase.assertTrue(code < 9); }
    @Test
    public void test10() { TestCase.assertTrue(code < 10); }
    @Test
    public void test11() { TestCase.assertTrue(code < 11); }
    @Test
    public void test12() { TestCase.assertTrue(code < 12); }
    @Test
    public void test13() { TestCase.assertTrue(code < 13); }
    @Test
    public void test14() { TestCase.assertTrue(code < 14); }
    @Test
    public void test15() { TestCase.assertTrue(code < 15); }
    @Test
    public void test16() { TestCase.assertTrue(code < 16); }
    @Test
    public void test17() { TestCase.assertTrue(code < 17); }
    @Test
    public void test18() { TestCase.assertTrue(code < 18); }
    @Test
    public void test19() { TestCase.assertTrue(code < 19); }
    @Test
    public void test20() { TestCase.assertTrue(code < 20); }
    @Test
    public void test21() { TestCase.assertTrue(code < 21); }
    @Test
    public void test22() { TestCase.assertTrue(code < 22); }
    @Test
    public void test23() { TestCase.assertTrue(code < 23); }
    @Test
    public void test24() { TestCase.assertTrue(code < 24); }
    @Test
    public void test25() { TestCase.assertTrue(code < 25); }
    @Test
    public void test26() { TestCase.assertTrue(code < 26); }
    @Test
    public void test27() { TestCase.assertTrue(code < 27); }
    @Test
    public void test28() { TestCase.assertTrue(code < 28); }
    @Test
    public void test29() { TestCase.assertTrue(code < 29); }
    @Test
    public void test30() { TestCase.assertTrue(code < 30); }
    @Test
    public void test31() { TestCase.assertTrue(code < 31); }
    @Test
    public void test32() { TestCase.assertTrue(code < 32); }
    @Test
    public void test33() { TestCase.assertTrue(code < 33); }
    @Test
    public void test34() { TestCase.assertTrue(code < 34); }
    @Test
    public void test35() { TestCase.assertTrue(code < 35); }
    @Test
    public void test36() { TestCase.assertTrue(code < 36); }
    @Test
    public void test37() { TestCase.assertTrue(code < 37); }
    @Test
    public void test38() { TestCase.assertTrue(code < 38); }
    @Test
    public void test39() { TestCase.assertTrue(code < 39); }
    @Test
    public void test40() { TestCase.assertTrue(code < 40); }
    @Test
    public void test41() { TestCase.assertTrue(code < 41); }
    @Test
    public void test42() { TestCase.assertTrue(code < 42); }
    @Test
    public void test43() { TestCase.assertTrue(code < 43); }
    @Test
    public void test44() { TestCase.assertTrue(code < 44); }
    @Test
    public void test45() { TestCase.assertTrue(code < 45); }
    @Test
    public void test46() { TestCase.assertTrue(code < 46); }
    @Test
    public void test47() { TestCase.assertTrue(code < 47); }
    @Test
    public void test48() { TestCase.assertTrue(code < 48); }
    @Test
    public void test49() { TestCase.assertTrue(code < 49); }
    @Test
    public void test50() { TestCase.assertTrue(code < 50); }
    @Test
    public void test51() { TestCase.assertTrue(code < 51); }
    @Test
    public void test52() { TestCase.assertTrue(code < 52); }
    @Test
    public void test53() { TestCase.assertTrue(code < 53); }
    @Test
    public void test54() { TestCase.assertTrue(code < 54); }
    @Test
    public void test55() { TestCase.assertTrue(code < 55); }
    @Test
    public void test56() { TestCase.assertTrue(code < 56); }
    @Test
    public void test57() { TestCase.assertTrue(code < 57); }
    @Test
    public void test58() { TestCase.assertTrue(code < 58); }
    @Test
    public void test59() { TestCase.assertTrue(code < 59); }
    @Test
    public void test60() { TestCase.assertTrue(code < 60); }
    @Test
    public void test61() { TestCase.assertTrue(code < 61); }
    @Test
    public void test62() { TestCase.assertTrue(code < 62); }
    @Test
    public void test63() { TestCase.assertTrue(code < 63); }
    @Test
    public void test64() { TestCase.assertTrue(code < 64); }
    @Test
    public void test65() { TestCase.assertTrue(code < 65); }
    @Test
    public void test66() { TestCase.assertTrue(code < 66); }
    @Test
    public void test67() { TestCase.assertTrue(code < 67); }
    @Test
    public void test68() { TestCase.assertTrue(code < 68); }
    @Test
    public void test69() { TestCase.assertTrue(code < 69); }
    @Test
    public void test70() { TestCase.assertTrue(code < 70); }
    @Test
    public void test71() { TestCase.assertTrue(code < 71); }
    @Test
    public void test72() { TestCase.assertTrue(code < 72); }
    @Test
    public void test73() { TestCase.assertTrue(code < 73); }
    @Test
    public void test74() { TestCase.assertTrue(code < 74); }
    @Test
    public void test75() { TestCase.assertTrue(code < 75); }
    @Test
    public void test76() { TestCase.assertTrue(code < 76); }
    @Test
    public void test77() { TestCase.assertTrue(code < 77); }
    @Test
    public void test78() { TestCase.assertTrue(code < 78); }
    @Test
    public void test79() { TestCase.assertTrue(code < 79); }
    @Test
    public void test80() { TestCase.assertTrue(code < 80); }
    @Test
    public void test81() { TestCase.assertTrue(code < 81); }
    @Test
    public void test82() { TestCase.assertTrue(code < 82); }
    @Test
    public void test83() { TestCase.assertTrue(code < 83); }
    @Test
    public void test84() { TestCase.assertTrue(code < 84); }
    @Test
    public void test85() { TestCase.assertTrue(code < 85); }
    @Test
    public void test86() { TestCase.assertTrue(code < 86); }
    @Test
    public void test87() { TestCase.assertTrue(code < 87); }
    @Test
    public void test88() { TestCase.assertTrue(code < 88); }
    @Test
    public void test89() { TestCase.assertTrue(code < 89); }
    @Test
    public void test90() { TestCase.assertTrue(code < 90); }
    @Test
    public void test91() { TestCase.assertTrue(code < 91); }
    @Test
    public void test92() { TestCase.assertTrue(code < 92); }
    @Test
    public void test93() { TestCase.assertTrue(code < 93); }
    @Test
    public void test94() { TestCase.assertTrue(code < 94); }
    @Test
    public void test95() { TestCase.assertTrue(code < 95); }
    @Test
    public void test96() { TestCase.assertTrue(code < 96); }
    @Test
    public void test97() { TestCase.assertTrue(code < 97); }
    @Test
    public void test98() { TestCase.assertTrue(code < 98); }
    @Test
    public void test99() { TestCase.assertTrue(code < 99); }
    @Test
    public void test100() { TestCase.assertTrue(code < 100); }
    @Test
    public void test101() { TestCase.assertTrue(code < 101); }
    @Test
    public void test102() { TestCase.assertTrue(code < 102); }
    @Test
    public void test103() { TestCase.assertTrue(code < 103); }
    @Test
    public void test104() { TestCase.assertTrue(code < 104); }
    @Test
    public void test105() { TestCase.assertTrue(code < 105); }
    @Test
    public void test106() { TestCase.assertTrue(code < 106); }
    @Test
    public void test107() { TestCase.assertTrue(code < 107); }
    @Test
    public void test108() { TestCase.assertTrue(code < 108); }
    @Test
    public void test109() { TestCase.assertTrue(code < 109); }
    @Test
    public void test110() { TestCase.assertTrue(code < 110); }
    @Test
    public void test111() { TestCase.assertTrue(code < 111); }
    @Test
    public void test112() { TestCase.assertTrue(code < 112); }
    @Test
    public void test113() { TestCase.assertTrue(code < 113); }
    @Test
    public void test114() { TestCase.assertTrue(code < 114); }
    @Test
    public void test115() { TestCase.assertTrue(code < 115); }
    @Test
    public void test116() { TestCase.assertTrue(code < 116); }
    @Test
    public void test117() { TestCase.assertTrue(code < 117); }
    @Test
    public void test118() { TestCase.assertTrue(code < 118); }
    @Test
    public void test119() { TestCase.assertTrue(code < 119); }
    @Test
    public void test120() { TestCase.assertTrue(code < 120); }
    @Test
    public void test121() { TestCase.assertTrue(code < 121); }
    @Test
    public void test122() { TestCase.assertTrue(code < 122); }
    @Test
    public void test123() { TestCase.assertTrue(code < 123); }
    @Test
    public void test124() { TestCase.assertTrue(code < 124); }
    @Test
    public void test125() { TestCase.assertTrue(code < 125); }
    @Test
    public void test126() { TestCase.assertTrue(code < 126); }
    @Test
    public void test127() { TestCase.assertTrue(code < 127); }
    @Test
    public void test128() { TestCase.assertTrue(code < 128); }
    @Test
    public void test129() { TestCase.assertTrue(code < 129); }
    @Test
    public void test130() { TestCase.assertTrue(code < 130); }
    @Test
    public void test131() { TestCase.assertTrue(code < 131); }
    @Test
    public void test132() { TestCase.assertTrue(code < 132); }
    @Test
    public void test133() { TestCase.assertTrue(code < 133); }
    @Test
    public void test134() { TestCase.assertTrue(code < 134); }
    @Test
    public void test135() { TestCase.assertTrue(code < 135); }
    @Test
    public void test136() { TestCase.assertTrue(code < 136); }
    @Test
    public void test137() { TestCase.assertTrue(code < 137); }
    @Test
    public void test138() { TestCase.assertTrue(code < 138); }
    @Test
    public void test139() { TestCase.assertTrue(code < 139); }
    @Test
    public void test140() { TestCase.assertTrue(code < 140); }
    @Test
    public void test141() { TestCase.assertTrue(code < 141); }
    @Test
    public void test142() { TestCase.assertTrue(code < 142); }
    @Test
    public void test143() { TestCase.assertTrue(code < 143); }
    @Test
    public void test144() { TestCase.assertTrue(code < 144); }
    @Test
    public void test145() { TestCase.assertTrue(code < 145); }
    @Test
    public void test146() { TestCase.assertTrue(code < 146); }
    @Test
    public void test147() { TestCase.assertTrue(code < 147); }
    @Test
    public void test148() { TestCase.assertTrue(code < 148); }
    @Test
    public void test149() { TestCase.assertTrue(code < 149); }
    @Test
    public void test150() { TestCase.assertTrue(code < 150); }
    @Test
    public void test151() { TestCase.assertTrue(code < 151); }
    @Test
    public void test152() { TestCase.assertTrue(code < 152); }
    @Test
    public void test153() { TestCase.assertTrue(code < 153); }
    @Test
    public void test154() { TestCase.assertTrue(code < 154); }
    @Test
    public void test155() { TestCase.assertTrue(code < 155); }
    @Test
    public void test156() { TestCase.assertTrue(code < 156); }
    @Test
    public void test157() { TestCase.assertTrue(code < 157); }
    @Test
    public void test158() { TestCase.assertTrue(code < 158); }
    @Test
    public void test159() { TestCase.assertTrue(code < 159); }
    @Test
    public void test160() { TestCase.assertTrue(code < 160); }
    @Test
    public void test161() { TestCase.assertTrue(code < 161); }
    @Test
    public void test162() { TestCase.assertTrue(code < 162); }
    @Test
    public void test163() { TestCase.assertTrue(code < 163); }
    @Test
    public void test164() { TestCase.assertTrue(code < 164); }
    @Test
    public void test165() { TestCase.assertTrue(code < 165); }
    @Test
    public void test166() { TestCase.assertTrue(code < 166); }
    @Test
    public void test167() { TestCase.assertTrue(code < 167); }
    @Test
    public void test168() { TestCase.assertTrue(code < 168); }
    @Test
    public void test169() { TestCase.assertTrue(code < 169); }
    @Test
    public void test170() { TestCase.assertTrue(code < 170); }
    @Test
    public void test171() { TestCase.assertTrue(code < 171); }
    @Test
    public void test172() { TestCase.assertTrue(code < 172); }
    @Test
    public void test173() { TestCase.assertTrue(code < 173); }
    @Test
    public void test174() { TestCase.assertTrue(code < 174); }
    @Test
    public void test175() { TestCase.assertTrue(code < 175); }
    @Test
    public void test176() { TestCase.assertTrue(code < 176); }
    @Test
    public void test177() { TestCase.assertTrue(code < 177); }
    @Test
    public void test178() { TestCase.assertTrue(code < 178); }
    @Test
    public void test179() { TestCase.assertTrue(code < 179); }
    @Test
    public void test180() { TestCase.assertTrue(code < 180); }
    @Test
    public void test181() { TestCase.assertTrue(code < 181); }
    @Test
    public void test182() { TestCase.assertTrue(code < 182); }
    @Test
    public void test183() { TestCase.assertTrue(code < 183); }
    @Test
    public void test184() { TestCase.assertTrue(code < 184); }
    @Test
    public void test185() { TestCase.assertTrue(code < 185); }
    @Test
    public void test186() { TestCase.assertTrue(code < 186); }
    @Test
    public void test187() { TestCase.assertTrue(code < 187); }
    @Test
    public void test188() { TestCase.assertTrue(code < 188); }
    @Test
    public void test189() { TestCase.assertTrue(code < 189); }
    @Test
    public void test190() { TestCase.assertTrue(code < 190); }
    @Test
    public void test191() { TestCase.assertTrue(code < 191); }
    @Test
    public void test192() { TestCase.assertTrue(code < 192); }
    @Test
    public void test193() { TestCase.assertTrue(code < 193); }
    @Test
    public void test194() { TestCase.assertTrue(code < 194); }
    @Test
    public void test195() { TestCase.assertTrue(code < 195); }
    @Test
    public void test196() { TestCase.assertTrue(code < 196); }
    @Test
    public void test197() { TestCase.assertTrue(code < 197); }
    @Test
    public void test198() { TestCase.assertTrue(code < 198); }
    @Test
    public void test199() { TestCase.assertTrue(code < 199); }
    @Test
    public void test200() { TestCase.assertTrue(code < 200); }
    @Test
    public void test201() { TestCase.assertTrue(code < 201); }
    @Test
    public void test202() { TestCase.assertTrue(code < 202); }
    @Test
    public void test203() { TestCase.assertTrue(code < 203); }
    @Test
    public void test204() { TestCase.assertTrue(code < 204); }
    @Test
    public void test205() { TestCase.assertTrue(code < 205); }
    @Test
    public void test206() { TestCase.assertTrue(code < 206); }
    @Test
    public void test207() { TestCase.assertTrue(code < 207); }
    @Test
    public void test208() { TestCase.assertTrue(code < 208); }
    @Test
    public void test209() { TestCase.assertTrue(code < 209); }
    @Test
    public void test210() { TestCase.assertTrue(code < 210); }
    @Test
    public void test211() { TestCase.assertTrue(code < 211); }
    @Test
    public void test212() { TestCase.assertTrue(code < 212); }
    @Test
    public void test213() { TestCase.assertTrue(code < 213); }
    @Test
    public void test214() { TestCase.assertTrue(code < 214); }
    @Test
    public void test215() { TestCase.assertTrue(code < 215); }
    @Test
    public void test216() { TestCase.assertTrue(code < 216); }
    @Test
    public void test217() { TestCase.assertTrue(code < 217); }
    @Test
    public void test218() { TestCase.assertTrue(code < 218); }
    @Test
    public void test219() { TestCase.assertTrue(code < 219); }
    @Test
    public void test220() { TestCase.assertTrue(code < 220); }
    @Test
    public void test221() { TestCase.assertTrue(code < 221); }
    @Test
    public void test222() { TestCase.assertTrue(code < 222); }
    @Test
    public void test223() { TestCase.assertTrue(code < 223); }
    @Test
    public void test224() { TestCase.assertTrue(code < 224); }
    @Test
    public void test225() { TestCase.assertTrue(code < 225); }
    @Test
    public void test226() { TestCase.assertTrue(code < 226); }
    @Test
    public void test227() { TestCase.assertTrue(code < 227); }
    @Test
    public void test228() { TestCase.assertTrue(code < 228); }
    @Test
    public void test229() { TestCase.assertTrue(code < 229); }
    @Test
    public void test230() { TestCase.assertTrue(code < 230); }
    @Test
    public void test231() { TestCase.assertTrue(code < 231); }
    @Test
    public void test232() { TestCase.assertTrue(code < 232); }
    @Test
    public void test233() { TestCase.assertTrue(code < 233); }
    @Test
    public void test234() { TestCase.assertTrue(code < 234); }
    @Test
    public void test235() { TestCase.assertTrue(code < 235); }
    @Test
    public void test236() { TestCase.assertTrue(code < 236); }
    @Test
    public void test237() { TestCase.assertTrue(code < 237); }
    @Test
    public void test238() { TestCase.assertTrue(code < 238); }
    @Test
    public void test239() { TestCase.assertTrue(code < 239); }
    @Test
    public void test240() { TestCase.assertTrue(code < 240); }
    @Test
    public void test241() { TestCase.assertTrue(code < 241); }
    @Test
    public void test242() { TestCase.assertTrue(code < 242); }
    @Test
    public void test243() { TestCase.assertTrue(code < 243); }
    @Test
    public void test244() { TestCase.assertTrue(code < 244); }
    @Test
    public void test245() { TestCase.assertTrue(code < 245); }
    @Test
    public void test246() { TestCase.assertTrue(code < 246); }
    @Test
    public void test247() { TestCase.assertTrue(code < 247); }
    @Test
    public void test248() { TestCase.assertTrue(code < 248); }
    @Test
    public void test249() { TestCase.assertTrue(code < 249); }
    @Test
    public void test250() { TestCase.assertTrue(code < 250); }
    @Test
    public void test251() { TestCase.assertTrue(code < 251); }
    @Test
    public void test252() { TestCase.assertTrue(code < 252); }
    @Test
    public void test253() { TestCase.assertTrue(code < 253); }
    @Test
    public void test254() { TestCase.assertTrue(code < 254); }
    @Test
    public void test255() { TestCase.assertTrue(code < 255); }
    @Test
    public void test256() { TestCase.assertTrue(code < 256); }


}

class TimeLimitedCodeBlock {

    public static void runWithTimeout(final Runnable runnable, long timeout, TimeUnit timeUnit) throws Exception {
        runWithTimeout(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                runnable.run();
                return null;
            }
        }, timeout, timeUnit);
    }

    public static <T> T runWithTimeout(Callable<T> callable, long timeout, TimeUnit timeUnit) throws Exception {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        final Future<T> future = executor.submit(callable);
        executor.shutdown(); // This does not cancel the already-scheduled task.
        try {
            return future.get(timeout, timeUnit);
        }
        catch (TimeoutException e) {
            //remove this if you do not want to cancel the job in progress
            //or set the argument to 'false' if you do not want to interrupt the thread
            future.cancel(true);
            throw e;
        }
        catch (ExecutionException e) {
            //unwrap the root cause
            Throwable t = e.getCause();
            if (t instanceof Error) {
                throw (Error) t;
            } else if (t instanceof Exception) {
                throw (Exception) e;
            } else {
                throw new IllegalStateException(t);
            }
        }
    }

}