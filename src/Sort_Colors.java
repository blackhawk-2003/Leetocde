public class Sort_Colors {

    public void sortColors(int[] nums) {
        int low = 0; // pointer for 0s (left side)
        int mid = 0; // pointer for 1s (middle)
        int high = nums.length - 1; // pointer for 2s (right side)

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    // Swap with the low pointer and advance both low and mid
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    // This is where 1s should be, just advance mid
                    mid++;
                    break;
                case 2:
                    // Swap with the high pointer and decrease high
                    // Don't advance mid yet as the swapped element needs to be checked
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
