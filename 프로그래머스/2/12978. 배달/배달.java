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
    
    private ArrayList<Node>[] adList;
    private int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        
        adList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];            
            adList[a].add(new Node(b, c));
            adList[b].add(new Node(a, c));
        }
        
        int answer = 0;
        
        dijkstra(N);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }
    
    private void dijkstra(int N) {
        dist = new int[N + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);  
        dist[1] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        
        pq.add(new Node(1, 0));          
        while (!pq.isEmpty()) {
            Node now = pq.poll();     
            if (dist[now.dest] < now.cost) continue;
            
            for (Node next : adList[now.dest]) {
                if (next.cost + now.cost < dist[next.dest]) {
                    dist[next.dest] = next.cost + now.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }        
    }
}