import java.util.*;



class Solution {
    
    static class Map {
        private int r;
        private int c;
    
        public Map(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    private static boolean[][] visited;
    private static int[] dx = { -1, 0, 0, 1 };
    private static int[] dy = { 0, 1, -1, 0 };
    private static int n;
    private static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;    
        visited = new boolean[n][m];
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        Queue<Map> queue = new ArrayDeque<>();
        int length = 0;
        queue.add(new Map(0, 0));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
          length++;
            int size = queue.size();
           for (int j = 0; j < size; j++) {
                Map map = queue.poll();
                int mR = map.r;
                int mC = map.c;
               
                if (mR == n - 1 && mC == m - 1) {
                    return length;
                }

                visited[mR][mC] = true;
                for (int i = 0; i < 4; i++) {
                    int newR = dx[i] + mR;
                    int newC = dy[i] + mC;
                    if (validPath(newR, newC) && maps[newR][newC] == 1 && !visited[newR][newC]) {
                        queue.add(new Map(newR, newC));
                        visited[newR][newC] = true;                    
                    }          
                }
            }
        }
        
        return -1;
    }
    
    private boolean validPath(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}