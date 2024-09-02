import java.util.*;
import java.io.*;

public class Main {
    
    private static int N;
    private static int M;
    private static int[] nums;
    private static int[] bucket;
    private static boolean[] visited;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        
        nums = new int[N];
        bucket = new int[M];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0, 0);
        System.out.println(sb.toString());
        br.close();
    }
    
    private static void dfs(int start, int depth) {
        if (M == depth) {
            for (int i = 0; i < M; i++) {
                sb.append(bucket[i]+" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i < N; i++) {
           bucket[depth] = nums[i];
           dfs(i, depth + 1);
        }
    }
    
    
}
