import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main (String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      sb.append(execute(input.toCharArray())).append("\n");
    }
    System.out.println(sb);
    br.close();
  }

  private static int execute(char[] chs) {
    int p = 0;
    int q = chs.length - 1;

    while (p < q) {
      if (chs[p] == chs[q]) {
        p++;
        q--;
      } else {
        int left = isPalin(p + 1, q, chs);
        int right = isPalin(p, q - 1, chs);
        return Math.min(left, right);
      }

    }
    return 0;
  }

  private static int isPalin(int i, int j, char[] chs) {
    while (i < j) {
      if (chs[i] == chs[j]) {
        i++;
        j--;
      } else {
        return 2;
      }

    }
    return 1;
  }
}
