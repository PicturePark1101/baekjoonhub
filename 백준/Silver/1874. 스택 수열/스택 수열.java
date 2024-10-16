import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    int pointer = 1;
    for (int i = 0; i < N; i++) {
      pointer = executeCommand(stack, pointer, sb, Integer.parseInt(br.readLine()));
      if (pointer == -1) {
        break;
      }
    }

    System.out.println(sb);
    br.close();
  }

  private static int executeCommand(Stack<Integer> stack, int pointer, StringBuilder sb, int inputN) {

    if (stack.isEmpty() || stack.peek() < inputN) {
      while (inputN >= pointer) {
        stack.push(pointer++);
        sb.append("+").append("\n");
      }
    }

    if (stack.peek() != inputN) {
      sb.setLength(0);
      sb.append("NO");
      return -1;
    }
    
    stack.pop();
    sb.append("-").append("\n");
    return pointer;
  }
}