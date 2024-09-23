import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0 ; i < s.length(); i++) {
            s = rotationS(s);
            if (valid(s)) answer++;
        }
        return answer;
    }
    
    private String rotationS(String s) {
        String newS = "";
        for (int i = 1; i < s.length(); i++) {
            newS += s.charAt(i);
        }
        return newS + s.charAt(0);
    }
    
    private boolean valid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                switch(ch) {
                    case '}' :
                        if (stack.peek() != '{') return false;
                        break;
                    case ')' :
                        if (stack.peek() != '(') return false;
                        break;    
                    case ']' :
                        if (stack.peek() != '[') return false;
                        break;                         
                }
                stack.pop();
            }
        }        
        
        return stack.isEmpty();
    }
}