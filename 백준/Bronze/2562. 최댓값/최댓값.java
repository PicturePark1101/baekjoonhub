import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[9];        
        int maxIdx = 0;
        
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i] >= nums[maxIdx]) {
                maxIdx = i;
            }
        }
        
        System.out.println(nums[maxIdx]);        
        System.out.println(maxIdx + 1);        

    }
    
}