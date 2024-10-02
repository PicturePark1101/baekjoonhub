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
    
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, 1, -1, 0};    
    private static int R;
    private static int C;

    public int solution(String[] maps) {
        int answer = 0;
        R = maps.length;
        C = maps[0].split("").length;
        
        Map startInfo = null;
        Map endInfo = null;
        Map leverInfo = null;
        for (int i = 0; i < maps.length; i++) {
            String[] str = maps[i].split("");
            for (int j = 0; j < C; j++) {
                if (str[j].equals("S")) {
                    startInfo = new Map(i, j);
                }
                if (str[j].equals("E")) {
                    endInfo = new Map(i, j);
                }
                if (str[j].equals("L")) {
                    leverInfo = new Map(i, j);
                }                
            }
        }
        
        int first = bfs(maps, startInfo, leverInfo);
        int second = bfs(maps, leverInfo, endInfo);
        if (first == -1 || second == -1) return -1;

        return first + second;
    }
    
    private int bfs(String[] maps,  Map start, Map end) {
        int[][] dist = new int[R][C];
        
        Queue<Map> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start.r][start.c] = 1;
                
        while(!queue.isEmpty()) {
            Map m = queue.poll();
            int mR = m.r;
            int mC = m.c;

            for (int i = 0; i < 4; i++) {
                int newR = mR + dx[i];
                int newC = mC + dy[i];
                if (!validPath(newR, newC)) continue;
                if (dist[newR][newC] != 0) continue;
              
                if (maps[newR].charAt(newC) != 'X'){
                    queue.offer(new Map(newR, newC));
                    dist[newR][newC] = dist[mR][mC] + 1;
                }
            }
        }
   
        return dist[end.r][end.c] - 1;
    }
        
    private boolean validPath(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}