import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static StringBuilder sb = new StringBuilder();
  private static int[] bucket;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int N = Integer.parseInt(input.substring(0, 1));

    while (N != 0) {
      int[] nums = changeIntArr(input);
      bucket = new int[6];

      pick(nums, 0, 0);
      sb.append("\n");
      input = br.readLine();
      N = Integer.parseInt(input.substring(0, 1));
    }

    System.out.println(sb);

    br.close();
  }

  private static int[] changeIntArr(String s) {
    StringTokenizer st = new StringTokenizer(s);
    int N = Integer.parseInt(st.nextToken());
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);
    return nums;
  }

  private static void pick(int[] nums, int start, int depth) {
    if (depth == 6) {
      for (int b : bucket) {
        sb.append(b).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i < nums.length; i++) {
      bucket[depth] = nums[i];
      pick(nums, i + 1, depth + 1);
    }
  }
}
