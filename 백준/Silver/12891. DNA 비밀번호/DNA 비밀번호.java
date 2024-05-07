import java.util.*;
import java.io.*;

public class Main {
    
    public static int indexArr(char ch) {
            switch (ch) {
                case 'A' : 
                    return 0;
                case 'C' : 
                    return 1;
                case 'G' : 
                    return 2;
                case 'T' : 
                    return 3;
            }
        return -1;
    }
    
    public static boolean isValid(int[] alphabet, int[] cnt) {
      
        for (int i = 0 ; i < 4; i++) {
            if (cnt[i] < alphabet[i]){
                return false;
            }
        }
        
        return true;
        
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        
        int[] alphabet = new int[4];
        st = new StringTokenizer(br.readLine());
        
        alphabet[0] = Integer.parseInt(st.nextToken());
        alphabet[1] = Integer.parseInt(st.nextToken());
        alphabet[2] = Integer.parseInt(st.nextToken());
        alphabet[3] = Integer.parseInt(st.nextToken());
        
        int[] currentCnt = new int[4];
        for (int i = 0; i < P - 1; i++) {
            currentCnt[indexArr(str.charAt(i))]++;
        }
        
        int ans = 0;
        for (int i = P - 1 ; i < N; i++){
            currentCnt[indexArr(str.charAt(i))]++;
            if (isValid(alphabet, currentCnt)){
                ans++;
            }
            currentCnt[indexArr(str.charAt(i - P + 1))]--;
        }
        bw. write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
        
    }
    
}