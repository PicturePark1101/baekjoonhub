class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        while(!s.equals("1")) {
            String newStr = initZero(s);
            answer[0]++;
            answer[1] += s.length() - newStr.length();
            s = binary(String.valueOf(newStr.length()));
        }
        
        return answer;
    }
    private String initZero(String s) {
        return s.replace("0", "");
    }
    
    private String binary(String s) {
        int n = Integer.parseInt(s);
        if (n == 1) return s;
             
        String newStr = String.valueOf(n % 2L);
        return binary(String.valueOf(n / 2L)) + newStr;
    }
}