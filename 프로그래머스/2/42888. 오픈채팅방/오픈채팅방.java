import java.util.*;

class Solution {
    HashMap<String, String> msg = new HashMap<>();

    private void makeMsg() {
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");
    }
    public String[] solution(String[] record) {
        makeMsg();   
        HashMap<String, String> userMap = new HashMap<>();

        for(String r : record) {
            String[] cmd = r.split(" ");
            if (cmd[0].equals("Enter") || cmd[0].equals("Change")) {
                userMap.put(cmd[1], cmd[2]);
            }
        }
        
        return makeResult(userMap, record);
    }
    
    private String[] makeResult(HashMap<String, String> userMap, String[] record) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] chat = record[i].split(" ");
            if (msg.containsKey(chat[0])) {
                result.add(userMap.get(chat[1]) + msg.get(chat[0]));
            }
        }
        
        return result.toArray(new String[0]);
    }
}