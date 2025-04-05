import java.util.*;

class Solution {
    private int N;
    private int[] arr;
    
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        N = commands.length;
        arr = array;
        
        for (int i = 0; i < N; i++) {
            answer.add(execute(commands[i][0], commands[i][1], commands[i][2]));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int execute(int p, int q, int k) {
        List<Integer> temp = new ArrayList<>();
        
        for (int i = p - 1; i <= q - 1; i++) {
            temp.add(arr[i]);
        }
        
        temp.sort(null);
        return temp.get(k - 1);
    }
}