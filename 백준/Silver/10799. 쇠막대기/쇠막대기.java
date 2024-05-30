import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    Stack<Character> stack = new Stack<>();
    int ans = 0;

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if (ch == '(') {
        stack.push(ch);
      }else if (ch == ')') {
        stack.pop();
        if (input.charAt(i - 1) == ')') { // 레이저아님
          ans++;
        } else { // 레이저임
          ans += stack.size();
        }
      }
    }
    System.out.println(ans);
  }
}
