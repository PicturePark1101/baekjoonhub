class Solution
{
    public int solution(int n, int a, int b){        
        return match(a, b);
    }
    
    private int match(int a, int b) {
        if (a == b) return 0;
        a = getNext(a);
        b = getNext(b);
        return match(a, b) + 1;
    }
    
    private int getNext(int n) {
        if (n % 2 != 0) {
            return n / 2 + 1;
        }
        return n / 2;
    }
}