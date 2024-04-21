
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


  private static int binarySearch(int[] treeH, int N, int M) {
    int l = 0;
    int r = treeH[N - 1];
    int result = 0;

    while (l <= r) {
      int m = (l + r) / 2;
      long sum = 0;

      for (int i = 0; i < N; i++) {
        if (treeH[i] > m) {
          sum += treeH[i] - m;
        }
      }

      if (sum >= M) {
        result = m;
        l = m + 1;
      } else {
        r = m - 1;
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

    int[] treeH = new int[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      treeH[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(treeH);
    bw.write(String.valueOf(binarySearch(treeH, N, M)));
    bw.flush();
    bw.close();
    br.close();
  }

}
