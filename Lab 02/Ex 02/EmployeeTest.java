import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name of employee 1: ");
        String firstName1 = input.nextLine();
        System.out.print("Enter last name of employee 1: ");
        String lastName1 = input.nextLine();
        System.out.print("Enter monthly salary of employee 1: ");
        double monthlySalary1 = input.nextDouble();
        System.out.print("Enter first name of employee 2: ");
        String firstName2 = input.nextLine();
        input.nextLine();
        System.out.print("Enter last name of employee 2: ");
        String lastName2 = input.nextLine();
        System.out.print("Enter monthly salary of employee 2: ");
        double monthlySalary2 = input.nextDouble();

        Employee emp1 = new Employee(firstName1, lastName1, monthlySalary1);
        Employee emp2 = new Employee(firstName2, lastName2, monthlySalary2);
        
        System.out.printf("%s %s's yearly salary is $%.2f\n", emp1.getFirstName(), emp1.getLastName(), emp1.getYearlySalary());
        System.out.printf("%s %s's yearly salary is $%.2f\n", emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());
        emp1.raiseSalary(10);
        emp2.raiseSalary(10);
        System.out.printf("%s %s's yearly salary after a 10%% raise is $%.2f\n", emp1.getFirstName(), emp1.getLastName(), emp1.getYearlySalary());
        System.out.printf("%s %s's yearly salary after a 10%% raise is $%.2f\n", emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());
        input.close();
    }
}
