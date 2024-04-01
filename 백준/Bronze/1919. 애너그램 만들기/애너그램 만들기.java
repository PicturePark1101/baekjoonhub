import java.io.*;

public class Main {


  public static int[] cntWord (String str) {

    int[] alphabet = new int[26];

    for (int i = 0; i < str.length(); i++) {
      alphabet[str.charAt(i) - 'a']++;
    }
    return alphabet;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int cnt = 0;
    int[] str1 = cntWord(br.readLine());
    int[] str2 = cntWord(br.readLine());

    for (int i = 0; i < 26; i++) {
      cnt += Math.abs(str1[i] - str2[i]);
    }

    bw.write(Integer.toString(cnt));

    br.close();
    bw.close();
  }
}