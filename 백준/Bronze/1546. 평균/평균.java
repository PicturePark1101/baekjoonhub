import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.valueOf(br.readLine());
        double[] nums = new double[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Double.valueOf(st.nextToken());
        }
        
        fixArr(nums, max(nums));
        System.out.println(calcAvg(nums));
        
        br.close();
    }
    
    private static double max(double[] nums) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
    
    private static void fixArr(double[] nums, double max) {
        for (int i = 0; i < nums.length; i++) {
             nums[i] = nums[i] / max * 100;
        }
    }
    
    private static double calcAvg(double[] nums) {
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
             sum += nums[i];
        }
        return sum / nums.length;
    }
}