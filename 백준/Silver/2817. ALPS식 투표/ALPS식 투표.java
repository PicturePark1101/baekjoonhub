import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int peopleNum = Integer.parseInt(br.readLine());
    Map<Double, String> map = new HashMap<>();
    Map<String, Integer> finalMap = new HashMap<>();

    double line = peopleNum * 0.05;

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      String p = st.nextToken();
      int vote = Integer.parseInt(st.nextToken());

      if (vote >= line) {
        finalMap.put(p, 0);
        for (double j = 1; j <= 14; j++) {
          map.put(vote / j, p);
        }
      }
    }

    // 숫자들 내림차순으로 sort
    List<Double> keySet = new ArrayList<>(map.keySet());
    Collections.sort(keySet, Collections.reverseOrder());

    // 상위 14개 가져와서 finalMap에 저장
    for (int j = 0; j < 14; j++) {
      String p = map.get(keySet.get(j));
      finalMap.replace(p, finalMap.get(p) + 1);
    }

    List<String> finalList = new ArrayList<>(finalMap.keySet());
    Collections.sort(finalList);
    for(String s : finalList) {
      bw.write(s+" "+finalMap.get(s) +"\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }

}
