import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int[] answer = { 0, 0, 0 };
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int[][] paper = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    func(paper, n, 0, 0);
    for (int i = 0; i < 3; i++) {
      System.out.println(answer[i]);
    }
    br.close();
  }

  private static void func(int[][] paper, int n, int startR, int startC) {
    if (!isFullSameNumber(paper, n, startR, startC)) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          func(paper, n / 3, startR + (n / 3 * i), startC + (n / 3 * j));
        }
      }
    }else {
        answer[paper[startR][startC] + 1]++;
    }
  }

  private static boolean isFullSameNumber(int[][] paper, int n, int startR, int startC) {
    int start = paper[startR][startC];
    for (int i = startR; i < startR + n; i++) {
      for (int j = startC; j < startC + n; j++) {
        if (paper[i][j] != start) {
          return false;
        }
      }
    }
    return true;
  }
}
