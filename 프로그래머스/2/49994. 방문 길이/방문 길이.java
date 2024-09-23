import java.util.*;

class Solution {
    public int solution(String dirs) {
        HashSet<String> visitedPath = new HashSet<>();

        int r = 0;
        int c = 0;
        for (int i = 0 ; i < dirs.length(); i++) {
            int[] movNext = commandNext(dirs.charAt(i));
            int newR = r + movNext[0];
            int newC = c + movNext[1];
 
            if (validPath(newR, newC)) {
                visitedPath.add(r+ " " +c+ " " +newR+ " "+newC);
                visitedPath.add(newR+ " " +newC+ " " +r+ " "+c);   
                r = newR;
                c = newC;
            }         
        }
        return visitedPath.size() / 2;
    }
    
    private int[] commandNext(char command) {
        switch(command){
            case 'U' : return new int[]{0, 1}; 
            case 'D' : return new int[]{0, -1}; 
            case 'R' : return new int[]{1, 0}; 
            case 'L' : return new int[]{-1, 0};       
        }
        return null;   
    }
    
    private boolean validPath(int r, int c) {
        return r >= -5 && r <= 5 && c >= -5 && c <= 5;
    }
}