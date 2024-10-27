import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  private static boolean[][] visited;
  private static int[][] paper;
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

    paper = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int maxWidth = 0;
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && paper[i][j] == 1) {
          maxWidth = Math.max(maxWidth, bfs(i, j));
          count++;
        }
      }
    }

    System.out.println(count);
    System.out.println(maxWidth);
    br.close();
  }

  private static int bfs(int r, int c) {
    Queue<Point> queue = new ArrayDeque<>();
    int width = 0;

    queue.offer(new Point(r, c));
    visited[r][c] = true;
    while (!queue.isEmpty()) {
      Point currentPoint = queue.poll();
      int x = currentPoint.r;
      int y = currentPoint.c;
      width++;
      for (int i = 0; i < 4; i++) {
        int newR = x + dx[i];
        int newC = y + dy[i];

        if (isValidPath(newR, newC) &&!visited[newR][newC] ) {
          visited[newR][newC] = true;
          queue.offer(new Point(newR, newC));
        }
      }
    }
    return width;
  }

  private static boolean isValidPath(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M && paper[r][c] == 1;
  }
}