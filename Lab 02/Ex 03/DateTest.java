import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the day: ");
        int day = input.nextInt();
        System.out.print("Enter the month: ");
        int month = input.nextInt();
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        Date date = new Date(month, day, year);
        date.displayDate();
        input.close();
    }
}