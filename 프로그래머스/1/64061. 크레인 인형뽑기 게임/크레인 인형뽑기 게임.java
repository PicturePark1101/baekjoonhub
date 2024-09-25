import java.util.*;

class Solution {
    private int N;
    private Stack<Integer>[] boardStack;
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        N = board.length;
        Stack<Integer> bucket = new Stack<>();
        
        makeStack(board);

        for (int i = 0; i < moves.length; i++) {
            if (!boardStack[moves[i]].isEmpty()) {
                int toy = boardStack[moves[i]].pop();
                if (!bucket.isEmpty() && toy == bucket.peek()) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(toy);
                }  
            }
        }
        
        return answer;
    }
    
    private void makeStack(int[][] board) {
        boardStack = new Stack[N + 1];
        
        for (int i = 1; i <= N; i++) {
            boardStack[i] = new Stack<>();
        }      
    
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) { 
                if (board[i][j] != 0) {
                    boardStack[j + 1].push(board[i][j]);
                }
            }
        }  
    }
}