import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShapeDrawingApplication extends JFrame {
    private Random random;
    private int nums;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private JComboBox<String> shapeComboBox;
    private String[] shapeOptions = { "Rectangle", "Oval", "Triangle" };
    private String selectedShape;

    public ShapeDrawingApplication(int nums) {
        this.nums = nums;
        setTitle("Shape Drawing");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        random = new Random();
        shapeComboBox = new JComboBox<>(shapeOptions);
        shapeComboBox.addActionListener(new ShapeComboBoxListener());
        selectedShape = shapeOptions[0];
        getContentPane().add(shapeComboBox, BorderLayout.NORTH);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Random random = new Random();
        for (int i = 0; i < this.nums; i++) {
            int x = random.nextInt(WIDTH + 700);
            int y = random.nextInt(HEIGHT + 500);
            int width = random.nextInt(100) + 50;
            int height = random.nextInt(100) + 50;
            if (selectedShape.equals("Rectangle")) {
                g2d.setColor(getRandomColor());
                g2d.drawRect(x, y, width, height);
                g2d.fillRect(x, y, width, height);
            } else if (selectedShape.equals("Oval")) {
                g2d.setColor(getRandomColor());
                g2d.drawOval(x, y, width, height);
                g2d.fillOval(x, y, width, height);
            } else if (selectedShape.equals("Triangle")) {
                int[] xPoints = { x, x + width / 2, x + width };
                int[] yPoints = { y + height, y, y + height };
                g2d.setColor(getRandomColor());
                g2d.drawPolygon(xPoints, yPoints, 3);
                g2d.fillPolygon(xPoints, yPoints, 3);
            }
        }
    }

    private Color getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    private class ShapeComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
            selectedShape = (String) comboBox.getSelectedItem();
            repaint();
        }
    }

    public static void main(String[] args) {
        int nums = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of shapes : "));
        EventQueue.invokeLater(() -> {
            ShapeDrawingApplication shapeDrawing = new ShapeDrawingApplication(nums);
            shapeDrawing.setVisible(true);
        });
    }
}