import java.util.*;

class Solution {
    
    static class Employees {
        private String name;
        private Employees recommand;
        public Employees(String name) {
            this.name = name;
        }
    }
    
    private Map<String, Integer> income = new HashMap<>();
    private int N;
    private Map<String, String> employee = new HashMap<>();
    private int M;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        N = enroll.length;
        M = seller.length;
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            employee.put(enroll[i], referral[i]);
            income.put(enroll[i], 0);
        }

        double b = 12 * 0.1;
        System.out.println((int) b);
        
        for (int i = 0; i < M; i++) { 
            calc(seller[i], amount[i] * 100);
        }
        
        for (int i = 0; i < N; i++) {
            answer[i] = income.get(enroll[i]);
        }
        
        return answer;
    }
    
    private void calc(String emp, int money) {
        if (emp.equals("-")) return;
        
        double remain = money * 0.1;
        
        if ((int) remain < 1) {
            income.put(emp, income.get(emp) + money);
            return;
        }
        
        int newM = money - (int) remain;
        
        income.put(emp, income.get(emp) + (int)newM);
        // System.out.println(emp+" "+income.get(emp) +" "+(int)remain);
        calc(employee.get(emp), (int)remain);
    }
}