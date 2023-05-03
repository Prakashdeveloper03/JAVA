import javax.swing.JOptionPane;

public class GCDApplication {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the first number:"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the second number:"));
        int gcd = gcd(num1, num2);
        JOptionPane.showMessageDialog(null, "The GCD of " + num1 + " and " + num2 + " is " + gcd + ".");
    }
    
    public static int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }
}