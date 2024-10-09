import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answers = new int[commands.length];
        int index = 0;
        for (int m = 0; m < commands.length; m++) {
            int i = commands[m][0];
            int j = commands[m][1];
            int k = commands[m][2];
            
            int[] list = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(list);
            answers[index++] = list[k - 1];
        }
        return answers;
    }
}