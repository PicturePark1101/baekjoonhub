import java.io.*;
import java.util.*;

public class Main {

    static class Meeting {
        private int start;
        private int end;
        
        public Meeting (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;


      int N = Integer.parseInt(br.readLine());
      Meeting[] meetings = new Meeting[N];
      
      for (int i = 0; i < N; i++) {
          st = new StringTokenizer(br.readLine());
          meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      }
      
      Arrays.sort(meetings, (o1, o2) -> {
          if (o1.end == o2.end){
              return o1.start - o2.start;
          }
          return o1.end - o2.end;
      });
      
      int count = 0;
      int startTime = 0;
      
      for (Meeting m : meetings) {
          if (m.start >= startTime){ // startTime보다 이르면 안됨. 
              startTime = m.end;
              count++;
          }
      }
      
      System.out.println(count);
      br.close();
  }

}