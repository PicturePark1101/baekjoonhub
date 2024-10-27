import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  private static boolean[][] visited;
  private static int[][] level;
  private static int[][] miro;
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

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    miro = new int[N][M];
    level = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        miro[i][j] = Integer.parseInt(input[j]);
      }
    }

    bfs(0, 0);
    System.out.println(miro[N - 1][M - 1]);
    br.close();
  }

  private static void bfs(int r, int c) {
    Queue<Point> queue = new ArrayDeque<>();

    queue.offer(new Point(r, c));
    visited[r][c] = true;

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
          miro[newR][newC] = miro[x][y] + 1;
        }
      }
    }
  }

  private static boolean isValidPath(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M && miro[r][c] == 1;
  }
}