import javax.swing.JOptionPane;

class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
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
	
	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}

	@Override
	public String toString() {
		return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}

class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);

		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
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

	@Override
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}

	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "commission employee", super.toString(), "gross sales",
				getGrossSales(), "commission rate", getCommissionRate());
	}
}

abstract class Employee {
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
		return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(),
				getSocialSecurityNumber());
	}

	public abstract double earnings();
}

class PieceWorker extends Employee {
	private double wage;
	private int pieces;
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces) {
		super(firstName, lastName, socialSecurityNumber);
		if (wage < 0.0) {
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}
		if (pieces < 0) {
			throw new IllegalArgumentException("Number of piece must be >= 0");
		}
		this.wage = wage;
		this.pieces = pieces;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if (wage < 0.0) {
			throw new IllegalArgumentException("Wage per piece must be >= 0.0");
		}

		this.wage = wage;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	@Override
	public double earnings() {
		return getWage() * getPieces();
	}

	@Override
	public String toString() {
		return String.format("piece worker: %s%n%s: $%,.2f; %s: %d", super.toString(), "piece wage", getWage(),
				"number of pieces", getPieces());
	}
}

class SalariedEmployee extends Employee {
	private double weeklySalary;
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}
		this.weeklySalary = weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}
		this.weeklySalary = weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	@Override
	public double earnings() {
		return getWeeklySalary();
	}

	@Override
	public String toString() {
		return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
	}
}


class HourlyEmployee extends Employee {
	private double wage;
	private double hours;
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);
		if (wage < 0.0) {
			throw new IllegalArgumentException("Piece wage must be >= 0.0");
		}

		if ((hours < 0.0) || (hours > 168.0)) {
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}
		this.wage = wage;
		this.hours = hours;
	}

	public void setWage(double wage) {
		if (wage < 0.0) {
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		this.wage = wage;
	}

	public double getWage() {
		return wage;
	}

	public void setHours(double hours) {
		if ((hours < 0.0) || (hours > 168.0)) {
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}
		this.hours = hours;
	}

	public double getHours() {
		return hours;
	}

	@Override
	public double earnings() {
		if (getHours() <= 40) {
			return getWage() * getHours();
		} else {
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
		}
	}

	@Override
	public String toString() {
		return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", getWage(),
				"hours worked", getHours());
	}
}

public class PayrollSystemTest {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        for (int i = 0; i < employees.length; i++) {
            String firstName = JOptionPane.showInputDialog("Enter first name for employee " + (i+1) + ":");
            String lastName = JOptionPane.showInputDialog("Enter last name for employee " + (i+1) + ":");
            String ssn = JOptionPane.showInputDialog("Enter social security number for employee " + (i+1) + ":");

            int type = JOptionPane.showOptionDialog(null, "Select the type of employee for " + firstName + " " + lastName,
                    "Select Employee Type", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    new String[] { "Salaried", "Hourly", "Commission", "Base Plus Commission", "Pieceworker" }, 0);

            switch (type) {
                case 0:
                    double weeklySalary = Double.parseDouble(JOptionPane.showInputDialog("Enter weekly salary for " + firstName + " " + lastName));
                    employees[i] = new SalariedEmployee(firstName, lastName, ssn, weeklySalary);
                    break;
                case 1:
                    double hourlyWage = Double.parseDouble(JOptionPane.showInputDialog("Enter hourly wage for " + firstName + " " + lastName));
                    double hoursWorked = Double.parseDouble(JOptionPane.showInputDialog("Enter hours worked for " + firstName + " " + lastName));
                    employees[i] = new HourlyEmployee(firstName, lastName, ssn, hourlyWage, hoursWorked);
                    break;
                case 2:
                    double grossSales = Double.parseDouble(JOptionPane.showInputDialog("Enter gross sales for " + firstName + " " + lastName));
                    double commissionRate = Double.parseDouble(JOptionPane.showInputDialog("Enter commission rate for " + firstName + " " + lastName));
                    employees[i] = new CommissionEmployee(firstName, lastName, ssn, grossSales, commissionRate);
                    break;
                case 3:
                    grossSales = Double.parseDouble(JOptionPane.showInputDialog("Enter gross sales for " + firstName + " " + lastName));
                    commissionRate = Double.parseDouble(JOptionPane.showInputDialog("Enter commission rate for " + firstName + " " + lastName));
                    double baseSalary = Double.parseDouble(JOptionPane.showInputDialog("Enter base salary for " + firstName + " " + lastName));
                    employees[i] = new BasePlusCommissionEmployee(firstName, lastName, ssn, grossSales, commissionRate, baseSalary);
                    break;
                case 4:
                    double piecesProduced = Double.parseDouble(JOptionPane.showInputDialog("Enter number of pieces produced for " + firstName + " " + lastName));
                    double wagePerPiece = Double.parseDouble(JOptionPane.showInputDialog("Enter wage per piece for " + firstName + " " + lastName));
                    employees[i] = new PieceWorker(firstName, lastName, ssn, piecesProduced, wagePerPiece);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Employees processed polymorphically:\n\n");

        for (Employee employee : employees) {
            sb.append(employee).append("\n");
            sb.append("earned $").append(String.format("%.2f", employee.earnings())).append("\n\n");

            if (employee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employeeWithBaseSalary = (BasePlusCommissionEmployee) employee;
                employeeWithBaseSalary.setBaseSalary(1.10 * employeeWithBaseSalary.getBaseSalary());
sb.append("new base salary with 10% increase is: $").append(String.format("%.2f", employeeWithBaseSalary.getBaseSalary())).append("\n");
}
        sb.append("Employee ").append(j).append(" is a ").append(employee.getClass().getSimpleName()).append("\n");
    }

    JTextArea outputArea = new JTextArea(sb.toString());
    JOptionPane.showMessageDialog(null, new JScrollPane(outputArea));
}}