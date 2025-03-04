import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Map<String, Integer> sell = new HashMap<>();
            
        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            
            sell.put(title, sell.getOrDefault(title, 0) + 1);
        }
        List<String> books = new ArrayList<>(sell.keySet());
        
        books.sort((o1, o2) -> {
            if (sell.get(o1) == sell.get(o2)) {
                return o1.compareTo(o2);
            }
           return sell.get(o2) - sell.get(o1);
        });
        
        System.out.println(books.get(0));
        br.close();
    }
}