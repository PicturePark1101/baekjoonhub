import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        // 일단 id - 닉네임 map 만들고
        HashMap<String, String> userMap = new HashMap<>();
        List<String> chatState = new ArrayList<>();
        
        for(String r : record) {
            String[] cmd = r.split(" ");
            if (cmd[0].equals("Enter") || cmd[0].equals("Change")) {
                userMap.put(cmd[1], cmd[2]);
            }
            if (cmd[0].equals("Enter") || cmd[0].equals("Leave")) {
                chatState.add(cmd[0]+" " +cmd[1]);
            }
        }
        
        return makeResult(userMap, chatState);
        // record에서 Enter, Change 명령어의 경우 map에 닉네임 새로 저장해줌
        // 채팅은 list에 담는다 "Enter uid1234" 형태로 change는 담지 않음
        // 마지막에 map의 닉네임으로 result 만들어주기
    }
    
    private String[] makeResult(HashMap<String, String> userMap, List<String> chatState) {
        String enterStr = "님이 들어왔습니다.";
        String leaveStr = "님이 나갔습니다.";
        String[] result = new String[chatState.size()];
        for (int i = 0; i < chatState.size(); i++) {
            String[] chat = chatState.get(i).split(" ");
            if (chat[0].equals("Enter")) {
                result[i] = userMap.get(chat[1]) + enterStr;
            } else {
                result[i] = userMap.get(chat[1]) + leaveStr;
            }
        }
        return result;
    }
}