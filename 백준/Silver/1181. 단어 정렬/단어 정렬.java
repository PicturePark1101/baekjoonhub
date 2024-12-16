import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Set<String> wordSet = new HashSet<>();
    for (int i = 0; i < N; i++) {
      wordSet.add(br.readLine());
    }

    List<String> words = new ArrayList<>(wordSet);
    words = words.stream().sorted((o1, o2) -> {
      if (o1.length() == o2.length()) {
        return o1.compareTo(o2);
      }
      return Integer.compare(o1.length(), o2.length());
    }).collect(Collectors.toList());
    printWords(words);
    br.close();
  }

  private static void printWords(List<String> words) {
    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      sb.append(word).append("\n");
    }
    System.out.println(sb);
  }
}
