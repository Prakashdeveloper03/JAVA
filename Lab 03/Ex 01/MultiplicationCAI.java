import java.util.Random;
import javax.swing.JOptionPane;

public class MultiplicationCAI {
    public static void main(String[] args) {
        Random random = new Random();
        int num1 = generateNumber(random);
        int num2 = generateNumber(random);
        askQuestion(num1, num2);
    }

    public static int generateNumber(Random random) {
        return random.nextInt(9) + 1;
    }

    public static void askQuestion(int num1, int num2) {
        int answer = Integer.parseInt(JOptionPane.showInputDialog(null,
                "How much is " + num1 + " times " + num2 + "?",
                "Multiplication CAI", JOptionPane.PLAIN_MESSAGE));
        int product = num1 * num2;
        if (answer == product) {
            JOptionPane.showMessageDialog(null, "Very good!",
                    "Multiplication CAI", JOptionPane.PLAIN_MESSAGE);
            num1 = generateNumber(new Random());
            num2 = generateNumber(new Random());
            askQuestion(num1, num2);
        } else {
            JOptionPane.showMessageDialog(null, "No. Please try again.",
                    "Multiplication CAI", JOptionPane.PLAIN_MESSAGE);
            askQuestion(num1, num2);
        }
    }
}