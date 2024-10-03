class Solution {
    private static int answer;
    private int[] arr;
    private int N;
    public int solution(int n) {
        arr = new int[n];
        N = n;
        answer = 0;
        dfs(0);
        return answer;
    }
    
    private void dfs(int depth) {        
        if (depth == N) {
            answer++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
           arr[depth] = i;
           if (validBoard(depth)) {
               dfs(depth + 1); 
           } 
        }
    }
    
    private boolean validBoard(int c) {
        for (int i = 0; i < c; i++) {
            if (arr[i] == arr[c]) return false;
            if (Math.abs(arr[i] - arr[c]) == Math.abs(i - c)) return false;
        }
        return true;
    }  
}