import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static String isBalanced(String str) {

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch =='(') {
        stack.push(ch);
      } else if (ch == '['){
        stack.push(ch);
      } else if (ch == ')'){
        if (stack.isEmpty()) {
          return "no";
        } else {
          if (stack.peek() == '[') {
            return "no";
          }else {
            stack.pop();
          }
        }

      } else if (ch == ']'){
        if (stack.isEmpty()) {
          return "no";
        } else {
          if (stack.peek() == '(') {
            return "no";
          }else {
            stack.pop();
          }
        }
      }
    }
    if (stack.isEmpty()) {
      return "yes";
    }
    return "no";
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    while (!str.equals(".")) {
      System.out.println(isBalanced(str.replace(" ", "")));
      str = br.readLine();
    }
  }
}
