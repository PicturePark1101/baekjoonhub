import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static int[] arr = new int[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    makeArr();
    System.out.println(arr[N]);
  }

  private static void makeArr() {
    for (int i = 1; i < arr.length; i++) {
      arr[i] = i;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j * j <= i; j++) {
        arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
      }
    }
  }
}
