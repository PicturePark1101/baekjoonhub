import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    Queue<Integer> qu = new LinkedList<>();

    int N = Integer.parseInt(br.readLine());

    int input = Integer.parseInt(br.readLine());

    while (input != -1) {

      if (input == 0) {
        qu.remove();
      } else if (N > qu.size()){
        qu.offer(input);
      }
      input = Integer.parseInt(br.readLine());
    }

    if (qu.isEmpty()) {
      bw.write("empty");
    } else {
      for (Integer i : qu) {
        bw.write(i+" ");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}