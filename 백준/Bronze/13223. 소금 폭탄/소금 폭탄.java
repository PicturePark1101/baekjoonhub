import java.io.*;

public class Main {

  private static String calcdiif(String t1, String t2) {
    long diff = parseTime(t2) - parseTime(t1);

    if (diff < 0) {
      diff += 24 * 60 * 60 * 1000;
    }

    int hours = (int) (diff / (1000 * 60 * 60));
    int minutes = (int) ((diff / (1000 * 60)) % 60);
    int seconds = (int) (diff / 1000) % 60;

    return String.format("%02d:%02d:%02d", hours, minutes, seconds);

  }

  private static long parseTime(String time) {
    String[] parts = time.split(":");

    int hours = Integer.parseInt(parts[0]);
    int minutes = Integer.parseInt(parts[1]);
    int seconds = Integer.parseInt(parts[2]);

    return hours * 3600000L + minutes * 60000L + seconds * 1000L;
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String t1 = br.readLine();
    String t2 = br.readLine();

    if (t1.equals(t2)) {
      bw.write("24:00:00");
    } else {
      String result = calcdiif(t1, t2);
      bw.write(result);
    }

    br.close();
    bw.close();
  }

}