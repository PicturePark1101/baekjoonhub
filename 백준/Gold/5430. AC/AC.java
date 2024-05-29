import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void queue(String[] nums, String command) {

    Deque<String> qu = new LinkedList<>();

    for (int i = 0; i < nums.length; i++) {
      qu.offer(nums[i]);
    }

    boolean isReverse = false;

    for (int i = 0; i < command.length(); i++) {
      char ch = command.charAt(i);

      if (ch == 'R') {
        isReverse = !isReverse;
      } else {
        if (qu.isEmpty()) {
          System.out.println("error");
          return;
        } else {
          if (isReverse) {
            qu.pollLast();
          } else {
            qu.pollFirst();
          }
        }
      }
    }
    printDeque(qu, isReverse);
  }

  public static void printDeque(Deque<String> queue, boolean isReverse) {

    StringBuilder sb = new StringBuilder();
    sb.append("[");

    while (!queue.isEmpty()) {
      if (isReverse) {
        sb.append(queue.pollLast());
      } else {
        sb.append(queue.pollFirst());
      }
      if (!queue.isEmpty()) {
        sb.append(",");
      }
    }
    sb.append("]\n");
    System.out.print(sb);
  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuffer sb = new StringBuffer();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      sb = new StringBuffer();

      String p = br.readLine();
      int N = Integer.parseInt(br.readLine());

      String arrStr = br.readLine();
      sb.append(arrStr);

      sb.deleteCharAt(arrStr.length() - 1);
      sb.deleteCharAt(0);

      String[] nums = new String[N];
      if (sb.isEmpty()) {
        nums = new String[]{};
      } else {
        nums = sb.toString().split(",");
      }
      queue(nums, p);
    }

  }

}
