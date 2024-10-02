class Solution {
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i);
                System.out.println();
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int[][] computers, int node) {
        visited[node] = true;
        
        for (int i = 0; i < computers[node].length; i++) {
            if (!visited[i] && computers[node][i] == 1 && node != i) {
                dfs(computers, i);
            }
        }        
    }
}