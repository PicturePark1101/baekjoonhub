class Solution {
    public int[] solution(String[] keyinput, int[] board) {        
        int x = 0;
        int y = 0;
        for (String command : keyinput) {
            int[] newLocation = newLocation(x, y, command);
            if (isValidPath(newLocation, board[0], board[1])) {
                x = newLocation[0];
                y = newLocation[1];
            }
        }
        return new int[]{x, y};
    }
    private int[] newLocation(int x, int y, String command) {
        switch(command) {
            case "up" :  
                return new int[]{x, y + 1};
            case "right" : 
                return new int[]{x + 1, y};
            case "down" : 
                return new int[]{x, y - 1};    
            case "left" :
                return new int[]{x - 1, y};                
            }
        return new int[2];
    }
    private boolean isValidPath(int[] newLocation, int r, int c) {
        return Math.abs(newLocation[0]) <= r / 2 && Math.abs(newLocation[1] ) <= c / 2;
    }
}