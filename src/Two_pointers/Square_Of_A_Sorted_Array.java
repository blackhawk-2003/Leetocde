package Two_pointers;

import java.util.Arrays;

public class Square_Of_A_Sorted_Array {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Square_Of_A_Sorted_Array solution = new Square_Of_A_Sorted_Array();
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] result = solution.sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
