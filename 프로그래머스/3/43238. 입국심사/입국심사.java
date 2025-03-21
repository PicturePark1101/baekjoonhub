import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = Arrays.stream(times).max().getAsInt();
        long p = 0;        
        long q = max * n;
        
        while (p <= q) {
            long mid = (p + q) / 2;
                       
            if (isPossible(n, times, mid)) {
                answer = mid;
                q = mid - 1;
            } else {
                p = mid + 1;
            }
        }
        return answer;
    }
    
    private boolean isPossible(int n, int[] times, long t) {
        long sum = 0;
        
        for (int i = 0; i < times.length; i++) {
            sum += t / times[i];
        }
        
        return sum >= n;
    }
}