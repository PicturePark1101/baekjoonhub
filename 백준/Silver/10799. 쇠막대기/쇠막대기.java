import java.util.*;
import java.io.*;

public class Main {
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(executeCommand(br.readLine()));
    br.close();
  }
  private static int executeCommand(String str) {
    Stack<Character> stack = new Stack<>();
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);
      if (currentChar == '(') {
        stack.push(currentChar);
      } else {
        if (str.charAt(i - 1) == '(') {
          count += stack.size() - 1;
        } else if (!stack.isEmpty()){
          count++;
        }
        stack.pop();
      }
    }
    return count;
  }
}