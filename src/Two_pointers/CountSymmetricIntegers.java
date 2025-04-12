package Two_pointers;

public class CountSymmetricIntegers {

    public static int countSymmetric(int low, int high) {
        int count = 0;

        // Constrain the range to max 10^4
        high = Math.min(high, 10000);

        // Iterate through all numbers in the range [low, high]
        for (int num = low; num <= high; num++) {
            int digitCount = countDigits(num);

            // Skip numbers with odd number of digits
            if (digitCount % 2 != 0) {
                continue;
            }

            // Check if the number is symmetric
            if (isSymmetric(num, digitCount)) {
                count++;
            }
        }

        return count;
    }

    // Helper method to count digits - optimized for small numbers
    private static int countDigits(int num) {
        if (num < 10)
            return 1;
        if (num < 100)
            return 2;
        if (num < 1000)
            return 3;
        if (num < 10000)
            return 4;
        return 5; // For 10000
    }

    // Helper method to check symmetry - optimized for specific digit counts
    private static boolean isSymmetric(int num, int digitCount) {
        // For 2-digit numbers
        if (digitCount == 2) {
            int firstDigit = num / 10;
            int lastDigit = num % 10;
            return firstDigit == lastDigit;
        }

        // For 4-digit numbers
        if (digitCount == 4) {
            int firstDigit = num / 1000;
            int secondDigit = (num / 100) % 10;
            int thirdDigit = (num / 10) % 10;
            int fourthDigit = num % 10;

            return (firstDigit + secondDigit) == (thirdDigit + fourthDigit);
        }

        // For other cases (only odd-digit numbers would reach here in this problem)
        return false;
    }

    public static void main(String[] args) {
        // Example 1
        int low1 = 1;
        int high1 = 100;
        System.out.println("Count of symmetric integers between " + low1 + " and " + high1 + ": "
                + countSymmetric(low1, high1));

        // Additional test case within constraint
        int low2 = 1000;
        int high2 = 10000;
        System.out.println("Count of symmetric integers between " + low2 + " and " + high2 + ": "
                + countSymmetric(low2, high2));
    }
}