import javax.swing.JOptionPane;

public class ReverseDigits {
    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }
    
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter an integer:");
        int number = Integer.parseInt(input);
        int reversed = reverse(number);
        JOptionPane.showMessageDialog(null, "Reversed number: " + reversed);
    }
}