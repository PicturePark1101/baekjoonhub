class Solution {
    
    private int answer;
    private int N;
    private boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = Integer.MIN_VALUE;
        N = dungeons.length;
        visited = new boolean[N];
        
        dfs(dungeons, k, 0, 0);
        
        return answer;
    }
    
    private void dfs(int[][] dungeons, int health, int depth, int n) {
        if (depth == N) {
            answer = Math.max(answer, depth);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i] || health < dungeons[i][0]) continue;
            visited[i] = true;
            dfs(dungeons,  health - dungeons[i][1], depth + 1, i);
            answer = Math.max(answer, depth + 1);
            visited[i] = false;
        }
    }
}