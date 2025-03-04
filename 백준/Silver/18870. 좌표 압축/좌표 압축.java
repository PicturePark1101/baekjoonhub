import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] inputs = new int[N];
        
        Map<Integer, Integer> press = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            inputs[i] = n;
            set.add(n);         
        }
        
        List<Integer> list = new ArrayList<>(set);

        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < list.size(); i++) {
            press.put(list.get(i), i);
        }
        
        printAnswer(inputs, press);
      
    br.close();
  }
    
    private static void printAnswer(int[] inputs, Map<Integer, Integer> press) {
        StringBuilder sb = new StringBuilder();
        for (int n : inputs) {
            sb.append(press.get(n)).append(" ");
        }
        System.out.println(sb);        
    }

}
