package Two_pointers;

import java.util.HashSet;

public class Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct {
    private static boolean isDistinct(int[] arr, int i) {
        // Create a HashSet to track unique elements
        HashSet<Integer> seen = new HashSet<>();

        // Iterate through the array
        for (int idx = i; idx < arr.length; idx++) {
            // If element is already in the set, it's a duplicate
            if (seen.contains(arr[idx])) {
                return false;
            }

            // Add the element to the set
            seen.add(arr[idx]);
        }

        // If we reach here, all elements are distinct
        return true;
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;

        // Calculating if all the elements in the array are disticnt or not
        int operations = 0;
        int i = 0;
        while (i < n) {
            if (isDistinct(nums, i)) {
                return operations;
            } else {
                i += 3;
                operations += 1;
            }
        }

        return operations;

    }
}
