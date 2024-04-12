import java.io.*;
import java.util.*;

public class Main {
    
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    Map<String, Integer> map = new HashMap<>();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {

      String name = br.readLine();
      int cnt = map.getOrDefault(name, 0) + 1;
      map.put(name, cnt);
    }

    List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
    entries.sort(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

        if (o1.getValue() == o2.getValue()) {
            return o1.getKey().compareTo(o2.getKey());
        }

        return o2.getValue().compareTo(o1.getValue());
      }
    });

    bw.write(entries.get(0).getKey()+ "\n");

    bw.flush();
    bw.close();
    br.close();

  }
}
