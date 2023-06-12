import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "postgres";
        String databaseName = "company";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            dropDatabase(connection, databaseName);
            createDatabase(connection, databaseName);
            connection.close();
            url = "jdbc:postgresql://localhost:5432/company";
            connection = DriverManager.getConnection(url, username, password);
            createTables(connection);
            insertEmployeeData(connection);
            displayEmployeeData(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDatabase(Connection connection, String databaseName) throws SQLException {
        String createDatabaseQuery = "CREATE DATABASE " + databaseName;
        Statement statement = connection.createStatement();
        statement.executeUpdate(createDatabaseQuery);
        System.out.println("Database created: " + databaseName);
    }

    private static void dropDatabase(Connection connection, String databaseName) throws SQLException {
        String dropDatabaseQuery = "DROP DATABASE IF EXISTS " + databaseName;
        Statement statement = connection.createStatement();
        statement.executeUpdate(dropDatabaseQuery);
        System.out.println("Database dropped: " + databaseName);
    }

    private static void createTables(Connection connection) throws SQLException {
        String createEmployeesTable = "CREATE TABLE employees (socialSecurityNumber varchar(30) NOT NULL, firstName varchar(30) NOT NULL, lastName varchar(30) NOT NULL, birthday date NOT NULL, employeeType varchar(30) NOT NULL, departmentName varchar(30) NOT NULL, PRIMARY KEY (socialSecurityNumber))";
        String createSalariedEmployeesTable = "CREATE TABLE salariedEmployees (socialSecurityNumber varchar(30) NOT NULL, weeklySalary real NOT NULL, bonus real, PRIMARY KEY (socialSecurityNumber), FOREIGN KEY (socialSecurityNumber) REFERENCES employees (socialSecurityNumber))";
        String createCommissionEmployeesTable = "CREATE TABLE commissionEmployees (socialSecurityNumber varchar(30) NOT NULL, grossSales int NOT NULL, commissionRate real NOT NULL, bonus real, PRIMARY KEY (socialSecurityNumber), FOREIGN KEY (socialSecurityNumber) REFERENCES employees (socialSecurityNumber))";
        String createBasePlusCommissionEmployeesTable = "CREATE TABLE basePlusCommissionEmployees (socialSecurityNumber varchar(30) NOT NULL, grossSales int NOT NULL, commissionRate real NOT NULL, baseSalary real NOT NULL, bonus real, PRIMARY KEY (socialSecurityNumber), FOREIGN KEY (socialSecurityNumber) REFERENCES employees (socialSecurityNumber))";
        String createHourlyEmployeesTable = "CREATE TABLE hourlyEmployees (socialSecurityNumber varchar(30) NOT NULL, hours int NOT NULL, wage real NOT NULL, bonus real, PRIMARY KEY (socialSecurityNumber), FOREIGN KEY (socialSecurityNumber) REFERENCES employees (socialSecurityNumber))";
        Statement statement = connection.createStatement();
        statement.executeUpdate(createEmployeesTable);
        statement.executeUpdate(createSalariedEmployeesTable);
        statement.executeUpdate(createCommissionEmployeesTable);
        statement.executeUpdate(createBasePlusCommissionEmployeesTable);
        statement.executeUpdate(createHourlyEmployeesTable);
    }

    private static void insertEmployeeData(Connection connection) throws SQLException {
        String ssn = JOptionPane.showInputDialog("Enter Social Security Number:");
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");
        String birthday = JOptionPane.showInputDialog("Enter Birthday (YYYY-MM-DD):");
        String employeeType = (String) JOptionPane.showInputDialog(null, "Select Employee Type:", "Employee Type", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Salaried", "Commission", "Base Plus Commission", "Hourly"}, "Salaried");
        String departmentName = JOptionPane.showInputDialog("Enter Department Name:");
        String insertEmployeeQuery = "INSERT INTO employees (socialSecurityNumber, firstName, lastName, birthday, employeeType, departmentName) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement insertEmployeeStatement = connection.prepareStatement(insertEmployeeQuery);
        insertEmployeeStatement.setString(1, ssn);
        insertEmployeeStatement.setString(2, firstName);
        insertEmployeeStatement.setString(3, lastName);
        insertEmployeeStatement.setDate(4, Date.valueOf(birthday));
        insertEmployeeStatement.setString(5, employeeType);
        insertEmployeeStatement.setString(6, departmentName);
        insertEmployeeStatement.executeUpdate();
        switch (employeeType) {
            case "Salaried": {
                double weeklySalary = Double.parseDouble(JOptionPane.showInputDialog("Enter Weekly Salary:"));
                double bonus = Double.parseDouble(JOptionPane.showInputDialog("Enter Bonus:"));
                String insertSalariedEmployeeQuery = "INSERT INTO salariedEmployees (socialSecurityNumber, weeklySalary, bonus) VALUES (?, ?, ?)";
                PreparedStatement insertSalariedEmployeeStatement = connection.prepareStatement(insertSalariedEmployeeQuery);
                insertSalariedEmployeeStatement.setString(1, ssn);
                insertSalariedEmployeeStatement.setDouble(2, weeklySalary);
                insertSalariedEmployeeStatement.setDouble(3, bonus);
                insertSalariedEmployeeStatement.executeUpdate();
                break;
            }
            case "Commission": {
                int grossSales = Integer.parseInt(JOptionPane.showInputDialog("Enter Gross Sales:"));
                double commissionRate = Double.parseDouble(JOptionPane.showInputDialog("Enter Commission Rate:"));
                double bonus = Double.parseDouble(JOptionPane.showInputDialog("Enter Bonus:"));
                String insertCommissionEmployeeQuery = "INSERT INTO commissionEmployees (socialSecurityNumber, grossSales, commissionRate, bonus) VALUES (?, ?, ?, ?)";
                PreparedStatement insertCommissionEmployeeStatement = connection.prepareStatement(insertCommissionEmployeeQuery);
                insertCommissionEmployeeStatement.setString(1, ssn);
                insertCommissionEmployeeStatement.setInt(2, grossSales);
                insertCommissionEmployeeStatement.setDouble(3, commissionRate);
                insertCommissionEmployeeStatement.setDouble(4, bonus);
                insertCommissionEmployeeStatement.executeUpdate();
                break;
            }
            case "Base Plus Commission": {
                int grossSales = Integer.parseInt(JOptionPane.showInputDialog("Enter Gross Sales:"));
                double commissionRate = Double.parseDouble(JOptionPane.showInputDialog("Enter Commission Rate:"));
                double baseSalary = Double.parseDouble(JOptionPane.showInputDialog("Enter Base Salary:"));
                double bonus = Double.parseDouble(JOptionPane.showInputDialog("Enter Bonus:"));
                String insertBasePlusCommissionEmployeeQuery = "INSERT INTO basePlusCommissionEmployees (socialSecurityNumber, grossSales, commissionRate, baseSalary, bonus) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertBasePlusCommissionEmployeeStatement = connection.prepareStatement(insertBasePlusCommissionEmployeeQuery);
                insertBasePlusCommissionEmployeeStatement.setString(1, ssn);
                insertBasePlusCommissionEmployeeStatement.setInt(2, grossSales);
                insertBasePlusCommissionEmployeeStatement.setDouble(3, commissionRate);
                insertBasePlusCommissionEmployeeStatement.setDouble(4, baseSalary);
                insertBasePlusCommissionEmployeeStatement.setDouble(5, bonus);
                insertBasePlusCommissionEmployeeStatement.executeUpdate();
                break;
            }
            case "Hourly": {
                int hours = Integer.parseInt(JOptionPane.showInputDialog("Enter Hours:"));
                double wage = Double.parseDouble(JOptionPane.showInputDialog("Enter Wage:"));
                double bonus = Double.parseDouble(JOptionPane.showInputDialog("Enter Bonus:"));
                String insertHourlyEmployeeQuery = "INSERT INTO hourlyEmployees (socialSecurityNumber, hours, wage, bonus) VALUES (?, ?, ?, ?)";
                PreparedStatement insertHourlyEmployeeStatement = connection.prepareStatement(insertHourlyEmployeeQuery);
                insertHourlyEmployeeStatement.setString(1, ssn);
                insertHourlyEmployeeStatement.setInt(2, hours);
                insertHourlyEmployeeStatement.setDouble(3, wage);
                insertHourlyEmployeeStatement.setDouble(4, bonus);
                insertHourlyEmployeeStatement.executeUpdate();
                break;
            }
        }
    }

    private static void displayEmployeeData(Connection connection) throws SQLException {
        String selectEmployeesQuery = "SELECT * FROM employees";
        Statement selectEmployeesStatement = connection.createStatement();
        ResultSet employeesResultSet = selectEmployeesStatement.executeQuery(selectEmployeesQuery);
        String[] columnNames = {"SSN", "First Name", "Last Name", "Birthday", "Employee Type", "Department"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        while (employeesResultSet.next()) {
            String ssn = employeesResultSet.getString("socialSecurityNumber");
            String firstName = employeesResultSet.getString("firstName");
            String lastName = employeesResultSet.getString("lastName");
            Date birthday = employeesResultSet.getDate("birthday");
            String employeeType = employeesResultSet.getString("employeeType");
            String departmentName = employeesResultSet.getString("departmentName");
            Object[] row = {ssn, firstName, lastName, birthday, employeeType, departmentName};
            tableModel.addRow(row);
        }
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Employee Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}