import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static class Egg {
    private int durability;
    private int weight;

    public Egg(int durability, int weight) {
      this.durability = durability;
      this.weight = weight;
    }
  }

  private static int N;
  private static Egg[] eggs;
  private static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    eggs = new Egg[N];
    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      eggs[i] = new Egg(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
    }
    hitEgg(0, 0);
    System.out.println(answer);
    br.close();
  }

  private static void hitEgg(int start, int brokenCount) {
    if (start == N || brokenCount == N - 1) {
      answer = Math.max(brokenCount, answer);
      return;
    }

    Egg currentEgg = eggs[start];

    if (currentEgg.durability <= 0) {
      hitEgg(start + 1, brokenCount);
      return;
    }

    for (int i = 0; i < N; i++) {
      Egg nextEgg = eggs[i];
      if(i != start && nextEgg.durability > 0) {
        nextEgg.durability -= currentEgg.weight;
        currentEgg.durability -= nextEgg.weight;
        int nextCount = brokenCount;
        if (nextEgg.durability <= 0) nextCount++;
        if (currentEgg.durability <= 0) nextCount++;
        hitEgg(start + 1, nextCount);
        nextEgg.durability += currentEgg.weight;
        currentEgg.durability += nextEgg.weight;
      }
    }
  }
}
