import java.util.*;

class Solution {
    int[] up;
    int[] down;  
    Stack<Integer> trashCan = new Stack<>();
    
    public String solution(int n, int k, String[] cmd) {
        String[] answer = new String[n];
        
        up = new int[n + 2];
        down = new int[n + 2];
        trashCan = new Stack<Integer>();
        
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
            
        int pointer = k + 1;
        
        for (int i = 0; i < cmd.length; i++) {
            pointer = command(cmd[i], pointer, trashCan, n);
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = "O";
        }
        
        for (int i : trashCan) {
            answer[i - 1] = "X";
        }
        
        return String.join("", answer);
    }
    
    private int command(String cmd, int pointer, Stack<Integer> trashCan, int n) {
        String[] cmdList = cmd.split(" ");
        
        if (cmdList[0].equals("C")) { // 삭제한 후
            trashCan.push(pointer);
            up[down[pointer]] = up[pointer];
            down[up[pointer]] = down[pointer];
            pointer = n < down[pointer] ? up[pointer] : down[pointer];
        } else if(cmdList[0].equals("Z")) {
            int restore = trashCan.pop();
            up[down[restore]] =  restore;
            down[up[restore]] = restore;
        } else {
            for (int i = 0; i < Integer.parseInt(cmdList[1]); i++) {
                pointer = cmdList[0].equals("U") ? up[pointer] : down[pointer];
            }
        }
   
        return pointer;
    }
}