import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int[][] paper;
  private static int N;
  private static int[] answer = { 0, 0 };
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    cutPaper(N, 0, 0);
    printAnswer();

    br.close();
  }

  private static void printAnswer() {
    for (int j : answer) {
      System.out.println(j);
    }
  }

  private static void cutPaper(int n, int startR, int startC) {
    int start = paper[startR][startC];
    if (!isFullPaper(n, start, startR, startC)) {
      for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
          cutPaper(n / 2, startR + (n / 2 * i), startC + (n / 2 * j));
        }
      }
    } else {
      answer[start]++;
    }
  }

  private static boolean isFullPaper(int n, int start, int r, int c) {
    for (int i = r; i < r + n; i++) {
      for (int j = c; j < c + n; j++) {
        if (start != paper[i][j]) return false;
      }
    }
    return true;
  }
}
