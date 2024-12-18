import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] DP0 = new int[41];
    private static int[] DP1 = new int[41];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        makeDP0();
        makeDP1();
        
        int N = Integer.parseInt(br.readLine());       
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(DP0[num]).append(" ").append(DP1[num]).append("\n");
        }
        System.out.println(sb);
        br.close();  
    }
    
    private static void makeDP0() {
        DP0[0] = 1;
        DP0[1] = 0;
        for (int i = 2; i <= 40; i++) {
            DP0[i] = DP0[i - 1] + DP0[i - 2];
        }
    }
    private static void makeDP1() {
        DP1[0] = 0;
        DP1[1] = 1;
        for (int i = 2; i <= 40; i++) {
            DP1[i] = DP1[i - 1] + DP1[i - 2];
        }
    }    
}
