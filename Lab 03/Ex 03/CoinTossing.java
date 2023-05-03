import javax.swing.JOptionPane;

public class CoinTossing {
    private static enum Coin {
        HEADS,
        TAILS
    }
    
    public static void main(String[] args) {
        int headsCount = 0, tailsCount = 0;
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Toss Coin", "Coin Tossing", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"Toss Coin", "Exit"}, "Toss Coin");
            if (choice == JOptionPane.NO_OPTION)
                break;
            Coin result = flip();
            
            if (result == Coin.HEADS)
                headsCount++;
            else
                tailsCount++;
            JOptionPane.showMessageDialog(null, "Heads: " + headsCount + "\nTails: " + tailsCount, "Coin Tossing", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private static Coin flip() {
        return (Math.random() < 0.5) ? Coin.HEADS : Coin.TAILS;
    }
}