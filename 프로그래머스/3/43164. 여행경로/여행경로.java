import java.util.*;

class Solution {
    
    private List<String> answers = new ArrayList<>();
    private String[][] arr;
    private boolean[] visited;
    private int N;
    
    public String[] solution(String[][] tickets) {
               
        N = tickets.length;
        String[] answer = new String[N + 1];
        visited = new boolean[N];
        arr = tickets;
        
        dfs("ICN", 0, 0, "ICN");   
        
        answers.sort(null);
        int index = 0;
                
        for (int i = 0; i < answers.get(0).length(); i += 3) {
            answer[index++] = answers.get(0).substring(i, i + 3);
        }
        
        return answer;
    }
    
    private void dfs(String start, int end, int depth, String path) {
        
        if (depth == N) {
            answers.add(path);
            return;
        }
        
        for (int i = 0; i < N; i++) {                    
            if (visited[i] || !arr[i][0].equals(start)) continue;
            
            visited[i] = true;
            dfs(arr[i][1], end, depth + 1, path+arr[i][1]);           
            visited[i] = false;
        }
    } 
}