import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

  static class Point {
    private int r;
    private int c;

    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
  private static int N;
  private static char[][] board;
  private static Map<String, Point> direction = new HashMap<>(Map.of(
      "R", new Point(0, 1),
      "U", new Point(-1, 0),
      "D", new Point(1, 0),
      "L", new Point(0, -1)
      ));

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    board = new char[N][N];
    makeBoard();

    String[] commands = br.readLine().split("");

    int currentR = 0;
    int currentC = 0;
    for (String cmd : commands) {
      Point next = direction.get(cmd);
      if (next == null) continue;  
      int nextR = next.r + currentR;
      int nextC = next.c + currentC;

      if (!validPath(nextR, nextC)) continue;

      if (isVertical(currentC, nextC)) {
        // current, next 모두 갱신
        changeBoardVertical(board[currentR][currentC], currentR, currentC);
        changeBoardVertical(board[nextR][nextC], nextR, nextC);
      } else {
        changeBoardHorizontal(board[currentR][currentC], currentR, currentC);
        changeBoardHorizontal(board[nextR][nextC], nextR, nextC);
      }
      currentR = nextR;
      currentC = nextC;
    }

    print();
    br.close();
  }

  private static void changeBoardVertical(char b, int r, int c) {
    if (b == 46) {
      board[r][c] = 124;
    }  else if (b == 45) {
      board[r][c] = 43;
    }
  }

  private static void changeBoardHorizontal(char b, int r, int c) {
    if (b == 46) { // 수평
      board[r][c] = 45;
    } else if (b == 124) {
      board[r][c] = 43;
    }
  }

  private static boolean isVertical(int currentC, int nextC) {
    return currentC - nextC == 0;
  }
  
  private static boolean validPath(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < N;
  }

  private static void makeBoard() {
    for (int i = 0; i < N; i++) {
      Arrays.fill(board[i], (char) 46);
    }
  }

  private static void print() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
}
