import java.util.HashSet;
package Two_pointers;

public class Minimum_Operations_to_Make_Array_Values_Equal_to_K {
    public int minOperations(int[] nums, int k) {
        // Base case:- if array contains an integer less than k than return -1

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                return -1;
            }
        }

        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int element : nums) {
            uniqueElements.add(element);
        }
        int minOperation = 0;

        for (int num : uniqueElements) {
            if (num > k) {
                minOperation++;
            }
        }

        return minOperation;
    }
}
