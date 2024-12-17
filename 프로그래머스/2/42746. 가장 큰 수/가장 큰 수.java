import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] numbersToString = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(numbersToString, (o1, o2) -> {
            int n1 = Integer.parseInt(o1 + o2);
            int n2 = Integer.parseInt(o2 + o1);
            return Integer.compare(n2, n1);
        });
        
        String answerStr = String.join("", numbersToString);
        if (answerStr.charAt(0) == '0') return "0";
        return answerStr;
    }
}