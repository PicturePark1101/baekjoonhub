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
    private int dist;
    private boolean isBroken;

    public Point(int r, int c, int dist, boolean isBroken) {
      this.r = r;
      this.c = c;
      this.dist = dist;
      this.isBroken = isBroken;
    }
  }

  private static final int[] dx = { -1, 0, 0, 1 };
  private static final int[] dy = { 0, 1, -1, 0 };
  private static int[][] map;
  private static boolean[][][] visited;
  private static int N;
  private static int M;
  private static int answer;



  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new boolean[2][N][M];

    for (int i = 0; i < N; i++) {
      String[] strings = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(strings[j]);
      }
    }

    System.out.println(bfs());
    br.close();
  }

  private static int bfs() {
    Queue<Point> queue = new ArrayDeque<>();

    queue.add(new Point(0, 0, 1, false));
    visited[0][0][0] = true;

    while (!queue.isEmpty()) {
      Point nowPoint = queue.poll();

      int nowR = nowPoint.r;
      int nowC = nowPoint.c;

      if (nowR == N - 1 && nowC == M - 1) return nowPoint.dist;

      for (int i = 0; i < 4; i++) {

        int newR = nowR + dx[i];
        int newC = nowC + dy[i];

        if (!isValidPath(newR, newC)) // 유효하지 않은 경로
          continue;

        // 만약 벽임 -> 부수는걸 고려해볼 수 있음.
        if (map[newR][newC] == 1) {
          if (!nowPoint.isBroken) { // 한번도 부순적 없다면
            visited[1][newR][newC] = true;
            queue.add(new Point(newR, newC, nowPoint.dist + 1, true));
          }

        } else { // 벽이 아님
          if (!nowPoint.isBroken && !visited[0][newR][newC]) { // 부순적 없고, 그 부수지 않은 곳을 방문한 적도 없었다면
            visited[0][newR][newC] = true;
            queue.add(new Point(newR, newC, nowPoint.dist + 1, false));
          } else if (nowPoint.isBroken && !visited[1][newR][newC]) { // 부순적 있고, 그 부순적 있는 곳을 방문한 적도 없었다면
            visited[1][newR][newC] = true;
            queue.add(new Point(newR, newC, nowPoint.dist + 1, true));
          }
        }
      }
    }
    return -1;
  }

  private static boolean isValidPath(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M;
  }
}