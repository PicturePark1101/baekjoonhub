import java.util.*;

class Solution {
    private List[] childMap;
    private int max;
    private boolean[] visited;
    
    public int solution(int[] info, int[][] edges) {
        int N = info.length;
        childMap = new ArrayList[info.length];
        visited = new boolean[info.length];
        max = Integer.MIN_VALUE;
        
        // 리스트 만들기
        for (int i = 0; i < N; i++) {
            childMap[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            childMap[edges[i][0]].add(edges[i][1]);
        }
        
        ArrayList<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(info, next, 0, 0, 0);
        return max;
    }
    
    private void dfs(int[] info, List<Integer> next, int node, int s, int w) {
        if (info[node] == 1){ //늑대
            w++;
        } else {
            s++;
        }
        
        if (s <= w) {
            return;
        }
        
        max = Math.max(max, s);
        
        List<Integer> newNext = new ArrayList<>(next);
        newNext.addAll(childMap[node]); // 내가 방문할 수 있는 곳도 저장
        newNext.remove(Integer.valueOf(node));
        for (int i : newNext) {
            dfs(info, newNext, i, s, w);
        }
    }
}