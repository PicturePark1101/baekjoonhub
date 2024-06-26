import java.io.*;
import java.util.StringTokenizer;


public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] acc = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        acc[i][j] = acc[i][j-1] + Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < M; i++) {
      int sum = 0;
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for (int j = x1; j <= x2; j++) {
        sum = sum + (acc[j][y2] - acc[j][y1-1]);
      }

      bw.write(String.valueOf(sum+"\n"));
    }

    bw.flush();
    bw.close();
    br.close();

  }

}
