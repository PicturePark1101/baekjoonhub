import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  private static int[] bucket;
  private static boolean[] visited;

  private static StringBuilder sb;
  private static int[] str;
  private static boolean findAns;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] inputStr = br.readLine().split("");

    str = new int[inputStr.length];
    bucket = new int[inputStr.length];
    visited = new boolean[51];

    for (int i = 0; i < str.length; i++) {
      str[i] =  Integer.parseInt(inputStr[i]);
    }

    sb = new StringBuilder();
    makeArr(0, 0);
    System.out.println(sb);

    br.close();
  }

  private static void makeArr(int depth, int size) {

    if (findAns) {
      return;
    }

    if (depth >= str.length) {
      // printBucket(size);
      if (isValid(bucket.clone(), size)) {
        findAns = true;
        for (int i = 0; i < size; i++) {
          sb.append(bucket[i]).append(" ");
        }
        sb.append("\n");
      }
      return;
    }

    if (depth + 1 != str.length) { // 마지막 배열이 아니라면
      int tmp = str[depth] * 10 + str[depth + 1];
      if (tmp <= 50 &&  !visited[tmp])  { // 50 이하면 탐색하러감. 아니면 안감....
        bucket[size] = str[depth] * 10 + str[depth + 1];
        visited[tmp] = true;
        makeArr(depth + 2, size + 1);
        visited[tmp] = false;

      }
    }

    int tmp2 = str[depth];
    if (tmp2 != 0 && !visited[tmp2]) {
      bucket[size] = str[depth];
      visited[tmp2] = true;
      makeArr(depth + 1, size + 1);
      visited[tmp2] = false;
    }
  }

  private static void printBucket(int size) {
    for (int i = 0; i < size; i++) {
      System.out.print(bucket[i] + " ");
    }
    System.out.println();
  }

  private static boolean isValid(int[] validBucket, int size) {
    Arrays.sort(validBucket, 0, size);
    for (int i = 1; i <= size; i++) {
      if (validBucket[i - 1] != i){ return false; };
    }
    return true;
  }
}
