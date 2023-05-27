import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class RandomCharacters extends JFrame {
    private Random random;
    private Font[] fonts;
    private Color[] colors;
    private String characters;
    private int nums;
    public RandomCharacters(int nums) {
        this.nums = nums;
        setTitle("Random Characters");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        random = new Random();
        fonts = new Font[]{
                new Font("Arial", Font.PLAIN, 12),
                new Font("Courier New", Font.BOLD, 14),
                new Font("Times New Roman", Font.ITALIC, 16),
                new Font("Verdana", Font.BOLD | Font.ITALIC, 18)
        };

        colors = new Color[]{
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.ORANGE
        };
        characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int x = 50;
        int y = 50;
        for (int i = 0; i < nums; i++) {
            Font font = fonts[random.nextInt(fonts.length)];
            int size = random.nextInt(20) + 12;
            Color color = colors[random.nextInt(colors.length)];
            g2d.setFont(font.deriveFont((float) size));
            g2d.setColor(color);
            char ch = characters.charAt(random.nextInt(characters.length()));
            g2d.drawString(String.valueOf(ch), x, y);
            x += 20;
            if (x > getWidth() - 50) {
                x = 50;
                y += 30;
            }
        }
    }

    public static void main(String[] args) {
        int nums = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of characters : "));
        EventQueue.invokeLater(() -> {
            RandomCharacters characters = new RandomCharacters(nums);
            characters.setVisible(true);
        });
    }
}