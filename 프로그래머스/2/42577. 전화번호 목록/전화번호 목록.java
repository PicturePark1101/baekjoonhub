import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {        
        // 접두사? 
        Arrays.sort(phone_book);
        // contains가 해시여야함?
        
        HashSet<String> hs = new HashSet<>();
        
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])){
                return false;
            }
        }
        return true;
    }
}