import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {   
        int index1 = 0;
        int index2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        // for (int i = 0; i < cards1.length; i++) {
        //     q1.add(cards1[i]);
        // }
        // for (int i = 0; i < cards2.length; i++) {
        //     q2.add(cards2[i]);
        // }
        // 카드는 사용하지 않고 다음 카드로 넘어갈 수 없다 
        
        for (int i = 0; i < goal.length; i++) {
            if (index1 < cards1.length && cards1[index1].equals(goal[i])) {
                index1++;
            }
            else if (index2 < cards2.length && cards2[index2].equals(goal[i])) {
                index2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}