import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static boolean isPossible(int[] money, int m, int M) {

    int cnt = 1;
    int wallet = m;

    for (int i = 0; i < money.length; i++) {
      if (money[i] > wallet) { // 지갑보다 써야할게 더 많음
        cnt++; // 인출
        wallet = m;
      }
      wallet -= money[i];
    }

    return cnt <= M;
  }
  private static int binarySearch(int[] money, int M, int max, int min) {
    int l = min;
    int r = max;
    int result = 0;

    while (l <= r) {
      int m = (l + r) / 2;
      if (isPossible(money , m, M)) { // 줄여야함 인출횟수가 더 많음
        result = m;
        r = m - 1;
      } else { // 늘려야함
        l = m + 1;
      }
    }

    return result;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;


    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] money = new int[N];
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      money[i] = Integer.parseInt(br.readLine());
      sum += money[i];
      max = Math.max(max, money[i]);
    }

    bw.write(String.valueOf(binarySearch(money, M, sum, max)));
    bw.flush();
    bw.close();
    br.close();
  }

}
