import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  static HashMap<Integer, String> hm = new HashMap<>();

  private static void radixConvert(int n , int r) {
    if (n < 1) {
      return;
    }

    radixConvert(n / r , r);

    int value = n % r;
    if (value > 9){
      System.out.print(hm.get(value));
    }else {
      System.out.print(n % r);
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());


    for (int i = 0; i <= 25; i++) {
      hm.put(i + 10, Character.toString( 'A' + i) );
    }

    int n = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    radixConvert(n , r);


  }

}
