import java.util.Scanner;

public class Q11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number 1: ");
    int num1 = sc.nextInt();
    System.out.print("Enter the number 2: ");
    int num2 = sc.nextInt();
    System.out.print("Enter the number 3: ");
    int num3 = sc.nextInt();
    System.out.print("Enter the number 4: ");
    int num4 = sc.nextInt();
    System.out.print("Enter the number 5: ");
    int num5 = sc.nextInt();

    int smallest = num1;
    if (num2 < smallest) {
      smallest = num2;
    }
    if (num3 < smallest) {
      smallest = num3;
    }
    if (num4 < smallest) {
      smallest = num4;
    }
    if (num5 < smallest) {
      smallest = num5;
    }

    int largest = num1;
    if (num2 > largest) {
      largest = num2;
    }
    if (num3 > largest) {
      largest = num3;
    }
    if (num4 > largest) {
      largest = num4;
    }
    if (num5 > largest) {
      largest = num5;
    }

    sc.close();
    System.out.printf("Smallest: %d%n", smallest);
    System.out.printf("Largest: %d%n", largest);
  }
}