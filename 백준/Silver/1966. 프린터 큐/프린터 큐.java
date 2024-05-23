import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int caseNum = Integer.parseInt(br.readLine());

    Map<Integer, Integer> map;

    for (int i = 0; i < caseNum; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      map = new HashMap<>();

      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < N; j++) {
        int input = Integer.parseInt(st.nextToken());
        map.put(j, input);
      }

      Queue<Entry<Integer, Integer>> queue = new LinkedList<>(map.entrySet());

      int pollCnt = 0;
      while (!queue.isEmpty()) {
        pollCnt++;
        Entry<Integer, Integer> m = queue.poll();
        boolean isMaxExist = false;
        Iterator<Entry<Integer, Integer>> iter = queue.iterator();
        while (iter.hasNext()) {

          if (iter.next().getValue() > m.getValue()) {
            isMaxExist = true;
            queue.offer(m);
            pollCnt--;
            break;
          }
        }

        if (!isMaxExist && m.getKey() == M) {
          bw.write(String.valueOf(pollCnt) + "\n");
          break;
        }
      }

    }
    bw.flush();
    bw.close();
    br.close();
  }
}
