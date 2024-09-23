import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        if (stack.isEmpty()) return true;
        return false;
    }
}