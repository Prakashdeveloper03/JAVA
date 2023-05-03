import javax.swing.JOptionPane;

public class PrimeNumbers {
	public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
        StringBuilder primes = new StringBuilder();
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                primes.append(i).append(" ");
            }
            if (i % 250 == 0) {
            	primes.append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, primes);
    }
}