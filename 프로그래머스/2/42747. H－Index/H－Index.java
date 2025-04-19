import java.util.*;

class Solution {
    private int N;
    private int[] arr;
    
    public int solution(int[] citations) {
        arr = citations;
        N = citations.length;
        Arrays.sort(arr);
        int max = arr[N - 1];
        
        for (int i = max; i >= 0; i--) {
            if (isValid(i)) {
                return i;
            }
        }
        return 0;
    }
    
    
    private boolean isValid(int h) {   
        // h편 이상인 가장 작은 논문을 찾는다. 
        int index = findIdx(h); 
        int h1 = N - index;  
        return h1 == h;
    }
    
    private int findIdx(int h) {
        int p = 0;
        int q = N - 1;
        int answer = N;
        
        while (p <= q) {
            int mid = (p + q) / 2;
            
            if (h > arr[mid]) {
                p = mid + 1;
            } else if (h <= arr[mid]) {
                answer = mid;
                q = mid - 1;
            }        
        }
        return answer;
    }
    
    
}