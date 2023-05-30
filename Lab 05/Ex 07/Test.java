interface CompensationModel {
	public abstract double earnings();
}

class BasePlusCommissionCompensationModel implements CompensationModel {
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

class CommissionCompensationModel implements CompensationModel {
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

class HourlyCompensationModel implements CompensationModel {
	private double wage;
	private double hours;

	public HourlyCompensationModel(double wage, double hours) {
		this.wage = wage;
		this.hours = hours;
	}

	@Override
	public double earnings() {
		if (hours <= 40) {
			return wage * hours;
		} else {
			return 40 * wage + (hours - 40) * wage * 1.5;
		}
	}

}

class SalariedCompensationModel implements CompensationModel {
	private double weeklySalary;

	public SalariedCompensationModel(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	@Override
	public double earnings() {
		return weeklySalary;
	}
}

public class Test {
    public static void main(String[] args) {
        String firstName1 = JOptionPane.showInputDialog(null, "Enter first name for employee 1:");
        String lastName1 = JOptionPane.showInputDialog(null, "Enter last name for employee 1:");
        String ssn1 = JOptionPane.showInputDialog(null, "Enter social security number for employee 1:");
        String salary1Str = JOptionPane.showInputDialog(null, "Enter salary for employee 1:");
        double salary1 = Double.parseDouble(salary1Str);
        Employee employee1 = new Employee(firstName1, lastName1, ssn1, new SalariedCompensationModel(salary1));

        String firstName2 = JOptionPane.showInputDialog(null, "Enter first name for employee 2:");
        String lastName2 = JOptionPane.showInputDialog(null, "Enter last name for employee 2:");
        String ssn2 = JOptionPane.showInputDialog(null, "Enter social security number for employee 2:");
        String hourlyRateStr = JOptionPane.showInputDialog(null, "Enter hourly rate for employee 2:");
        double hourlyRate = Double.parseDouble(hourlyRateStr);
        String hoursWorkedStr = JOptionPane.showInputDialog(null, "Enter hours worked for employee 2:");
        double hoursWorked = Double.parseDouble(hoursWorkedStr);
        Employee employee2 = new Employee(firstName2, lastName2, ssn2, new HourlyCompensationModel(hourlyRate, hoursWorked));

        String firstName3 = JOptionPane.showInputDialog(null, "Enter first name for employee 3:");
        String lastName3 = JOptionPane.showInputDialog(null, "Enter last name for employee 3:");
        String ssn3 = JOptionPane.showInputDialog(null, "Enter social security number for employee 3:");
        String salesStr = JOptionPane.showInputDialog(null, "Enter sales for employee 3:");
        double sales = Double.parseDouble(salesStr);
        String commissionRateStr = JOptionPane.showInputDialog(null, "Enter commission rate for employee 3:");
        double commissionRate = Double.parseDouble(commissionRateStr);
        Employee employee3 = new Employee(firstName3, lastName3, ssn3, new CommissionCompensationModel(sales, commissionRate));

        String firstName4 = JOptionPane.showInputDialog(null, "Enter first name for employee 4:");
        String lastName4 = JOptionPane.showInputDialog(null, "Enter last name for employee 4:");
        String ssn4 = JOptionPane.showInputDialog(null, "Enter social security number for employee 4:");
        String sales4Str = JOptionPane.showInputDialog(null, "Enter sales for employee 4:");
        double sales4 = Double.parseDouble(sales4Str);
        String commissionRate4Str = JOptionPane.showInputDialog(null, "Enter commission rate for employee 4:");
        double commissionRate4 = Double.parseDouble(commissionRate4Str);
        String baseSalary4Str = JOptionPane.showInputDialog(null, "Enter base salary for employee 4:");
        double baseSalary4 = Double.parseDouble(baseSalary4Str);
        Employee employee4 = new Employee(firstName4, lastName4, ssn4, new BasePlusCommissionCompensationModel(sales4, commissionRate4, baseSalary4));

        JOptionPane.showMessageDialog(null, employee1);
        JOptionPane.showMessageDialog(null, employee2);
        JOptionPane.showMessageDialog(null, employee3);
        JOptionPane.showMessageDialog(null, employee4);
        employee2.setCompensationModel(new CommissionCompensationModel(10000, .06));
        JOptionPane.showMessageDialog(null, employee2);
    }
}

