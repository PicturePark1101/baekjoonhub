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
      people.offer(i);
    }

    int count = 0;
    sb.append("<");
    while (!people.isEmpty()) {
      count++;
      if (count == K) {
        sb.append(people.poll());
        if (people.size() != 0) {
          sb.append(", ");
        }
        count = 0;
      } else {
        people.offer(people.poll());
      }
    }
    sb.append(">");
    System.out.println(sb);
    br.close();
  }
}
