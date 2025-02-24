import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  private static int N;
  private static int K;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    Deque<String> wheel = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      wheel.offer("?");
    }

    boolean flag = true;

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int rotation = Integer.parseInt(st.nextToken());
      String alpha = st.nextToken();

      if (!execute(rotation, wheel, alpha)) {
        flag = false;
        break;
      }
    }

    if (flag) {
      printWheel(wheel);
    } else {
      System.out.println("!");
    }
    br.close();
  }

  private static void printWheel(Deque<String> wheel) {
    System.out.print(wheel.poll());
    while (!wheel.isEmpty()) {
      System.out.print(wheel.pollLast());
    }
  }

  private static boolean execute(int rotation, Deque<String> wheel, String alpha) {
    for (int j = 0; j < rotation; j++) {
      wheel.offer(wheel.poll());
    }

    String pointer = wheel.peek();
    wheel.removeFirst();

    if ((!pointer.equals("?")) && (!pointer.equals(alpha))) {
      return false;
    } else if (wheel.contains(alpha)) {
      return false;
    }
    wheel.addFirst(alpha);
    return true;
  }
}
