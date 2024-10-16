import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int K = Integer.parseInt(br.readLine());
         Stack<Integer> stack = new Stack<>();
         
         for (int i = 0; i < K; i++) {
             int N = Integer.parseInt(br.readLine());
             if (N == 0) {
                 stack.pop();
             } else {
                 stack.push(N);
             }
         }
         
         int answer = 0;
         while(!stack.isEmpty()) {
             answer += stack.pop();
         }
         System.out.println(answer);
         br.close();
     }   
}