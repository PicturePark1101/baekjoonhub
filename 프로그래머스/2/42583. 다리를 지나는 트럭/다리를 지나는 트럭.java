import java.util.*;

class Solution {
    
    public static class Truck {
        private int weights;
        private int second;
        
        public Truck(int weights, int second) {
            this.weights = weights;
            this.second = second;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int N = truck_weights.length;
        // 걸리는 시간 올라감 + 길이
        
        Deque<Truck> queue = new ArrayDeque<>();
        Deque<Integer> done = new ArrayDeque<>();
        // 큐 사이즈 : bridge_length
        // 무게 제한 : weight
        int second = 0;
        int currentWeight = 0;
        int index = 0;
        
        while (done.size() != N) {
                        
            
            if (!queue.isEmpty() && queue.peek().second == bridge_length) { // 해당 초가 되면 뺀다.
                Truck q = queue.poll();
                done.offer(q.weights);
                currentWeight -= q.weights;
                // System.out.println(second+" 초, 꺼냄 :  "+q);
            }
            
            if (index < N && currentWeight + truck_weights[index] <= weight) {   
                // System.out.println(second+" 초, 넣음 :  "+truck_weights[index]);
                int next = truck_weights[index];
                
                queue.offer(new Truck(next, 0)); 
                currentWeight += next;
                index++;
            }
            second++;      
            
            addSecond(queue);
        }
        return second;
    }
    
    private void addSecond(Deque<Truck> queue) {
        for (Truck t : queue) {
            t.second++;
        }
    }
    
}