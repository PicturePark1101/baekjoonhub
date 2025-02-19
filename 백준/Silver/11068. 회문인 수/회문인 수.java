import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(getAnswer(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    
    private static int getAnswer(int n) {
        for (int i = 2; i <= 64; i++) {
            List<String> strs = new ArrayList<>();
            rotation(strs, n, i);
            
            if (isPalin(strs)) { 
                return 1 ;
            };
        }
        return 0;
    }
    
    private static boolean isPalin(List<String> strs) {
        for (int i = 0; i < strs.size() / 2; i++) {
            if (!strs.get(i).equals(strs.get(strs.size() - i - 1))) return false;
        }
        return true;
    }
    
    private static void rotation(List<String> strs, int n, int b) {
        if (n <= 0) {
            return;
        }
        
       strs.add(String.valueOf(n % b));
       rotation(strs, n / b, b);
    }
    
    
}