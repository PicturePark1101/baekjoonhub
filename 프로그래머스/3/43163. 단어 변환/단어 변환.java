import java.util.*;

class Solution {
    private boolean[] visited;
    private int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        
        visited = new boolean[words.length];
        
        if (existTarget(words, target)) {
            dfs(words, 0, target, begin);
            return answer;
        } {
            return 0;
        }
    }
        
    private boolean existTarget(String[] words, String target) {
        for (int i = 0; i < words.length; i++) { 
            if (target.equals(words[i])) return true;
        }
        return false;
    }
    
    private void dfs(String[] words, int depth, String target, String current)  {
        if (target.equals(current)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        // if (depth == words.length) {
        //     return;
        // }
                
        for (int i = 0; i < words.length; i++) {
            //방문하는 조건은 한글자만 다르고, 방문하지 않은 경우임
            if (differentOneWord(current, words[i]) && !visited[i]) {
                // System.out.println("방문티비 "+words[i]+ " 깊이" +depth);
                visited[i] = true;
                dfs(words, depth + 1, target, words[i]);
                visited[i] = false;
                // System.out.println("돌아옴 ");
                // System.out.println();

            }
        }        
    }
    
    private boolean differentOneWord(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) count++;
        }

        return count == 1;
    }
}