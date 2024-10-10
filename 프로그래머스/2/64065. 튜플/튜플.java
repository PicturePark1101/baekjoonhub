import java.util.*;

class Solution {
    public int[] solution(String s) {        
        s = s.replace("{", "");
        s = s.replace("}}", "");
        String[] arr = s.split("},");
        
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        HashSet<String> hs = new HashSet<>();
        int[] answer = new int[arr.length];
        int index = 0;
        
        for (String str : arr) {
            String[] elements = str.split(",");
            for (String e : elements) {
                if (!hs.contains(e)) {
                    answer[index++] = Integer.parseInt(e);
                    hs.add(e);
                    break;
                }
            }
        }
                          
        System.out.println(arr.length);
        return answer;
    }
}