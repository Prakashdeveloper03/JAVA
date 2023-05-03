import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        playGame();
    }
    
    public static void playGame() {
        int numberToGuess = (int)(Math.random() * 1000) + 1;
        int guess, option, numGuesses = 0;
        String message;
        do {
            guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Guess a number between 1 and 1000:"));
            numGuesses++;
            if (guess == numberToGuess) {
                message = String.format("Congratulations. You guessed the number!\n\nNumber of guesses: %d", numGuesses);
                option = JOptionPane.showConfirmDialog(null, message, "You Win!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    playGame();
                } else {
                    System.exit(0);
                }
            } else if (guess < numberToGuess) {
                JOptionPane.showMessageDialog(null, "Too low. Try again.", "Guess again", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Too high. Try again.", "Guess again", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (guess != numberToGuess);
    }
}
