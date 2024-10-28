import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static class Point {
    private int z;
    private int x;
    private int y;

    public Point(int z, int x, int y) {
      this.z = z;
      this.x = x;
      this.y = y;
    }
  }

  private static final int[] dx = {0, -1, 0, 0, 1, 0};
  private static final int[] dy = {0, 0, 1, -1, 0, 0};
  private static final int[] dz = {-1, 0, 0, 0, 0, 1};

  private static int[][][] box;
  private static boolean[][][] visited;

  private static Queue<Point> queue;
  private static int M;
  private static int N;
  private static int H;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    queue = new ArrayDeque<>();
    box = new int[H][N][M];
    visited = new boolean[H][N][M];

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          box[i][j][k] = Integer.parseInt(st.nextToken());
          if (box[i][j][k] == 1) {
            queue.offer(new Point(i, j, k));
            visited[i][j][k] = true;
          }
        }
      }
    }

    bfs();
    System.out.println(checkDays());
    br.close();
  }
  
  private static void bfs() {
    while (!queue.isEmpty()) {
      Point now = queue.poll();
      int nowH = now.z;
      int nowR = now.x;
      int nowC = now.y;
      for (int i = 0; i < 6; i++) {
        int newH = nowH + dz[i];
        int newR = nowR + dx[i];
        int newC = nowC + dy[i];

        if (!validPath(newH, newR, newC)) {
          continue;
        }
        if (box[newH][newR][newC] == -1 || visited[newH][newR][newC]) {
          continue;
        }
        box[newH][newR][newC] = box[nowH][nowR][nowC] + 1;
        queue.offer(new Point(newH, newR, newC));
        visited[newH][newR][newC] = true;
      }
    }
  }

  private static int checkDays() {
    int answer = -1;
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
          if (box[i][j][k] == 0) {
            return -1;
          }
          answer = Math.max(box[i][j][k], answer);
        }
      }
    }
    return answer - 1;
  }

  private static boolean validPath(int h, int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M && h >= 0 && h < H;
  }
}