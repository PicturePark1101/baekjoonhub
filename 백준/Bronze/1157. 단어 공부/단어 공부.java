import java.io.*;

public class Main {

  public static String answer(int[] alphabet) {

    char ans = 0;
    int maxCnt = -1;

    for (int i = 0; i < alphabet.length; i++) {
      if (alphabet[i] > maxCnt) {
        ans = (char) (i + 'A');
        maxCnt = alphabet[i];
      } else if (alphabet[i] == maxCnt){
        ans = '?';
      }
    }

    return String.valueOf(ans);
  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] alphabet = new int[26];

    String input = br.readLine().toUpperCase();
    
    for (int i = 0; i < input.length(); i++) {
      alphabet[input.charAt(i) - 'A']++;
    }

    bw.write(answer(alphabet));

    br.close();
    bw.close();
  }
}