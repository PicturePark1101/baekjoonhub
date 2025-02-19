import java.util.*;
import java.io.*;

public class Main {

  private static char[][] board;
  private static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new char[n][n];

    for (int i = 0; i < n; i++) {
      board[i] = br.readLine().toCharArray();
    }

    System.out.println(changeArr());
    br.close();
  }

  private static int changeArr() {

    int answer = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // 오른쪽, 아래를 살펴본다.
        // 바꿔서 살펴본다.
        if (j + 1 < n && board[i][j + 1] != board[i][j]) {
          temp(i, j, i, j + 1);
          answer = Math.max(searchChangeArr(), answer);
          temp(i, j, i, j + 1);
        }
        if (i + 1 < n && board[i + 1][j] != board[i][j]) {
          temp(i, j, i + 1, j);
          answer = Math.max(searchChangeArr(), answer);
          temp(i, j, i + 1, j);
        }
      }
    }
    return answer;
  }

  private static void temp(int r, int c, int newR, int newC) {
    char temp = board[r][c];
    board[r][c] = board[newR][newC];
    board[newR][newC] = temp;
  }

  private static int searchChangeArr() {
    int rMax = -1;
    // 행 기준
    int count = 0;
    for (int i = 0; i < n; i++) {
      count = 1;
      for (int j = 0; j < n - 1; j++) {
        if (board[i][j] != board[i][j + 1]) {
          count = 1;
        } else {
          count++;
          rMax = Math.max(rMax, count);
        }
      }
    }


    int cMax = -1;
    // 열기준
    for (int j = 0; j < n; j++) {
      count = 1;
      for (int i = 0; i < n - 1; i++) {
        if (board[i][j] != board[i + 1][j]) {
          count = 1;
        } else {
          count++;
          cMax = Math.max(cMax, count);
        }
      }
    }
    return Math.max(cMax, rMax);
  }
}
