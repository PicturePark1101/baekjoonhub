import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    Set<String> set = new HashSet<>();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());

      String name = st.nextToken();
      String status = st.nextToken();
      if (status.equals("enter")) {
        set.add(name);
      } else {
        set.remove(name);
      }
    }

    ArrayList<String> list = new ArrayList<>(set);
    list.sort(Comparator.reverseOrder());

    for (String name : list) {
      bw.write(name+"\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }

}
