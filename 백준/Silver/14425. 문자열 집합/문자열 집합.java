import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {


  private static boolean isExist(String[] arr, String str) {

    int l = 0, r = arr.length - 1;

    while (l <= r) {
      int m = (l + r) / 2;
      if (str.compareTo(arr[m]) > 0) { // str이 더 큼
        l = m + 1;
      } else if (str.compareTo(arr[m]) < 0)  {  // str이 더 작음
        r = m - 1;
      } else {
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    String[] keyArr = new String[N];

    for (int i = 0; i < N; i++) {
      keyArr[i] = br.readLine();
    }
    Arrays.sort(keyArr);

    int cnt = 0;
    for (int i = 0; i < M; i++) {
      if (isExist(keyArr, br.readLine())) {
        cnt++;
      }
    }

    bw.write(String.valueOf(cnt));
    bw.flush();
    bw.close();
    br.close();
  }
}
