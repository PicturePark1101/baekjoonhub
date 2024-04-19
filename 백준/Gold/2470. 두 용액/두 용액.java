import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int MIN = Integer.MAX_VALUE;

  private static int findMinSum(ArrayList<Integer> arr, int s, int e, int n) {
    int value = arr.get(s);
    int minAbsSum = Math.abs(value + n);
    while(s <= e) {
      int m = (s + e) / 2;
      int sum = arr.get(m) + n;
      int absSum = Math.abs(sum);
      if (absSum < minAbsSum) {
        minAbsSum = absSum;
        value = arr.get(m);
      }

      if (sum < 0) { // 오른쪽 이동
        s = m + 1;
      } else if (sum > 0) { // 양수인 경우. 왼쪽으로 이동해야..?
        e = m - 1;
      } else { // 합의 부호가 바뀌는 시점인지
        return arr.get(m);
      }
    }

    return value;
  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    ArrayList<Integer> nums = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      nums.add(Integer.parseInt(st.nextToken()));
    }

    // 정렬하고 이분탐색
    // 자기자신과 다른 애들의 합을 구한다.
    // 그 중 절댓값이 가장 작은 것을 찾는다.ㅜㅜ

    nums.sort(Comparator.naturalOrder());

    int n1 = 0, n2 = 0;
    int minSum = Integer.MAX_VALUE;
    for (int i = 0; i < N - 1; i++) {
      int pair = findMinSum(nums, i + 1, N - 1, nums.get(i));
      int abs = Math.abs(pair + nums.get(i));

      if (minSum > abs) {
        minSum = abs;
        n1 = nums.get(i);
        n2 = pair;
      }

    }

    System.out.println(n1+" "+n2);
  }

}
