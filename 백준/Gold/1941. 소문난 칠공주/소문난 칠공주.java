import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  private static boolean[] visited = new boolean[25];
  private static int[] dx = {-1, 0, 0, 1};
  private static int[] dy = {0, 1, -1, 0};
  private static int ans = 0;
  private static String[][] students = new String[5][5];
  
  public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 5; i++) {
      students[i] = br.readLine().split("");
    }

    dfs(0, 0, 0);
    System.out.println(ans);
    br.close();
  }

  private static void dfs(int depth, int start, int countY) {
    if (countY >= 4) return;

    if (depth == 7){
      int startIndex = start - 1;
      if (isNearPath(startIndex / 5, startIndex % 5)) ans++;
      return;
    }


    for (int i = start; i < 25; i++) {
      visited[i] = true;
      if (students[i / 5][i % 5].equals("Y")) {
        dfs(depth + 1, i + 1, countY + 1);
      } else {
        dfs(depth + 1, i + 1, countY);
      }
      visited[i] = false;
    }
  }

  private static boolean isNearPath(int r, int c) {
    Queue<Integer> queue = new LinkedList<>();
    int count = 0;
    boolean[] isVisitedQueue = new boolean[25];

    queue.offer(r * 5 + c);
    isVisitedQueue[r * 5 + c] = true;
    while (!queue.isEmpty()) {
      int n = queue.poll();
      count++;
      for (int i = 0; i < 4; i++) {
        int newR = dx[i] + (n / 5);
        int newC = dy[i] + (n % 5);
        if (isValid(newR, newC) && visited[newR * 5 + newC] && !isVisitedQueue[newR * 5 + newC]) {
          isVisitedQueue[newR * 5 + newC] = true;
          queue.offer(newR * 5 + newC);
        }
      }
    }
    return count == 7;
  }

  private static boolean isValid(int r, int c) {
    return r >= 0 && r < 5 && c >= 0 && c < 5;
  }
}