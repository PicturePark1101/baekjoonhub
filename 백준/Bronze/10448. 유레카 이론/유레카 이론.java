import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static int T;
  private static int[] tArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    tArr = new int[1001];
    makeTArr();

    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      sb.append(getAnswer(Integer.parseInt(br.readLine()))).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  private static void makeTArr() {
    for (int i = 0; i < tArr.length; i++) {
      tArr[i] = i * (i + 1) / 2;
    }
  }

  private static int getAnswer(int n) {
    int sum = 0;
    for (int i = 1; i < tArr.length; i++) {
      for (int j = 1; j < tArr.length; j++) {
        for (int k = 1; k < tArr.length; k++) {
          sum = tArr[i] + tArr[j] + tArr[k];
          if (sum == n) {
            return 1;
          } else if (sum > n) {
            break;
          }
        }
      }
    }
    return 0;
  }
}
