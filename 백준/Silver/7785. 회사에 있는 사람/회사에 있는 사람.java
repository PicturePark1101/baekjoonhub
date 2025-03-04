import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        Set<String> employees = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();
            if (command.equals("enter")) {
                employees.add(name);
            } else {
                employees.remove(name);
            }
            
        }
        
        List<String> remainEmp = new ArrayList<>(employees);
        remainEmp.sort((o1, o2) -> {
            return o2.compareTo(o1);
        });
        
        printEmp(remainEmp);
        br.close();
    }
    
    private static void printEmp(List<String> employees) {
        StringBuilder sb = new StringBuilder();
        for (String emp : employees) {
            sb.append(emp).append("\n");
        }
        System.out.println(sb);
    }
} 