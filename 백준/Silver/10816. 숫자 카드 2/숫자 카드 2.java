import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  // -10 -10 2 3 3
  // 6 10 10 10 10

  // l = 0, r = 5 m = 2였는데
  // r = 4,  minIdx = 2
  private static int findMinIdx(int[] arr, int n) {
    int l = 0, r = arr.length - 1;
    int minIdx = arr.length;
    while (l <= r) {
      int m = (l + r) / 2;
      if (arr[m] < n) { // 찾는 값이 더 크다.
        l = m + 1; // 왼쪽 제외
      } else { // 찾는 값이 더 작거나 같다.
        r = m - 1;
        minIdx = m;
      }

    }
    return minIdx;
  }


  // -10 -10 2 3 3
  // 6 10 10 10 10 11 12 13
  private static int findMaxIdx(int[] arr, int n) {
    int l = 0, r = arr.length - 1;
    int maxIdx = arr.length;
    while (l <= r) {
      int m = (l + r) / 2;
      if (arr[m] <= n) { // 찾는 값이 더 크거나 같다.
        l = m + 1; // 왼쪽 제외
      } else { // 찾는 값이 더 작다.
        r = m - 1;
        maxIdx = m;
      }

    }
    return maxIdx;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] card = new int[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      card[i] = Integer.parseInt(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    int[] search = new int[M];
    st = new StringTokenizer(br.readLine());

    Arrays.sort(card);
    for (int i = 0; i < M; i++) {
      search[i] = Integer.parseInt(st.nextToken());
      int min = findMinIdx(card, search[i]);
      int max = findMaxIdx(card, search[i]);
      bw.write(String.valueOf(max - min)+ " ");

    }

    bw.flush();
    bw.close();
    br.close();
  }

}
