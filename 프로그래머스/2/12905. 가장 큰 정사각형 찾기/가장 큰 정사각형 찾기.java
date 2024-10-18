class Solution{
    public int solution(int[][] board){
        int answer = 0;
        int R = board.length;
        int C = board[0].length;
        
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (board[i][j] == 1) {
                    int up = board[i - 1][j];
                    int upleft = board[i - 1][j - 1];
                    int left = board[i][j - 1];                  
                    board[i][j] += Math.min(up, Math.min(upleft, left));
                }

            }
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }        
        return answer * answer;
    }
}