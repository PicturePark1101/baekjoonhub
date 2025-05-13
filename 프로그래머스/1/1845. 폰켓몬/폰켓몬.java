import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> peonKet = new HashSet<>();
        for (int n : nums) {
            peonKet.add(n);
        }
        if (peonKet.size() > nums.length / 2) {
            answer = nums.length / 2;
        } else {
            answer = peonKet.size();
        }
        return answer;
    }
}