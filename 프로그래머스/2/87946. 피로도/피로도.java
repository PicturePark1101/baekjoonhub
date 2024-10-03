class Solution {
    private static int answer;
    private static int N;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        answer = Integer.MIN_VALUE;
        visited = new boolean[N];
        dfs(dungeons, 0, k);
        return answer;
    }
    
    private void dfs(int[][] dungeons, int depth, int health) {           
        for (int i = 0; i < N; i++) {             
            if (!visited[i] && health >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, depth + 1, health - dungeons[i][1]);
                answer = Math.max(answer, depth + 1);
                visited[i] = false;
            }            
        }       
    } 
}