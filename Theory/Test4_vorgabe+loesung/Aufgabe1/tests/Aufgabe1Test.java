import junit.framework.TestCase;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

//import static org.hamcrest.MatcherAssert.assertThat;

public class Aufgabe1Test {

    private int code = 0x3FF;

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

                        checkField();
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

                        testSimple();
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

                        testMonthOverflow();
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

                        testYearOverflow();
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

                        testAddSunSimple();
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

                        testAddSunExists();
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

                        testAddSunNull();
                        code -= 64;

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

                        testMultipleEntries();
                        code -= 128;

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

                        testUnequalSize();
                        code -= 256;

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

                        testGetYear();
                        code -= 512;

                    } catch (Exception e) {
                    } catch (AssertionError e) {
                    }
                }
            }, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
        }


    }

    private Map<String, String> getMap(SunAndRain sar) {
        Field field = null;
        try {
            field = SunAndRain.class.getDeclaredField("map");
        } catch (NoSuchFieldException e) {
            assertTrue("Student did not called it map", false);
        }
        field.setAccessible(true);
        Object value = null;
        try {
            value = field.get(sar);
        } catch (IllegalAccessException e) {
            assertTrue("Access to field did not work", false);
        }
        return (Map<String, String>) value;
    }

    public void checkField() {
        Field field = null;
        try {
            field = SunAndRain.class.getDeclaredField("map");
        } catch (NoSuchFieldException e) {
            assertTrue("Student did not called it map", false);
        }
        assertTrue("should not be accessible", !field.isAccessible()); // seems do not detect public
        assertTrue("should be private", Modifier.isPrivate(field.getModifiers()));
    }

    public void testSimple() throws Exception {
        SunAndRain sar = new SunAndRain(2000, 12, 20, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
        Map<String, String> m = getMap(sar);
        assertThat(m.size(), is(3));
        assertThat(m.get("20.12.2000"), is("rain 1h"));
        assertThat(m.get("21.12.2000"), is("rain 2h"));
        assertThat(m.get("22.12.2000"), is("rain 4h"));
    }

    public void testMonthOverflow() throws Exception {
        SunAndRain sar = new SunAndRain(2000, 5, 30, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
        Map<String, String> m = getMap(sar);
        assertThat(m.size(), is(3));
        assertThat(m.get("30.5.2000"), is("rain 1h"));
        assertThat(m.get("1.6.2000"), is("rain 2h"));
        assertThat(m.get("2.6.2000"), is("rain 4h"));
    }

    public void testYearOverflow() throws Exception {
        SunAndRain sar = new SunAndRain(2000, 12, 30, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
        Map<String, String> m = getMap(sar);
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));
    }

    public void testAddSunSimple() throws Exception {
        SunAndRain sar = new SunAndRain(2000, 12, 30, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
        Map<String, String> m = getMap(sar);
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"),is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));

        sar.addSun(new String[]{"5.12.2000"},new int[]{5});
        assertThat(m.size(), is(4));
        assertThat(m.get("5.12.2000"), is("sun 5h"));
    }

    public void testAddSunExists() throws Exception {
        SunAndRain sar = new SunAndRain(2000, 12, 30, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
        Map<String, String> m = getMap(sar);
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));

        sar.addSun(new String[]{"30.12.2000"},new int[]{5});
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("sun 5h, rain 1h"));

        sar.addSun(new String[]{"30.12.2000"},new int[]{8});
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("sun 5h, rain 1h"));
    }

    public void testAddSunNull() throws Exception {
        SunAndRain sar = new SunAndRain(2000, 12, 30, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
        Map<String, String> m = getMap(sar);
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));

        sar.addSun(null,new int[]{5});
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));

        sar.addSun(new String[]{"30.12.2000"},null);
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));
    }

    public void testMultipleEntries() throws Exception {
        SunAndRain sar = new SunAndRain(2000, 12, 30, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
        Map<String, String> m = getMap(sar);
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));

        sar.addSun(new String[]{"30.12.2000", "20.12.3000", "12.12.1999"},new int[]{5, 8, 20});
        assertThat(m.size(), is(5));
        assertThat(m.get("30.12.2000"), is("sun 5h, rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));
        assertThat(m.get("20.12.3000"), is("sun 8h"));
        assertThat(m.get("12.12.1999"), is("sun 20h"));
    }

    public void testUnequalSize() throws Exception {

        SunAndRain sar = new SunAndRain(2000, 12, 30, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
        Map<String, String> m = getMap(sar);
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));

        sar.addSun(new String[]{"30.12.2000", "20.12.3000", "12.12.1999"},new int[]{5, 8});
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));

        sar.addSun(new String[]{"30.12.2000", "20.12.3000"}, new int[]{5, 8, 20});
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));

    }

    public void testGetYear() throws Exception {
        SunAndRain sar = new SunAndRain(2000, 12, 30, new LinkedList<Integer>(Arrays.asList(1, 2, 4)));
        Map<String, String> m = getMap(sar);
        assertThat(m.size(), is(3));
        assertThat(m.get("30.12.2000"), is("rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));

        sar.addSun(new String[]{"30.12.2000", "20.12.3000", "12.12.1999"},new int[]{5, 8, 20});
        SunAndRain sary = sar.getYear(2001);
        Map<String, String> my = getMap(sary);

        assertThat(m.size(), is(5));
        assertThat(m.get("30.12.2000"), is("sun 5h, rain 1h"));
        assertThat(m.get("1.1.2001"), is("rain 2h"));
        assertThat(m.get("2.1.2001"), is("rain 4h"));
        assertThat(m.get("20.12.3000"), is("sun 8h"));
        assertThat(m.get("12.12.1999"), is("sun 20h"));

        assertThat(my.size(), is(2));
        assertThat(my.get("1.1.2001"), is("rain 2h"));
        assertThat(my.get("2.1.2001"), is("rain 4h"));
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
    @Test
    public void test257() { TestCase.assertTrue(code < 257); }
    @Test
    public void test258() { TestCase.assertTrue(code < 258); }
    @Test
    public void test259() { TestCase.assertTrue(code < 259); }
    @Test
    public void test260() { TestCase.assertTrue(code < 260); }
    @Test
    public void test261() { TestCase.assertTrue(code < 261); }
    @Test
    public void test262() { TestCase.assertTrue(code < 262); }
    @Test
    public void test263() { TestCase.assertTrue(code < 263); }
    @Test
    public void test264() { TestCase.assertTrue(code < 264); }
    @Test
    public void test265() { TestCase.assertTrue(code < 265); }
    @Test
    public void test266() { TestCase.assertTrue(code < 266); }
    @Test
    public void test267() { TestCase.assertTrue(code < 267); }
    @Test
    public void test268() { TestCase.assertTrue(code < 268); }
    @Test
    public void test269() { TestCase.assertTrue(code < 269); }
    @Test
    public void test270() { TestCase.assertTrue(code < 270); }
    @Test
    public void test271() { TestCase.assertTrue(code < 271); }
    @Test
    public void test272() { TestCase.assertTrue(code < 272); }
    @Test
    public void test273() { TestCase.assertTrue(code < 273); }
    @Test
    public void test274() { TestCase.assertTrue(code < 274); }
    @Test
    public void test275() { TestCase.assertTrue(code < 275); }
    @Test
    public void test276() { TestCase.assertTrue(code < 276); }
    @Test
    public void test277() { TestCase.assertTrue(code < 277); }
    @Test
    public void test278() { TestCase.assertTrue(code < 278); }
    @Test
    public void test279() { TestCase.assertTrue(code < 279); }
    @Test
    public void test280() { TestCase.assertTrue(code < 280); }
    @Test
    public void test281() { TestCase.assertTrue(code < 281); }
    @Test
    public void test282() { TestCase.assertTrue(code < 282); }
    @Test
    public void test283() { TestCase.assertTrue(code < 283); }
    @Test
    public void test284() { TestCase.assertTrue(code < 284); }
    @Test
    public void test285() { TestCase.assertTrue(code < 285); }
    @Test
    public void test286() { TestCase.assertTrue(code < 286); }
    @Test
    public void test287() { TestCase.assertTrue(code < 287); }
    @Test
    public void test288() { TestCase.assertTrue(code < 288); }
    @Test
    public void test289() { TestCase.assertTrue(code < 289); }
    @Test
    public void test290() { TestCase.assertTrue(code < 290); }
    @Test
    public void test291() { TestCase.assertTrue(code < 291); }
    @Test
    public void test292() { TestCase.assertTrue(code < 292); }
    @Test
    public void test293() { TestCase.assertTrue(code < 293); }
    @Test
    public void test294() { TestCase.assertTrue(code < 294); }
    @Test
    public void test295() { TestCase.assertTrue(code < 295); }
    @Test
    public void test296() { TestCase.assertTrue(code < 296); }
    @Test
    public void test297() { TestCase.assertTrue(code < 297); }
    @Test
    public void test298() { TestCase.assertTrue(code < 298); }
    @Test
    public void test299() { TestCase.assertTrue(code < 299); }
    @Test
    public void test300() { TestCase.assertTrue(code < 300); }
    @Test
    public void test301() { TestCase.assertTrue(code < 301); }
    @Test
    public void test302() { TestCase.assertTrue(code < 302); }
    @Test
    public void test303() { TestCase.assertTrue(code < 303); }
    @Test
    public void test304() { TestCase.assertTrue(code < 304); }
    @Test
    public void test305() { TestCase.assertTrue(code < 305); }
    @Test
    public void test306() { TestCase.assertTrue(code < 306); }
    @Test
    public void test307() { TestCase.assertTrue(code < 307); }
    @Test
    public void test308() { TestCase.assertTrue(code < 308); }
    @Test
    public void test309() { TestCase.assertTrue(code < 309); }
    @Test
    public void test310() { TestCase.assertTrue(code < 310); }
    @Test
    public void test311() { TestCase.assertTrue(code < 311); }
    @Test
    public void test312() { TestCase.assertTrue(code < 312); }
    @Test
    public void test313() { TestCase.assertTrue(code < 313); }
    @Test
    public void test314() { TestCase.assertTrue(code < 314); }
    @Test
    public void test315() { TestCase.assertTrue(code < 315); }
    @Test
    public void test316() { TestCase.assertTrue(code < 316); }
    @Test
    public void test317() { TestCase.assertTrue(code < 317); }
    @Test
    public void test318() { TestCase.assertTrue(code < 318); }
    @Test
    public void test319() { TestCase.assertTrue(code < 319); }
    @Test
    public void test320() { TestCase.assertTrue(code < 320); }
    @Test
    public void test321() { TestCase.assertTrue(code < 321); }
    @Test
    public void test322() { TestCase.assertTrue(code < 322); }
    @Test
    public void test323() { TestCase.assertTrue(code < 323); }
    @Test
    public void test324() { TestCase.assertTrue(code < 324); }
    @Test
    public void test325() { TestCase.assertTrue(code < 325); }
    @Test
    public void test326() { TestCase.assertTrue(code < 326); }
    @Test
    public void test327() { TestCase.assertTrue(code < 327); }
    @Test
    public void test328() { TestCase.assertTrue(code < 328); }
    @Test
    public void test329() { TestCase.assertTrue(code < 329); }
    @Test
    public void test330() { TestCase.assertTrue(code < 330); }
    @Test
    public void test331() { TestCase.assertTrue(code < 331); }
    @Test
    public void test332() { TestCase.assertTrue(code < 332); }
    @Test
    public void test333() { TestCase.assertTrue(code < 333); }
    @Test
    public void test334() { TestCase.assertTrue(code < 334); }
    @Test
    public void test335() { TestCase.assertTrue(code < 335); }
    @Test
    public void test336() { TestCase.assertTrue(code < 336); }
    @Test
    public void test337() { TestCase.assertTrue(code < 337); }
    @Test
    public void test338() { TestCase.assertTrue(code < 338); }
    @Test
    public void test339() { TestCase.assertTrue(code < 339); }
    @Test
    public void test340() { TestCase.assertTrue(code < 340); }
    @Test
    public void test341() { TestCase.assertTrue(code < 341); }
    @Test
    public void test342() { TestCase.assertTrue(code < 342); }
    @Test
    public void test343() { TestCase.assertTrue(code < 343); }
    @Test
    public void test344() { TestCase.assertTrue(code < 344); }
    @Test
    public void test345() { TestCase.assertTrue(code < 345); }
    @Test
    public void test346() { TestCase.assertTrue(code < 346); }
    @Test
    public void test347() { TestCase.assertTrue(code < 347); }
    @Test
    public void test348() { TestCase.assertTrue(code < 348); }
    @Test
    public void test349() { TestCase.assertTrue(code < 349); }
    @Test
    public void test350() { TestCase.assertTrue(code < 350); }
    @Test
    public void test351() { TestCase.assertTrue(code < 351); }
    @Test
    public void test352() { TestCase.assertTrue(code < 352); }
    @Test
    public void test353() { TestCase.assertTrue(code < 353); }
    @Test
    public void test354() { TestCase.assertTrue(code < 354); }
    @Test
    public void test355() { TestCase.assertTrue(code < 355); }
    @Test
    public void test356() { TestCase.assertTrue(code < 356); }
    @Test
    public void test357() { TestCase.assertTrue(code < 357); }
    @Test
    public void test358() { TestCase.assertTrue(code < 358); }
    @Test
    public void test359() { TestCase.assertTrue(code < 359); }
    @Test
    public void test360() { TestCase.assertTrue(code < 360); }
    @Test
    public void test361() { TestCase.assertTrue(code < 361); }
    @Test
    public void test362() { TestCase.assertTrue(code < 362); }
    @Test
    public void test363() { TestCase.assertTrue(code < 363); }
    @Test
    public void test364() { TestCase.assertTrue(code < 364); }
    @Test
    public void test365() { TestCase.assertTrue(code < 365); }
    @Test
    public void test366() { TestCase.assertTrue(code < 366); }
    @Test
    public void test367() { TestCase.assertTrue(code < 367); }
    @Test
    public void test368() { TestCase.assertTrue(code < 368); }
    @Test
    public void test369() { TestCase.assertTrue(code < 369); }
    @Test
    public void test370() { TestCase.assertTrue(code < 370); }
    @Test
    public void test371() { TestCase.assertTrue(code < 371); }
    @Test
    public void test372() { TestCase.assertTrue(code < 372); }
    @Test
    public void test373() { TestCase.assertTrue(code < 373); }
    @Test
    public void test374() { TestCase.assertTrue(code < 374); }
    @Test
    public void test375() { TestCase.assertTrue(code < 375); }
    @Test
    public void test376() { TestCase.assertTrue(code < 376); }
    @Test
    public void test377() { TestCase.assertTrue(code < 377); }
    @Test
    public void test378() { TestCase.assertTrue(code < 378); }
    @Test
    public void test379() { TestCase.assertTrue(code < 379); }
    @Test
    public void test380() { TestCase.assertTrue(code < 380); }
    @Test
    public void test381() { TestCase.assertTrue(code < 381); }
    @Test
    public void test382() { TestCase.assertTrue(code < 382); }
    @Test
    public void test383() { TestCase.assertTrue(code < 383); }
    @Test
    public void test384() { TestCase.assertTrue(code < 384); }
    @Test
    public void test385() { TestCase.assertTrue(code < 385); }
    @Test
    public void test386() { TestCase.assertTrue(code < 386); }
    @Test
    public void test387() { TestCase.assertTrue(code < 387); }
    @Test
    public void test388() { TestCase.assertTrue(code < 388); }
    @Test
    public void test389() { TestCase.assertTrue(code < 389); }
    @Test
    public void test390() { TestCase.assertTrue(code < 390); }
    @Test
    public void test391() { TestCase.assertTrue(code < 391); }
    @Test
    public void test392() { TestCase.assertTrue(code < 392); }
    @Test
    public void test393() { TestCase.assertTrue(code < 393); }
    @Test
    public void test394() { TestCase.assertTrue(code < 394); }
    @Test
    public void test395() { TestCase.assertTrue(code < 395); }
    @Test
    public void test396() { TestCase.assertTrue(code < 396); }
    @Test
    public void test397() { TestCase.assertTrue(code < 397); }
    @Test
    public void test398() { TestCase.assertTrue(code < 398); }
    @Test
    public void test399() { TestCase.assertTrue(code < 399); }
    @Test
    public void test400() { TestCase.assertTrue(code < 400); }
    @Test
    public void test401() { TestCase.assertTrue(code < 401); }
    @Test
    public void test402() { TestCase.assertTrue(code < 402); }
    @Test
    public void test403() { TestCase.assertTrue(code < 403); }
    @Test
    public void test404() { TestCase.assertTrue(code < 404); }
    @Test
    public void test405() { TestCase.assertTrue(code < 405); }
    @Test
    public void test406() { TestCase.assertTrue(code < 406); }
    @Test
    public void test407() { TestCase.assertTrue(code < 407); }
    @Test
    public void test408() { TestCase.assertTrue(code < 408); }
    @Test
    public void test409() { TestCase.assertTrue(code < 409); }
    @Test
    public void test410() { TestCase.assertTrue(code < 410); }
    @Test
    public void test411() { TestCase.assertTrue(code < 411); }
    @Test
    public void test412() { TestCase.assertTrue(code < 412); }
    @Test
    public void test413() { TestCase.assertTrue(code < 413); }
    @Test
    public void test414() { TestCase.assertTrue(code < 414); }
    @Test
    public void test415() { TestCase.assertTrue(code < 415); }
    @Test
    public void test416() { TestCase.assertTrue(code < 416); }
    @Test
    public void test417() { TestCase.assertTrue(code < 417); }
    @Test
    public void test418() { TestCase.assertTrue(code < 418); }
    @Test
    public void test419() { TestCase.assertTrue(code < 419); }
    @Test
    public void test420() { TestCase.assertTrue(code < 420); }
    @Test
    public void test421() { TestCase.assertTrue(code < 421); }
    @Test
    public void test422() { TestCase.assertTrue(code < 422); }
    @Test
    public void test423() { TestCase.assertTrue(code < 423); }
    @Test
    public void test424() { TestCase.assertTrue(code < 424); }
    @Test
    public void test425() { TestCase.assertTrue(code < 425); }
    @Test
    public void test426() { TestCase.assertTrue(code < 426); }
    @Test
    public void test427() { TestCase.assertTrue(code < 427); }
    @Test
    public void test428() { TestCase.assertTrue(code < 428); }
    @Test
    public void test429() { TestCase.assertTrue(code < 429); }
    @Test
    public void test430() { TestCase.assertTrue(code < 430); }
    @Test
    public void test431() { TestCase.assertTrue(code < 431); }
    @Test
    public void test432() { TestCase.assertTrue(code < 432); }
    @Test
    public void test433() { TestCase.assertTrue(code < 433); }
    @Test
    public void test434() { TestCase.assertTrue(code < 434); }
    @Test
    public void test435() { TestCase.assertTrue(code < 435); }
    @Test
    public void test436() { TestCase.assertTrue(code < 436); }
    @Test
    public void test437() { TestCase.assertTrue(code < 437); }
    @Test
    public void test438() { TestCase.assertTrue(code < 438); }
    @Test
    public void test439() { TestCase.assertTrue(code < 439); }
    @Test
    public void test440() { TestCase.assertTrue(code < 440); }
    @Test
    public void test441() { TestCase.assertTrue(code < 441); }
    @Test
    public void test442() { TestCase.assertTrue(code < 442); }
    @Test
    public void test443() { TestCase.assertTrue(code < 443); }
    @Test
    public void test444() { TestCase.assertTrue(code < 444); }
    @Test
    public void test445() { TestCase.assertTrue(code < 445); }
    @Test
    public void test446() { TestCase.assertTrue(code < 446); }
    @Test
    public void test447() { TestCase.assertTrue(code < 447); }
    @Test
    public void test448() { TestCase.assertTrue(code < 448); }
    @Test
    public void test449() { TestCase.assertTrue(code < 449); }
    @Test
    public void test450() { TestCase.assertTrue(code < 450); }
    @Test
    public void test451() { TestCase.assertTrue(code < 451); }
    @Test
    public void test452() { TestCase.assertTrue(code < 452); }
    @Test
    public void test453() { TestCase.assertTrue(code < 453); }
    @Test
    public void test454() { TestCase.assertTrue(code < 454); }
    @Test
    public void test455() { TestCase.assertTrue(code < 455); }
    @Test
    public void test456() { TestCase.assertTrue(code < 456); }
    @Test
    public void test457() { TestCase.assertTrue(code < 457); }
    @Test
    public void test458() { TestCase.assertTrue(code < 458); }
    @Test
    public void test459() { TestCase.assertTrue(code < 459); }
    @Test
    public void test460() { TestCase.assertTrue(code < 460); }
    @Test
    public void test461() { TestCase.assertTrue(code < 461); }
    @Test
    public void test462() { TestCase.assertTrue(code < 462); }
    @Test
    public void test463() { TestCase.assertTrue(code < 463); }
    @Test
    public void test464() { TestCase.assertTrue(code < 464); }
    @Test
    public void test465() { TestCase.assertTrue(code < 465); }
    @Test
    public void test466() { TestCase.assertTrue(code < 466); }
    @Test
    public void test467() { TestCase.assertTrue(code < 467); }
    @Test
    public void test468() { TestCase.assertTrue(code < 468); }
    @Test
    public void test469() { TestCase.assertTrue(code < 469); }
    @Test
    public void test470() { TestCase.assertTrue(code < 470); }
    @Test
    public void test471() { TestCase.assertTrue(code < 471); }
    @Test
    public void test472() { TestCase.assertTrue(code < 472); }
    @Test
    public void test473() { TestCase.assertTrue(code < 473); }
    @Test
    public void test474() { TestCase.assertTrue(code < 474); }
    @Test
    public void test475() { TestCase.assertTrue(code < 475); }
    @Test
    public void test476() { TestCase.assertTrue(code < 476); }
    @Test
    public void test477() { TestCase.assertTrue(code < 477); }
    @Test
    public void test478() { TestCase.assertTrue(code < 478); }
    @Test
    public void test479() { TestCase.assertTrue(code < 479); }
    @Test
    public void test480() { TestCase.assertTrue(code < 480); }
    @Test
    public void test481() { TestCase.assertTrue(code < 481); }
    @Test
    public void test482() { TestCase.assertTrue(code < 482); }
    @Test
    public void test483() { TestCase.assertTrue(code < 483); }
    @Test
    public void test484() { TestCase.assertTrue(code < 484); }
    @Test
    public void test485() { TestCase.assertTrue(code < 485); }
    @Test
    public void test486() { TestCase.assertTrue(code < 486); }
    @Test
    public void test487() { TestCase.assertTrue(code < 487); }
    @Test
    public void test488() { TestCase.assertTrue(code < 488); }
    @Test
    public void test489() { TestCase.assertTrue(code < 489); }
    @Test
    public void test490() { TestCase.assertTrue(code < 490); }
    @Test
    public void test491() { TestCase.assertTrue(code < 491); }
    @Test
    public void test492() { TestCase.assertTrue(code < 492); }
    @Test
    public void test493() { TestCase.assertTrue(code < 493); }
    @Test
    public void test494() { TestCase.assertTrue(code < 494); }
    @Test
    public void test495() { TestCase.assertTrue(code < 495); }
    @Test
    public void test496() { TestCase.assertTrue(code < 496); }
    @Test
    public void test497() { TestCase.assertTrue(code < 497); }
    @Test
    public void test498() { TestCase.assertTrue(code < 498); }
    @Test
    public void test499() { TestCase.assertTrue(code < 499); }
    @Test
    public void test500() { TestCase.assertTrue(code < 500); }
    @Test
    public void test501() { TestCase.assertTrue(code < 501); }
    @Test
    public void test502() { TestCase.assertTrue(code < 502); }
    @Test
    public void test503() { TestCase.assertTrue(code < 503); }
    @Test
    public void test504() { TestCase.assertTrue(code < 504); }
    @Test
    public void test505() { TestCase.assertTrue(code < 505); }
    @Test
    public void test506() { TestCase.assertTrue(code < 506); }
    @Test
    public void test507() { TestCase.assertTrue(code < 507); }
    @Test
    public void test508() { TestCase.assertTrue(code < 508); }
    @Test
    public void test509() { TestCase.assertTrue(code < 509); }
    @Test
    public void test510() { TestCase.assertTrue(code < 510); }
    @Test
    public void test511() { TestCase.assertTrue(code < 511); }
    @Test
    public void test512() { TestCase.assertTrue(code < 512); }
    @Test
    public void test513() { TestCase.assertTrue(code < 513); }
    @Test
    public void test514() { TestCase.assertTrue(code < 514); }
    @Test
    public void test515() { TestCase.assertTrue(code < 515); }
    @Test
    public void test516() { TestCase.assertTrue(code < 516); }
    @Test
    public void test517() { TestCase.assertTrue(code < 517); }
    @Test
    public void test518() { TestCase.assertTrue(code < 518); }
    @Test
    public void test519() { TestCase.assertTrue(code < 519); }
    @Test
    public void test520() { TestCase.assertTrue(code < 520); }
    @Test
    public void test521() { TestCase.assertTrue(code < 521); }
    @Test
    public void test522() { TestCase.assertTrue(code < 522); }
    @Test
    public void test523() { TestCase.assertTrue(code < 523); }
    @Test
    public void test524() { TestCase.assertTrue(code < 524); }
    @Test
    public void test525() { TestCase.assertTrue(code < 525); }
    @Test
    public void test526() { TestCase.assertTrue(code < 526); }
    @Test
    public void test527() { TestCase.assertTrue(code < 527); }
    @Test
    public void test528() { TestCase.assertTrue(code < 528); }
    @Test
    public void test529() { TestCase.assertTrue(code < 529); }
    @Test
    public void test530() { TestCase.assertTrue(code < 530); }
    @Test
    public void test531() { TestCase.assertTrue(code < 531); }
    @Test
    public void test532() { TestCase.assertTrue(code < 532); }
    @Test
    public void test533() { TestCase.assertTrue(code < 533); }
    @Test
    public void test534() { TestCase.assertTrue(code < 534); }
    @Test
    public void test535() { TestCase.assertTrue(code < 535); }
    @Test
    public void test536() { TestCase.assertTrue(code < 536); }
    @Test
    public void test537() { TestCase.assertTrue(code < 537); }
    @Test
    public void test538() { TestCase.assertTrue(code < 538); }
    @Test
    public void test539() { TestCase.assertTrue(code < 539); }
    @Test
    public void test540() { TestCase.assertTrue(code < 540); }
    @Test
    public void test541() { TestCase.assertTrue(code < 541); }
    @Test
    public void test542() { TestCase.assertTrue(code < 542); }
    @Test
    public void test543() { TestCase.assertTrue(code < 543); }
    @Test
    public void test544() { TestCase.assertTrue(code < 544); }
    @Test
    public void test545() { TestCase.assertTrue(code < 545); }
    @Test
    public void test546() { TestCase.assertTrue(code < 546); }
    @Test
    public void test547() { TestCase.assertTrue(code < 547); }
    @Test
    public void test548() { TestCase.assertTrue(code < 548); }
    @Test
    public void test549() { TestCase.assertTrue(code < 549); }
    @Test
    public void test550() { TestCase.assertTrue(code < 550); }
    @Test
    public void test551() { TestCase.assertTrue(code < 551); }
    @Test
    public void test552() { TestCase.assertTrue(code < 552); }
    @Test
    public void test553() { TestCase.assertTrue(code < 553); }
    @Test
    public void test554() { TestCase.assertTrue(code < 554); }
    @Test
    public void test555() { TestCase.assertTrue(code < 555); }
    @Test
    public void test556() { TestCase.assertTrue(code < 556); }
    @Test
    public void test557() { TestCase.assertTrue(code < 557); }
    @Test
    public void test558() { TestCase.assertTrue(code < 558); }
    @Test
    public void test559() { TestCase.assertTrue(code < 559); }
    @Test
    public void test560() { TestCase.assertTrue(code < 560); }
    @Test
    public void test561() { TestCase.assertTrue(code < 561); }
    @Test
    public void test562() { TestCase.assertTrue(code < 562); }
    @Test
    public void test563() { TestCase.assertTrue(code < 563); }
    @Test
    public void test564() { TestCase.assertTrue(code < 564); }
    @Test
    public void test565() { TestCase.assertTrue(code < 565); }
    @Test
    public void test566() { TestCase.assertTrue(code < 566); }
    @Test
    public void test567() { TestCase.assertTrue(code < 567); }
    @Test
    public void test568() { TestCase.assertTrue(code < 568); }
    @Test
    public void test569() { TestCase.assertTrue(code < 569); }
    @Test
    public void test570() { TestCase.assertTrue(code < 570); }
    @Test
    public void test571() { TestCase.assertTrue(code < 571); }
    @Test
    public void test572() { TestCase.assertTrue(code < 572); }
    @Test
    public void test573() { TestCase.assertTrue(code < 573); }
    @Test
    public void test574() { TestCase.assertTrue(code < 574); }
    @Test
    public void test575() { TestCase.assertTrue(code < 575); }
    @Test
    public void test576() { TestCase.assertTrue(code < 576); }
    @Test
    public void test577() { TestCase.assertTrue(code < 577); }
    @Test
    public void test578() { TestCase.assertTrue(code < 578); }
    @Test
    public void test579() { TestCase.assertTrue(code < 579); }
    @Test
    public void test580() { TestCase.assertTrue(code < 580); }
    @Test
    public void test581() { TestCase.assertTrue(code < 581); }
    @Test
    public void test582() { TestCase.assertTrue(code < 582); }
    @Test
    public void test583() { TestCase.assertTrue(code < 583); }
    @Test
    public void test584() { TestCase.assertTrue(code < 584); }
    @Test
    public void test585() { TestCase.assertTrue(code < 585); }
    @Test
    public void test586() { TestCase.assertTrue(code < 586); }
    @Test
    public void test587() { TestCase.assertTrue(code < 587); }
    @Test
    public void test588() { TestCase.assertTrue(code < 588); }
    @Test
    public void test589() { TestCase.assertTrue(code < 589); }
    @Test
    public void test590() { TestCase.assertTrue(code < 590); }
    @Test
    public void test591() { TestCase.assertTrue(code < 591); }
    @Test
    public void test592() { TestCase.assertTrue(code < 592); }
    @Test
    public void test593() { TestCase.assertTrue(code < 593); }
    @Test
    public void test594() { TestCase.assertTrue(code < 594); }
    @Test
    public void test595() { TestCase.assertTrue(code < 595); }
    @Test
    public void test596() { TestCase.assertTrue(code < 596); }
    @Test
    public void test597() { TestCase.assertTrue(code < 597); }
    @Test
    public void test598() { TestCase.assertTrue(code < 598); }
    @Test
    public void test599() { TestCase.assertTrue(code < 599); }
    @Test
    public void test600() { TestCase.assertTrue(code < 600); }
    @Test
    public void test601() { TestCase.assertTrue(code < 601); }
    @Test
    public void test602() { TestCase.assertTrue(code < 602); }
    @Test
    public void test603() { TestCase.assertTrue(code < 603); }
    @Test
    public void test604() { TestCase.assertTrue(code < 604); }
    @Test
    public void test605() { TestCase.assertTrue(code < 605); }
    @Test
    public void test606() { TestCase.assertTrue(code < 606); }
    @Test
    public void test607() { TestCase.assertTrue(code < 607); }
    @Test
    public void test608() { TestCase.assertTrue(code < 608); }
    @Test
    public void test609() { TestCase.assertTrue(code < 609); }
    @Test
    public void test610() { TestCase.assertTrue(code < 610); }
    @Test
    public void test611() { TestCase.assertTrue(code < 611); }
    @Test
    public void test612() { TestCase.assertTrue(code < 612); }
    @Test
    public void test613() { TestCase.assertTrue(code < 613); }
    @Test
    public void test614() { TestCase.assertTrue(code < 614); }
    @Test
    public void test615() { TestCase.assertTrue(code < 615); }
    @Test
    public void test616() { TestCase.assertTrue(code < 616); }
    @Test
    public void test617() { TestCase.assertTrue(code < 617); }
    @Test
    public void test618() { TestCase.assertTrue(code < 618); }
    @Test
    public void test619() { TestCase.assertTrue(code < 619); }
    @Test
    public void test620() { TestCase.assertTrue(code < 620); }
    @Test
    public void test621() { TestCase.assertTrue(code < 621); }
    @Test
    public void test622() { TestCase.assertTrue(code < 622); }
    @Test
    public void test623() { TestCase.assertTrue(code < 623); }
    @Test
    public void test624() { TestCase.assertTrue(code < 624); }
    @Test
    public void test625() { TestCase.assertTrue(code < 625); }
    @Test
    public void test626() { TestCase.assertTrue(code < 626); }
    @Test
    public void test627() { TestCase.assertTrue(code < 627); }
    @Test
    public void test628() { TestCase.assertTrue(code < 628); }
    @Test
    public void test629() { TestCase.assertTrue(code < 629); }
    @Test
    public void test630() { TestCase.assertTrue(code < 630); }
    @Test
    public void test631() { TestCase.assertTrue(code < 631); }
    @Test
    public void test632() { TestCase.assertTrue(code < 632); }
    @Test
    public void test633() { TestCase.assertTrue(code < 633); }
    @Test
    public void test634() { TestCase.assertTrue(code < 634); }
    @Test
    public void test635() { TestCase.assertTrue(code < 635); }
    @Test
    public void test636() { TestCase.assertTrue(code < 636); }
    @Test
    public void test637() { TestCase.assertTrue(code < 637); }
    @Test
    public void test638() { TestCase.assertTrue(code < 638); }
    @Test
    public void test639() { TestCase.assertTrue(code < 639); }
    @Test
    public void test640() { TestCase.assertTrue(code < 640); }
    @Test
    public void test641() { TestCase.assertTrue(code < 641); }
    @Test
    public void test642() { TestCase.assertTrue(code < 642); }
    @Test
    public void test643() { TestCase.assertTrue(code < 643); }
    @Test
    public void test644() { TestCase.assertTrue(code < 644); }
    @Test
    public void test645() { TestCase.assertTrue(code < 645); }
    @Test
    public void test646() { TestCase.assertTrue(code < 646); }
    @Test
    public void test647() { TestCase.assertTrue(code < 647); }
    @Test
    public void test648() { TestCase.assertTrue(code < 648); }
    @Test
    public void test649() { TestCase.assertTrue(code < 649); }
    @Test
    public void test650() { TestCase.assertTrue(code < 650); }
    @Test
    public void test651() { TestCase.assertTrue(code < 651); }
    @Test
    public void test652() { TestCase.assertTrue(code < 652); }
    @Test
    public void test653() { TestCase.assertTrue(code < 653); }
    @Test
    public void test654() { TestCase.assertTrue(code < 654); }
    @Test
    public void test655() { TestCase.assertTrue(code < 655); }
    @Test
    public void test656() { TestCase.assertTrue(code < 656); }
    @Test
    public void test657() { TestCase.assertTrue(code < 657); }
    @Test
    public void test658() { TestCase.assertTrue(code < 658); }
    @Test
    public void test659() { TestCase.assertTrue(code < 659); }
    @Test
    public void test660() { TestCase.assertTrue(code < 660); }
    @Test
    public void test661() { TestCase.assertTrue(code < 661); }
    @Test
    public void test662() { TestCase.assertTrue(code < 662); }
    @Test
    public void test663() { TestCase.assertTrue(code < 663); }
    @Test
    public void test664() { TestCase.assertTrue(code < 664); }
    @Test
    public void test665() { TestCase.assertTrue(code < 665); }
    @Test
    public void test666() { TestCase.assertTrue(code < 666); }
    @Test
    public void test667() { TestCase.assertTrue(code < 667); }
    @Test
    public void test668() { TestCase.assertTrue(code < 668); }
    @Test
    public void test669() { TestCase.assertTrue(code < 669); }
    @Test
    public void test670() { TestCase.assertTrue(code < 670); }
    @Test
    public void test671() { TestCase.assertTrue(code < 671); }
    @Test
    public void test672() { TestCase.assertTrue(code < 672); }
    @Test
    public void test673() { TestCase.assertTrue(code < 673); }
    @Test
    public void test674() { TestCase.assertTrue(code < 674); }
    @Test
    public void test675() { TestCase.assertTrue(code < 675); }
    @Test
    public void test676() { TestCase.assertTrue(code < 676); }
    @Test
    public void test677() { TestCase.assertTrue(code < 677); }
    @Test
    public void test678() { TestCase.assertTrue(code < 678); }
    @Test
    public void test679() { TestCase.assertTrue(code < 679); }
    @Test
    public void test680() { TestCase.assertTrue(code < 680); }
    @Test
    public void test681() { TestCase.assertTrue(code < 681); }
    @Test
    public void test682() { TestCase.assertTrue(code < 682); }
    @Test
    public void test683() { TestCase.assertTrue(code < 683); }
    @Test
    public void test684() { TestCase.assertTrue(code < 684); }
    @Test
    public void test685() { TestCase.assertTrue(code < 685); }
    @Test
    public void test686() { TestCase.assertTrue(code < 686); }
    @Test
    public void test687() { TestCase.assertTrue(code < 687); }
    @Test
    public void test688() { TestCase.assertTrue(code < 688); }
    @Test
    public void test689() { TestCase.assertTrue(code < 689); }
    @Test
    public void test690() { TestCase.assertTrue(code < 690); }
    @Test
    public void test691() { TestCase.assertTrue(code < 691); }
    @Test
    public void test692() { TestCase.assertTrue(code < 692); }
    @Test
    public void test693() { TestCase.assertTrue(code < 693); }
    @Test
    public void test694() { TestCase.assertTrue(code < 694); }
    @Test
    public void test695() { TestCase.assertTrue(code < 695); }
    @Test
    public void test696() { TestCase.assertTrue(code < 696); }
    @Test
    public void test697() { TestCase.assertTrue(code < 697); }
    @Test
    public void test698() { TestCase.assertTrue(code < 698); }
    @Test
    public void test699() { TestCase.assertTrue(code < 699); }
    @Test
    public void test700() { TestCase.assertTrue(code < 700); }
    @Test
    public void test701() { TestCase.assertTrue(code < 701); }
    @Test
    public void test702() { TestCase.assertTrue(code < 702); }
    @Test
    public void test703() { TestCase.assertTrue(code < 703); }
    @Test
    public void test704() { TestCase.assertTrue(code < 704); }
    @Test
    public void test705() { TestCase.assertTrue(code < 705); }
    @Test
    public void test706() { TestCase.assertTrue(code < 706); }
    @Test
    public void test707() { TestCase.assertTrue(code < 707); }
    @Test
    public void test708() { TestCase.assertTrue(code < 708); }
    @Test
    public void test709() { TestCase.assertTrue(code < 709); }
    @Test
    public void test710() { TestCase.assertTrue(code < 710); }
    @Test
    public void test711() { TestCase.assertTrue(code < 711); }
    @Test
    public void test712() { TestCase.assertTrue(code < 712); }
    @Test
    public void test713() { TestCase.assertTrue(code < 713); }
    @Test
    public void test714() { TestCase.assertTrue(code < 714); }
    @Test
    public void test715() { TestCase.assertTrue(code < 715); }
    @Test
    public void test716() { TestCase.assertTrue(code < 716); }
    @Test
    public void test717() { TestCase.assertTrue(code < 717); }
    @Test
    public void test718() { TestCase.assertTrue(code < 718); }
    @Test
    public void test719() { TestCase.assertTrue(code < 719); }
    @Test
    public void test720() { TestCase.assertTrue(code < 720); }
    @Test
    public void test721() { TestCase.assertTrue(code < 721); }
    @Test
    public void test722() { TestCase.assertTrue(code < 722); }
    @Test
    public void test723() { TestCase.assertTrue(code < 723); }
    @Test
    public void test724() { TestCase.assertTrue(code < 724); }
    @Test
    public void test725() { TestCase.assertTrue(code < 725); }
    @Test
    public void test726() { TestCase.assertTrue(code < 726); }
    @Test
    public void test727() { TestCase.assertTrue(code < 727); }
    @Test
    public void test728() { TestCase.assertTrue(code < 728); }
    @Test
    public void test729() { TestCase.assertTrue(code < 729); }
    @Test
    public void test730() { TestCase.assertTrue(code < 730); }
    @Test
    public void test731() { TestCase.assertTrue(code < 731); }
    @Test
    public void test732() { TestCase.assertTrue(code < 732); }
    @Test
    public void test733() { TestCase.assertTrue(code < 733); }
    @Test
    public void test734() { TestCase.assertTrue(code < 734); }
    @Test
    public void test735() { TestCase.assertTrue(code < 735); }
    @Test
    public void test736() { TestCase.assertTrue(code < 736); }
    @Test
    public void test737() { TestCase.assertTrue(code < 737); }
    @Test
    public void test738() { TestCase.assertTrue(code < 738); }
    @Test
    public void test739() { TestCase.assertTrue(code < 739); }
    @Test
    public void test740() { TestCase.assertTrue(code < 740); }
    @Test
    public void test741() { TestCase.assertTrue(code < 741); }
    @Test
    public void test742() { TestCase.assertTrue(code < 742); }
    @Test
    public void test743() { TestCase.assertTrue(code < 743); }
    @Test
    public void test744() { TestCase.assertTrue(code < 744); }
    @Test
    public void test745() { TestCase.assertTrue(code < 745); }
    @Test
    public void test746() { TestCase.assertTrue(code < 746); }
    @Test
    public void test747() { TestCase.assertTrue(code < 747); }
    @Test
    public void test748() { TestCase.assertTrue(code < 748); }
    @Test
    public void test749() { TestCase.assertTrue(code < 749); }
    @Test
    public void test750() { TestCase.assertTrue(code < 750); }
    @Test
    public void test751() { TestCase.assertTrue(code < 751); }
    @Test
    public void test752() { TestCase.assertTrue(code < 752); }
    @Test
    public void test753() { TestCase.assertTrue(code < 753); }
    @Test
    public void test754() { TestCase.assertTrue(code < 754); }
    @Test
    public void test755() { TestCase.assertTrue(code < 755); }
    @Test
    public void test756() { TestCase.assertTrue(code < 756); }
    @Test
    public void test757() { TestCase.assertTrue(code < 757); }
    @Test
    public void test758() { TestCase.assertTrue(code < 758); }
    @Test
    public void test759() { TestCase.assertTrue(code < 759); }
    @Test
    public void test760() { TestCase.assertTrue(code < 760); }
    @Test
    public void test761() { TestCase.assertTrue(code < 761); }
    @Test
    public void test762() { TestCase.assertTrue(code < 762); }
    @Test
    public void test763() { TestCase.assertTrue(code < 763); }
    @Test
    public void test764() { TestCase.assertTrue(code < 764); }
    @Test
    public void test765() { TestCase.assertTrue(code < 765); }
    @Test
    public void test766() { TestCase.assertTrue(code < 766); }
    @Test
    public void test767() { TestCase.assertTrue(code < 767); }
    @Test
    public void test768() { TestCase.assertTrue(code < 768); }
    @Test
    public void test769() { TestCase.assertTrue(code < 769); }
    @Test
    public void test770() { TestCase.assertTrue(code < 770); }
    @Test
    public void test771() { TestCase.assertTrue(code < 771); }
    @Test
    public void test772() { TestCase.assertTrue(code < 772); }
    @Test
    public void test773() { TestCase.assertTrue(code < 773); }
    @Test
    public void test774() { TestCase.assertTrue(code < 774); }
    @Test
    public void test775() { TestCase.assertTrue(code < 775); }
    @Test
    public void test776() { TestCase.assertTrue(code < 776); }
    @Test
    public void test777() { TestCase.assertTrue(code < 777); }
    @Test
    public void test778() { TestCase.assertTrue(code < 778); }
    @Test
    public void test779() { TestCase.assertTrue(code < 779); }
    @Test
    public void test780() { TestCase.assertTrue(code < 780); }
    @Test
    public void test781() { TestCase.assertTrue(code < 781); }
    @Test
    public void test782() { TestCase.assertTrue(code < 782); }
    @Test
    public void test783() { TestCase.assertTrue(code < 783); }
    @Test
    public void test784() { TestCase.assertTrue(code < 784); }
    @Test
    public void test785() { TestCase.assertTrue(code < 785); }
    @Test
    public void test786() { TestCase.assertTrue(code < 786); }
    @Test
    public void test787() { TestCase.assertTrue(code < 787); }
    @Test
    public void test788() { TestCase.assertTrue(code < 788); }
    @Test
    public void test789() { TestCase.assertTrue(code < 789); }
    @Test
    public void test790() { TestCase.assertTrue(code < 790); }
    @Test
    public void test791() { TestCase.assertTrue(code < 791); }
    @Test
    public void test792() { TestCase.assertTrue(code < 792); }
    @Test
    public void test793() { TestCase.assertTrue(code < 793); }
    @Test
    public void test794() { TestCase.assertTrue(code < 794); }
    @Test
    public void test795() { TestCase.assertTrue(code < 795); }
    @Test
    public void test796() { TestCase.assertTrue(code < 796); }
    @Test
    public void test797() { TestCase.assertTrue(code < 797); }
    @Test
    public void test798() { TestCase.assertTrue(code < 798); }
    @Test
    public void test799() { TestCase.assertTrue(code < 799); }
    @Test
    public void test800() { TestCase.assertTrue(code < 800); }
    @Test
    public void test801() { TestCase.assertTrue(code < 801); }
    @Test
    public void test802() { TestCase.assertTrue(code < 802); }
    @Test
    public void test803() { TestCase.assertTrue(code < 803); }
    @Test
    public void test804() { TestCase.assertTrue(code < 804); }
    @Test
    public void test805() { TestCase.assertTrue(code < 805); }
    @Test
    public void test806() { TestCase.assertTrue(code < 806); }
    @Test
    public void test807() { TestCase.assertTrue(code < 807); }
    @Test
    public void test808() { TestCase.assertTrue(code < 808); }
    @Test
    public void test809() { TestCase.assertTrue(code < 809); }
    @Test
    public void test810() { TestCase.assertTrue(code < 810); }
    @Test
    public void test811() { TestCase.assertTrue(code < 811); }
    @Test
    public void test812() { TestCase.assertTrue(code < 812); }
    @Test
    public void test813() { TestCase.assertTrue(code < 813); }
    @Test
    public void test814() { TestCase.assertTrue(code < 814); }
    @Test
    public void test815() { TestCase.assertTrue(code < 815); }
    @Test
    public void test816() { TestCase.assertTrue(code < 816); }
    @Test
    public void test817() { TestCase.assertTrue(code < 817); }
    @Test
    public void test818() { TestCase.assertTrue(code < 818); }
    @Test
    public void test819() { TestCase.assertTrue(code < 819); }
    @Test
    public void test820() { TestCase.assertTrue(code < 820); }
    @Test
    public void test821() { TestCase.assertTrue(code < 821); }
    @Test
    public void test822() { TestCase.assertTrue(code < 822); }
    @Test
    public void test823() { TestCase.assertTrue(code < 823); }
    @Test
    public void test824() { TestCase.assertTrue(code < 824); }
    @Test
    public void test825() { TestCase.assertTrue(code < 825); }
    @Test
    public void test826() { TestCase.assertTrue(code < 826); }
    @Test
    public void test827() { TestCase.assertTrue(code < 827); }
    @Test
    public void test828() { TestCase.assertTrue(code < 828); }
    @Test
    public void test829() { TestCase.assertTrue(code < 829); }
    @Test
    public void test830() { TestCase.assertTrue(code < 830); }
    @Test
    public void test831() { TestCase.assertTrue(code < 831); }
    @Test
    public void test832() { TestCase.assertTrue(code < 832); }
    @Test
    public void test833() { TestCase.assertTrue(code < 833); }
    @Test
    public void test834() { TestCase.assertTrue(code < 834); }
    @Test
    public void test835() { TestCase.assertTrue(code < 835); }
    @Test
    public void test836() { TestCase.assertTrue(code < 836); }
    @Test
    public void test837() { TestCase.assertTrue(code < 837); }
    @Test
    public void test838() { TestCase.assertTrue(code < 838); }
    @Test
    public void test839() { TestCase.assertTrue(code < 839); }
    @Test
    public void test840() { TestCase.assertTrue(code < 840); }
    @Test
    public void test841() { TestCase.assertTrue(code < 841); }
    @Test
    public void test842() { TestCase.assertTrue(code < 842); }
    @Test
    public void test843() { TestCase.assertTrue(code < 843); }
    @Test
    public void test844() { TestCase.assertTrue(code < 844); }
    @Test
    public void test845() { TestCase.assertTrue(code < 845); }
    @Test
    public void test846() { TestCase.assertTrue(code < 846); }
    @Test
    public void test847() { TestCase.assertTrue(code < 847); }
    @Test
    public void test848() { TestCase.assertTrue(code < 848); }
    @Test
    public void test849() { TestCase.assertTrue(code < 849); }
    @Test
    public void test850() { TestCase.assertTrue(code < 850); }
    @Test
    public void test851() { TestCase.assertTrue(code < 851); }
    @Test
    public void test852() { TestCase.assertTrue(code < 852); }
    @Test
    public void test853() { TestCase.assertTrue(code < 853); }
    @Test
    public void test854() { TestCase.assertTrue(code < 854); }
    @Test
    public void test855() { TestCase.assertTrue(code < 855); }
    @Test
    public void test856() { TestCase.assertTrue(code < 856); }
    @Test
    public void test857() { TestCase.assertTrue(code < 857); }
    @Test
    public void test858() { TestCase.assertTrue(code < 858); }
    @Test
    public void test859() { TestCase.assertTrue(code < 859); }
    @Test
    public void test860() { TestCase.assertTrue(code < 860); }
    @Test
    public void test861() { TestCase.assertTrue(code < 861); }
    @Test
    public void test862() { TestCase.assertTrue(code < 862); }
    @Test
    public void test863() { TestCase.assertTrue(code < 863); }
    @Test
    public void test864() { TestCase.assertTrue(code < 864); }
    @Test
    public void test865() { TestCase.assertTrue(code < 865); }
    @Test
    public void test866() { TestCase.assertTrue(code < 866); }
    @Test
    public void test867() { TestCase.assertTrue(code < 867); }
    @Test
    public void test868() { TestCase.assertTrue(code < 868); }
    @Test
    public void test869() { TestCase.assertTrue(code < 869); }
    @Test
    public void test870() { TestCase.assertTrue(code < 870); }
    @Test
    public void test871() { TestCase.assertTrue(code < 871); }
    @Test
    public void test872() { TestCase.assertTrue(code < 872); }
    @Test
    public void test873() { TestCase.assertTrue(code < 873); }
    @Test
    public void test874() { TestCase.assertTrue(code < 874); }
    @Test
    public void test875() { TestCase.assertTrue(code < 875); }
    @Test
    public void test876() { TestCase.assertTrue(code < 876); }
    @Test
    public void test877() { TestCase.assertTrue(code < 877); }
    @Test
    public void test878() { TestCase.assertTrue(code < 878); }
    @Test
    public void test879() { TestCase.assertTrue(code < 879); }
    @Test
    public void test880() { TestCase.assertTrue(code < 880); }
    @Test
    public void test881() { TestCase.assertTrue(code < 881); }
    @Test
    public void test882() { TestCase.assertTrue(code < 882); }
    @Test
    public void test883() { TestCase.assertTrue(code < 883); }
    @Test
    public void test884() { TestCase.assertTrue(code < 884); }
    @Test
    public void test885() { TestCase.assertTrue(code < 885); }
    @Test
    public void test886() { TestCase.assertTrue(code < 886); }
    @Test
    public void test887() { TestCase.assertTrue(code < 887); }
    @Test
    public void test888() { TestCase.assertTrue(code < 888); }
    @Test
    public void test889() { TestCase.assertTrue(code < 889); }
    @Test
    public void test890() { TestCase.assertTrue(code < 890); }
    @Test
    public void test891() { TestCase.assertTrue(code < 891); }
    @Test
    public void test892() { TestCase.assertTrue(code < 892); }
    @Test
    public void test893() { TestCase.assertTrue(code < 893); }
    @Test
    public void test894() { TestCase.assertTrue(code < 894); }
    @Test
    public void test895() { TestCase.assertTrue(code < 895); }
    @Test
    public void test896() { TestCase.assertTrue(code < 896); }
    @Test
    public void test897() { TestCase.assertTrue(code < 897); }
    @Test
    public void test898() { TestCase.assertTrue(code < 898); }
    @Test
    public void test899() { TestCase.assertTrue(code < 899); }
    @Test
    public void test900() { TestCase.assertTrue(code < 900); }
    @Test
    public void test901() { TestCase.assertTrue(code < 901); }
    @Test
    public void test902() { TestCase.assertTrue(code < 902); }
    @Test
    public void test903() { TestCase.assertTrue(code < 903); }
    @Test
    public void test904() { TestCase.assertTrue(code < 904); }
    @Test
    public void test905() { TestCase.assertTrue(code < 905); }
    @Test
    public void test906() { TestCase.assertTrue(code < 906); }
    @Test
    public void test907() { TestCase.assertTrue(code < 907); }
    @Test
    public void test908() { TestCase.assertTrue(code < 908); }
    @Test
    public void test909() { TestCase.assertTrue(code < 909); }
    @Test
    public void test910() { TestCase.assertTrue(code < 910); }
    @Test
    public void test911() { TestCase.assertTrue(code < 911); }
    @Test
    public void test912() { TestCase.assertTrue(code < 912); }
    @Test
    public void test913() { TestCase.assertTrue(code < 913); }
    @Test
    public void test914() { TestCase.assertTrue(code < 914); }
    @Test
    public void test915() { TestCase.assertTrue(code < 915); }
    @Test
    public void test916() { TestCase.assertTrue(code < 916); }
    @Test
    public void test917() { TestCase.assertTrue(code < 917); }
    @Test
    public void test918() { TestCase.assertTrue(code < 918); }
    @Test
    public void test919() { TestCase.assertTrue(code < 919); }
    @Test
    public void test920() { TestCase.assertTrue(code < 920); }
    @Test
    public void test921() { TestCase.assertTrue(code < 921); }
    @Test
    public void test922() { TestCase.assertTrue(code < 922); }
    @Test
    public void test923() { TestCase.assertTrue(code < 923); }
    @Test
    public void test924() { TestCase.assertTrue(code < 924); }
    @Test
    public void test925() { TestCase.assertTrue(code < 925); }
    @Test
    public void test926() { TestCase.assertTrue(code < 926); }
    @Test
    public void test927() { TestCase.assertTrue(code < 927); }
    @Test
    public void test928() { TestCase.assertTrue(code < 928); }
    @Test
    public void test929() { TestCase.assertTrue(code < 929); }
    @Test
    public void test930() { TestCase.assertTrue(code < 930); }
    @Test
    public void test931() { TestCase.assertTrue(code < 931); }
    @Test
    public void test932() { TestCase.assertTrue(code < 932); }
    @Test
    public void test933() { TestCase.assertTrue(code < 933); }
    @Test
    public void test934() { TestCase.assertTrue(code < 934); }
    @Test
    public void test935() { TestCase.assertTrue(code < 935); }
    @Test
    public void test936() { TestCase.assertTrue(code < 936); }
    @Test
    public void test937() { TestCase.assertTrue(code < 937); }
    @Test
    public void test938() { TestCase.assertTrue(code < 938); }
    @Test
    public void test939() { TestCase.assertTrue(code < 939); }
    @Test
    public void test940() { TestCase.assertTrue(code < 940); }
    @Test
    public void test941() { TestCase.assertTrue(code < 941); }
    @Test
    public void test942() { TestCase.assertTrue(code < 942); }
    @Test
    public void test943() { TestCase.assertTrue(code < 943); }
    @Test
    public void test944() { TestCase.assertTrue(code < 944); }
    @Test
    public void test945() { TestCase.assertTrue(code < 945); }
    @Test
    public void test946() { TestCase.assertTrue(code < 946); }
    @Test
    public void test947() { TestCase.assertTrue(code < 947); }
    @Test
    public void test948() { TestCase.assertTrue(code < 948); }
    @Test
    public void test949() { TestCase.assertTrue(code < 949); }
    @Test
    public void test950() { TestCase.assertTrue(code < 950); }
    @Test
    public void test951() { TestCase.assertTrue(code < 951); }
    @Test
    public void test952() { TestCase.assertTrue(code < 952); }
    @Test
    public void test953() { TestCase.assertTrue(code < 953); }
    @Test
    public void test954() { TestCase.assertTrue(code < 954); }
    @Test
    public void test955() { TestCase.assertTrue(code < 955); }
    @Test
    public void test956() { TestCase.assertTrue(code < 956); }
    @Test
    public void test957() { TestCase.assertTrue(code < 957); }
    @Test
    public void test958() { TestCase.assertTrue(code < 958); }
    @Test
    public void test959() { TestCase.assertTrue(code < 959); }
    @Test
    public void test960() { TestCase.assertTrue(code < 960); }
    @Test
    public void test961() { TestCase.assertTrue(code < 961); }
    @Test
    public void test962() { TestCase.assertTrue(code < 962); }
    @Test
    public void test963() { TestCase.assertTrue(code < 963); }
    @Test
    public void test964() { TestCase.assertTrue(code < 964); }
    @Test
    public void test965() { TestCase.assertTrue(code < 965); }
    @Test
    public void test966() { TestCase.assertTrue(code < 966); }
    @Test
    public void test967() { TestCase.assertTrue(code < 967); }
    @Test
    public void test968() { TestCase.assertTrue(code < 968); }
    @Test
    public void test969() { TestCase.assertTrue(code < 969); }
    @Test
    public void test970() { TestCase.assertTrue(code < 970); }
    @Test
    public void test971() { TestCase.assertTrue(code < 971); }
    @Test
    public void test972() { TestCase.assertTrue(code < 972); }
    @Test
    public void test973() { TestCase.assertTrue(code < 973); }
    @Test
    public void test974() { TestCase.assertTrue(code < 974); }
    @Test
    public void test975() { TestCase.assertTrue(code < 975); }
    @Test
    public void test976() { TestCase.assertTrue(code < 976); }
    @Test
    public void test977() { TestCase.assertTrue(code < 977); }
    @Test
    public void test978() { TestCase.assertTrue(code < 978); }
    @Test
    public void test979() { TestCase.assertTrue(code < 979); }
    @Test
    public void test980() { TestCase.assertTrue(code < 980); }
    @Test
    public void test981() { TestCase.assertTrue(code < 981); }
    @Test
    public void test982() { TestCase.assertTrue(code < 982); }
    @Test
    public void test983() { TestCase.assertTrue(code < 983); }
    @Test
    public void test984() { TestCase.assertTrue(code < 984); }
    @Test
    public void test985() { TestCase.assertTrue(code < 985); }
    @Test
    public void test986() { TestCase.assertTrue(code < 986); }
    @Test
    public void test987() { TestCase.assertTrue(code < 987); }
    @Test
    public void test988() { TestCase.assertTrue(code < 988); }
    @Test
    public void test989() { TestCase.assertTrue(code < 989); }
    @Test
    public void test990() { TestCase.assertTrue(code < 990); }
    @Test
    public void test991() { TestCase.assertTrue(code < 991); }
    @Test
    public void test992() { TestCase.assertTrue(code < 992); }
    @Test
    public void test993() { TestCase.assertTrue(code < 993); }
    @Test
    public void test994() { TestCase.assertTrue(code < 994); }
    @Test
    public void test995() { TestCase.assertTrue(code < 995); }
    @Test
    public void test996() { TestCase.assertTrue(code < 996); }
    @Test
    public void test997() { TestCase.assertTrue(code < 997); }
    @Test
    public void test998() { TestCase.assertTrue(code < 998); }
    @Test
    public void test999() { TestCase.assertTrue(code < 999); }
    @Test
    public void test1000() { TestCase.assertTrue(code < 1000); }
    @Test
    public void test1001() { TestCase.assertTrue(code < 1001); }
    @Test
    public void test1002() { TestCase.assertTrue(code < 1002); }
    @Test
    public void test1003() { TestCase.assertTrue(code < 1003); }
    @Test
    public void test1004() { TestCase.assertTrue(code < 1004); }
    @Test
    public void test1005() { TestCase.assertTrue(code < 1005); }
    @Test
    public void test1006() { TestCase.assertTrue(code < 1006); }
    @Test
    public void test1007() { TestCase.assertTrue(code < 1007); }
    @Test
    public void test1008() { TestCase.assertTrue(code < 1008); }
    @Test
    public void test1009() { TestCase.assertTrue(code < 1009); }
    @Test
    public void test1010() { TestCase.assertTrue(code < 1010); }
    @Test
    public void test1011() { TestCase.assertTrue(code < 1011); }
    @Test
    public void test1012() { TestCase.assertTrue(code < 1012); }
    @Test
    public void test1013() { TestCase.assertTrue(code < 1013); }
    @Test
    public void test1014() { TestCase.assertTrue(code < 1014); }
    @Test
    public void test1015() { TestCase.assertTrue(code < 1015); }
    @Test
    public void test1016() { TestCase.assertTrue(code < 1016); }
    @Test
    public void test1017() { TestCase.assertTrue(code < 1017); }
    @Test
    public void test1018() { TestCase.assertTrue(code < 1018); }
    @Test
    public void test1019() { TestCase.assertTrue(code < 1019); }
    @Test
    public void test1020() { TestCase.assertTrue(code < 1020); }
    @Test
    public void test1021() { TestCase.assertTrue(code < 1021); }
    @Test
    public void test1022() { TestCase.assertTrue(code < 1022); }
    @Test
    public void test1023() { TestCase.assertTrue(code < 1023); }
    @Test
    public void test1024() { TestCase.assertTrue(code < 1024); }


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