import java.util.*;

class Solution {
    
    static class Node {
        private int r;
        private int c;
        private int direction;
        private int cost;
        
        public Node(int r, int c, int cost, int direction) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.direction = direction;
        }
    }
    
    private int[][][] distance;
    private int[][] map;
    private int N;
    private final int[] dx = { 0, -1, 0, 1 }; // 왼, 위, 아래, 밑
    private final int[] dy = { -1, 0, 1, 0 };
    private int answer;
    
    public int solution(int[][] board) {
        N = board.length;
        map = board;
        distance = new int[N][N][4];
        answer = Integer.MAX_VALUE;
        
        bfs(new Node(0, 0, 0, -1));
        
        return answer;       
    }
    
    private void bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowC = now.c;
            int nowR = now.r;
            int nowCost = now.cost;
                        
            for (int i = 0; i < 4; i++) {
                int nextR = nowR + dx[i];
                int nextC = nowC + dy[i];
                
                if (!isValid(nextR, nextC) || map[nextR][nextC] == 1 || (nextR == 0 && nextC == 0)) continue;
                                
                int nextCost = nowCost + getCost(i, now.direction);
                
                if (N - 1 == nextR && N - 1 == nextC) {
                    answer = Math.min(answer, nextCost);
                } else if (distance[nextR][nextC][i] == 0 || nextCost < distance[nextR][nextC][i]) {
                    
                    distance[nextR][nextC][i] = nextCost;
                    queue.offer(new Node(nextR, nextC, nextCost, i)); 
                }                                            
            }           
        }
    }
    
    private boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
    
    private int getCost(int i, int nowDir) {
        if (nowDir == -1 || (nowDir - i) % 2 == 0) return 100;
        return 600;
    }
    
}