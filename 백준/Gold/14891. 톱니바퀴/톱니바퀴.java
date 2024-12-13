import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

  private static List<Integer>[] saws = new List[5];
  private static Map<Integer, Integer> scoreMap = new HashMap<>();
  private static final int sawSize = 8;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    initScoreMap();
    for (int i = 1; i <= 4; i++) {
      saws[i] = new ArrayList<>();
      saws[i].addAll(Arrays.stream(br.readLine().split("")).map(Integer::parseInt).collect(Collectors.toList()));
    }

    int K = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int sawN = Integer.parseInt(st.nextToken());
      int direction = Integer.parseInt(st.nextToken());
      execute(sawN, direction);
    }

    System.out.println(calcScore());
    br.close();
  }

  private static void initScoreMap() {
    scoreMap.put(1, 1);
    scoreMap.put(2, 2);
    scoreMap.put(3, 4);
    scoreMap.put(4, 8);
  }

  private static int calcScore() {
    int score = 0;
    for (int i = 1; i <= 4; i++) {
      if (saws[i].get(0) != 0) {
        score += scoreMap.get(i);
      }
    }
    return score;
  }

  private static void execute(int sawN, int direction) {
    Map<Integer, Integer> rotationTarget = new HashMap<>();
    rotationTarget.put(sawN, direction);

    checkNearBySaws(sawN, rotationTarget);
    // print(rotationTarget);
    rotateSaws(rotationTarget);
  }

  private static void print(Map<Integer, Integer> rotationTarget) {
    for(Entry<Integer, Integer> map : rotationTarget.entrySet()) {
      System.out.println(map.getKey()+" "+map.getValue());
    }
    System.out.println();
  }

  private static void rotateSaws(Map<Integer, Integer> rotationTarget) {
    for(Entry<Integer, Integer> map : rotationTarget.entrySet()) {
      int index = map.getKey();
      if (map.getValue() == 1) { // 시계방향
        saws[index].add(0, saws[index].remove(sawSize - 1));
      } else { // 반시계
        saws[index].add(saws[index].remove(0));
      }
    }
  }

  private static void checkNearBySaws(int startT, Map<Integer, Integer> rotationTarget) {

    int leftDirc = rotationTarget.get(startT);
    for (int i = startT; i >= 2; i--) {
      int left = saws[i - 1].get(2);
      int right = saws[i].get(6);
      if (left != right) {
        rotationTarget.put(i - 1, leftDirc * -1);
        leftDirc *= -1;
      } else {
        break;
      }
    }

    // 오른쪽
    int rigthDirc = rotationTarget.get(startT);
    for (int i = startT; i < 4; i++) {
      int left = saws[i].get(2);
      int right = saws[i + 1].get(6);
      if (left != right) {
        rotationTarget.put(i + 1, rigthDirc * -1);
        rigthDirc *= -1;
      } else {
        break;
      }
    }
  }

}
