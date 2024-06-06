import java.util.*;
import java.io.*;

public class Main {
            
    public static ArrayList<Integer> makeBaseArr(int num, int B) {
        ArrayList<Integer> baseList = new ArrayList<>();
        
        while (num > 0) {
            baseList.add(num % B);
            num /= B;
        }
       return baseList;
    }
    
    public static boolean isPalin(ArrayList<Integer> baseList) {
        for (int i = 0; i < baseList.size() / 2; i++) {
            if (baseList.get(i) != baseList.get(baseList.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            int input = Integer.parseInt(br.readLine());
            for (int j = 2; j <= 64; j++) {
                if (isPalin(makeBaseArr(input, j))) {
                    flag = true;
                    break;    
                }
            }
            if (flag) {
               sb.append("1");
            } else {
                sb.append("0");
            }              
            sb.append("\n");
        }
        System.out.println(sb);      
    }
}