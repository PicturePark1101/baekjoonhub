import java.util.*;

class Solution {
    
    private Queue<Integer> remain = new ArrayDeque<>();
    private int N;
    
    public int[] solution(int[] progresses, int[] speeds) {
        N = progresses.length;
        getRemain(progresses, speeds);
        return getAnswer();
    }
    
    private int[] getAnswer() {
        List<Integer> answer = new ArrayList<>();
        
        while (!remain.isEmpty()) {
            int current = remain.poll();
            int count = 1;
            while (!remain.isEmpty() && current >= remain.peek()) {
                count++;
                remain.poll();
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private void getRemain(int[] progresses, int[] speeds) {
        for (int i = 0; i < N; i++) {
            
            int leftTime = 100 - progresses[i];
            if (leftTime % speeds[i] == 0) {
                remain.offer(leftTime / speeds[i]);
            } else {
                remain.offer(leftTime / speeds[i] + 1);
            }
        }
        
    }
}