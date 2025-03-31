import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Queue<Integer> people = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      people.add(i);
    }
    int count = 0;

    sb.append("<");
    while(people.size() != 1) {
      count++;
      if (count == K) {
        sb.append(people.poll()).append(", ");
        count = 0;
      } else {
        people.add(people.poll());
      }
    }
    sb.append(people.poll()).append(">");
    System.out.println(sb);
    br.close();
  }
}