import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {        
        List<String> arr = Arrays.stream(numbers)
                        .boxed()
                        .map(it -> String.valueOf(it))
                        .collect(Collectors.toList());  
        
        arr.sort((o1, o2) -> Integer.compare(Integer.parseInt(o2 + o1), Integer.parseInt(o1 + o2)));
        
        String str = String.join("", arr);
        if (str.replaceAll("0", "").isEmpty()) return "0";
        return str;
    }
}