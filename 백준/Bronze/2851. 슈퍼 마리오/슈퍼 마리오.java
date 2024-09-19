import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] S = new int[11];

    for (int i = 1; i <= 10; i++){
      S[i] = S[i - 1] + Integer.parseInt(br.readLine());
      // System.out.println(S[i]);
    }

    int ans = 0;
    int min =  Math.abs(S[0] - 100);
    for (int i = 1; i <= 10; i++) {
      if (min >= Math.abs(S[i] - 100)) {
        ans = S[i];
        min = Math.abs(S[i] - 100);
      };
    }
    System.out.println(ans);
    br.close();
  }
}