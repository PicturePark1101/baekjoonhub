import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int N;
  private static int M;
  private static int K;
  private static int a;
  private static int b;
  private static int T;
  private static int[][] board;

  private static int[][] count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    count = new int[N + 1][M + 1];
    board = new int[N + 1][M + 1];
    for (int i = 1; i <= N; i++) {
      String[] input = br.readLine().split("");
      for (int j = 1; j <= M; j++) {
        if (input[j - 1].equals("*")) {
          board[i][j] = 1;
        } else {
          board[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < T; i++) {
      countLife();
      executeTime();
    }

    printBoard();
    br.close();
  }

  private static void printBoard() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        if (board[i][j] == 1) {
          sb.append("*");
        } else {
          sb.append(".");
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private static void executeTime() {
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        int cnt = calc(i, j);
        if (board[i][j] == 1) { // 생명일 경우 
            if (cnt < a || cnt > b) {
                board[i][j]--;
            }
        } else {
            if (cnt > a && cnt <= b) {
                board[i][j]++;
            }
        }
      }
    }
  }

  private static int calc(int i, int j) {
    int r1 = Math.max(1, i - K);
    int r2 = Math.min(N, i + K);
    int c1 = Math.max(1, j - K);
    int c2 = Math.min(M, j + K);

    return count[r2][c2] - count[r1 - 1][c2] - count[r2][c1 - 1] + count[r1 - 1][c1 - 1] - board[i][j];
  }

  private static void countLife() {
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
          count[i][j] = board[i][j] + count[i - 1][j] + count[i][j - 1] - count[i - 1][j - 1];
        }
    }
  }
}
