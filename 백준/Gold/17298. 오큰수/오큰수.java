import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
      
    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];
    int[] ans = new int[N];
    Stack<Integer> stack = new Stack<>();
      
    StringTokenizer st = new StringTokenizer(br.readLine());
      
    for (int i = 0 ; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
      ans[i] = -1;
    }
      
    for (int i = 0 ; i < N; i++) {
        
      while (!stack.empty() && nums[stack.peek()] < nums[i]) {
          int idx = stack.pop();
          ans[idx] = nums[i];
      }
        
      stack.push(i);
    }  

      
    for (int i = 0 ; i < N; i++) {
      sb.append(ans[i]).append(" ");
    }
    System.out.println(sb);
    br.close();
  }
}
