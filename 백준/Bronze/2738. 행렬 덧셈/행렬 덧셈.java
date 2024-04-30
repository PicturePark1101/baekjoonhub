import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
    
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
    
        int[][] a = new int[N][M];
        int[][] b = new int[N][M];
        int[][] sum = new int[N][M];
    
        for (int i = 0 ; i < N; i++) {
          st = new StringTokenizer(br.readLine());
          for (int j = 0 ; j < M; j++) {
              a[i][j] = Integer.parseInt(st.nextToken());
          }
        }
    
        for (int i = 0 ; i < N; i++) {
          st = new StringTokenizer(br.readLine());
          for (int j = 0 ; j < M; j++) {
              b[i][j] = Integer.parseInt(st.nextToken());
              sum[i][j] = a[i][j] + b[i][j];
          }
        }
    
        
        for (int i = 0 ; i < N; i++) {
          for (int j = 0 ; j < M; j++) {
              bw.write(String.valueOf(sum[i][j])+" ");
          }
          bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
        }


}