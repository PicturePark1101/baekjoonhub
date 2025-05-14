import java.util.*;

class Solution {
    
    private boolean[][] visited;
    private int N;
    private int M;
    private int[][] distance;
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, 1, -1, 0};
    
    static class Point {
        private int r;
        private int c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        distance = new int[N][M];
        visited = new boolean[N][M];
        int answer = 0;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        distance[0][0] = 1;
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowR = now.r;
            int nowC = now.c;
        
            for (int i = 0; i < 4; i++) {
                int nextR = nowR + dx[i];
                int nextC = nowC + dy[i];
                
                
                if (!vaildPath(nextR, nextC) || visited[nextR][nextC]) continue;
            
        
                if (maps[nextR][nextC] == 1) {        
                    queue.offer(new Point(nextR, nextC));
                    distance[nextR][nextC] = distance[nowR][nowC] + 1;
                    visited[nextR][nextC] = true;
                }
            }
        }
        return distance[N - 1][M - 1] == 0 ? -1 : distance[N - 1][M - 1];
    }
    
    private boolean vaildPath(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}