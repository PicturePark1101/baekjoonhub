import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      int cnt = linkedHashMap.getOrDefault(num, 0) + 1;
      linkedHashMap.put(num, cnt);
    }

    ArrayList<Map.Entry<Integer, Integer>> newList = new ArrayList<>(linkedHashMap.entrySet());

    newList.sort(new Comparator<Entry<Integer, Integer>>() {
      @Override
      public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
        return Integer.compare(o2.getValue(), o1.getValue());
      }
    });

    for (Map.Entry<Integer, Integer> i : newList){
      for (int j = 0; j < i.getValue(); j++) {
        bw.write(String.valueOf(i.getKey())+" ");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
