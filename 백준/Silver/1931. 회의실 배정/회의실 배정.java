import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    ArrayList<int[]> meeting = new ArrayList<>();
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      meeting.add(new int[]{start, end});
    }

    meeting.sort(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) {
          return Integer.compare(o1[0], o2[0]);
        }
        return Integer.compare(o1[1], o2[1]);
      }
    });

    int cnt = 0;
    int end = 0;
    for(int[] m : meeting) {
      if (end <= m[0]) {
        cnt++;
        end = m[1];
      }
    }
    bw.write(String.valueOf(cnt));

    bw.flush();
    bw.close();
    br.close();
  }

}