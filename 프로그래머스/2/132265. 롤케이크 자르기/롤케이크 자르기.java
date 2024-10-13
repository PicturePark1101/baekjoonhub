import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> allMap = new HashMap<>();
        
        for (int t : topping) {
            allMap.put(t, allMap.getOrDefault(t, 0) + 1);
        }
        
        HashMap<Integer, Integer> userAMap = new HashMap<>();
        
        int answer = 0;
        int userA = 0;
        int userB = allMap.size();
        for (int t : topping) {
            userAMap.put(t, userAMap.getOrDefault(t, 0) + 1);
            userA = userAMap.size();
            if (allMap.get(t) - userAMap.get(t) <= 0) {
                userB--;
            }
            // System.out.println(userA+" "+userB);
            if (userA == userB) answer++;
        }        
        
        
        return answer;
    }
}