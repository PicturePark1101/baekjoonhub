import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static boolean makeWheel(String[] str, String s, int N, int cnt, int idx) {

    if (isNotExist(str, s, idx)) { // 다른 곳에 존재하지 않음
      if (str[idx].equals("?")) {
        str[idx] = s;
      } else if (!str[idx].equals(s)) {
        return false;
      }
    } else {
      return false;
    }
    return true;
  }
  public static boolean isNotExist(String[] strs, String s, int idx) {
    for (int i = 0; i < strs.length; i++) {
      if (i != idx && strs[i].equals(s)){

        return false;
      }
    }
    return true;

  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int size = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    String[] str = new String[size];

    // 모두 ?로 초기화하기
    for (int i = 0; i < str.length; i++) {
      str[i] = "?";
    }

    int idx = 0;
    boolean flag = true;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      String s = st.nextToken();

      idx = (idx + cnt) % size;

      if (!makeWheel(str, s, N, cnt, idx)){
        bw.write("!");
        flag = false;
        break;
      }
    }

    if (flag) {
      for (int i = 0; i < size; i++) {
        bw.write(str[idx]);
        idx = (idx - 1 + size) % size;
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }

}
