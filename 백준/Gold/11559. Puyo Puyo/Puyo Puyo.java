import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

  static class Puyo {
    private int r;
    private int c;

    public Puyo(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  private static final int fixedRow = 6;
  private static final int fixedColumn = 12;
  private static String[][] gameBoard = new String[fixedRow][fixedColumn];
  private static int[] dx = { -1, 0, 0, 1 };
  private static int[] dy = { 0, 1, -1, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int answer = 0;
    for (int i = 0; i < fixedColumn; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < fixedRow; j++) {
        gameBoard[j][i] = input[j];
      }
    }

    int countBumb = 0;

    do {
      countBumb = 0;
      for (int i = 0; i < fixedRow; i++) {
        for (int j = 0; j < fixedColumn; j++) {
          if (!gameBoard[i][j].equals(".")) {
            if (startGameRound(gameBoard[i][j], new Puyo(i, j)) > 0) {
              countBumb++;
            }
          }
        }
      }

      if (countBumb > 0) {
        answer++;
        applyGravity();
      }
    } while (countBumb != 0);
    System.out.println(answer);
    br.close();
  }

  private static void applyGravity() {
    for (int i = 0; i < fixedRow; i++) {
      String result = String.join("", gameBoard[i]).replace(".", "");
      if (!result.isEmpty()) {
        String[] splitResult = result.split("");
        Arrays.fill(gameBoard[i], ".");
        for (int j = 0; j < splitResult.length; j++) {
          gameBoard[i][fixedColumn - j - 1] = splitResult[splitResult.length - 1 - j];
        }
      }
    }
  }

  private static void print(int count, int r, int c) {
    for (int i = 0; i < fixedRow; i++) {
      for (int j = 0; j < fixedColumn; j++) {
        System.out.print(gameBoard[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println("완료");
  }

  private static int startGameRound(String puyoChar, Puyo startPuyo) {
    Queue<Puyo> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[fixedRow][fixedColumn];
    queue.add(startPuyo);
    visited[startPuyo.r][startPuyo.c] = true;
    int count = 0;

    while (!queue.isEmpty()) {
      Puyo nowPuyo = queue.poll();
      int nowR = nowPuyo.r;
      int nowC = nowPuyo.c;
      count++;
      for (int i = 0; i < 4; i++) {
        int nextR = nowR + dx[i];
        int nextC = nowC + dy[i];

        if (validPath(nextR, nextC) && !visited[nextR][nextC] && puyoChar.equals(gameBoard[nextR][nextC])) {
          visited[nextR][nextC] = true;
          queue.offer(new Puyo(nextR, nextC));
        }
      }
    }

    if (count >= 4) {
      explodePuyo(visited);
      return count;
    }
    return 0;
  }

  private static void explodePuyo(boolean[][] visited) {
    for (int i = 0; i < fixedRow; i++) {
      for (int j = 0; j < fixedColumn; j++) {
        if (visited[i][j]) {
          gameBoard[i][j] = ".";
        }
      }
    }
  }


  private static boolean validPath(int r, int c) {
    return r >= 0 && r < fixedRow && c >= 0 && c < fixedColumn;
  }
}
