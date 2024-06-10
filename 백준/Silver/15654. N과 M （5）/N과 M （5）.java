import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static int[] bucket;
  private static int[] nums;
  private static boolean[] visited;
  // 순열, 중복 x
  public static void pick(int[] nums, int N, int M, int depth) {

    if (M == depth) {
      for (int i = 0; i < M; i++) {
        System.out.print(bucket[i]+" ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        bucket[depth] = nums[i];
        pick(nums, N, M, depth + 1);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    nums = new int[N];
    bucket = new int[M];
    visited = new boolean[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);
    pick(nums, N, M, 0);
  }
}
