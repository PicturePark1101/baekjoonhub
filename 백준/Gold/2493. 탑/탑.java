import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    stack.push(0);
    sb.append(0).append(" ");
    for (int i = 1; i < N; i++) {

      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        stack.pop();
      }

      if (stack.isEmpty()) { // 큰 수 없는 경우
        sb.append(0);
      } else {
        sb.append(stack.peek() + 1);
      }
      sb.append(" ");
      stack.push(i);
    }

    System.out.print(sb);
    br.close();
  }
}