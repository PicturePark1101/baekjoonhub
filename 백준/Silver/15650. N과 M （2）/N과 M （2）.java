import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static int N;
  private static int M;
  private static int[] bucket;
  private static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    bucket = new int[M];
    combin(0, 0);
    System.out.println(sb);
    br.close();
  }

  private static void combin(int start, int depth) {

    if (depth == M) {
      for (int b : bucket) {
        sb.append(b).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i < N; i++) {
      bucket[depth] = i + 1;
      combin(i + 1, depth + 1);
    }
  }
}
