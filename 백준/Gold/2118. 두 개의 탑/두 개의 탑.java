import java.util.*;
import java.io.*;

public class Main {
    

    public static int maxDistance(int[] arr, int[] prefixSum, int total) {

      int maxDis = Integer.MIN_VALUE;
      for (int i = 1 ; i < arr.length; i++) {
        int j = i + 1;
        while(j < arr.length) {
          int dis = prefixSum[j++] - prefixSum[i];
          int rDis = total- dis;
          int minGap = Math.min(dis, rDis);
          maxDis = Math.max(maxDis, minGap);
        }
      }
      return maxDis;
    }

    public static void main(String[] args) throws Exception {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int N = Integer.parseInt(br.readLine());

      int[] arr = new int[N + 1];
      int[] prefixSum = new int[N + 1];
      int total = 0;

      for (int i = 1; i <= N; i++) {
        arr[i] = Integer.parseInt(br.readLine());
        total += arr[i];
      }

      for (int i = 2; i <= N; i++) {
        prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
//        System.out.println(prefixSum[i]);
      }
      bw.write(String.valueOf(maxDistance(arr, prefixSum, total)));
      bw.flush();
      bw.close();
      br.close();
    }
    
}