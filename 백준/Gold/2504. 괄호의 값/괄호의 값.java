import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main (String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    Stack<Character> stack = new Stack<>();

    int ans = 0;
    int temp = 1;
    for (int i = 0; i < input.length(); i++) {

      char ch = input.charAt(i);
      if (ch == '('){
        temp *= 2;
        stack.push(ch);
      } else if (ch == '[') {
        temp *= 3;
        stack.push(ch);
      } else if (ch == ')') {
        if (stack.isEmpty() || stack.peek() != '('){
          ans = 0; // 유효하지 않은 괄호에 대한 처리
          break;
        } else {
            if (input.charAt(i - 1) == '(') { // ()괄호
              ans += temp;
            }
            stack.pop();
            temp /= 2;
        }
      } else if (ch == ']') {
        if (stack.isEmpty() || stack.peek() != '['){
          ans = 0; // 유효하지 않은 괄호에 대한 처리
          break;
        } else {
          if (input.charAt(i - 1) == '[') { // ()괄호
            ans += temp;
          }
          stack.pop();
          temp /= 3;
        }
      }
    }
    if (!stack.isEmpty()) {
      ans = 0;
    }
    System.out.println(ans);
  }

}