import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String people : participant) {
            map.put(people, map.getOrDefault(people, 0) + 1);
        }
        
        for (String people : completion) {
            map.put(people, map.get(people) - 1);
        }
        
        for (Map.Entry<String, Integer> em : map.entrySet()) {
            if (em.getValue() != 0) return em.getKey();
        }
        return "";
    }
}