import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

  private static char[][] students;
  private static int answer;
  private static int[] dx = { -1, 0, 0, 1 };
  private static int[] dy = { 0, 1, -1, 0 };
  private static boolean[] visited;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    students = new char[5][5];
    visited = new boolean[25];
    for (int i = 0; i < 5; i++) {
      students[i] = br.readLine().toCharArray();
    }

    pick(0, 0, 0);
    System.out.println(answer);
    br.close();
  }

  private static void pick(int index, int depth, int yCnt) {

    if (yCnt >= 4) {
      return;
    }

    if (depth == 7) {
      int start = index - 1;
      if (isNearPath(start / 5, start % 5)) {
        answer++;
      }
      return;
    }


    for (int i = index; i < 25; i++) {
      visited[i]= true;
      if(students[i/5][i%5] == 'Y'){
        pick(i + 1, depth + 1, yCnt + 1);
      }else{
        pick(i + 1, depth + 1, yCnt);
      }
      visited[i] = false;
    }
  }

  private static boolean isNearPath(int r, int c) {
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] visitedQueue = new boolean[25];

    int count = 0;
    int start = r * 5 + c;
    queue.offer(start);
    visitedQueue[start] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      count++;
      for (int i = 0; i < 4; i++) {
        int newR = (now / 5) + dx[i];
        int newC = (now % 5) + dy[i];
        int newIndex = newR * 5 + newC;
        if (validPath(newR, newC) && !visitedQueue[newIndex] && visited[newIndex]) {
          queue.offer(newIndex);
          visitedQueue[newIndex] = true;
        }
      }
    }
    return count == 7;
  }
  private static boolean validPath(int r, int c) {
    return r >= 0 && r < 5 && c >= 0 && c < 5;
  }
}
