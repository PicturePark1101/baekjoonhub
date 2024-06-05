import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main (String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    
    int last = 1;
    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(br.readLine());
      if (n >= last) {
        for (int j = last; j <= n; j++) {
          stack.push(j);
          sb.append("+").append("\n");
        }
        last = n + 1;
      }
      int peek = stack.peek();

      if (peek != n) {
        sb = new StringBuilder();
        sb.append("NO");
        break;
      }
      stack.pop();
      sb.append("-").append("\n");
    }
    System.out.println(sb);
    br.close();
  }
}
