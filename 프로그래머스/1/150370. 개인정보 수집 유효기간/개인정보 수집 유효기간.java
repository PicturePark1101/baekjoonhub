import java.util.*;
class Solution {
    Map<String, Integer> termsMap = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < terms.length; i++) {
            String[] input = terms[i].split(" ");
            termsMap.put(input[0], Integer.parseInt(input[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            if (!validPrivacies(today, privacies[i])) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean validPrivacies(String today, String privacies) {
        String[] splitPrivacies = privacies.split(" ");
        int term = termsMap.get(splitPrivacies[1]);
        
        if (parseDay(splitPrivacies[0]) + term * 28 <= parseDay(today)) {
            return false;
        }
        return true;
    }
    
    private int parseDay(String day){
        int[] tmp = Arrays.stream(day.split("\\.")).mapToInt(Integer::parseInt).toArray();
        return (tmp[0] * 12 * 28) + (tmp[1] * 28) + tmp[2];
    }
}