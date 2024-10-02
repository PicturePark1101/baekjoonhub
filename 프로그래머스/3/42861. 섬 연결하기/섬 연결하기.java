import java.util.*;
class Solution {
    private static int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int edages = 0;
        int answer = 0;

        for (int[] edge : costs) {
            if (edages == n - 1) {
                break;
            }
        
            if (find(edge[0]) != find(edge[1])) { // 루트가 같지 않다면
                union(edge[0], edge[1]);
                answer += edge[2];
                edages++;
            }
        }
            
        return answer;
    }
    
    private static void union(int n1, int n2) {
        int root1 = find(n1);
        int root2 = find(n2); 
        parent[root2] = root1;
    }
    
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}