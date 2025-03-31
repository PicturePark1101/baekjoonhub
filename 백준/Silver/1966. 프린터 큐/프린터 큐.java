import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  static class Docs {
    private int priority;
    private int order;

    public Docs(int priority, int order) {
      this.priority = priority;
      this.order = order;
    }
  }

  private static LinkedList<Docs> nums = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      nums = new LinkedList<>();
      for (int j = 0; j < N; j++) {
        nums.offer(new Docs(Integer.parseInt(st.nextToken()), j));
      }
      sb.append(execute(N, M)).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  private static int execute(int n, int m) {
    int count = 0;

    while (!nums.isEmpty()) {
      // 우선순위 나보다 높은거 있으면 꺼내서 뒤에 집어 넣음
      // 아니면 꺼냄. -> 이 때 요소의 order이 찾는 m과 일치하면 출력

      Docs currentDoc = nums.poll();
      boolean isMax = true;

      for (int i = 0; i < nums.size(); i++) {
        if (currentDoc.priority < nums.get(i).priority) {
          nums.offer(currentDoc);
          for (int j = 0; j < i; j++) {
            nums.offer(nums.poll());
          }
          isMax = false;
          break;
        }
      }
      if (!isMax) {
        continue;
      }

      count++;
      if (currentDoc.order == m) return count;
    }
    return 0;
  }

}
