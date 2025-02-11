import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        
        int[] sumChar1 = new int[26];
        int[] sumChar2 = new int[26];
        
        countChars(str1, sumChar1);
        countChars(str2, sumChar2);
        
        int answer = getAnswer(sumChar1, sumChar2);
        System.out.println(answer);
        br.close();
    }
    
    private static void countChars(char[] strs, int[] countChar) {
        for (char str : strs) {
            countChar[str - 'a']++;
        }        
    }
    
    private static int getAnswer(int[] sumChar1, int[] sumChar2) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(sumChar1[i] - sumChar2[i]);
        }
        return count;
    }
}