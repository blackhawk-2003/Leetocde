import java.util.Arrays;

public class Minimize_Maximum_pair_sum_in_an_array {
    private static int minPairSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int maxSum = Integer.MIN_VALUE; // Initialize to minimum possible

        // Pair smallest with largest elements
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            maxSum = Math.max(maxSum, currentSum);
            left++;
            right--;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(minPairSum(nums));

        // Test the case that was failing
        int[] failingCase = { 3, 5, 2, 3 };
        System.out.println(minPairSum(failingCase)); // Should print 7
    }
}