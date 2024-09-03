import java.io.*;
import java.util.*;

public class Main {
    
    private static int N;
    private static int S;
    private static int[] nums;
    private static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
      
        st = new StringTokenizer(br.readLine());        
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        makeAns(0, 0);
        if (S == 0) ans--;
        System.out.println(ans);
        br.close();
    }
    
    private static void makeAns(int depth, int sum) {
        if (depth == N) {
            if (sum == S) { ans++; }
            return;
        }
        
        makeAns(depth + 1, sum + nums[depth]);
        makeAns(depth + 1, sum);
    }
}