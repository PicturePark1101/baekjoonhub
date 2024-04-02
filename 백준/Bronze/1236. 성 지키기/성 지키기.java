import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());


    List<String>[] castle = new ArrayList[r];

    for(int i = 0; i < r; i++) {
      castle[i] = new ArrayList<String>();
    }

    for (int i = 0; i < r; i++) {
      String input = br.readLine();
      for (char ch : input.toCharArray()) {
        castle[i].add(String.valueOf(ch));
      }
    }

    // 행 확인
    int cntR = 0;
    for (int i = 0; i < r; i++) {
      if (!castle[i].contains("X")){
        cntR++;
      }
    }

    // 열 확인
    int cntC = 0;
    for (int j = 0; j < c; j++) {
      int flag = 1;
      for (int i = 0; i < r; i++) {
        if (castle[i].get(j).equals("X")) {
          flag = 0;
          break;
        }
      }
      if (flag == 1) {
        cntC++;
      }
    }

    bw.write(String.valueOf(Math.max(cntC, cntR)));

    bw.close();
    br.close();
  }

}