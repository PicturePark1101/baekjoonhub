import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        String N = br.readLine();
       
        int[] countSet = new int[9]; // 0 ~ 8
        for (int i = 0; i < N.length(); i++) {
            char num = N.charAt(i);
            if (num == '9') {
                countSet[6]++;
            }
            else {
                countSet[num - '0']++;
            }
        }
        if (countSet[6] % 2 == 0) {
          countSet[6] = countSet[6] / 2;
        }
        else {
          countSet[6] = countSet[6] / 2 + 1;
        }
        
        System.out.println(Arrays.stream(countSet).max().getAsInt());
        br.close();
    }
}
