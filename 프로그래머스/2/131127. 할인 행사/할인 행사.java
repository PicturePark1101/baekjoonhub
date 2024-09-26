import java.util.*;

class Solution {
    private HashMap<String, Integer> hm;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        hm = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            hm.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            if (validSignUp(discount, i)){
                answer++;
            }
        }
        return answer;
    }
    private boolean validSignUp(String[] discount, int start) {
        HashMap<String, Integer> bucket = new HashMap<>();
        for (int i = start; i < start + 10; i++) {
            if (!hm.containsKey(discount[i])) {
                return false;
            }
            bucket.put(discount[i], bucket.getOrDefault(discount[i], 0) + 1);
        }
        
        for (Map.Entry<String, Integer> it : hm.entrySet()) {
            if (bucket.get(it.getKey()) != it.getValue()) {
                return false;
            }
        }
        return true;
    }
}