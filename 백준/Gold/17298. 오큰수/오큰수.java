import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while ((!stack.isEmpty()) && arr[stack.peek()] < arr[i]) {
                int popIndex = stack.pop();
                answer[popIndex] = arr[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }        
        System.out.println(sb);
        br.close();  
    }  
}