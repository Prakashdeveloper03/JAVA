import javax.swing.JOptionPane;

public class VariableLengthArgs {
    public static void main(String[] args) {
        int[] values = {2, 3, 4, 5};
        int product = product(values);
        JOptionPane.showMessageDialog(null, "Product of 2, 3, 4, and 5 is: " + product);    
        product = product(10, 20, 30);
        JOptionPane.showMessageDialog(null, "Product of 10, 20, and 30 is: " + product);
        product = product(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        JOptionPane.showMessageDialog(null, "Product of 1 to 10 is: " + product);
        String input = JOptionPane.showInputDialog(null, "Enter a series of numbers separated by spaces:");
        String[] tokens = input.split(" ");
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }
        product = product(nums);
        JOptionPane.showMessageDialog(null, "Product of " + input + " is: " + product);
    }
    
    public static int product(int... values) {
        int result = 1;
        for (int value : values) {
            result *= value;
        }
        return result;
    }   
}