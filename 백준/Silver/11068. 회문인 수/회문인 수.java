import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

  // 진수변환
  private static boolean radixConvert(int n , int r) {
    ArrayList<Integer> convertWord = new ArrayList<>();

    while (n > 0) {
      convertWord.add(n % r);
      n /= r;
    }

    return isPaldm(convertWord);
  }

  private static boolean isPaldm(ArrayList<Integer> word){
    for (int i = 0; i < word.size() / 2; i++) {
      if (word.get(i) != word.get(word.size() - i - 1)){
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int number = Integer.parseInt(br.readLine());
      boolean isFound = false;

        for (int j = 2; j <= 64; j++) {
          if (radixConvert(number, j)){
            isFound = true;
            break;
          }
        }

      bw.write(isFound ? "1\n" : "0\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }

}
