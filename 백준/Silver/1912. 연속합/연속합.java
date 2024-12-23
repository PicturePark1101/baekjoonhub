import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] DP = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(makeArr(arr, DP));
    br.close();
  }

  private static int makeArr(int[] arr, int [] DP) {
    DP[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      DP[i] = Math.max(arr[i], arr[i] + DP[i - 1]);
    }

    return Arrays.stream(DP).max().getAsInt();
  }
}
