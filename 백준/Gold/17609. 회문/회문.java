import java.io.*;

public class Main {

  public static int isPalin (String str, int s, int e, int ans) {

    if (ans >= 2) {
      return 2;
    }

    while (s < e) {
      if (str.charAt(s) == str.charAt(e)) {
        s++;
        e--;
      } else {
        int left = isPalin(str, s + 1, e, ans + 1);
        int right = isPalin(str, s, e - 1, ans + 1);
        return Math.min(left, right);
      }
    }

    return ans;
  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      bw.write(String.valueOf(isPalin (str, 0, str.length() - 1, 0)));
      bw.newLine();
    }
    bw.flush();
    bw.close();
    br.close();
  }
}