import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<Integer>[] connectList;
  static int[] subTreeSizes;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    connectList = new ArrayList[N + 1];
    visited = new boolean[N + 1];
    subTreeSizes = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      connectList[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      connectList[a].add(b);
      connectList[b].add(a);
    }

    makeTree(R);

    for (int i = 0; i < Q; i++) {
      System.out.println(subTreeSizes[Integer.parseInt(br.readLine())]);
    }
    br.close();
  }

  public static int makeTree(int currentNode) {
    visited[currentNode] = true;
    int size = 1;
    for (int n : connectList[currentNode]) {
      if(!visited[n]) {
        size += makeTree(n);
      }
    }
    subTreeSizes[currentNode] = size;
    return size;
  }
}