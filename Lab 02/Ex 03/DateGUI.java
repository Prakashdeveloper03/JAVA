import javax.swing.*;

public class DateGUI {
    public static void main(String[] args) {
        JTextField monthField = new JTextField(5);
        JTextField dayField = new JTextField(5);
        JTextField yearField = new JTextField(5);
        
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Day:"));
        myPanel.add(dayField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Month:"));
        myPanel.add(monthField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Year:"));
        myPanel.add(yearField);
        
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Please enter the date",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            int month = Integer.parseInt(monthField.getText());
            int day = Integer.parseInt(dayField.getText());
            int year = Integer.parseInt(yearField.getText());
            String format = day + "/" + month + "/" + year;
            JOptionPane.showMessageDialog(null, format, "Date", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}