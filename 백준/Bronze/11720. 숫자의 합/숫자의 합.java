import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split("");
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += Integer.parseInt(nums[i]);
        }
        
        bw.write(String.valueOf(sum));
        bw.close();
        br.close();

    }
    
}