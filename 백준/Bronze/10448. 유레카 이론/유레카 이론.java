import java.io.*;

public class Main {

  private static int[] e = new int[45];

  private static int eureka(int n) {

    int cnt = 0;
    for (int i = 1; i < e.length; i++) {
      for (int j = 1; j < e.length; j++) {
        for (int k = 1; k < e.length; k++) {
          if (n == e[i] + e[j] + e[k])
            return 1;
        }
      }
    }
    return 0;
  }

  private static void makeArr(){

    for (int i = 1; i < e.length; i++) {
      e[i] = i * (i + 1) / 2;
    }
  }

  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    makeArr();

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      bw.write(String.valueOf(eureka(Integer.parseInt(br.readLine())))+"\n");
    }
    bw.flush();
    bw.close();
    br.close();

  }

}
