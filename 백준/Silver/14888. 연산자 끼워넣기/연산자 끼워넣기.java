import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int MAX = Integer.MIN_VALUE;
  static int MIN = Integer.MAX_VALUE;
  static int[] opNums = new int[4];
  static int[] nums;
  static int n;

  public static void dfs(int num, int idx){
    if (n == idx){
      MAX = Math.max(MAX, num);
      MIN = Math.min(MIN, num);
      return;
    }


    for (int i = 0; i < 4; i++) {
      if (opNums[i] > 0){
        opNums[i]--;
        switch (i){
          case 0 :
            dfs(num + nums[idx], idx + 1);
            break;
          case 1 :
            dfs(num - nums[idx], idx + 1);
            break;
          case 2 :
            dfs(num * nums[idx], idx + 1);
            break;
          case 3 :
            dfs(num / nums[idx], idx + 1);
            break;
        }
        opNums[i]++;
      }

    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 숫자 갯수 입력을 받는다
    n = Integer.parseInt(br.readLine());
    nums = new int[n];
    st = new StringTokenizer(br.readLine());

    // 숫자 입력받기
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    // 부호 개수 입력받기
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      opNums[i] = Integer.parseInt(st.nextToken());
    }

    dfs(nums[0], 1);

    System.out.println(MAX);
    System.out.println(MIN);

    br.close();
  }
}
