import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] arr = new String[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int countR = 0;
        for (int i = 0; i < N; i++) {
            if (!arr[i].contains("X")) {
                countR++;
            }
        }
        
        int countC = 0;
        boolean flag;
        for (int j = 0; j < M; j++) {
            flag = true;
            for (int i = 0; i < N; i++) {    
                if (arr[i].charAt(j) == 'X') {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                countC++;
            }
        }
        
        System.out.println(Math.max(countC, countR));
        br.close();
    } 
}