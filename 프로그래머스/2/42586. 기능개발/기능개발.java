import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[N];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++) {
            int remain = 100 - progresses[i];
            if (remain % speeds[i] != 0) {
                queue.add(remain / speeds[i] + 1);
            } else {
                queue.add(remain / speeds[i]);
            }
        }
        
        while(!queue.isEmpty()) {
            int e = queue.poll();
            System.out.println(e);
            int count = 1;
            while(!queue.isEmpty() && e >= queue.peek()) {
                queue.poll();
                count++;
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}