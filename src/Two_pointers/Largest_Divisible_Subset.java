package Two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // If the array is empty, return an empty list
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        // Sort the array first - critical for the divisibility property
        Arrays.sort(nums);

        int n = nums.length;
        // dp[i] represents the size of the largest divisible subset ending with nums[i]
        int[] dp = new int[n];
        // prev[i] stores the index of the previous element in the largest subset ending
        // with nums[i]
        int[] prev = new int[n];

        Arrays.fill(dp, 1); // Each number by itself forms a divisible subset of size 1
        Arrays.fill(prev, -1); // -1 indicates no previous element

        int maxLen = 1; // Track the maximum subset length
        int maxIndex = 0; // Track the index of the last element in the maximum subset

        // Build dp array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If nums[i] is divisible by nums[j] and including nums[j] leads to a larger
                // subset
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            // Update the max length and index if necessary
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }

        // Reconstruct the largest divisible subset
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        // Reverse the result since we built it backwards
        Collections.reverse(result);
        return result;
    }
}
