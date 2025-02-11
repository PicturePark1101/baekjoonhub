import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        
        for (char ch : str) {
            if (ch >= 'A' && ch <= 'Z') {
               System.out.print(Character.toLowerCase(ch)); 
            } else {
                System.out.print(Character.toUpperCase(ch)); 
            }
        }
        br.close();
    }    
} 