import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    System.out.println(getAnswer(N));
    br.close();
  }

  private static long getAnswer(int N) {
    long[][] DP = new long[N + 1][10];

    for (int i = 1 ; i < 10; i++) {
      DP[1][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
      DP[i][0] =DP[i - 1][1] % 1000000000;
      DP[i][9] =DP[i - 1][8] % 1000000000;
      for (int j = 1; j <= 8; j++) {
        DP[i][j] = (DP[i - 1][j - 1] +  DP[i - 1][j + 1]) % 1000000000;
      }
    }

    return Arrays.stream(DP[N]).sum() % 1000000000;
  }
}
