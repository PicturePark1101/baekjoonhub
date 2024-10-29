import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static class Point {
    private int r;
    private int c;
    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  private static final int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
  private static final int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      int l = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      int startR = Integer.parseInt(st.nextToken());
      int startC = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int desR = Integer.parseInt(st.nextToken());
      int desC = Integer.parseInt(st.nextToken());

      sb.append(bfs(l, startR, startC, desR, desC)).append("\n");
    }
    System.out.println(sb);
    br.close();
  }

  private static int bfs(int N, int startR, int startC, int desR, int desC) {
    Queue<Point> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[N][N];
    int[][] borad = new int[N][N];

    queue.add(new Point(startR, startC));
    visited[startR][startC] = true;
    while (!queue.isEmpty()) {
      Point nowPoint = queue.poll();
      int nowR = nowPoint.r;
      int nowC = nowPoint.c;
      if (nowR == desR && nowC == desC) break;
      for (int i = 0; i < 8; i++) {
        int newR = nowR + dx[i];
        int newC = nowC + dy[i];

        if (!isValidPath(N, newR, newC)) continue;
        if (visited[newR][newC]) continue;

        queue.add(new Point(newR, newC));
        borad[newR][newC] = borad[nowR][nowC] + 1;
        visited[newR][newC] = true;
      }
    }
    return borad[desR][desC];
  }

  private static boolean isValidPath(int n, int r, int c) {
    return r >= 0 && r < n && c >= 0 && c < n;
  }
}
