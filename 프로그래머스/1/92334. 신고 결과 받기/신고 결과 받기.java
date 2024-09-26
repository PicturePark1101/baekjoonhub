import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportTable = new HashMap<>();
        HashMap<String, Integer> reportedCount = new HashMap<>();
        ArrayList<String> stoppedUser = new ArrayList<>();
        
        for (String id : id_list) {
            reportTable.put(id, new HashSet<>());
            reportedCount.put(id, 0);
        }
        
        for (String info : report) { 
            String[] cmd = info.split(" ");
            
            HashSet<String> reportUsers = reportTable.get(cmd[0]);
            reportUsers.add(cmd[1]);
            reportTable.put(cmd[0], reportUsers);
            
        }
        
        for (Map.Entry<String, HashSet<String>> em : reportTable.entrySet()) {
            for (String name : em.getValue()) {
                reportedCount.put(name, reportedCount.get(name) + 1);       
            }            
        }        
        
        for (Map.Entry<String, Integer> em : reportedCount.entrySet()) {
            System.out.println(em.getValue()+" "+em.getKey());
            if (em.getValue() >= k) {
                stoppedUser.add(em.getKey());
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            for (String r : reportTable.get(id_list[i])) {
                if (stoppedUser.contains(r)) {
                    answer[i] ++;
                }  
            }              
        }   
            
        return answer;
    }
}