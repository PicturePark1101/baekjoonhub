class Solution {
    
    private int[] op = { -1,  1 };
    private int N;
    private int T;
    private int answer;
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        T = target;
        return dfs(numbers, 0, 0);
    }
    
    // 중복을 허용함. 2개를 5번에 
    
    private int dfs(int[] numbers, int depth, int n) {
        if (depth == N) {
            if (n == T) {
                return 1;
            } 
            return 0;
        }
               
        return dfs(numbers, depth + 1, n + numbers[depth] * op[0]) + dfs(numbers, depth + 1, n + numbers[depth] * op[1]);
    }
    
    
}