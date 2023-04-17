import java.util.Scanner;

public class Q04 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number 1: ");
    int x = sc.nextInt();
    System.out.print("Enter the number 2: ");
    int y = sc.nextInt();
    System.out.print("Enter the number 3: ");
    int z = sc.nextInt();
    int result = x * y * z;
    System.out.printf("Product of %d, %d & %d is %d%n", x, y, z, result);
    sc.close();
  }
}
