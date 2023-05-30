import javax.swing.JOptionPane;

class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
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

	@Override
	public String toString() {
		return String.format("%s: %s %s%n%s: %s", "employee", firstName, lastName,
				"social security number", socialSecurityNumber);
	}
}

class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		this.grossSales = grossSales;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		this.commissionRate = commissionRate;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public double earnings() {
		return commissionRate * grossSales;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s: %.2f%n%s: %.2f", super.toString(), "gross sales", grossSales,
				"commission rate", commissionRate);
	}
}

public class CommissionEmployeeTest {
	public static void main(String[] args) {
		String firstName = JOptionPane.showInputDialog("Enter employee's first name:");
		String lastName = JOptionPane.showInputDialog("Enter employee's last name:");
		String socialSecurityNumber = JOptionPane.showInputDialog("Enter employee's social security number:");
		String grossSalesStr = JOptionPane.showInputDialog("Enter employee's gross sales:");
		String commissionRateStr = JOptionPane.showInputDialog("Enter employee's commission rate:");
		double grossSales = Double.parseDouble(grossSalesStr);
		double commissionRate = Double.parseDouble(commissionRateStr);
		CommissionEmployee employee = new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales,
				commissionRate);
		String output = "Employee information obtained by get methods:\n\n" + "First name is " + employee.getFirstName()
				+ "\nLast name is " + employee.getLastName() + "\nSocial security number is "
				+ employee.getSocialSecurityNumber() + "\nGross sales is " + employee.getGrossSales()
				+ "\nCommission rate is " + employee.getCommissionRate();

		JOptionPane.showMessageDialog(null, output);
		String newGrossSalesStr = JOptionPane.showInputDialog("Enter new gross sales:");
		String newCommissionRateStr = JOptionPane.showInputDialog("Enter new commission rate:");
		double newGrossSales = Double.parseDouble(newGrossSalesStr);
		double newCommissionRate = Double.parseDouble(newCommissionRateStr);
		employee.setGrossSales(newGrossSales);
		employee.setCommissionRate(newCommissionRate);
		String updatedOutput = "Updated employee information obtained by toString:\n\n" + employee.toString();
		JOptionPane.showMessageDialog(null, updatedOutput);
	}
}
