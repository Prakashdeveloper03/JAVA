import java.util.Scanner;

public class Q05 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number 1: ");
    int b = sc.nextInt();
    System.out.print("Enter the number 2: ");
    int c = sc.nextInt();
    int a = b * c;
    System.out.println("The product of b and c is " + a);
    sc.close();
  }
}
