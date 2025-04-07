package Two_pointers;

import java.util.Arrays;

public class DI_String_Match {

    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        int left = 0;
        int right = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = left++;
            } else {
                result[i] = right--;
            }
        }
        result[n] = left;
        return result;
    }

    public static void main(String[] args) {
        DI_String_Match solution = new DI_String_Match();
        String s = "IDID";
        int[] result = solution.diStringMatch(s);
        System.out.println(Arrays.toString(result));
    }
}
