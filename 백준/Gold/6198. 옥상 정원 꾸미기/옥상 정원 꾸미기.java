import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] count = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    stack.push(0);

    for (int i = 1; i < N; i++) {
      while ((!stack.isEmpty()) && arr[stack.peek()] <= arr[i]) {
        int popIndex = stack.pop();
        count[popIndex] = i - popIndex - 1;
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      int popIndex = stack.pop();
      count[popIndex] = N - popIndex - 1;
    }

    long answer = 0L;
    for (int n : count) {
      answer += n;
    }
    System.out.println(answer);
    br.close();
  }
}