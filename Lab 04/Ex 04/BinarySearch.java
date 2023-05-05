import java.util.Arrays;
import javax.swing.JOptionPane;

public class BinarySearch {
  public static void main(String[] args) {
    String input = JOptionPane.showInputDialog(null, "Enter a sorted list of integers separated by spaces:");
    String[] inputArray = input.split(" ");
    int[] numbers = new int[inputArray.length];
    for (int i = 0; i < inputArray.length; i++) {
      numbers[i] = Integer.parseInt(inputArray[i]);
    }
    Arrays.sort(numbers);
    String searchStr = JOptionPane.showInputDialog(null, "Enter the number to search for:");
    int searchNumber = Integer.parseInt(searchStr);
    int result = binarySearch(numbers, searchNumber);
    String message = (result >= 0) ? ("Found at index " + result) : "Not found";
    JOptionPane.showMessageDialog(null, message);
  }
  
  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}