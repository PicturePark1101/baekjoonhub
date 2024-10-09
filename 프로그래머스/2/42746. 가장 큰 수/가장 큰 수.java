import java.util.*;

class Solution {
    
    private int N;
    private boolean[] visited;
    private String answer;
    
    public String solution(int[] numbers) {
        N = numbers.length;
        answer = "-1";
        visited = new boolean[N];
        
        String[] numberToStr = new String[N];
        
        int index = 0;
        for (int number : numbers) {
            numberToStr[index++] = String.valueOf(number);
        }
        
        Arrays.sort(numberToStr, new Comparator<String>() {
            @Override 
            public int compare(String s1, String s2) {
                int a = Integer.parseInt(s2 + s1);
                int b = Integer.parseInt(s1 + s2);
                return Integer.compare(a, b);            
            }
        });
        
        String answer = String.join("", numberToStr);
        if (answer.charAt(0) == '0') return "0";
        return answer;
    }
}