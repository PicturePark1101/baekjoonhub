import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {

  private int r;
  private int c;

  public Node(int r, int c) {
    this.r = r;
    this.c = c;
  }

  public Node() {
  }

  public int getR() {
    return r;
  }

  public int getC() {
    return c;
  }
}

public class Main {

  private static int N;
  private static int M;
  private static String[][] miro;
  private static boolean[][] visited;
  private static int[] dx = {-1, 0, 0, 1};
  private static int[] dy = {0, 1, -1, 0};;
  private static int minLength = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    miro = new String[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      miro[i] = br.readLine().split("");
    }

    System.out.println(bfs(0, 0));
    br.close();
  }

  private static int bfs(int r, int c) {
    Queue<Node> queue = new LinkedList<>();
    int length = 0;

    queue.offer(new Node(r, c));
    visited[r][c] = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      length++;

      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        if (node.getR() == N - 1 && node.getC() == M - 1) {
          return length;
        }

        for (int j = 0; j < 4; j++) {
          int newR = dx[j] + node.getR();
          int newC = dy[j] + node.getC();
          if (isValid(newR, newC) && miro[newR][newC].equals("1") && !visited[newR][newC]) {
            visited[newR][newC] = true;
            queue.offer(new Node(newR, newC));
          }
        }
      }
    }
    return -1;
  }

  private static boolean isValid(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M ;
  }
}