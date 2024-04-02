import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;


    int n = Integer.parseInt(br.readLine());

    int[] list = new int[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    int x = Integer.parseInt(br.readLine());

    Arrays.sort(list);

    int start = 0;
    int end = n - 1;
    int cnt = 0;
    while (start < end){
      if (list[start] + list[end] == x) cnt++;
      if (list[start] + list[end] <= x) start++;
      else end--;
    }

    bw.write(String.valueOf(cnt));
    bw.close();
    br.close();

  }

}
