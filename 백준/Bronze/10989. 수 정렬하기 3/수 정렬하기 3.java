import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int n = Integer.parseInt(br.readLine());
      int[] list = new int[n];

      for (int i = 0; i < n; i++) {
        list[i] = Integer.parseInt(br.readLine());
      }

      Arrays.sort(list);

      for (int i : list) {
        bw.write(String.valueOf(i)+"\n");
      }

      bw.flush();
      bw.close();
      br.close();
    }

}
  