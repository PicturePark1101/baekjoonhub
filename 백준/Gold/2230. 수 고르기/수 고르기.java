import java.util.*;
import java.io.*;

public class Main {
    
    // 조합으로도 풀 수 있남...
    public static int minGap(int[] arr, int M) {
        
        int minAns = Integer.MAX_VALUE;
        int gap = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            
            do {
                gap = arr[j] - arr[i];
                j++;
            } while(gap < M && j < arr.length);
           
         
            if (gap >= M) {
                minAns = Math.min(minAns, gap);
            }
        }
        return minAns;
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        bw.write(String.valueOf(minGap(arr, M)));
        
        bw.flush();
        bw.close();
        br.close();
    }
    
}