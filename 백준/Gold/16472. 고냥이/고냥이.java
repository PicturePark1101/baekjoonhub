import java.io.*;

public class Main {

  public static int maxArrLen(String arr, int N) {

    int[] cntAlpha = new int[26];

    int e = 0;
    int maxLen = 0;
    for (int s = 0; s < arr.length(); s++) {

      while (e < arr.length()) {
        cntAlpha[arr.charAt(e) - 'a']++;
        if (!cntAlphaKind(cntAlpha, N)) {
          cntAlpha[arr.charAt(e) - 'a']--;
          break;
        }
        e++;
      }
      maxLen = Math.max(maxLen, e - s);
      // System.out.println(e - s);
      cntAlpha[arr.charAt(s) - 'a']--;
    }

    return maxLen;
  }

  public static boolean cntAlphaKind(int[] cntAlpha, int N) {
    int cnt = 0;

    for (int i = 0; i < 26; i++) {
      if (cntAlpha[i] > 0) {
        cnt++;
      }
      if (cnt > N) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String arr = br.readLine();

    bw.write(String.valueOf(maxArrLen(arr, N)));
    bw.flush();
    bw.close();
    br.close();
  }

}