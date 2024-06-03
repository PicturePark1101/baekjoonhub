import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static String cursor(String pwd) {

    Stack<Character> pre = new Stack<>();
    Stack<Character> post = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0 ; i < pwd.length(); i++) {
      char ch = pwd.charAt(i);
      if (ch == '>') {
        if (!post.empty()) {
          pre.push(post.pop());
        }
      } else if (ch =='<'){
        if (!pre.empty()) {
          post.push(pre.pop());
        }
      } else if (ch == '-') {
        if (!pre.empty()) {
          pre.pop();
        }
      } else {
        pre.push(ch);
      }
    }

    while (!post.empty()) {
      pre.push(post.pop());
    }

    for (int i = 0; i < pre.size(); i++) {
      sb.append(pre.elementAt(i));
    }
    
    return sb.toString();
  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      System.out.println(cursor(br.readLine()));
    }
  }

}
