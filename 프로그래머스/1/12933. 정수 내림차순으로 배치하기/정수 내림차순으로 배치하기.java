import java.util.*;

class Solution {
    public long solution(long n) {
        String[] N = Long.toString(n).split("");
        
        Arrays.sort(N, (n1, n2) -> {
            return n2.compareTo(n1);
        });
        
        return Long.parseLong(String.join("", N));
    }
}