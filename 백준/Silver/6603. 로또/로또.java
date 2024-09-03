import java.io.*;
import java.util.*;

public class Main {
    
    private static int k;
    private static int[] nums;
    private static int[] bucket;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        bucket = new int[6];
        k = Integer.parseInt(st.nextToken());
        while(k != 0) {
            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            } 
            makeLotto(0, 0, k);
            sb.append("\n");
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken()); 
        }
        
        System.out.println(sb.toString());
        br.close();
    }
    
    private static void makeLotto(int start, int depth, int k) {
        if(depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(bucket[i]+ " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i < k; i ++) {
            bucket[depth] = nums[i];
            makeLotto(i + 1, depth + 1, k);
        }
    }
}