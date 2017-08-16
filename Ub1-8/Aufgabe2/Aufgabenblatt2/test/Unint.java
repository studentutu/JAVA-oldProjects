import java.util.Scanner;

public class Unint {
  public static void main(String[] args) {
    Scanner nu = new Scanner(System.in);
    int sum = 0;
    boolean err = false;
    while (nu.hasNext()) {
      try { int ans = nu.nextInt();

      System.out.print("Enter a number: ");
          if (ans == 0)
            break;
          System.out.println("Got the int: " + ans);
          sum += ans;
     
      } catch (java.util.InputMismatchException e) {
          err = true;
          nu.next();
//          break;
      }
    }
  }
}
