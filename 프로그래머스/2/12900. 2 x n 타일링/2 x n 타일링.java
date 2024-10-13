class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] F = new int[n + 1];
        
        F[1] = 1;
        F[2] = 2;
        for (int i = 3; i <= n; i++) {
            F[i] = (F[i - 1] + F[i - 2]) % 1000000007;
        }
        return F[n] % 1000000007;
    }
}