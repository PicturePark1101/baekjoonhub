import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    long[] arr = new long[101];
    makeArr(arr);

    for (int i = 0; i < N; i++) {
      sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
    }
    System.out.println(sb);
    br.close();
  }

  private static void makeArr(long[] arr) {
    arr[1] = 1;
    arr[2] = 1;
    arr[3] = 1;
    arr[4] = 2;
    arr[5] = 2;
    arr[6] = 3;
    arr[7] = 4;
    arr[8] = 5;
    arr[9] = 7;
    arr[10] = 9;

    for (int i = 11; i < arr.length; i++) {
      arr[i] = arr[i - 5] + arr[i - 1];
    }
  }
}
