import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] scores = {0, 0, 0};
        List<Integer> answer = new ArrayList<>();
        int[] p0 = {1, 2, 3, 4, 5};
        int[] p1 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p2 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p0[i % 5]) scores[0]++;
            if (answers[i] == p1[i % 8]) scores[1]++;
            if (answers[i] == p2[i % 10]) scores[2]++;
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        for (int i = 0; i < 3; i++) {
            if (maxScore == scores[i]) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}