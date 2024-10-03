import java.util.*;

class Solution {
    
    private List<Integer>[] adList;
    private boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        adList = new ArrayList[n + 1];
               
        for (int i = 0; i <= n; i++) {
            adList[i] = new ArrayList<>();
        }
        
        int answer = n + 1;
        for (int i = 0; i < n - 1; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            adList[a].add(b); 
            adList[b].add(a); 
        }
                       
        for (int i = 0; i < n - 1; i++) {
            visited = new boolean[n + 1];
            int a = dfs(wires[i][0], wires[i][1], 1);
            int b = n - a;
            int gap = Math.abs(a - b);
            answer = Math.min(gap, answer);
        }        
        return answer;
    }
    
    private int dfs(int now, int exceptionNode, int depth) {
        visited[now] = true;        
        for (int next : adList[now]) {
            if (!visited[next] && next != exceptionNode) {
                depth = dfs(next, exceptionNode, depth + 1);
            }
        }
        return depth;
    }
}