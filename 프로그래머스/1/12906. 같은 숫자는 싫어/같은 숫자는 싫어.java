import java.util.*;

public class Solution {
    public int[] solution(int []arr) {        
        List<Integer> nums = new ArrayList<>();
        for (int n : arr) {
            if (nums.isEmpty() || nums.get(nums.size() - 1) != n) {
                nums.add(n);
            }
        }
        return nums.stream().mapToInt(Integer::intValue).toArray();
    }
}