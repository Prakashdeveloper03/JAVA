import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        int radius = sc.nextInt();
        sc.close();
        System.out.printf("Diameter: %.2f%n", 2.0 * radius);
        System.out.printf("Circumference: %.2f%n", 2.0 * 3.14159 * radius);
        System.out.printf("Area: %.2f%n", 3.14159 * radius * radius);
    }
}
