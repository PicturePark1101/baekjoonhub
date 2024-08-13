import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static List<Integer>[] childEmployee;
  static int[] praise;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    praise = new int[n + 1];
    visited = new boolean[n + 1];
    childEmployee = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) {
      childEmployee[i] = new ArrayList<>();
    }

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= n; i++) {
      int employee = Integer.parseInt(st.nextToken());
      if (i == 1) continue;
      childEmployee[employee].add(i);
    }

    for (int i = 1; i <= m; i++) {
      st = new StringTokenizer(br.readLine());
      praise[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
    }

    bfs(1);

    for (int i = 1; i <= n; i++) {
      System.out.print(praise[i]+" ");
    }
  }

  public static void bfs(int start) {

    Queue<Integer> qu = new LinkedList<>();
    qu.offer(start);
    while (!qu.isEmpty()) {
      int poll = qu.poll();
      for (int n : childEmployee[poll]) {
        qu.add(n);
        praise[n] += praise[poll];
      }
    }
  }
}