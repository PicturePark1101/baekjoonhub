import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  private static int X;
  private static int N;
  private static Map<String, Integer> staff = new HashMap<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    X = Integer.parseInt(br.readLine());
    N = Integer.parseInt(br.readLine());
    Map<Double, String> scoreMap = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String people = st.nextToken();
      double score = Integer.parseInt(st.nextToken());

      if (score >= X * 0.05) {
        staff.put(people, 0);
        for (int j = 1; j <= 14; j++) {
          scoreMap.put(score / j, people);
        }
      }
    }

    List<Double> scores = new ArrayList<>(scoreMap.keySet());
    scores.sort(Comparator.reverseOrder());

    for (int i = 0; i < 14; i++) {
      String people = scoreMap.get(scores.get(i));
      staff.put(people, staff.getOrDefault(people, 0) + 1);
    }
    print();
    br.close();
  }

  private static void print() {
    List<String> names = new ArrayList<>(staff.keySet());
    names.sort(null);
    for (String name : names) {
      System.out.println(name+" "+staff.get(name));
    }
  }
}
