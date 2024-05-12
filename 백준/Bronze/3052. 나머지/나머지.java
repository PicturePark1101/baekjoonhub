import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
        int[] remainderArr = new int[42];
        for (int i = 0; i < 10; i++) {
            int input = Integer.parseInt(br.readLine());
            remainderArr[input % 42]++;
        }
        
        int ans = 0;
        for (int i = 0; i < 42; i++) {
            if (remainderArr[i] != 0)
                ans++;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();

    }
}