import javax.swing.*;

public class InvoiceGUI {
    public static void main(String[] args) {
        JLabel partNumLabel = new JLabel("Part Number:");
        JTextField partNumField = new JTextField(10);
        JLabel partDescLabel = new JLabel("Part Description:");
        JTextField partDescField = new JTextField(20);
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(5);
        JLabel priceLabel = new JLabel("Price per Item:");
        JTextField priceField = new JTextField(10);
        JButton submitButton = new JButton("Submit");
        JLabel outputLabel = new JLabel();
        
        JPanel inputPanel = new JPanel();
        inputPanel.add(partNumLabel);
        inputPanel.add(partNumField);
        inputPanel.add(partDescLabel);
        inputPanel.add(partDescField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(submitButton);
        
        JPanel outputPanel = new JPanel();
        outputPanel.add(outputLabel);
        JFrame frame = new JFrame("Invoice Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(inputPanel);
        frame.add(outputPanel);
        submitButton.addActionListener(e -> {
            String partNum = partNumField.getText();
            String partDesc = partDescField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());
            Invoice invoice = new Invoice(partNum, partDesc, quantity, price);
            outputLabel.setText("<html>" +
                    "Part number: " + invoice.getPartNumber() + "<br>" +
                    "Part description: " + invoice.getPartDescription() + "<br>" +
                    "Quantity: " + invoice.getQuantity() + "<br>" +
                    "Price per item: $" + invoice.getPricePerItem() + "<br>" +
                    "Invoice amount: $" + invoice.getInvoiceAmount() +
                    "</html>");
        });
        frame.setVisible(true);
    }
}