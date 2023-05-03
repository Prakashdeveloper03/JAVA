import javax.swing.JOptionPane;

public class CircleArea {
    public static void main(String[] args) {
        double radius = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius of the circle: "));
        double area = circleArea(radius);
        JOptionPane.showMessageDialog(null, "The area of the circle is " + area);
    }
    
    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }
}