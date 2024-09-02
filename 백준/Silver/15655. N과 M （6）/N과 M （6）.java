import java.util.*;
import java.io.*;

public class Main {
    
    private static int N;
    private static int M;
    private static int[] nums;
    private static int[] bucket;
    
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
        dfs(0, 0);
        br.close();
    }
    
    private static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(bucket[i]+ " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = start; i < N; i++) {
            bucket[depth] = nums[i];
            dfs(i + 1, depth + 1);
        }
    }
    
}