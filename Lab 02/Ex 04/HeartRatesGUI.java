import javax.swing.*;

public class HeartRatesGUI extends JFrame {
    private JLabel firstNameLabel, lastNameLabel, birthMonthLabel, birthDayLabel, birthYearLabel;
    private JTextField firstNameField, lastNameField, birthMonthField, birthDayField, birthYearField;
    private JButton calculateButton;
    private JTextArea resultArea;

    public HeartRatesGUI() {
        super("Heart Rates Calculator");
        firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);
        lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);
        birthMonthLabel = new JLabel("Birth Month (1-12):");
        birthMonthField = new JTextField(2);
        birthDayLabel = new JLabel("Birth Day (1-31):");
        birthDayField = new JTextField(2);
        birthYearLabel = new JLabel("Birth Year (4-digit format):");
        birthYearField = new JTextField(4);
        calculateButton = new JButton("Calculate");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        JPanel contentPane = new JPanel();
        contentPane.add(firstNameLabel);
        contentPane.add(firstNameField);
        contentPane.add(lastNameLabel);
        contentPane.add(lastNameField);
        contentPane.add(birthDayLabel);
        contentPane.add(birthDayField);
        contentPane.add(birthMonthLabel);
        contentPane.add(birthMonthField);
        contentPane.add(birthYearLabel);
        contentPane.add(birthYearField);
        contentPane.add(calculateButton);
        contentPane.add(new JScrollPane(resultArea));
        setContentPane(contentPane);

        calculateButton.addActionListener(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            int birthMonth = Integer.parseInt(birthMonthField.getText());
            int birthDay = Integer.parseInt(birthDayField.getText());
            int birthYear = Integer.parseInt(birthYearField.getText());
            HeartRates person = new HeartRates(firstName, lastName, birthMonth, birthDay, birthYear);

            int age = person.calculates();
            int maxHeartRate = person.maximumHeartRate();
            String targetHeartRateRange = person.calculateTargetHeartRateRange();
            resultArea.setText("First Name: " + firstName + "\nLast Name: " + lastName + "\nAge: " + age + " years\n" +
                                "Maximum Heart Rate: " + maxHeartRate + " bpm\n" +
                                "Target Heart Rate Range: " + targetHeartRateRange + " bpm");
        });
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HeartRatesGUI();
    }
}
