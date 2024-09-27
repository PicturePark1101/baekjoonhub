class Solution{
    public int solution(int n, int a, int b){
        return fight(a, b);
    }
    
    private int fight(int A, int B) {
        if (Math.abs(A - B) == 1) {
            if (A % 2 == 1 && B - A == 1) {
                return 1;
            } else if (B % 2 == 1 && A - B == 1) {
                return 1;
            }
        }
        
        return fight(next(A), next(B)) + 1;
    }
    
    private int next(int n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        return n / 2 + 1;
    }
}