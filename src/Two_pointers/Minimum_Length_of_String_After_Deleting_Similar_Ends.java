package Two_pointers;

public class Minimum_Length_of_String_After_Deleting_Similar_Ends {

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char currentChar = s.charAt(left);

            while (left <= right && s.charAt(left) == currentChar) {
                left++;
            }

            while (left <= right && s.charAt(right) == currentChar) {
                right--;
            }
        }

        return right - left + 1;
    }
}
