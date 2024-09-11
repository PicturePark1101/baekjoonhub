import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  private static int N;
  private static int K;
  private static boolean[] visited = new boolean[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.println(bfs());
  }

  private static int bfs() {
    Queue<Integer> queue = new LinkedList<>();
    int length = 0;

    queue.offer(N);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int n = queue.poll();
        // if (n < 0) continue;
        if (n == K) return length;

        if (!visited[n]) {
          visited[n] = true;
          if (n - 1 >= 0) queue.offer(n - 1);
          if (n + 1 <= 100000) queue.offer(n + 1);
          if (n * 2 <= 100000) queue.offer(n * 2);
        }
      }
      length++;
    }
    return -1;
  }
}