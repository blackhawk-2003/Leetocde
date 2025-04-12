package Two_pointers;

import java.util.HashMap;

public class Count_the_Number_of_Powerful_ntegers {

    public long countPowerfulIntegers(long start, long finish, long limit, String s) {
        // Since we're dealing with strings and need to handle them carefully
        return countPowerfulInRange(start, finish, limit, s);
    }

    private long countPowerfulInRange(long start, long finish, long limit, String s) {
        // Simple validations first
        for (char c : s.toCharArray()) {
            if (c - '0' > limit) {
                return 0; // If any digit in suffix exceeds limit, no valid numbers
            }
        }

        // Count powerful integers up to finish
        long countUpToFinish = countPowerfulUpTo(finish, limit, s);

        // Count powerful integers up to start-1
        long countUpToStartMinus1 = countPowerfulUpTo(start - 1, limit, s);

        return countUpToFinish - countUpToStartMinus1;
    }

    private long countPowerfulUpTo(long num, long limit, String s) {
        // Convert to string for easier digit processing
        String numStr = String.valueOf(num);

        // If the number has fewer digits than the suffix, it can't be powerful
        if (numStr.length() < s.length()) {
            return 0;
        }

        // Use a more straightforward approach
        return dfs(numStr, 0, true, limit, s, new Long[numStr.length()][2]);
    }

    // DFS approach with memoization
    private long dfs(String numStr, int pos, boolean tight, long limit, String s, Long[][] memo) {
        // Base case: if we've filled all positions
        if (pos == numStr.length()) {
            return 1L;
        }

        // Check memo
        if (memo[pos][tight ? 1 : 0] != null) {
            return memo[pos][tight ? 1 : 0];
        }

        long result = 0;

        // Determine if current position matches with suffix
        int suffixPos = pos - (numStr.length() - s.length());
        boolean isSuffixPos = suffixPos >= 0;

        // If this is a suffix position
        if (isSuffixPos) {
            char requiredDigit = s.charAt(suffixPos);
            long digValue = requiredDigit - '0';

            // Skip if digit exceeds limit
            if (digValue > limit) {
                memo[pos][tight ? 1 : 0] = 0L;
                return 0;
            }

            // If tight constraint and required digit > current bound
            if (tight && digValue > (numStr.charAt(pos) - '0')) {
                memo[pos][tight ? 1 : 0] = 0L;
                return 0;
            }

            // Move to next position, maintaining tight constraint if needed
            boolean newTight = tight && digValue == (numStr.charAt(pos) - '0');
            result = dfs(numStr, pos + 1, newTight, limit, s, memo);
        } else {
            // Not a suffix position, try all valid digits
            long upperLimit = tight ? (numStr.charAt(pos) - '0') : 9;
            upperLimit = Math.min(upperLimit, limit);

            for (long d = 0; d <= upperLimit; d++) {
                boolean newTight = tight && d == (numStr.charAt(pos) - '0');
                result += dfs(numStr, pos + 1, newTight, limit, s, memo);
            }
        }

        // Memoize and return
        memo[pos][tight ? 1 : 0] = result;
        return result;
    }

    public static void main(String[] args) {
        Count_the_Number_of_Powerful_ntegers solution = new Count_the_Number_of_Powerful_ntegers();

        // Test the given example
        long start = 1;
        long finish = 6000;
        long limit = 4;
        String s = "124";

        long result = solution.countPowerfulIntegers(start, finish, limit, s);
        System.out.println("Number of powerful integers: " + result);

        // Validate with expected powerful integers
        System.out.println("Expected powerful integers: 124, 1124, 2124, 3124, 4124");
    }
}
