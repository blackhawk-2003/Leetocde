import java.util.Arrays;

public class Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 == 0) {
                left++;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Sort_Array_By_Parity solution = new Sort_Array_By_Parity();
        int[] nums = { 3, 1, 2, 4 };
        int[] result = solution.sortArrayByParity(nums);
        System.out.println(Arrays.toString(result));
    }
}
