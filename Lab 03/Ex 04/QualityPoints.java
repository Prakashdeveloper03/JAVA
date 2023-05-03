import javax.swing.JOptionPane;

public class QualityPoints {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Enter student's average:");
        double average = Double.parseDouble(input);
        int qualityPoints;
        if (average >= 90 && average <= 100) {
            qualityPoints = 4;
        } else if (average >= 80 && average <= 89) {
            qualityPoints = 3;
        } else if (average >= 70 && average <= 79) {
            qualityPoints = 2;
        } else if (average >= 60 && average <= 69) {
            qualityPoints = 1;
        } else {
            qualityPoints = 0;
        }
        JOptionPane.showMessageDialog(null, "Quality Points: " + qualityPoints);
    }
}
