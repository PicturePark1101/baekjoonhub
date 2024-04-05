import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0 ; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int min = Integer.MAX_VALUE;
      int sum = 0;

      for (int j = 0; j < 7; j++) {
        int num = Integer.parseInt(st.nextToken());
        if (num % 2 == 0) {
          sum += num;
          if (min > num) {
            min = num;
          }
        }
      }
      bw.write(String.valueOf(sum)+ " " +String.valueOf(min)+"\n");

    }

    bw.flush();
    bw.close();
    br.close();

  }
}
