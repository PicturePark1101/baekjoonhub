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
    hitEgg(0);
    System.out.println(answer);
    br.close();
  }

  private static void hitEgg(int start) {
    if (start == N) {
      answer = Math.max(checkBrokenEggs(), answer);
      return;
    }

    Egg currentEgg = eggs[start];
    for (int i = 0; i < N; i++) {
      if(i != start) {
        Egg nextEgg = eggs[i];
        if (currentEgg.durability > 0 && nextEgg.durability > 0) {
          nextEgg.durability -= currentEgg.weight;
          currentEgg.durability -= nextEgg.weight;
          hitEgg(start + 1);
          nextEgg.durability += currentEgg.weight; // 계란 복구
          currentEgg.durability += nextEgg.weight;
        } else {
          hitEgg(start + 1);
        }
      }
    }
  }

  private static int checkBrokenEggs() {
    int count = 0;
    for (Egg e : eggs) {
      if (e.durability <= 0) {
        count++;
      }
    }
    return count;
  }
}
