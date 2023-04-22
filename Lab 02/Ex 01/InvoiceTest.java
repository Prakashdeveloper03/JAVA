import java.util.Scanner;

public class InvoiceTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter part number: ");
        String partNumber = input.nextLine();
        System.out.print("Enter part description: ");
        String partDescription = input.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        System.out.print("Enter price per item: ");
        double pricePerItem = input.nextDouble();

        Invoice invoice = new Invoice(partNumber, partDescription, quantity, pricePerItem);
        
        System.out.println("\n\nInvoice");
        System.out.printf("Part number: %s\n", invoice.getPartNumber());
        System.out.printf("Part description: %s\n", invoice.getPartDescription());
        System.out.printf("Quantity: %d\n", invoice.getQuantity());
        System.out.printf("Price per item: $%.2f\n", invoice.getPricePerItem());
        System.out.printf("Invoice amount: $%.2f\n", invoice.getInvoiceAmount());
        input.close();
    }
}
