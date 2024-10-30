import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  private static final int[] dx = { -1, 0, 0, 1};
  private static final int[] dy = { 0, 1, -1, 0};
  private static int h;
  private static int w;
  private static char[][] map;
  private static int[][] fire;
  private static int[][] exit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());
      map = new char[h][w];
      fire = new int[h][w];
      exit = new int[h][w];
      Point startAtUser = null;
      List<Point> startAtFire = new ArrayList<>();

      for (int j = 0; j < h; j++) {
         String inputArr = br.readLine();
         for (int k = 0; k < w; k++) {
           map[j][k] = inputArr.charAt(k);
           fire[j][k] = Integer.MAX_VALUE;
           if (map[j][k] == '@') {
             startAtUser = new Point(j, k);
           }
           if (map[j][k] == '*') {
             startAtFire.add(new Point(j, k));
           }
         }
      }

      if (!startAtFire.isEmpty()) {
        bfsForFire(startAtFire);
      }
      sb.append(bfsForExit(startAtUser)).append("\n");
    }
    System.out.println(sb);
  }

  private static void bfsForFire(List<Point> start) {
    boolean[][] visited = new boolean[h][w];
    Queue<Point> queue = new ArrayDeque<>(start);
    for (Point startPoint : start) {
      visited[startPoint.x][startPoint.y] = true;
      fire[startPoint.x][startPoint.y] = 1;
    }

    while (!queue.isEmpty()) {
      Point now = queue.poll();
      int nowR = now.x;
      int nowC = now.y;
      for (int i = 0; i < 4; i++) {
        int newR = nowR + dx[i];
        int newC = nowC + dy[i];

        if (!validPath(newR, newC)) continue;

        if (map[newR][newC] != '#' && !visited[newR][newC]) {
          queue.add(new Point(newR, newC));
          visited[newR][newC] = true;
          fire[newR][newC] = fire[nowR][nowC] + 1;
        }
      }
    }
  }

  private static boolean validPath(int r, int c) {
    return r >= 0 && r < h && c >= 0 && c < w;
  }

  private static String bfsForExit(Point start) {
    Queue<Point> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[h][w];

    queue.add(start);
    visited[start.x][start.y] = true;
    exit[start.x][start.y] = 1;
    while (!queue.isEmpty()) {
      Point now = queue.poll();
      int nowR = now.x;
      int nowC = now.y;
      if (canExit(nowR, nowC)) return String.valueOf(exit[nowR][nowC]);

      for (int i = 0; i < 4; i++) {
        int newR = nowR + dx[i];
        int newC = nowC + dy[i];

        if (!validPath(newR, newC)) continue;

        int newDay = exit[nowR][nowC] + 1;
        if (visited[newR][newC] || map[newR][newC] != '.') continue;
        if (newDay < fire[newR][newC]) {
          queue.add(new Point(newR, newC));
          visited[newR][newC] = true;
          exit[newR][newC] = newDay;
        }
      }
    }

    return "IMPOSSIBLE";
  }

  private static boolean canExit(int r, int c) {
    return r == 0 || r == h - 1 || c == 0 || c == w - 1;
  }
}
