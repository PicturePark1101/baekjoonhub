import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    LinkedList<Integer> p = new LinkedList();

    for (int i = 1; i <= N; i++) {
      p.add(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");
    while (!(p.size() == 1)) {
      for (int i = 0; i < K - 1; i++) {
        p.add(p.remove());
      }
      sb.append(p.remove()+", ");
    }

    sb.append(p.remove()+">");

    System.out.println(sb);
    br.close();
  }
}
