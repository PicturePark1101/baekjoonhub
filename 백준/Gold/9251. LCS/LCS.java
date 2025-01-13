import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String str2 = br.readLine();
    System.out.println(findAnswer(str1, str2));
    br.close();
  }

  private static int findAnswer(String str1, String str2) {
    int r = str1.length();
    int c = str2.length();
    int[][] DP = new int[r + 1][c + 1];
    for (int i = 1; i <= r; i++) {
      for (int j = 1; j <= c; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          DP[i][j] = DP[i - 1][j - 1] + 1;
        } else {
          DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
        }
      }
    }
    return DP[r][c];
  }
}
