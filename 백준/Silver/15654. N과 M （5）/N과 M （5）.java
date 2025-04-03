import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] bucket;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));           
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        
        arr = new int[N];
        visited = new boolean[N];
        bucket = new int[M];
        
        st = new StringTokenizer(br.readLine());        
        for (int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        permutation(0);
        System.out.print(sb);
        br.close();
    }
    
    private static void permutation(int r) {
        if (r == M) {
            for (int i = 0; i < M; i++) {
                sb.append(bucket[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bucket[r] = arr[i];
                permutation(r + 1);
                visited[i] = false;
            }
        }
        
    }
}