import java.util.Scanner;

public class Q07 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number 1: ");
    int num1 = sc.nextInt();
    System.out.print("Enter the number 2: ");
    int num2 = sc.nextInt();
    int sum = num1 + num2;
    int product = num1 * num2;
    int difference = num1 - num2;
    int quotient = num1 / num2;
    sc.close();
    System.out.printf("Sum: %d%n", sum);
    System.out.printf("Product: %d%n", product);
    System.out.printf("Difference: %d%n", difference);
    System.out.printf("Quotient: %d%n", quotient);
  }
}
