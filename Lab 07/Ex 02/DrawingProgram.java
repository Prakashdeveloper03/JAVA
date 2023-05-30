import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DrawingProgram extends JFrame {
    private JButton loadButton;
    private JButton saveButton;
    private JPanel canvas;
    private ArrayList<MyShape> shapes;

    public DrawingProgram() {
        shapes = new ArrayList<>();

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (MyShape shape : shapes) {
                    shape.draw(g);
                }
            }
        };

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                Color color = getRandomColor();

                MyShape shape;
                if (Math.random() < 0.5) {
                    shape = new MyRectangle(x, y, color);
                } else {
                    shape = new MyOval(x, y, color);
                }

                shapes.add(shape);
                canvas.repaint();
            }
        });

        loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Shape Files", "ser"));
                int result = fileChooser.showOpenDialog(DrawingProgram.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filename = fileChooser.getSelectedFile().getAbsolutePath();
                    loadShapes(filename);
                    canvas.repaint();
                }
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Shape Files", "ser"));
                int result = fileChooser.showSaveDialog(DrawingProgram.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filename = fileChooser.getSelectedFile().getAbsolutePath();
                    saveShapes(filename);
                }
            }
        });

        getContentPane().add(loadButton, "North");
        getContentPane().add(canvas, "Center");
        getContentPane().add(saveButton, "South");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    private Color getRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }

    private void saveShapes(String filename) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {
            output.writeObject(shapes);
            System.out.println("Shapes saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadShapes(String filename) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))) {
            shapes = (ArrayList<MyShape>) input.readObject();
            System.out.println("Shapes loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DrawingProgram();
    }
}