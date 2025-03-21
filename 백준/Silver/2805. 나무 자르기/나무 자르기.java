import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] tree;
    private static int N;
    private static int M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        tree = new int[N];
        
         st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(binarySearch());
        br.close();
    }
    
    private static int binarySearch() {       
        int p = 0;
        int q = Arrays.stream(tree).max().getAsInt();
        int answer = 0;
        
        while (p <= q) {
            int mid = (p + q) / 2;
            
            if (ifPossible(mid)) { // 가능하다면 
                // 더 큰값을 찾아본다.
                answer = mid;
                p = mid + 1;
            } else {
                q = mid - 1;
            }           
        }
        return answer;
    }
    
    private static boolean ifPossible(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (tree[i] >= mid) {
                sum += tree[i] - mid;
            }
        }
        return sum >= M;
    }
}