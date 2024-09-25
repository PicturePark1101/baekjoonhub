import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int pick = stack.pop();
                answer[pick] = i - pick;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) { 
            int pick = stack.pop();
            answer[pick] = prices.length - pick - 1;
        }

        
        return answer;
        
        
    }
}