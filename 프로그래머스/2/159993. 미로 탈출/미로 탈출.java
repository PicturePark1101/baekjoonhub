import java.util.*;

class Solution {
    
    static class Point{
        private int r;
        private int c;
        
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    private char[][] mapsChar;
    private int N;
    private int M;
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, 1, -1, 0};
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        mapsChar = new char[N][M];
        
        Point startPoint = null;
        Point leverPoint = null;
        Point exitPoint = null;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mapsChar[i][j] = maps[i].charAt(j);
                if (mapsChar[i][j] == 'S') {
                    startPoint = new Point(i, j);
                }
                if (mapsChar[i][j] == 'E') {
                    exitPoint = new Point(i, j);
                }
                if (mapsChar[i][j] == 'L') {
                    leverPoint = new Point(i, j);
                }
            }
        }
        
        int getLeverPath = bfs(startPoint, leverPoint);
        if (getLeverPath == -1) return -1;
        int getExitPath = bfs(leverPoint, exitPoint);
        if (getExitPath == -1) return -1;
        return getLeverPath + getExitPath;
    }
    
    private int bfs(Point start, Point end) {
        
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] path = new int[N][M];
        
        queue.offer(start);
        visited[start.r][start.c] = true;
        
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int nowR = now.r;
            int nowC = now.c;
            
            if (nowR == end.r && nowC == end.c) return path[nowR][nowC];
            
            for (int i = 0; i < 4; i++) {
                int newR = nowR + dx[i];
                int newC = nowC + dy[i];         
                
                if (!validPath(newR, newC)) continue;
                
                if (mapsChar[newR][newC] == 'X' || visited[newR][newC]) continue;
                queue.offer(new Point(newR, newC));
                visited[newR][newC] = true; 
                path[newR][newC] =  path[nowR][nowC] + 1;
            }            
        }
        
        return -1;
    }
    private boolean validPath(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
    
}