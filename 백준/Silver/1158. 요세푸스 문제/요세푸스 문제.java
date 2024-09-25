import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }
        sb.append("<");
        while(!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            sb.append(String.valueOf(queue.poll()));
            if (queue.size() != 0) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}