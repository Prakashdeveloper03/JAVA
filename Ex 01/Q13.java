import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number 1: ");
        int number1 = sc.nextInt();
        System.out.print("Enter the number 2: ");
        int number2 = sc.nextInt();
        if (number1 % number2 == 0) {
            System.out.printf("%d is a multiple of %d.%n", number1, number2);
        } else {
            System.out.printf("%d is not a multiple of %d.%n", number1, number2);
        }
        sc.close();
    }
}
