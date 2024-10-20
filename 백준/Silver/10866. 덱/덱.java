import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      executeCommand(deque, sb, br.readLine());
    }

    System.out.print(sb);
    br.close();
  }

  private static void executeCommand(Deque<Integer> deque, StringBuilder sb, String command) {
    StringTokenizer st = new StringTokenizer(command);

     switch (st.nextToken()) {
        case "push_front" :
          deque.addFirst(Integer.parseInt(st.nextToken()));
          break;
        case "push_back" :
          deque.addLast(Integer.parseInt(st.nextToken()));
          break;
        case "pop_front" :
          if (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
          } else {
            sb.append("-1");
          }
          sb.append("\n");
          break;
        case "pop_back" :
          if (!deque.isEmpty() ) {
            sb.append(deque.pollLast());
          } else {
            sb.append("-1");
          }
          sb.append("\n");;
          break;
        case "size" :
          sb.append(deque.size()).append("\n");;
          break;
        case "empty" :
          if (deque.isEmpty()) {
            sb.append("1");
          } else {
            sb.append("0");
          }
          sb.append("\n");;
            break;
        case "front" :
          if (!deque.isEmpty()) {
            sb.append(deque.peekFirst());
          } else {
              sb.append("-1");
          }
          sb.append("\n");
          break;
        case "back" :
          if (!deque.isEmpty() ) {
            sb.append(deque.peekLast());
          } else {
            sb.append("-1");
          }
          sb.append("\n");;
          break;
      }
  }
}