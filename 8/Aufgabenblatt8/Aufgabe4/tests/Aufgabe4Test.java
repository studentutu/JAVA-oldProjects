import org.junit.Rule;
import org.junit.Test;

import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

public class Aufgabe4Test {

    @Rule
    public Timeout globalTimeout = new Timeout(500);

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testCheckForExit() throws Exception {

        String[] myMaze1 = new String[15];
        myMaze1[0] =  "***************";
        myMaze1[1] =  "*     *       *";
        myMaze1[2] =  "***** *    *  *";
        myMaze1[3] =  "*   * ******* *";
        myMaze1[4] =  "*             *";
        myMaze1[5] =  "***********   *";
        myMaze1[6] =  "*             *";
        myMaze1[7] =  "* ***  ****   *";
        myMaze1[8] =  "    *     *   *";
        myMaze1[9] =  "***** *****   *";
        myMaze1[10] = "*        *    *";
        myMaze1[11] = "* ********** **";
        myMaze1[12] = "*        *    *";
        myMaze1[13] = "*    *        *";
        myMaze1[14] = "***************";

        String[] myMaze2 = new String[15];
        myMaze2[0] =  "******* *******";
        myMaze2[1] =  "*     *       *";
        myMaze2[2] =  "*** * *    *  *";
        myMaze2[3] =  "*   * ******* *";
        myMaze2[4] =  "*   *         *";
        myMaze2[5] =  "* *************";
        myMaze2[6] =  "*   *         *";
        myMaze2[7] =  "*** *  ***** **";
        myMaze2[8] =  "*         *   *";
        myMaze2[9] =  "***********   *";
        myMaze2[10] = "*             *";
        myMaze2[11] = "* *************";
        myMaze2[12] = "*        *    *";
        myMaze2[13] = "*    *        *";
        myMaze2[14] = "***************";

        String[] myMaze3 = new String[15];
        myMaze3[0] =  "***************";
        myMaze3[1] =  "*     *       *";
        myMaze3[2] =  "*** * *    *  *";
        myMaze3[3] =  "*   * ******* *";
        myMaze3[4] =  "*   *         *";
        myMaze3[5] =  "* *************";
        myMaze3[6] =  "*   *         *";
        myMaze3[7] =  "*** *  ***** **";
        myMaze3[8] =  "*         *   *";
        myMaze3[9] =  "***********   *";
        myMaze3[10] = "*             *";
        myMaze3[11] = "* *************";
        myMaze3[12] = "*        *    *";
        myMaze3[13] = "*    *        *";
        myMaze3[14] = "***************";

        Maze myTestSolver = new Maze(myMaze1);
        assertThat("Labyrinth sollte einen Ausgang haben!", myTestSolver.checkForExit(3, 13, 0), is(true));

        myTestSolver = new Maze(myMaze2);
        assertThat("Labyrinth sollte einen Ausgang haben!", myTestSolver.checkForExit(5, 12, 0), is(true));

        myTestSolver = new Maze(myMaze3);
        assertThat("Labyrinth sollte keinen Ausgang aufweisen!", myTestSolver.checkForExit(4, 1, 0), is(false));
    }

    @Test
    public void testDumpMaze() throws Exception {

        String[] myMaze = new String[15];
        myMaze[0] =  "***************";
        myMaze[1] =  "*     *       *";
        myMaze[2] =  "*** * *    *  *";
        myMaze[3] =  "*   * ******* *";
        myMaze[4] =  "*   *         *";
        myMaze[5] =  "* *************";
        myMaze[6] =  "*   *         *";
        myMaze[7] =  "*** *  ***** **";
        myMaze[8] =  "*         *   *";
        myMaze[9] =  "***********   *";
        myMaze[10] = "*             *";
        myMaze[11] = "* *************";
        myMaze[12] = "*        *    *";
        myMaze[13] = "*    *        *";
        myMaze[14] = "***************";

        String[] testValues = new String[]{ "***************",
                                            "*.....*.......*",
                                            "***.*.*....*..*",
                                            "*...*.*******.*",
                                            "*...*.........*",
                                            "*.*************",
                                            "*...*.........*",
                                            "***.*..*****.**",
                                            "*.........*...*",
                                            "***********...*",
                                            "*.............*",
                                            "*.*************",
                                            "*........*....*",
                                            "*..S.*........*",
                                            "***************"};

        StringBuilder testString = new StringBuilder();
        for(String i: testValues) {
            testString.append(i).append(System.lineSeparator());
        }

        Maze myTestSolver = new Maze(myMaze);
        myTestSolver.checkForExit(3, 13, 0);
        myTestSolver.dumpMaze();
        assertEquals(testString.toString(), log.getLog());
    }
}
