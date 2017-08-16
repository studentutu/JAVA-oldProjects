
/*

Hier ist ein Beispiel für die wesentlichen Teile einer Lösung:

    public static int countCharLinesInFile(char c, String filePath) {
        int count = 0;
        try {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(filePath));
                String s;
                while ((s = in.readLine()) != null) {
                    if (s.length() > 0 && s.charAt(0) == c) {
                        count++;
                    }
                }
            }
            finally {
                if (in != null) {
                    in.close();
                }
            }
        }
        catch (IOException x) {
            System.err.println("cannot read file");
            count = 0;
        }
        return count;
    }

    public static void indentedLines(String filePath) {
        System.out.println(filePath + ": " + countCharLinesInFile(' ', filePath));
    }

    public static void main(String[] args) {
        for (String s : args) {
            indentedLines(s);
        }
    }

***********************************************************************************/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class IOAndExceptions {

    /*
    Aufgabe:
        Ergänzen Sie fehlende Teile der Methoden entsprechend den Kommentaren an den mit TODO gekennzeichneten Stellen.

    Punkte (maximal 15):
        9 Punkte für countCharLinesInFile,
        3 Punkte für indentedLines,
        3 Punkte für main.
        Auch für teilweise korrekte Lösungen werden Punkte vergeben.
    */

    // Returns the number of lines that begin with the character c in the file filePath (has to be opened for reading);
    // on return the file is closed;  if the file does not exist or cannot be read, the string "cannot read file" is
    // written to the standard error stream (Standardfehlerausgabe) and 0 is returned.
    public static int countCharLinesInFile(char c, String filePath) {
        // TODO: Implementation is your task
        // Note: You have to open and close the file and handle exceptions related to I/O errors.

    }


    // Prints a line of the following form to the standard output stream (Standardausgabe):
    //     <filePath>: <number>
    // <filePath> is the content of the parameter, and <number> is the number of indented lines in the file filePath
    // as returned by an appropriate call of countCharLinesInFile;
    // a line is indented if it begins with the blank character ' '.
    public static void indentedLines(String filePath) {
        // TODO: Implementation is your task

    }

    // Calls indentedLines once for each command line argument (Programmparameter);
    // each command line argument is assumed to specify the name or path of a file.
    public static void main(String[] args) {
        // TODO: Implementation is your task


    }


}

