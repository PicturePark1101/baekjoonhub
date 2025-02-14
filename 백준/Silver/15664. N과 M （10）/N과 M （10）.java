import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static int[] nums;
  private static int[] bucket;
  private static int N;
  private static int M;
  private static StringBuilder sb = new StringBuilder();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    nums = new int[N];
    bucket = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);
    pick(0, 0);
    System.out.println(sb);
    br.close();
  }

  private static void pick (int start, int depth) {
    if (depth == M) {
      for (int b : bucket) {
        sb.append(b).append(" ");
      }
      sb.append("\n");
      return;
    }

    int lastNum = -1;
    for (int i = start; i < N; i++) {
      if (nums[i] ==  lastNum) continue;
      bucket[depth] = nums[i];
      pick (i + 1, depth + 1);
      lastNum = nums[i];
    }
  }
}
