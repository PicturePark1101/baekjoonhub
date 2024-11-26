import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static class Board {
    private int r;
    private int c;
    private int len;

    public Board(int r, int c, int len) {
      this.r = r;
      this.c = c;
      this.len = len;
    }

  }

  private static List<Board> boundary = new ArrayList<>();

  private static int[][] land;
  private static int N;
  private static int[] dx = { -1, 0, 0, 1 };
  private static int[] dy = { 0, -1, 1, 0 };
  private static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());

    land = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        land[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    makeBoundary();
    findAnswer();
    System.out.println(answer);
    br.close();
  }

  private static void makeBoundary() {
    boolean[][] visited = new boolean[N][N];
    int landNumber = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (land[i][j] == 1 && !visited[i][j]) {
          searchBoundary(i, j, visited, landNumber++); // 대륙을 방문함. 구분하는 용도..
        }
      }
    }
    // print();
  }

  private static void findAnswer() {
    boolean[][] visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (land[i][j] != 0 && !visited[i][j]) {
          bfs(new Board(i, j, 0), visited);
        }
        visited = new boolean[N][N];
      }
    }
  }

  private static void bfs(Board start, boolean[][] visited) {
    Queue<Board> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start.r][start.c] = true;
    while (!queue.isEmpty()) {
      Board now = queue.poll();
      int nowR = now.r;
      int nowC = now.c;

      for (int i = 0; i < 4; i++) {
        int newR = nowR + dx[i];
        int newC = nowC + dy[i];

        // 같은섬에 도착함
        if (!validPath(newR, newC)) continue; // 유효하지 않은 곳.
        if (land[newR][newC] == land[start.r][start.c]) continue;
        if (visited[newR][newC]) continue;

        if (land[newR][newC] == 0) {
          visited[newR][newC] = true;
          queue.add(new Board(newR, newC, now.len + 1));
        } else { // 다른섬 도착
          answer = Math.min(answer, now.len);
          return;
        }
      }
    }
  }

  private static void print() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
         System.out.print(land[i][j]+" ");
      }
      System.out.println();
    }
  }

  private static void searchBoundary(int r, int c, boolean[][] visited, int number) {
    visited[r][c] = true;
    land[r][c] = number;
    for (int i = 0; i < 4; i++) {
      int newR = r + dx[i];
      int newC = c + dy[i];

      if (!validPath(newR, newC)) continue;
      if (visited[newR][newC]) continue;

      if (land[newR][newC] == 1) {
        searchBoundary(newR, newC, visited, number);
      }
    }
  }

  private static boolean validPath(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < N;
  }
}