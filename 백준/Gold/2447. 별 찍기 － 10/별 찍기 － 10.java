import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static int N;
  private static char[][] board;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    board = new char[N][N];
    makeBoard(N, 0, 0);
    printBoard();
    br.close();
  }

  private static void printBoard() {
    StringBuilder sb = new StringBuilder();
    for (char[] boardR : board) {
      for (char b : boardR) {
        sb.append(b);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private static void makeBoard(int n, int startR, int startC) {
    if (n == 3) {
      printStar(startR, startC);
      return;
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (isMiddlePoint(i, j)) {
          printMid(n / 3, startR + (n / 3 * i), startC + (n / 3 * j));
        } else {
          makeBoard(n / 3, startR + (n / 3 * i), startC + (n / 3 * j));
        }
      }
    }
  }

  private static void printMid(int n, int startR, int startC) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[startR + i][startC + j] = ' ';
      }
    }
  }

  private static boolean isMiddlePoint(int i, int j) {
    return i == 1 && j == 1;
  }

  private static void printStar(int startR, int startC) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (isMiddlePoint(i, j)) {
          board[i + startR][j + startC] = ' ';
        } else {
          board[i + startR][j + startC] = '*';
        }
      }
    }
  }
}
