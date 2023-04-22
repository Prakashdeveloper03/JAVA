import java.util.Scanner;

public class Q09 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number 1: ");
    int num1 = sc.nextInt();
    System.out.print("Enter the number 2: ");
    int num2 = sc.nextInt();
    System.out.print("Enter the number 3: ");
    int num3 = sc.nextInt();

    int sum = num1 + num2 + num3;
    double average = sum / 3.0;
    int product = num1 * num2 * num3;

    int smallest = num1;
    if (num2 < smallest) {
      smallest = num2;
    }
    if (num3 < smallest) {
      smallest = num3;
    }

    int largest = num1;
    if (num2 > largest) {
      largest = num2;
    }
    if (num3 > largest) {
      largest = num3;
    }

    sc.close();
    System.out.printf("Sum: %d%n", sum);
    System.out.printf("Average: %.2f%n", average);
    System.out.printf("Product: %d%n", product);
    System.out.printf("Smallest: %d%n", smallest);
    System.out.printf("Largest: %d%n", largest);
  }
}