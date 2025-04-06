package Two_pointers;

import java.util.Arrays;

public class Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {

    public static int numSubseq(int[] nums, int target) {
        int MOD = 1000000007;
        Arrays.sort(nums);

        // Precompute powers of 2
        int n = nums.length;
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // For each valid left pointer, we can include or exclude each element between
                // left+1 and right
                // This gives us 2^(right-left) subsequences
                count = (count + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 6, 7 };
        int target = 9;
        System.out.println(numSubseq(nums, target));
    }
}