import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
        
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());
                int N = Integer.parseInt(st.nextToken());
                sb.append(getAnswer(H, W, N)).append("\n");
            
        }
        
        System.out.println(sb);
        br.close();
    }
    
    private static int getAnswer(int H, int W, int N) {
        int[][] hotel = new int[H][W];
        int count = 0;
        for (int i = 0; i < W; i++) {
             for (int j = 0; j < H; j++) {
                 count++;
                 if (count == N) {
                     return (j + 1) * 100 + i + 1;
                 }
             }
        }
        return 0;
    }
}