import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStreamWriter;

public class Main {


  public static boolean checkRC(int r, int c, int N){
    if (r >=0 && r < N && c >= 0 && c < N){
      return true;
    }
    return false;
  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    char[][] arr = new char[N][N];

    String command = br.readLine();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        arr[i][j] = '.';
      }
    }

    int r = 0;
    int c = 0;
    for (int i = 0; i < command.length(); i++) {
      int addR = 0;
      int addC = 0;

      switch (command.charAt(i)) {
        case 'U':
          addR = -1;
          break;
        case 'D':
          addR = 1;
          break;
        case 'L':
          addC = -1;
          break;
        case 'R':
          addC = 1;
          break;
      }

      if (checkRC(r + addR, c + addC, N)) {

        // 자기꺼 검사
        if (addR != 0) { // 수직 방향으로 움직임
          if (arr[r][c] == '-') {
            arr[r][c] = '+';
          } else if (arr[r][c] == '.') {
            arr[r][c] = '|';
          }

          if (arr[r + addR][c] == '-') {
            arr[r + addR][c] = '+';
          } else if (arr[r + addR][c] == '.'){
            arr[r + addR][c] = '|';
          }

        } else if (addC != 0) { // 수평방향으로 움직임
          if (arr[r][c] == '|') {
            arr[r][c] = '+';
          } else if (arr[r][c] == '.') { 
            arr[r][c] = '-';
          }

          if (arr[r][c + addC] == '|') {
            arr[r][c + addC] = '+';
          } else if (arr[r][c + addC] == '.') {
            arr[r][c + addC] = '-';
          }
        }
        r += addR;
        c += addC;

      }




    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        bw.write(String.valueOf(arr[i][j]));
      }
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();

  }

}
