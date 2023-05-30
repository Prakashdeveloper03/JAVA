import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConcentricCircles extends JFrame {
    private int nums;
    public ConcentricCircles(int nums) {
        this.nums = nums;
        setTitle("Concentric Circles");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 10;

        for (int i = 0; i < nums; i++) {
            g2d.drawArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, 0, 360);
            radius += 10;
        }
    }

    public static void main(String[] args) {
        int nums = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of circles : "));
        EventQueue.invokeLater(() -> {
            ConcentricCircles circles = new ConcentricCircles(nums);
            circles.setVisible(true);
        });
    }
}