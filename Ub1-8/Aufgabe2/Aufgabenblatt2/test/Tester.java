import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            scan.next();
            System.out.println("Has next: ");
            if (scan.hasNextInt())
                System.out.println("Integer");
            else
                System.out.println("Not an int");
        }
        System.out.println("End of the loop");
    }
}
