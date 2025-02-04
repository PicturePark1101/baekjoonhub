import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int T;
    
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      int[] nums = new int[N + 1];
      for (int j = 1; j <= N; j++) {
        nums[j] = Integer.parseInt(st.nextToken());
      }

      sb.append(getAnswer(nums, N, Integer.parseInt(br.readLine()))).append("\n");
    }
    System.out.println(sb);
    br.close();
  }

  private static int getAnswer(int[] nums, int N, int M) {
    int[][] dp = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      int n =  nums[i];
      for (int j = 1; j <= M; j++) {
        if (j % n == 0) {
          dp[i][j]++;
        }
        for (int k = j / n; k >= 0; k--) {
          int temp = j - n * k;
          dp[i][j] += dp[i - 1][temp];
        }
      }
    }
    return dp[N][M];
  }
}
