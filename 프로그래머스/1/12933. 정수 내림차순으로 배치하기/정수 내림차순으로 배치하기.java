import java.util.*;

class Solution {
    public long solution(long n) {
        List<Long> arrList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            arrList.add(n % 10);
            n /= 10;
        }
        
        arrList.sort(Comparator.reverseOrder());
        for (Long num : arrList) {
            sb.append(num);
        }
        
        return Long.parseLong(sb.toString());
    }
}