import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {}; 
        int[] challenger = new int[N + 2];
        
        HashMap<Integer, Double> map = new HashMap<>();
        
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]]++;
        }
        
        int clear = challenger[N + 1];    
        for (int i = N; i >= 1; i--) {
        clear += challenger[i];
            if (challenger[i] != 0) {
                map.put(i, (double)challenger[i] / clear);
            } else {
                map.put(i, (double)0);
            }
        }

        return map.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}