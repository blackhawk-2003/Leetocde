package Two_pointers;

import java.util.ArrayList;
import java.util.List;

public class Pancake_Sorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();

        // Check if array is already sorted
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            return result; // Empty list if already sorted
        }

        // Start pancake sort
        int n = arr.length;
        for (int i = n; i > 1; i--) {
            // Find the index of the current largest value (1-indexed values in original
            // problem)
            int maxIndex = findMaxIndex(arr, i);

            // If the largest element is already at the end of the current subarray, skip
            if (maxIndex == i - 1) {
                continue;
            }

            // If max element is not at the beginning, flip to move it to the beginning
            if (maxIndex != 0) {
                // Flip from 0 to maxIndex
                flip(arr, 0, maxIndex);
                result.add(maxIndex + 1); // Add k value (1-indexed)
            }

            // Now flip the whole current subarray to move the max element to its correct
            // position
            flip(arr, 0, i - 1);
            result.add(i); // Add k value (1-indexed)
        }

        return result;
    }

    // Helper method to find the index of maximum element in the subarray
    // arr[0...end]
    private int findMaxIndex(int[] arr, int end) {
        int maxIndex = 0;
        for (int i = 1; i < end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Helper method to flip/reverse the subarray from start to end (inclusive)
    private void flip(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Pancake_Sorting solution = new Pancake_Sorting();
        int[] arr = { 3, 2, 4, 1 };
        List<Integer> result = solution.pancakeSort(arr);
        System.out.println(result);
    }
}
