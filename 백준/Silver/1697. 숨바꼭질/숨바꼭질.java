import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  private static int N;
  private static int K;
  private static int[] ansArr = new int[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.println(bfs());
  }

  private static int bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(N);

    ansArr[N] = 0;
    while (!queue.isEmpty()) {
      int n = queue.poll();
      int index = 0;
      if (n == K) {
        return ansArr[n];
      }
      for (int i = 0; i < 3; i++) {
        switch (i) {
          case 0 :
            index = n - 1;
            break;
          case 1:
            index = n + 1;
            break;
          case 2:
            index = n * 2;
            break;
        }

        if (isValid(index)) {
          ansArr[index] = ansArr[n] + 1;
          queue.offer(index);
        }
      }
    }
    return -1;
  }

  private static boolean isValid(int index) {
    return index >= 0 && index <= 100000 && ansArr[index] == 0;
  }
}