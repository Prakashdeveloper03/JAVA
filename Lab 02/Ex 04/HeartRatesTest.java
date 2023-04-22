import java.util.Scanner;

public class HeartRatesTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter your birth day (1-31): ");
        int birthDay = input.nextInt();
        System.out.print("Enter your birth month (1-12): ");
        int birthMonth = input.nextInt();
        System.out.print("Enter your birth year (4-digit format): ");
        int birthYear = input.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, birthMonth, birthDay, birthYear);

        System.out.println("\nFirst Name: " + person.getFirstName());
        System.out.println("Last Name: " + person.getLastName());
        System.out.println("Date of Birth: " + person.getBirthMonth() + "/" + person.getBirthDay() + "/" + person.getBirthYear());
        System.out.println("Age: " + person.calculates() + " years");
        System.out.println("Maximum Heart Rate: " + person.maximumHeartRate() + " bpm");
        System.out.println("Target Heart Rate Range: " + person.calculateTargetHeartRateRange() + " bpm");
    }
}