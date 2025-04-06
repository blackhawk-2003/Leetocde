import java.util.Arrays;

public class _3Sum_With_multiplicity {
    private static int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        long result = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            // Skip duplicates for i
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else { // sum == target
                    // Count duplicates at position j
                    int countJ = 1;
                    while (j + countJ < k && arr[j] == arr[j + countJ]) {
                        countJ++;
                    }

                    // Count duplicates at position k
                    int countK = 1;
                    while (k - countK > j && arr[k] == arr[k - countK]) {
                        countK++;
                    }

                    // If all elements in the range [j, k] are the same
                    if (arr[j] == arr[k]) {
                        // Number of ways to choose 2 positions from (k-j+1) positions
                        long ways = (long) (k - j + 1) * (k - j) / 2;
                        result = (result + ways) % MOD;
                    } else {
                        // If different elements, multiply counts of duplicates
                        result = (result + (long) countJ * countK) % MOD;
                    }

                    // Move pointers past duplicates
                    j += countJ;
                    k -= countK;
                }
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
        int target = 8;
        System.out.println(threeSumMulti(arr, target));
    }
}
