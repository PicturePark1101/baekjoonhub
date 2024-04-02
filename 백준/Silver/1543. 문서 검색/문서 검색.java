import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    String search = br.readLine();

    int i = 0;
    int idx = input.indexOf(search);
    int cnt = 0;
    // System.out.println("idx: "+ idx);

    while (idx < input.length() && idx != -1) {
      idx = input.indexOf(search, idx + search.length());
      // System.out.println("idx: "+ idx);
      cnt++;
    }

    bw.write(Integer.toString(cnt));

    br.close();
    bw.close();
  }
}