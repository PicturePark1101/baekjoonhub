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
    private int h;
    private int len;

    public Point(int r, int c, int h, int len) {
      this.r = r;
      this.c = c;
      this.h = h;
      this.len = len;
    }
  }

  private static int K;
  private static int W;
  private static int H;
  private static int[][] borad;
  private static int[][][] boradCount;
  private static boolean[][][] visited;
  private static int[] dx1 = { -1, 0, 0, 1 };
  private static int[] dy1 = { 0, 1, -1, 0 };
  private static int[] dx2 = { -2, -1, 1, 2, 2, 1, -1, -2 };
  private static int[] dy2 = { 1, 2, 2, 1, -1, -2, -2, -1 };
  private static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    borad = new int[H][W];
    boradCount = new int[K + 1][H][W];
    visited = new boolean[K + 1][H][W];

    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; j++) {
        borad[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    bfs();
    System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    br.close();
  }

  private static void bfs() {
    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(0, 0, 0, 0));


    while (!queue.isEmpty()) {
      Point nowP = queue.poll();
      int nowR = nowP.r;
      int nowC = nowP.c;
      int nowH = nowP.h;
      checkDest(nowR, nowC, nowP.len);

      if (nowH < K) {
        for (int i = 0; i < 8; i++) {
          doOffer(nowR + dx2[i] , nowC + dy2[i],nowH + 1, nowP.len + 1, queue);
        }
      }
      for (int i = 0; i < 4; i++) {
        doOffer(nowR + dx1[i], nowC + dy1[i], nowH, nowP.len + 1, queue);
      }
    }
  }

  private static void doOffer(int newR, int newC, int newH, int newLen, Queue<Point> queue) {
    if (!validPath(newR, newC)) return;
    if (borad[newR][newC] == 1) return;
    if (!visited[newH][newR][newC] || boradCount[newH][newR][newC] > newLen) {
      visited[newH][newR][newC] = true;
      boradCount[newH][newR][newC] = newLen;
      queue.offer(new Point(newR, newC, newH, newLen));
    }
  }

  private static void checkDest(int r, int c, int len) {
    if (r == H - 1 && c == W - 1) {
      answer = Math.min(len, answer);
    }
  }

  private static boolean validPath(int r, int c) {
      return r >= 0 && r < H && c >= 0 && c < W;
  }
}
