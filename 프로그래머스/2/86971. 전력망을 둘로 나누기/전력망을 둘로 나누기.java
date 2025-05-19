import java.util.*;

class Solution {
    
    private List<Integer>[] adjust;
    private boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        adjust = new ArrayList[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            adjust[i] = new ArrayList<>();
        }
        
        for (int[] edge : wires) {
            adjust[edge[0]].add(edge[1]);
            adjust[edge[1]].add(edge[0]);
        }
        
        for (int[] edge : wires) {
            int count1 = getLinkedNodeCount(new boolean[n + 1], edge[0], edge[1]);
            int count2 = getLinkedNodeCount(new boolean[n + 1], edge[1], edge[0]);
            answer = Math.min(Math.abs(count1 - count2), answer);
        }
        
        return answer;
    }
    
    private int getLinkedNodeCount(boolean[] visited, int n, int expcetion) {

        visited[n] = true;   
        int count = 1;
        
        for (int ad : adjust[n]) {
            if (visited[ad] || expcetion == ad) {
                continue;
            }
            count += getLinkedNodeCount(visited, ad, expcetion);
        }
        return count;
    }
}