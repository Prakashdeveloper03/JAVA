import javax.swing.JOptionPane;

class Employee {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;

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
		return String.format("First name: %s%nLast name: %s%nSocial security number: %s%n", getFirstName(),
				getLastName(), getSocialSecurityNumber());
	}
}

class HourlyEmployee extends Employee {
	private double hours;
	private double wage;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);

		if (hours < 0 || hours > 168)
			throw new IllegalArgumentException("The hours must be between 0 and 168");

		if (wage < 0)
			throw new IllegalArgumentException("Wage must be >= 0.0");

		this.hours = hours;
		this.wage = wage;
	}

	public double earnings() {
		return getHours() * getWage();
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		if (hours < 0 || hours > 168)
			throw new IllegalArgumentException("The hours must be between 0 and 168");

		this.hours = hours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if (wage < 0)
			throw new IllegalArgumentException("Wage must be >= 0.0");

		this.wage = wage;
	}

	@Override
	public String toString() {
		return String.format("%sHours: %,.2f%nWage: %,.2f", super.toString(), getHours(), getWage());
	}
}

public class HourlyEmployeeTest {
	public static void main(String[] args) {
		String firstName = JOptionPane.showInputDialog("Enter employee's first name:");
		String lastName = JOptionPane.showInputDialog("Enter employee's last name:");
		String socialSecurityNumber = JOptionPane.showInputDialog("Enter employee's social security number:");
		String hoursStr = JOptionPane.showInputDialog("Enter employee's hours:");
		String wageStr = JOptionPane.showInputDialog("Enter employee's wage:");
		double hours = Double.parseDouble(hoursStr);
		double wage = Double.parseDouble(wageStr);
		HourlyEmployee employee = new HourlyEmployee(firstName, lastName, socialSecurityNumber, hours, wage);
		String output = "Employee information obtained by get methods:\n\n" + "First name is " + employee.getFirstName()
				+ "\nLast name is " + employee.getLastName() + "\nSocial security number is "
				+ employee.getSocialSecurityNumber() + "\nHours is " + employee.getHours() + "\nWage is "
				+ employee.getWage();

		JOptionPane.showMessageDialog(null, output);
		String newHoursStr = JOptionPane.showInputDialog("Enter new hours:");
		String newWageStr = JOptionPane.showInputDialog("Enter new wage:");
		double newHours = Double.parseDouble(newHoursStr);
		double newWage = Double.parseDouble(newWageStr);
		employee.setHours(newHours);
		employee.setWage(newWage);
		String updatedOutput = "Updated employee information obtained by toString:\n\n" + employee.toString();
		JOptionPane.showMessageDialog(null, updatedOutput);
	}
}