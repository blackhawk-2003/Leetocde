package Two_pointers;

import java.util.Arrays;

public class Sort_Array_By_Parity_II {
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;
        while (even < nums.length && odd < nums.length) {
            if (nums[even] % 2 == 0) {
                even += 2;
            } else if (nums[odd] % 2 == 1) {
                odd += 2;
            } else {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Sort_Array_By_Parity_II solution = new Sort_Array_By_Parity_II();
        int[] nums = { 4, 2, 5, 7 };
        int[] result = solution.sortArrayByParityII(nums);
        System.out.println(Arrays.toString(result));
    }
}
