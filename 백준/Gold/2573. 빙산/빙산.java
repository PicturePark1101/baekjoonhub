import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static int N;
  private static int M;
  private static int[][] iceberg;
  private static boolean[][] visited;
  private static int[] dx = {-1, 0, 0, 1};
  private static int[] dy = {0, 1, -1, 0};

  static class Board {
    private int r;
    private int c;

    public Board(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    iceberg = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        iceberg[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    System.out.println(getAnswer());
  }

  private static int getAnswer() {
    int year = 0;
    while (!allFilledWithOne()) {
      year++;
      visited = new boolean[N][M];
      for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < M - 1; j++) {
          if (iceberg[i][j] > 0 && !visited[i][j]) {
            bfs(new Board(i, j));
          }
        }
         
      }
        if (isAnswer()) return year;
    }
    return 0;
  }

  private static boolean isAnswer() {
    int count = 0;
    boolean[][] visitedForCount = new boolean[N][M];
    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < M - 1; j++) {
        if (iceberg[i][j] != 0 && !visitedForCount[i][j]) {
          dfs(new Board(i, j), visitedForCount);
          count++;
        }
      }
    }
    return count > 1;
  }

  private static void dfs(Board current, boolean[][] visitedForCount) {
    visitedForCount[current.r][current.c] = true;

    for (int i = 0; i < 4; i++) {
      int newR = current.r + dx[i];
      int newC = current.c + dy[i];
      if (iceberg[newR][newC] > 0 && !visitedForCount[newR][newC]) {
        dfs(new Board(newR, newC), visitedForCount);
      }
    }
  }
  private static boolean allFilledWithOne() {
    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < M - 1; j++) {
        if (iceberg[i][j] != 0) return false;
      }
    }
    return true;
  }

  private static void print() {
    for (int i = 0; i < N ; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(iceberg[i][j]+" ");
      }
      System.out.println();
    }
  }
  private static void bfs(Board start) {

    Queue<Board> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start.r][start.c] = true;
    boolean[][] currentValidIceBege = new boolean[N][M];
    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < M - 1; j++) {
        if (iceberg[i][j] > 0) {
          currentValidIceBege[i][j] = true;
        };
      }
    }

    while (!queue.isEmpty()) {
      Board now = queue.poll();
      int nowR = now.r;
      int nowC = now.c;
      int count = 0;

      for (int i = 0; i < 4; i++) {
        int newR = nowR + dx[i];
        int newC = nowC + dy[i];

        if (!currentValidIceBege[newR][newC]) { // 녹아야하는 0임
          count++;
        } else if(currentValidIceBege[newR][newC] && !visited[newR][newC]){
          visited[newR][newC] = true;
          queue.add(new Board(newR, newC));
        }
      }

      if (iceberg[nowR][nowC] - count < 0) {
        iceberg[nowR][nowC] = 0;
      } else {
        iceberg[nowR][nowC] -= count;
      }
    }
  }
}
