import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    ArrayList<Integer> originList = new ArrayList<>();

    Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
    Set<Integer> set = new LinkedHashSet<>();

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      originList.add(num);
      set.add(num);
    }

    ArrayList<Integer> newList = new ArrayList<>(set);
    newList.sort(Comparator.naturalOrder());

    for (int i = 0; i < newList.size(); i++) {
      if (!linkedHashMap.containsKey(newList.get(i))) {
        linkedHashMap.put(newList.get(i), i);
      }
    }

    for (int i = 0; i < N; i++) {
      bw.write(String.valueOf(linkedHashMap.get(originList.get(i)))+" ");
    }

    bw.flush();
    bw.close();
    br.close();
  }

}
