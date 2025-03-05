import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int arr[] = new int[N + 1];
    int acc[] = new int[N + 2];
    int finalAcc[] = new int[N + 2];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      acc[start] += k;
      acc[end + 1] += -k;
    }

    for (int i = 1; i <= N; i++) {
      finalAcc[i]  = acc[i] + finalAcc[i - 1];
    }

    for (int i = 1; i <= N; i++) {
      arr[i] += finalAcc[i];
      bw.write(String.valueOf(arr[i])+" ");

    }

    bw.flush();
    bw.close();
    br.close();

  }

}
