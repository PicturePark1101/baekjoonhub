import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Integer>[] list;
  static int[] parent;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    parent = new int[N + 1];
    list = new ArrayList[N + 1];
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      list[n1].add(n2);
      list[n2].add(n1);
    }

    dfs(1);

    for (int i = 2; i <= N; i++) {
      System.out.println(parent[i]);
    }
    br.close();
  }

  public static void dfs(int n) {
    visited[n] = true;
    for (int nums : list[n]){
      if(!visited[nums]) {
        parent[nums] = n;
        dfs(nums);
      }
    }
  }
}