import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static int calcCnt(int[] arr, int n) {

    int cnt = 1;
    int pick = arr[0];
    // 1 2 4 8 9
    // 1 4 5 6 최대거리 2일 때 선택할 수 있는 집의 수
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - pick >= n) {
        pick = arr[i];
        cnt++;
      }
    }
    return cnt;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    int[] houseArr = new int[N];
    for (int i = 0 ; i < N; i++) {
      houseArr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(houseArr);

    int l = 1, r = houseArr[N - 1] - houseArr[0];
    int ans = 0;
    // 두 공유기 사이의 최대 거리 출력하기

    while(l <= r) {
      int m = (l + r) / 2;
      if (calcCnt(houseArr, m) >= C) { // 설치할 수 있는 공유기의 더 많다. -> 거리 늘려도 됨
        l = m + 1;
        ans = m;
      } else { // 설치할 수 있는 공유기의 수가 적다. -> 그럼 거리 좁혀야됨?
        r = m - 1;
      }

    }

    bw.write(String.valueOf(ans));

    bw.flush();
    bw.close();
    br.close();
  }

}
