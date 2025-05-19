import java.util.*;

class Solution {
    
    static class Node {
        private int dest;
        private int cost;
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    
    private int[] dist;
    private List<Node>[] adjust;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        dist = new int[N + 1];
        adjust = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adjust[i] = new ArrayList<>();
        }
        makeAdjust(road);
        Arrays.fill(dist, Integer.MAX_VALUE);
        makeDist();
        
        for (int i = 0; i < N + 1; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }
    
    private void makeDist() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
        
            if (dist[now.dest] < now.cost) {
                continue;
            }
            
            for (Node next : adjust[now.dest]) {
                if (dist[next.dest] > next.cost + now.cost ) {
                    dist[next.dest] = next.cost + now.cost; 
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        
    }
    
    private void makeAdjust(int[][] road) {
        for (int i = 0; i < road.length; i++) {
            adjust[road[i][0]].add(new Node(road[i][1], road[i][2]));
            adjust[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
    }
}