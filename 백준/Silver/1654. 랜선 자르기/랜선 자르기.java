import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static long cuttingCable(int[] cable, int N) {
    long l = 1, r = cable[cable.length - 1];
    long ans = 1;

    while (l <= r) {
      long m = (l + r) / 2;
      int cnt = 0;

      for (int i = 0; i < cable.length; i++) {
        cnt += (cable[i] / m);
      }

//      if (cnt == N) {
//        return ans;
//      } else
//      System.out.println(cnt +" "+m);
      if (cnt < N){ // 개수보다 적음 -> 줄여야함
        r = m - 1;
      } else { // 개수보다 많다... -> m을 늘려야함 오른쪽 탐색
        l = m + 1;
        ans = m;
      }

    }
    return ans;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int[] cable = new int[K];

    for (int i = 0; i < K; i++){
      cable[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(cable);

    bw.write(String.valueOf(cuttingCable(cable, N)));

    br.close();
    bw.flush();
    bw.close();

  }

}
