import javax.swing.JOptionPane;

public class SalesCommission {
    public static void main(String[] args) {
        int[] salaryCounters = new int[9];
        int numSalespeople = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Enter the number of salespeople:"));

        for (int i = 0; i < numSalespeople; i++) {
            double grossSales = Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Enter the gross sales for salesperson " + (i+1) + ":"));
            double salary = 200 + (0.09 * grossSales);
            int salaryRange = (int) (salary / 100) - 2;
            if (salaryRange >= 0 && salaryRange <= 8) {
                salaryCounters[salaryRange]++;
            }
        }

        String output = String.format("%-20s %s\n", "Salary Range", "Number of Salespeople");
        output += "-------------------------------------------------------\n";
        output += String.format("$200 - $299 %15d\n", salaryCounters[0]);
        output += String.format("$300 - $399 %15d\n", salaryCounters[1]);
        output += String.format("$400 - $499 %15d\n", salaryCounters[2]);
        output += String.format("$500 - $599 %15d\n", salaryCounters[3]);
        output += String.format("$600 - $699 %15d\n", salaryCounters[4]);
        output += String.format("$700 - $799 %15d\n", salaryCounters[5]);
        output += String.format("$800 - $899 %15d\n", salaryCounters[6]);
        output += String.format("$900 - $999 %15d\n", salaryCounters[7]);
        output += String.format("$1000 & over %12d\n", salaryCounters[8]);

        JOptionPane.showMessageDialog(null, output);
    }
}
