import java.util.*;
import java.io.*;

public class Main {
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String command = br.readLine();
    while(!command.equals(".")) {
      sb.append(executeCommand(command)).append("\n");
      command = br.readLine();
    }
    System.out.print(sb);
    br.close();
  }

  private static String executeCommand(String str) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);
      if (currentChar == '(' || currentChar == '[') {
        stack.push(currentChar);
      } else if(currentChar == ')') {
        if (stack.isEmpty() || stack.peek() == '[') {
          return "no";
        }
        stack.pop();
      } else if(currentChar == ']') {
        if (stack.isEmpty() || stack.peek() == '(') {
          return "no";
        }
        stack.pop();
      }
    }
    if (stack.isEmpty()) {
      return "yes";
    }
    else {
      return "no";
    }
  }
}