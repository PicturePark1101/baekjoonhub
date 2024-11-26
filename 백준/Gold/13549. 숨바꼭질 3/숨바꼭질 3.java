import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static int[] road = new int[100001];
  private static Map<Integer, Integer> direction = Map.of(-1, 1, 1, 1, 2, 0);

  private static boolean[] visited = new boolean[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int subin = Integer.parseInt(st.nextToken());
    int sister = Integer.parseInt(st.nextToken());
    Arrays.fill(road, Integer.MAX_VALUE);

    bfs(subin, sister);
    System.out.println(road[sister]);

    br.close();
  }

  private static void bfs(int start, int dest) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    road[start] = 0;
    visited[start] = true;
    int next;
    while (!queue.isEmpty()) {
      int current = queue.poll();

      for (Entry<Integer, Integer> dir : direction.entrySet()) {
        if (dir.getKey() == 2) {
          next = current * dir.getKey();
        } else {
          next = current + dir.getKey();
        }

        if (!validPoint(next)) continue;
        int time = road[current] + dir.getValue();

        if (!visited[next] || time < road[next]) {
          road[next] = time;
          queue.offer(next);
          visited[next] = true;
        }
      }
    }
  }

  private static boolean validPoint(int p) {
    return p >= 0 && p < 100001;
  }
}
