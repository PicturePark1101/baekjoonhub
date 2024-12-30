import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static class Counsel {
    private int day;
    private int pay;

    public Counsel(int day, int pay) {
      this.day = day;
      this.pay = pay;
    }
  }
  private static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    Counsel[] counsels = new Counsel[N + 1];
    int[] DP = new int[N + 2];

    StringTokenizer st;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      counsels[i] = new Counsel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    makeArr(counsels, DP);
    // print(DP);
    System.out.println(Arrays.stream(DP).max().getAsInt());
    br.close();
  }

  private static void makeArr(Counsel[] counsels, int[] DP) {
    for (int i = 1; i <= N; i++) {
      if (counsels[i].day + i <= N + 1) {
        int next = counsels[i].day + i;
        DP[next] = Math.max(DP[next], DP[i] + counsels[i].pay);
      }
      DP[i + 1] = Math.max(DP[i + 1], DP[i]);
    }
  }

  private static void print(int[] DP) {
    for (int i = 1; i <= N + 1; i++) {
      System.out.print(DP[i]+" ");
    }
    System.out.println();
  }
}
