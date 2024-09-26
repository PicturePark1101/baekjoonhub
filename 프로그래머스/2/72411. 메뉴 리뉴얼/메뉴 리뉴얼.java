import java.util.*;

class Solution {
    private HashMap<String, Integer>[] menuCom;
    private int[] maxOrder;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        menuCom = new HashMap[course.length];
        maxOrder = new int[course.length];
        for (int i = 0; i < course.length; i++) { 
            menuCom[i] = new HashMap<>();
        }
        
        for (int i = 0; i < course.length; i++) {
            maxOrder[i] = Integer.MIN_VALUE;

            for (int j = 0; j < orders.length; j++) {
                char[] ch = orders[j].toCharArray();
                Arrays.sort(ch);
                combination(new String(ch), 0, course[i], "", i);                
            }
            System.out.println(maxOrder[i]);
        }
        
        for (int i = 0; i < course.length; i++) {
            for (Map.Entry<String, Integer> em : menuCom[i].entrySet()) {
                if (maxOrder[i] >= 2 && em.getValue() == maxOrder[i]) {
                    answer.add(em.getKey());
                }
            }
        }
        
       Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    private void combination(String order, int start, int k, String result, int index) {
        if (result.length() == k) {
            menuCom[index].put(result, menuCom[index].getOrDefault(result, 0) + 1);
            maxOrder[index] = Math.max(maxOrder[index], menuCom[index].get(result));
            return;
        }
        
        
        for (int i = start; i < order.length(); i++) {
            combination(order, i + 1, k, result + order.charAt(i), index);
        }
    }
}