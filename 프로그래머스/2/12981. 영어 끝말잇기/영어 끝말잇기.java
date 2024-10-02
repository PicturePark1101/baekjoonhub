import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0 ,0};
        
        HashSet<String> wordSet = new HashSet<>();
        String beforeWord = words[0];
        wordSet.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            char beforeLastChar = beforeWord.charAt(beforeWord.length() - 1);
            char currentFirstChar = words[i].charAt(0);

            if (beforeLastChar != currentFirstChar || wordSet.contains(words[i])) {
                return new int[]{i % n + 1, i / n + 1};
            }
            wordSet.add(words[i]);
            beforeWord = words[i];
        }

        return answer;
    }
}