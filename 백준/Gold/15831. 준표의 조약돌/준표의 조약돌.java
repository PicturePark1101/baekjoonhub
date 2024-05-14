import java.io.*;
import java.util.*;

public class Main {

  public static int maxRoadLen(String road, int maxB, int minW) {

    int e = 0;
    int cntB = 0;
    int cntW = 0;
    int maxLen = 0;

    for (int s = 0; s < road.length(); s++) {

      while (e < road.length()) {
        if (cntB == maxB && road.charAt(e) == 'B') {
          break;
        }
        if (road.charAt(e) == 'B') {
          cntB++;
        } else {
          cntW++;
        }
        e++;
      }

      if (minW <= cntW) {
        // 조건 만족시 갱신
        // System.out.println(s+" "+e+" ");
        maxLen = Math.max(maxLen, e - s);
      }

      if (road.charAt(s) == 'B') {
        cntB--;
      } else {
        cntW--;
      }
    }
    return maxLen;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int maxB = Integer.parseInt(st.nextToken());
    int minW = Integer.parseInt(st.nextToken());

    String road = br.readLine();

    bw.write(String.valueOf(maxRoadLen(road, maxB, minW)));
    bw.flush();
    bw.close();
    br.close();
  }

}
