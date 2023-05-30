import javax.swing.JOptionPane;

class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private CompensationModel compensationModel;

	public Employee(String firstName, String lastName, String socialSecurityNumber,
			CompensationModel compensationModel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.compensationModel = compensationModel;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setCompensationModel(CompensationModel compensationModel) {
		this.compensationModel = compensationModel;
	}

	public double earnings() {
		return compensationModel.earnings();
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s %.2f", "employee", firstName, lastName, "social security number",
				socialSecurityNumber, "earnings", earnings());
	}
}

class CompensationModel {
	public double earnings() {
		return 0.0;
	}
}

class BasePlusCommissionCompensationModel extends CompensationModel {
	private double grossSales;
	private double commissionRate;
	private double baseSalary;
	public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, double baseSalary) {
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
		this.baseSalary = baseSalary;
	}

	@Override
	public double earnings() {
		return baseSalary + grossSales * commissionRate;
	}
}

class CommissionCompensationModel extends CompensationModel {
	private double grossSales;
	private double commissionRate;

	public CommissionCompensationModel(double grossSales, double commissionRate) {
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	@Override
	public double earnings() {
		return grossSales * commissionRate;
	}
}

public class Test {
	public static void main(String[] args) {
		String firstName1 = JOptionPane.showInputDialog(null, "Enter first name of employee 1:");
		String lastName1 = JOptionPane.showInputDialog(null, "Enter last name of employee 1:");
		String ssn1 = JOptionPane.showInputDialog(null, "Enter social security number of employee 1:");
		double grossSales1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter gross sales of employee 1:"));
		double commissionRate1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter commission rate of employee 1:"));
		
		Employee employee1 = new Employee(firstName1, lastName1, ssn1, new CommissionCompensationModel(grossSales1, commissionRate1));
		
		String firstName2 = JOptionPane.showInputDialog(null, "Enter first name of employee 2:");
		String lastName2 = JOptionPane.showInputDialog(null, "Enter last name of employee 2:");
		String ssn2 = JOptionPane.showInputDialog(null, "Enter social security number of employee 2:");
		double grossSales2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter gross sales of employee 2:"));
		double commissionRate2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter commission rate of employee 2:"));
		double baseSalary2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter base salary of employee 2:"));
		
		Employee employee2 = new Employee(firstName2, lastName2, ssn2,
				new BasePlusCommissionCompensationModel(grossSales2, commissionRate2, baseSalary2));

		JOptionPane.showMessageDialog(null, employee1.toString() + "\n\n" + employee2.toString());

		double newGrossSales2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter new gross sales for employee 2:"));
		double newCommissionRate2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter new commission rate for employee 2:"));

		employee2.setCompensationModel(new CommissionCompensationModel(newGrossSales2, newCommissionRate2));

		JOptionPane.showMessageDialog(null, employee2.toString());
	}
}