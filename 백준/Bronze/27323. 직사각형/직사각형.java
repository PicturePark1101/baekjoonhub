import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(n1 * n2));
        
        bw.flush();
        bw.close();
        br.close();
    }
          
}