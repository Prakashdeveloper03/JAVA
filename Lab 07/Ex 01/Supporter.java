import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JOptionPane;

public class Supporter {
    private static Formatter output;

    public static void main(String[] args) {
        int[] responses = gatherResponses();

        openFile();
        addRecords(responses);
        closeFile();
    }

    public static int[] gatherResponses() {
        final int AMOUNT = 5;
        int[] responses = new int[AMOUNT];

        for (int i = 0; i < responses.length; i++) {
            String responseString = JOptionPane.showInputDialog(null, "Enter rating for response " + (i + 1) + ":");
            responses[i] = Integer.parseInt(responseString);
        }
        return responses;
    }

    public static void openFile() {
        try {
            output = new Formatter("numbers.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addRecords(int[] responses) {
        for (int i = 0; i < responses.length; i++)
            output.format("%d%n", responses[i]);
    }

    public static void closeFile() {
        if (output != null)
            output.close();
    }
}