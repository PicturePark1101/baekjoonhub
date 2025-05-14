import java.util.*;

class Solution {
    private int N;
    private int[] graph;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        N = costs.length;
        graph = new int[n];
        int edge = 0;
        initGraph();
        
        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];
        });
        
        for (int i = 0; i < N; i++) {
            
            if (edge == n - 1) return answer;
            
            if (isCycle(costs[i][0], costs[i][1])) continue;
            
            union(costs[i][0], costs[i][1]);
            answer += costs[i][2];
            edge++;
        }
        return answer;
    }
   
    private boolean isCycle(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        return rootA == rootB;
    }
    
    private int findRoot(int n) {
        if (graph[n] == n) return n;
        return findRoot(graph[n]); 
    }
    
    private void union(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        graph[rootA] = rootB;
    }
    
    private void initGraph() {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = i;
        }
    }
}