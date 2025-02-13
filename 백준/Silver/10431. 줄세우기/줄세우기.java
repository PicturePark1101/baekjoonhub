import java.util.*;
import java.io.*;


public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int P = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= P; i++) {
      st = new StringTokenizer(br.readLine());

      List<Integer> students = new ArrayList<>();
      sb.append(st.nextToken()).append(" ");

      int count = 0;

      for (int j = 0; j < 20; j++) {
        count += getLineStep(students, Integer.parseInt(st.nextToken()));
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
    br.close();
  }

  private static int getLineStep(List<Integer> students, int newStudent) {
    int step = 0;
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i) > newStudent) {
        step = students.size() - i;
        students.add(i, newStudent);
        return step;
      }
    }
    students.add(newStudent);
    return step;
  }
    
}