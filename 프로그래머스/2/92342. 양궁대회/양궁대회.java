import java.util.*;

class Solution {
    
    private static int maxGap;
    private static int[] answer = new int[11];
    private static int[] infoArr = new int[11];

    public int[] solution(int n, int[] info) {
        infoArr = info;
        maxGap = 0;
        pick(new int[11], 0, n, n);
        
        if (maxGap == 0) {
            return new int[]{-1};
        }
        return answer;
        
    }
    
    private void pick(int[] bucket, int depth, int remainArrow, int n) {     
        if (depth == 10) {
            bucket[depth] = remainArrow;
            getAnswer(bucket);
            bucket[depth] = 0;
            return;
        }
        
        for (int i = remainArrow; i >= 0; i--) {
            bucket[depth] = i;
            pick(bucket, depth + 1, remainArrow - i, n);
            bucket[depth] = 0;
        }
    }
    
    
    private void getAnswer(int[] bucket){
        int gap = calcScoreGap(bucket);

        if (maxGap < gap) {
            maxGap = gap;
            answer = bucket.clone();
        } else if (gap > 0 && maxGap == gap) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] != bucket[i]) {
                if (answer[i] < bucket[i]) {
                    answer = bucket.clone();
                    
                } 
                    return;
                }
            }        
        }
    }

    private int calcScoreGap(int[] bucket) {
        int rion = 0;
        int aPeach = 0;
        for (int i = 0; i < 11; i++) {
            if (infoArr[i] == 0 && bucket[i] == 0) continue;
            
            if (infoArr[i] >= bucket[i]) {
                aPeach += (10 - i);
            } else {
                rion += (10 - i);
            }
        }
        return rion - aPeach;
    }
}