import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<Integer> deque = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      deque.add(i);
    }

    st = new StringTokenizer(br.readLine());
    int answer = 0;
    for (int i = 0; i < M; i++) {
      int n = Integer.parseInt(st.nextToken());
      int searchIndex = deque.indexOf(n);

      int halfSize = deque.size() / 2;
      if (deque.size() % 2 == 0) {
        halfSize--;
      }
      
      if (halfSize >= searchIndex) { // 첫 번째에 더 가까이 있음
        while ((!deque.isEmpty()) && deque.get(0) != n) {
          deque.add(deque.remove(0));
          answer++;
        }
      } else {
        while ((!deque.isEmpty()) && deque.get(0) != n) {
          deque.add(0, deque.remove(deque.size() - 1));
          answer++;
        }
      }
      deque.remove(0);
    }

    System.out.print(answer);
    br.close();
  }
}