import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        
        Set<String> strsSet = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            strsSet.add(br.readLine());
        }
        
        List<String> strs = new ArrayList<>(strsSet);
        
        
        strs.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } 
            return o1.length() - o2.length();
        });
        
        printStrs(strs);
        br.close();
    }
    
    private static void printStrs(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str).append("\n");
        }     
        System.out.println(sb);
    }
}