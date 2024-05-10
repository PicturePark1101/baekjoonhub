import java.util.*;
import java.io.*;

public class Main {
   public static void mergeArrs(int[] arr1, int[] arr2) {
    StringBuilder sb = new StringBuilder();
    int size1 = arr1.length;
    int size2 = arr2.length;

    int i = 0;
    int j = 0;

    while (i < size1 && j < size2){

      if (arr1[i] < arr2[j]){ // 작은걸 놔야함
        sb.append(arr1[i++]).append(" ");
      } else {
        sb.append(arr2[j++]).append(" ");
      }

      if (i == size1) {
        while (j <size2) {
          sb.append(arr2[j++]).append(" ");
        }
      }

      if (j == size2) {
        while (i < size1) {
          sb.append(arr1[i++]).append(" ");
        }
      }

    }
    System.out.println(sb);

  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr1 = new int[N];
    int[] arr2 = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr1[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      arr2[i] = Integer.parseInt(st.nextToken());
    }

    mergeArrs(arr1, arr2);
    br.close();
  }
}
