import java.util.*;

class Solution {

    private boolean[][] visited;
    private int n;
    private int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        // 큐..
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};
        Queue<Board> queue = new LinkedList<>();
        
        queue.offer(new Board(0, 0));
        visited[0][0] = true;
        int level = 0;
        
        while(!queue.isEmpty()) {
            level++;   
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Board tempBoard = queue.poll();
                if (tempBoard.getR() == n - 1 && tempBoard.getC() == m - 1) return level;
                
                for (int j = 0; j < 4; j++) {
                    int newR = tempBoard.getR() + dx[j];
                    int newC = tempBoard.getC() + dy[j];
                    // 방문할 수 있는 길이라면 
                    if (validPath(newR, newC) && !visited[newR][newC] && maps[newR][newC] == 1) {
                        queue.offer(new Board(newR, newC));
                        visited[newR][newC] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean validPath(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

class Board {
    private int r;
    private int c;
    
    public Board (int r, int c) {
        this.r = r;
        this.c = c;
    }
    
    public int getR() {
        return r;
    }
    
    public int getC() {
        return c;
    }
}