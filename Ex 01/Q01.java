import java.util.Scanner;

public class Q01 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int value = sc.nextInt();
    System.out.println("You entered: " + value);
    sc.close();
  }
}