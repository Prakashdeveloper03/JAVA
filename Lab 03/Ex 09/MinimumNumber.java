import javax.swing.JOptionPane;

public class MinimumNumber {
    public static void main(String[] args) {
        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Enter first number:"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Enter second number:"));
        double num3 = Double.parseDouble(JOptionPane.showInputDialog("Enter third number:"));
        double min = minimum3(num1, num2, num3);
        JOptionPane.showMessageDialog(null, "The smallest value is " + min);
    }

    public static double minimum3(double x, double y, double z) {
        return Math.min(x, Math.min(y, z));
    }
}