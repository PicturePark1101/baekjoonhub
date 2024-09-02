import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] nums;
    private static int[] bucket;
    private static boolean[] visited;
    private static int N;
    private static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        bucket = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        dfs(0);
        br.close();    
    }
    
    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(bucket[i]+" ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bucket[depth] = nums[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;

            }
        }
    }
}
