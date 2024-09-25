import java.util.*;

class Solution {
    public int solution(String s) {
        String[] cmd = s.split(" ");
        int last = 0;
        int answer = 0;
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].equals("Z")) {
                answer -= last;
            } else {
                int num = Integer.parseInt(cmd[i]);
                answer += num;
                last = num;
            }
        }
        return answer;
    }
}