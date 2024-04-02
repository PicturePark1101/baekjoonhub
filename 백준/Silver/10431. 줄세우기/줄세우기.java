import java.io.*;
import java.util.*;

public class Main {

  private static int check(int[] p) {

    int cnt = 0;
    int[] newP = new int[20];

    for (int i = 0; i < 20; i++) {
      // i의 앞에 i보다 더 큰사람이 있는지를 검사

      boolean flag = false;
      for (int j = 0; j < i; j++) {
        if (newP[j] > p[i]) {
          // i가 j앞으로 가야함......
          // 어떻게? 3중 포문? i를 j위치로, 나머지륾 위로
          flag = true;
          // j부터 기존꺼 뒤로 미루기
          for (int k = i - 1; k >= j; k--) {
            newP[k + 1] = newP[k];
            cnt++;
          }
          newP[j] = p[i];
          break;
        }
      }

      if (!flag){
        newP[i] = p[i];
      }
    }

    return cnt;
  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      int[] people = new int[20];
      st = new StringTokenizer(br.readLine());

      int order = Integer.parseInt(st.nextToken());

      for (int idx = 0; idx < 20; idx++) {
        people[idx] = Integer.parseInt(st.nextToken());
      }
      bw.write(String.valueOf(i+1) +" "+String.valueOf(check(people)) +"\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }

}