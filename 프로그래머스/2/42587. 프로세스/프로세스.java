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
    
    private Process[] processes;
    public int solution(int[] priorities, int location) {        
        int N = priorities.length;
        
        processes = new Process[N];
        

        
        PriorityQueue<Process> queue = new PriorityQueue<>(
            (a, b) -> {
                if (b.n == a.n) {
                    return Integer.compare(b.index, a.index);  
                }
                return Integer.compare(b.n, a.n);             
            }
        );
        
        for (int i = 0; i < N; i++) {
            queue.offer(new Process(priorities[i], i));
        }        
    
        int order = 1;
        while (!queue.isEmpty()) {
            Process p = queue.poll();
            if (p.index == location) return order;
            order++;
        }
        return 0;
    }
    
    private void execute() {
        Queue<Process> queue = new ArrayDeque<>();
        
        // while(queue.isEmpty()) {
            
        // }
        
    }
}