import java.util.*;

class Solution {
    private int N;
    private String[] numsbersArr;
    private boolean[] visited;
    private Set<Integer> visitedNums = new HashSet<>();
    private int answer;
    public int solution(String numbers) {
        N = numbers.length();
        numsbersArr = numbers.split("");
        
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N];
            pick("", 0, i);
        }
        return answer;
    }
    
    private void pick(String str, int depth, int m) { // m개 뽑아야함
        if (depth == m) {
            int tranferNum = Integer.parseInt(str);
            if (!visitedNums.contains(tranferNum) && isPrime(tranferNum)) {
                visitedNums.add(tranferNum);
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pick(str + numsbersArr[i], depth + 1, m);
                visited[i] = false;
            }

        }
        
    }
    
    private boolean isPrime(int n) {
        if (n == 1 || n == 0) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false; 
        }
        return true;
        
    }
}