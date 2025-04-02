import java.util.*;
import java.io.*;

public class Main {
    
    static class Guitar {
        private int line;
        private int flat;
        
        public Guitar(int line, int flat) {
            this.line = line;
            this.flat = flat;
        }
    }
    
    private static Stack<Guitar>[] playlist;

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        playlist = new Stack[N];
        
        for (int i = 0; i < N; i++) {
           playlist[i] = new Stack<>(); 
        }
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int lineNum = Integer.parseInt(st.nextToken());
            int platNum = Integer.parseInt(st.nextToken());
            
            count += playGuitar(lineNum, platNum);
        }
        
        System.out.println(count);
        br.close();
    }
    
    private static int playGuitar(int lineNum, int platNum) {        
        int count = 0;
       
        while (!playlist[lineNum].isEmpty() && playlist[lineNum].peek().flat > platNum) {                
                playlist[lineNum].pop();
                count++;
        }
        
        if (playlist[lineNum].isEmpty() || playlist[lineNum].peek().flat < platNum) {
            playlist[lineNum].push(new Guitar(lineNum, platNum));
            count++;            
        }    
        return count; 
    }
}