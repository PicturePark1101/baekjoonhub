import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  private static boolean[][] visited;
  private static Queue<Point> queue;

  private static int[][] days;
  private static int[][] tomato;
  private static int N;
  private static int M;
  private static final int[] dx = {-1, 0, 0, 1};
  private static final int[] dy = {0, -1, 1, 0};

  static class Point {
    private int r;
    private int c;

    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    days = new int[N][M];
    tomato = new int[N][M];
    visited = new boolean[N][M];
    queue = new ArrayDeque<>();

    for (int i = 0; i < days.length; i++) {
      Arrays.fill(days[i], -1);
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        tomato[i][j] = Integer.parseInt(st.nextToken());
        if(tomato[i][j] == 1) {
          queue.offer(new Point(i, j));
          days[i][j] = 0;
          visited[i][j] = true;
        }
      }
    }

    bfs();

    System.out.println(getDay());
    br.close();
  }

  private static int getDay() {
    int maxDay = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (days[i][j] == -1 && tomato[i][j] != -1)
          return -1;
        maxDay = Math.max(maxDay, days[i][j]);
      }
    }
    return maxDay;
  }

  private static void bfs() {
    while (!queue.isEmpty()) {
      Point currentPoint = queue.poll();
      int x = currentPoint.r;
      int y = currentPoint.c;

      for (int j = 0; j < 4; j++) {
        int newR = x + dx[j];
        int newC = y + dy[j];

        if (isValidPath(newR, newC) && !visited[newR][newC]) {
          visited[newR][newC] = true;
          queue.offer(new Point(newR, newC));
          days[newR][newC] = days[x][y] + 1;
        }
      }
    }
  }

  private static boolean isValidPath(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M && tomato[r][c] == 0;
  }
}