import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int N = commands.length;
        int M = commands[0].length;
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int[] newArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(newArr);
            answer[i] = pickK(newArr, commands[i][2]);
        }

        return answer;
    }
    
    private int pickK(int[] arr, int k) {
        return arr[k - 1];
    }
}