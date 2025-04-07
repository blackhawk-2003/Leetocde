package Two_pointers;

import java.util.Arrays;

public class Bag_Of_Tokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        // Sort tokens for greedy approach
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0; // Track maximum score achieved

        while (left <= right) {
            if (tokens[left] <= power) {
                // Play smallest token face-up
                power -= tokens[left];
                score++;
                maxScore = Math.max(maxScore, score); // Update max score
                left++;
            } else if (score > 0) {
                // Play largest token face-down
                power += tokens[right];
                score--;
                right--;
            } else {
                // Can't play any token - just break
                break;
            }
        }

        return maxScore;
    }

}
