import java.util.*;
import java.io.*;

public class Main {
    
    private static int N;
    private static int M;
    private static int[] nums;
    private static int[] bucket;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        bucket = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
          nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        pick(0, 0);
        
        System.out.println(sb);
        br.close();
    }
    
    private static void pick(int start, int depth) {
        if (M == depth) {
            for (int b : bucket) {
                sb.append(b).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i < N; i++) {
            bucket[depth] = nums[i];
            pick(i, depth + 1);
        }
    }
    
}