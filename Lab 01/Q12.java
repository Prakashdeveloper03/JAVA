import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an number: ");
        int number = sc.nextInt();
        if (number % 2 == 0) {
            System.out.printf("%d is even.%n", number);
        } else {
            System.out.printf("%d is odd.%n", number);
        }
        sc.close();
    }
}
