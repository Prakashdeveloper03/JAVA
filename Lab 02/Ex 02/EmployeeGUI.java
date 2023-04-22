import javax.swing.*;

public class EmployeeGUI {
    public static void main(String[] args) {
        String firstName1 = JOptionPane.showInputDialog(null, "Enter first name of employee 1:");
        String lastName1 = JOptionPane.showInputDialog(null, "Enter last name of employee 1:");
        String salary1String = JOptionPane.showInputDialog(null, "Enter monthly salary of employee 1:");
        double salary1 = Double.parseDouble(salary1String);
        String firstName2 = JOptionPane.showInputDialog(null, "Enter first name of employee 2:");
        String lastName2 = JOptionPane.showInputDialog(null, "Enter last name of employee 2:");
        String salary2String = JOptionPane.showInputDialog(null, "Enter monthly salary of employee 2:");
        double salary2 = Double.parseDouble(salary2String);
        Employee emp1 = new Employee(firstName1, lastName1, salary1);
        Employee emp2 = new Employee(firstName2, lastName2, salary2);
        String output = String.format("%s %s's yearly salary is $%.2f\n", emp1.getFirstName(), emp1.getLastName(), emp1.getYearlySalary()) +
                        String.format("%s %s's yearly salary is $%.2f\n", emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());
        JOptionPane.showMessageDialog(null, output);
        emp1.raiseSalary(10);
        emp2.raiseSalary(10);
        output = String.format("%s %s's yearly salary after a 10%% raise is $%.2f\n", emp1.getFirstName(), emp1.getLastName(), emp1.getYearlySalary()) +
                 String.format("%s %s's yearly salary after a 10%% raise is $%.2f\n", emp2.getFirstName(), emp2.getLastName(), emp2.getYearlySalary());
        JOptionPane.showMessageDialog(null, output);
    }
}