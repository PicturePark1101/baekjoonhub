import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

  private static boolean isExist(ArrayList<Integer> arr, int n) {

    int l = 0, r = arr.size() - 1;

    while (l <= r) {
      int m = (l + r) / 2;
      if (arr.get(m) < n) { // n이 더 큼
        l = m + 1;
      } else if (arr.get(m) > n)  { // n 이 더작다.
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

    int[] arr = new int[N];
    ArrayList<Integer> sumARr = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 0 ; i < N; i++) {
      for (int j = i; j < N; j++) {
        sumARr.add(arr[i] + arr[j]);
      }
    }

    Arrays.sort(arr);
    sumARr.sort(Comparator.naturalOrder());

    boolean flag = false;
    for (int i = N - 1; i >= 0; i--) {
      for (int j = i; j >= 0; j--) {
        if (isExist(sumARr, arr[i] - arr[j])){
          bw.write(String.valueOf(arr[i]));
          flag = true;
          break;
        }
      }
      if (flag) {
        break;
      }

    }

    bw.flush();
    bw.close();
    br.close();
  }
}
