import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());   
        }
        
        int M = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (M == arr[i]){
                cnt++;
            } 
        }
        System.out.println(cnt);
        br.close();
    }
}