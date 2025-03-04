import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> countNums = new LinkedHashMap<>();
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> mapToList = new ArrayList<>(countNums.entrySet());
        Collections.sort(mapToList, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        for (Map.Entry<Integer, Integer> map : mapToList) {
            for (int i = 0; i < map.getValue(); i++) {
                sb.append(map.getKey()).append(" ");
            }
        }
        System.out.println(sb);
        br.close();     
    }
}
