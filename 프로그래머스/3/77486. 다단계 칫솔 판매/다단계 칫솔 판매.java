import java.util.*;

class Solution {
    private final String root = "MINHO";
    private HashMap<String, String> referralMap = new HashMap<>();
    private HashMap<String, Integer> resultMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        
        for (int i = 0; i < N; i++) {
            if (referral[i].equals("-")) {
                referralMap.put(enroll[i], root);
            }else {
                referralMap.put(enroll[i], referral[i]);
            }
        }
        
        for (int i = 0; i < seller.length; i++) {
            calcResult(seller[i], amount[i] * 100);
        }
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) { 
            answer[i] = resultMap.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
    
    private void calcResult(String currentSeller, int money) {
        if (currentSeller.equals(root)) {
            return;
        }

        if (money * 0.1 < 1) {
            resultMap.put(currentSeller, resultMap.getOrDefault(currentSeller, 0) + money);
            return;
        }
        
        resultMap.put(currentSeller, resultMap.getOrDefault(currentSeller, 0) + money - (money / 10));
        
        calcResult(referralMap.get(currentSeller), money / 10);
    }
}