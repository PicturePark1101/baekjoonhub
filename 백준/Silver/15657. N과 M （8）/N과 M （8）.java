import java.io.BufferedReader;
import java.io.InputStreamReader;;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int[] bucket;
  static int[] nums;

  static int N;
  static int M;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    bucket = new int[M];
    nums = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);
    pick(0,0);
    br.close();
  }

  public static void pick(int idx, int depth) {

    if (M == depth) {
      for (int i = 0; i < M; i++) {
        System.out.print(bucket[i]+ " ");
      }
      System.out.println();
      return;
    }

    for (int i = idx; i < N; i++) {
      bucket[depth] = nums[i];
      pick(i, depth + 1);
    }
  }
}