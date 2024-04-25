import java.util.*;
import java.io.*;

public class Main {
    
    private static boolean isExist(int arr[], int n) {
        int l = 0, r = arr.length - 1;
        
        while (l <= r) {
            int m = (l + r) / 2;
            
            if (arr[m] < n) { // 더 큼 오른쪽에서 탐색해야함
                l = m + 1;
            } else if (arr[m] > n) {
                r = m - 1;
            } else if (arr[m] == n){
                 return true;
            }
        }     
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {   
            int num = Integer.parseInt(st.nextToken());
            int ans = isExist(arr, num) ? 1 : 0;
            bw.write(String.valueOf(ans)+"\n");
        }
        
        
        
        bw.flush();
        bw.close();
        br.close();
        
    }
    
}