import java.util.*;

class Solution {
    
    static class Process {
        private int n;
        private int index;
        
        public Process(int n, int index) {
            this.n = n;
            this.index = index;
        }
    }
    
    private LinkedList<Process> queue = new LinkedList<>();
    
    public int solution(int[] priorities, int location) {        
        int N = priorities.length;
         
        List<Integer> priority = new ArrayList<>();
                
        for (int i = 0; i < N; i++) {
            priority.add(priorities[i]);
            queue.offer(new Process(priorities[i], i));
        }
        
        priority.sort(Comparator.reverseOrder());

        int ans = 0;
        while (!queue.isEmpty()) {
            Process current = queue.peek();
            if (priority.get(0) == current.n) {
                Process pollP = queue.poll();
                ans++;
                                
                if (location == pollP.index) {
                    return ans;
                }
                priority.remove(0);
            } else {
                queue.offer(queue.poll());
            }
        }
        
        return execute(location);
    }
    
    private int execute(int location) {        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            Process current = queue.peek();
            boolean isMax = true;
            
            for (int i = 1; i < queue.size(); i++) {
                Process temp = queue.get(i);
                
                if (current.n < temp.n) { 
                    isMax = false;
                    for (int j = 0; j < i; j++) {
                        queue.offer(queue.poll());
                    }
                }
            }
            
            if (isMax) {
               answer++;
                if (queue.poll().index == location) {
                    return answer;
                }
            }
        
        }
        return 0;
    }
}