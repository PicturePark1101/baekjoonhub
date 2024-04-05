import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] room;

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int h = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      int roomNum = Integer.parseInt(st.nextToken());

      room = new int[h * w + 1];

      int idx = 0;
      for (int j = 0; j < w; j++) {
        int n1 = 101 + j;
        for (int k = 0; k < h; k++) {
          room[idx++] = n1 + (100 * k);
        }
      }

      bw.write(String.valueOf(room[roomNum - 1])+ "\n");

    }

    bw.flush();
    bw.close();
    br.close();
  }
}
