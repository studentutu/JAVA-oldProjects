import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class Aufgabe5Test {
    private static int points;
    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @BeforeClass
    public static void calcPoints(){
        points = 0;
        points += (Questions2.o38294638() == -1) ? 1: (Questions2.o38294638() == 0) ? 0 : -1;
        points += (Questions2.o67284372() == 1) ? 1: (Questions2.o67284372() == 0) ? 0 : -1;
        points += (Questions2.o91048263() == 1) ? 1: (Questions2.o91048263() == 0) ? 0 : -1;
        points += (Questions2.o53753291() == -1) ? 1: (Questions2.o53753291() == 0) ? 0 : -1;
        points += (Questions2.o19283728() == -1) ? 1: (Questions2.o19283728() == 0) ? 0 : -1;
    }

    @Test
    public void test1(){
        TestCase.assertTrue(points >= 1);
    }
    @Test
    public void test2(){
        TestCase.assertTrue(points >= 2);
    }
    @Test
    public void test3(){
        TestCase.assertTrue(points >= 3);
    }
    @Test
    public void test4(){
        TestCase.assertTrue(points >= 4);
    }
    @Test
    public void test5(){
        TestCase.assertTrue(points == 5);
    }
}
