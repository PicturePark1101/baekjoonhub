import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    Set<String> set = new HashSet<String>();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      set.add(br.readLine());
    }

    ArrayList<String> list = new ArrayList<>(set);

    list.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() == o2.length()){
          return o1.compareTo(o2); 
        }
        return Integer.compare(o1.length(), o2.length());
      }
    });

    for (String word : list) {
      bw.write(word+ "\n");
    }

    bw.flush();
    bw.close();
    br.close();

  }
}

