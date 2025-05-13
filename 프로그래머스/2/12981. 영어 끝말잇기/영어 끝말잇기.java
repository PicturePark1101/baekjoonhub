import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> wordSet = new HashSet<>();
    
        
        char lastAlphabet = words[0].charAt(words[0].length() - 1);
        wordSet.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            int id = i % n;
            // 탈락 조건
            char startAlphabet = words[i].charAt(0);
            
            if (startAlphabet != lastAlphabet || wordSet.contains(words[i])) {
                return new int[]{id + 1, i / n + 1};
            }
            
            wordSet.add(words[i]);  
            lastAlphabet = words[i].charAt(words[i].length() - 1);
            
        }
        return new int[]{0, 0};
    }
}