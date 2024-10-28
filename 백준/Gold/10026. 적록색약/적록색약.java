import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
  static class Point {
    private int r;
    private int c;
    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  private static char[][] grid;
  private static final int[] dx = {-1, 0, 0, 1};
  private static final int[] dy = {0, 1, -1, 0};
  private static int N;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    grid = new char[N][N];

    for (int i = 0; i < N; i++) {
      grid[i] = br.readLine().toCharArray();
    }

    sb.append(getAnswer(false)).append(" ");
    sb.append(getAnswer(true));

    System.out.println(sb);
    br.close();
  }

  private static int getAnswer(boolean isCb) {
    boolean[][] visited = new boolean[N][N];
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          bfs(grid[i][j], visited, i, j, isCb);
          count++;
        }
      }
    }
    return count;
  }

  private static void bfs(char ch, boolean[][] visited, int r, int c, boolean isCb) {
    Queue<Point> queue = new ArrayDeque<>();

    queue.offer(new Point(r, c));
    visited[r][c] = true;
    while (!queue.isEmpty()) {
      Point now = queue.poll();
      int nowR = now.r;
      int nowC = now.c;
      for (int i = 0; i < 4; i++) {
        int newR = nowR + dx[i];
        int newC = nowC + dy[i];

        if (!validPath(newR, newC)) continue;

        if (visited[newR][newC]) continue;

        if (isCb && (ch == 'R' || ch == 'G')) { // 색맹이고, 현재 값이 빨 초임
          if (grid[newR][newC] == 'R' || grid[newR][newC] == 'G') {
              queue.offer(new Point(newR, newC));
              visited[newR][newC] = true;
          }
        } else {
          if (grid[newR][newC] == ch) {
            queue.offer(new Point(newR, newC));
            visited[newR][newC] = true;
          }
        }
      }
    }
  }

  private static boolean validPath(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < N;
  }
}