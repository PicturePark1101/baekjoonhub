class Solution {
    
    private boolean[] visited;
    private int N;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = computers.length;
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int[][] computers, int n) {
        
        visited[n] = true;
        
        for (int i = 0; i < N; i++) {
            if (computers[n][i] != 1 || visited[i]) continue;
            dfs(computers, i);
        }
    }
}