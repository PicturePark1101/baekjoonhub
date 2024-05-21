import java.util.*;
import java.io.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(br.readLine().split("")));

    int N = Integer.parseInt(br.readLine());

    ListIterator<String> iter = linkedList.listIterator();
    //커서 초기화 : 맨 뒤
    while(iter.hasNext()) {
      iter.next();
    }

    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "B" :
          if (iter.hasPrevious()) {
            iter.previous();
            iter.remove();
          }
          break;
        case "D" :
          if(iter.hasNext()) {
            iter.next();
          }
          break;
        case "L" :
          if(iter.hasPrevious()) {
            iter.previous();
          }
          break;
        case "P" :
          iter.add(st.nextToken());
          break;
      }
    }

    System.out.println(String.join("", linkedList));
    br.close();
  }
}
