import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GridApplication extends JFrame {
    private int rows, cols;

    public GridApplication(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        setTitle("Grid Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int cellSize = getWidth() / this.rows;
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                int x = col * cellSize;
                int y = row * cellSize;
                g2d.drawRect(x, y, cellSize, cellSize);
            }
        }
    }

    public static void main(String[] args) {
        int rows = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of rows"));
        int cols = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of columns"));
        EventQueue.invokeLater(() -> {
            GridApplication grid = new GridApplication(rows, cols);
            grid.setVisible(true);
        });
    }
}