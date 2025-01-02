import java.util.*;
import java.io.*;

public class Main {
    
    static class Plan {
        private int day;
        private int pay;
        
        public Plan(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }
    }
    
    private static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Plan[] plans = new Plan[N + 1];
        int[] DP = new int[N + 2];
        
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            plans[i] = new Plan(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        makeDP(plans, DP);
        System.out.println(Arrays.stream(DP).max().getAsInt());
        br.close();
    }
    
    private static void makeDP(Plan[] plans, int[] DP) {
        for (int i = 1; i <= N; i++) {
            int afterDay = i + plans[i].day;
            
            DP[i + 1] = Math.max(DP[i + 1], DP[i]);        
            if (afterDay <= N + 1) {
                DP[afterDay] = Math.max(DP[afterDay], plans[i].pay + DP[i]);
            }
        }
    }

}