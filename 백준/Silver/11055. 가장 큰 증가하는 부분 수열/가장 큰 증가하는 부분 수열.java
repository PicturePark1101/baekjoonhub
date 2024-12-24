import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    int[] DP = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    makeDP(N, DP, arr);

    System.out.println(getAnswer(N, DP));

    br.close();
  }

  private static void makeDP(int N, int[] DP, int[] arr) {
    DP[1] = arr[1];
    for (int i = 2; i <= N; i++) {
      DP[i] = arr[i];
      for (int j = 1; j < i; j++) {
        if (arr[i] > arr[j]) {
          DP[i] = Math.max(DP[i], DP[j] + arr[i]);
        }
      }
    }
  }

  private static int getAnswer(int N, int[] DP) {
    int answer = -1;
    for (int i = 1; i <= N; i++) {
      answer = Math.max(DP[i], answer);
    }
    return answer;
  }
}
