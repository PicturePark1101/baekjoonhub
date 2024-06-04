import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static boolean isPPAP(String str) {

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == 'P') {
        stack.push('P');
      } else {
        if (stack.size() >= 2 && i + 1 < str.length() && str.charAt(i + 1) == 'P') {
          stack.pop();
          stack.pop();
        } else {
          return false;
        }
      }
    }

    return stack.size() == 1;
  }
  public static void main (String[] args) throws Exception {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    if (isPPAP(str)) {
      System.out.println("PPAP");
    } else {
      System.out.println("NP");
    }
  }
}