import javax.swing.*;

public class DistanceCalculator {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter x1:"));
        double y1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter y1:"));
        double x2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter x2:"));
        double y2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter y2:"));
        double distance = distance(x1, y1, x2, y2);
        JOptionPane.showMessageDialog(null, "The distance between the points is " + distance);
    }
    
    public static double distance(double x1, double y1, double x2, double y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
