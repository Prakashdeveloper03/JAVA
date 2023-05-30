import javax.swing.JOptionPane;

class BasePlusCommissionEmployee {
	private CommissionEmployee commissionEmployee;
	private double baseSalary;
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		commissionEmployee = new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales,
				commissionRate);
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
	}

	public CommissionEmployee getCommissionEmployee() {
		return commissionEmployee;
	}

	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public double earnings() {
		return getBaseSalary() + commissionEmployee.earnings();
	}

	@Override
	public String toString() {
		return String.format("%s %s%n%s: %.2f", "base-salaried", commissionEmployee, "base salary", getBaseSalary());
	}
}

 class CommissionEmployee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private double grossSales;
	private double commissionRate;
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
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
		return getCommissionRate() * getGrossSales();
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "commission employee", getFirstName(),
				getLastName(), "social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(),
				"commission rate", getCommissionRate());
	}
}

public class BasePlusCommissionEmployeeTest {
	public static void main(String[] args) {
		String firstName = JOptionPane.showInputDialog("Enter employee's first name:");
		String lastName = JOptionPane.showInputDialog("Enter employee's last name:");
		String socialSecurityNumber = JOptionPane.showInputDialog("Enter employee's social security number:");
		String grossSalesStr = JOptionPane.showInputDialog("Enter employee's gross sales:");
		String commissionRateStr = JOptionPane.showInputDialog("Enter employee's commission rate:");
		String baseSalaryStr = JOptionPane.showInputDialog("Enter employee's base salary:");
		double grossSales = Double.parseDouble(grossSalesStr);
		double commissionRate = Double.parseDouble(commissionRateStr);
		double baseSalary = Double.parseDouble(baseSalaryStr);
		BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(firstName, lastName, socialSecurityNumber,
				grossSales, commissionRate, baseSalary);
		String output = "Employee information obtained by get methods:\n\n" + "First name is "
				+ employee.getCommissionEmployee().getFirstName() + "\nLast name is "
				+ employee.getCommissionEmployee().getLastName() + "\nSocial security number is "
				+ employee.getCommissionEmployee().getSocialSecurityNumber() + "\nGross sales is "
				+ employee.getCommissionEmployee().getGrossSales() + "\nCommission rate is "
				+ employee.getCommissionEmployee().getCommissionRate() + "\nBase salary is " + employee.getBaseSalary();

		JOptionPane.showMessageDialog(null, output);
		String newBaseSalaryStr = JOptionPane.showInputDialog("Enter new base salary:");
		double newBaseSalary = Double.parseDouble(newBaseSalaryStr);
		employee.setBaseSalary(newBaseSalary);
		String updatedOutput = "Updated employee information obtained by toString:\n\n" + employee.toString();
		JOptionPane.showMessageDialog(null, updatedOutput);
	}
}