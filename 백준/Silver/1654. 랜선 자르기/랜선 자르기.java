import java.util.*;
import java.io.*;


public class Main {
    
    private static int N;
    private static int M;
    private static int[] lines;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lines = new int[N];
        
        for (int i = 0; i < N; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(binary());
        br.close();
    }
    
    private static long binary() {
        
        long p = 1;
        long q = Arrays.stream(lines).max().getAsInt();
        long answer = 0;
        
        while (p <= q) {
            long mid = (p + q) / 2;
            if (isPossible(mid)) {
                p = mid + 1;
                answer = mid;
            } else {
                q = mid - 1;
            }
        }
        return answer;
    }
    
    private static boolean isPossible(long n) {
        int sum = 0;
        for (int line : lines) {
            if (line / n > 0) {
                sum += line / n;
            }
        }
        return sum >= M;
    }
}