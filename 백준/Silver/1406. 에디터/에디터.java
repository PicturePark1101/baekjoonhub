import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> str = Arrays.asList(br.readLine().split(""));
    Stack<String> stack1 = new Stack<>();
    Stack<String> stack2 = new Stack<>();
    stack1.addAll(str);

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      executeCommand(stack1, stack2, br.readLine());
    }
    while (!stack2.isEmpty()) {
      stack1.add(stack2.pop());
    }
    StringBuilder sb = new StringBuilder();
    while (!stack1.isEmpty()) {
      sb.append(stack1.pop());
    }
    System.out.println(sb.reverse());
  }

  private static void executeCommand(Stack<String> stack1, Stack<String> stack2, String command) {
    StringTokenizer st = new StringTokenizer(command);
    switch(st.nextToken()) {
      case "L" : {
        if (!stack1.isEmpty()) {
          stack2.add(stack1.pop());
        }
        break;
      }
      case "D" : {
        if (!stack2.isEmpty()) {
          stack1.add(stack2.pop());
        }
        break;
      }
      case "B" : {
        if (!stack1.isEmpty()) {
          stack1.pop();
        }
        break;
      }
      case "P" : {
        stack1.add(st.nextToken());
        break;
      }
    }
  }
}