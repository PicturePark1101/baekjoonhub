import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String output = "";

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        output += Character.toString(ch - 32);
      }else {
        output += Character.toString(ch + 32);
      }
    }
    System.out.println(output);

  }

}
