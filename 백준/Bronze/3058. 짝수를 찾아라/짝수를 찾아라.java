import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int min = Integer.MAX_VALUE; 
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n % 2 == 0) {
                    sum += n;
                    min = Math.min(min, n);
                }
            }
            sb.append(sum).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}