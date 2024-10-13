class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalArea = brown + yellow; 
        for (int i = 2; i <= totalArea / 2; i++) {
            if (totalArea % i == 0) {
                int j = totalArea / i;
                if ((i - 2) * (j - 2) == yellow) {
                    return new int[]{j, i};
                }
            }
        }
        
        return answer;
    }
}