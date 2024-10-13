import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");
        
        int r = str1.length;
        int c = str2.length;
        int[][] dp = new int[r + 1][c + 1];
        
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (str1[i - 1].equals(str2[j - 1])) { // str1의 i번째, str2의 j번째가 같으면 길이 갱신해야함
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 다르면 이전에서 더 큰걸로 갱신      
                }                               
            }
        }
        System.out.println(dp[r][c]);
        br.close();
    }
}