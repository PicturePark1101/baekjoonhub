import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      System.out.println(getString(br.readLine().toCharArray()));
    }
    br.close();
  }

  private static String getString(char[] commands) {
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();

    for (int j = 0; j < commands.length; j++) {
      executeCommand(stack1, stack2, commands[j]);
    }

    while(!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }

    StringBuilder sb = new StringBuilder();
    while(!stack1.isEmpty()) {
      sb.append(stack1.pop());
    }
    
     return sb.reverse().toString();
  }

  private static void executeCommand(Stack<Character> stack1, Stack<Character> stack2, char command) {
    switch(command) {
      case '<' : {
        if (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
        break;
      }
      case '>' : {
        if (!stack2.isEmpty()) {
          stack1.push(stack2.pop());
        }
        break;
      }
      case '-' : {
        if (!stack1.isEmpty()) {
          stack1.pop();
        }
        break;
      }
      default : {
        stack1.push(command);
      }
    }
  }
}