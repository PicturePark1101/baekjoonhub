import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    List<Stack<Integer>> stacks = new ArrayList<>();

    for (int i = 0; i <= 6; i++) {
      stacks.add(new Stack<Integer>());
    }

    int ans = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());

      Stack<Integer> stack = stacks.get(n);
      while ((!stack.empty()) && stack.peek() > p) {
        stack.pop();
        ans++;
      }

      if (stack.empty() || stack.peek() != p) {
        stack.push(p);
        ans++;
      }
    }
    System.out.println(ans);
  }
}
