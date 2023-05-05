import java.util.HashMap;
import javax.swing.JOptionPane;

public class FrequencyCount {
  public static void main(String[] args) {
    String input = JOptionPane.showInputDialog(null, "Enter a list of integers separated by spaces:");
    String[] inputArray = input.split(" ");
    int[] numbers = new int[inputArray.length];
    for (int i = 0; i < inputArray.length; i++) {
      numbers[i] = Integer.parseInt(inputArray[i]);
    }
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    for (int number : numbers) {
      if (frequencyMap.containsKey(number)) {
        frequencyMap.put(number, frequencyMap.get(number) + 1);
      } else {
        frequencyMap.put(number, 1);
      }
    }
    StringBuilder messageBuilder = new StringBuilder();
    for (int number : frequencyMap.keySet()) {
      int frequency = frequencyMap.get(number);
      messageBuilder.append(number).append(": ").append(frequency).append("\n");
    }
    String message = messageBuilder.toString();
    JOptionPane.showMessageDialog(null, message);
  }
}