import java.util.Scanner;

public class Q08 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number 1: ");
    int num1 = sc.nextInt();
    System.out.print("Enter the number 2: ");
    int num2 = sc.nextInt();
    if (num1 > num2) {
      System.out.printf("%d is larger%n", num1);
    } else if (num2 > num1) {
      System.out.printf("%d is larger%n", num2);
    } else {
      System.out.println("These numbers are equal");
    }
    sc.close();
  }
}
