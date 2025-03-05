import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[][] count;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N + 1][N + 1];
        count = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }           
        }
        
        makeCount(arr);
        for (int i = 1; i <= M; i++) { 
           st = new StringTokenizer(br.readLine()); 
           int x1 = Integer.parseInt(st.nextToken());
           int y1 = Integer.parseInt(st.nextToken());
           int x2 = Integer.parseInt(st.nextToken()); 
           int y2 = Integer.parseInt(st.nextToken()); 
           sb.append(getAnswer(x1, y1, x2, y2)).append("\n");
        }
        System.out.println(sb);
        
        br.close();
    }
    
    private static void makeCount(int[][] arr) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                count[i][j] = arr[i][j] + count[i][j - 1];             
            }           
        }        
    }
    
    private static int getAnswer(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            sum += count[i][y2] - count[i][y1 - 1];
        }
        return sum;
    }
}