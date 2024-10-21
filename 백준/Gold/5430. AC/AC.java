import java.util.*;
import java.io.*;

public class Main {
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String p = br.readLine();
      int n = Integer.parseInt(br.readLine());
      executeCommand(p, makeNumsArr(br.readLine(), n));
    }
    System.out.println(sb);
    br.close();
  }

  private static void executeCommand(String p, Deque<Integer> arr) {
    boolean isFirstPointer = true;

    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == 'R') { // 순서 뒤집기
        isFirstPointer = !isFirstPointer;
      } else{
        if (arr.isEmpty()) {
          sb.append("error\n");
          return;
        } else {
          if (isFirstPointer) {
            arr.pollFirst();
          } else {
            arr.pollLast();
          }
        }
      }
    }

    printArr(arr, isFirstPointer);
  }

  private static void printArr(Deque<Integer> arr, boolean isFirstPointer) {
    sb.append("[");

    while (!arr.isEmpty()) {
      if (isFirstPointer) {
        sb.append(arr.pollFirst());
      } else {
        sb.append(arr.pollLast());
      }
      if (!arr.isEmpty()) {
        sb.append(",");
      }
    }

    sb.append("]\n");
  }

  private static Deque<Integer> makeNumsArr(String s, int n) {
    s = s.substring(1, s.length() - 1);
    if (s.isEmpty()) {
      return new LinkedList<>();
    }
    String[] tempS = s.split(",");

    Deque<Integer> arr = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      arr.add(Integer.parseInt(tempS[i]));
    }
    return arr;
  }
}