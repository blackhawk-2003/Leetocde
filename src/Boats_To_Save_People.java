import java.util.Arrays;

public class Boats_To_Save_People {

    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            // Try to pair the lightest person with the heaviest
            if (people[left] + people[right] <= limit) {
                left++; // Both people can fit in one boat
            }
            // Either way, the heaviest person takes a boat
            right--;
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {
        int[] people = { 1, 2, 3, 4, 5 };
        int limit = 5;
        System.out.println(numRescueBoats(people, limit));
    }

}
