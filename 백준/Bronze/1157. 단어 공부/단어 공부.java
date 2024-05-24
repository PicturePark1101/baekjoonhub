import java.util.*;
import java.io.*;

public class Main {
    
    public static int[] cntArr(String arr) {
        int[] cntAlpha = new int[26];
        
        for (int i = 0; i < arr.length(); i++) {
            char ch = arr.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                cntAlpha[ch - 'a']++;
            } else {
                cntAlpha[ch - 'A']++;  
            }
        }
        return cntAlpha;
    }
    
    public static char maxAlpha(int[] cntAlpha) {
        
        int max = Integer.MIN_VALUE;
        int idx = 0;
        
        for (int i = 0; i < 26; i++) {
            if (max < cntAlpha[i]) {
                max = cntAlpha[i];
                idx = i;
            }
        }
        
        char ans = (char)(idx + 'A');
        for (int i = 0; i < 26; i++) {
            if (max == cntAlpha[i] && idx != i) {
                ans = '?';
                break;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphaCnt = cntArr(br.readLine());
        
        System.out.println(maxAlpha(alphaCnt));
        br.close();
    }
    
}