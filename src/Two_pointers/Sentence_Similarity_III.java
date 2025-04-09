package Two_pointers;

public class Sentence_Similarity_III {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int i = 0;
        int j = 0;

        while (i < words1.length && j < words2.length && words1[i].equals(words2[j])) {
            i++;
            j++;
        }

        while (i < words1.length && j < words2.length
                && words1[words1.length - 1].equals(words2[words2.length - 1])) {
            i++;
            j++;
        }

        return i == words1.length || j == words2.length;
    }

    public static void main(String[] args) {
        Sentence_Similarity_III solution = new Sentence_Similarity_III();
        String sentence1 = "My name is John";
        String sentence2 = "is name John";
        System.out.println(solution.areSentencesSimilar(sentence1, sentence2));
    }
}
