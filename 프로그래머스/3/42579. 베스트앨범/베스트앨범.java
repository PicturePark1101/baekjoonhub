import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        Map<String, Integer> genresCountMap = new HashMap<>();
        Map<String, ArrayList<Integer>> playsMap = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            genresCountMap.put(genres[i], genresCountMap.getOrDefault(genres[i], 0) + plays[i]);
            ArrayList<Integer> list = playsMap.getOrDefault(genres[i], new ArrayList<>());
            list.add(i);
            playsMap.put(genres[i], list);
        }
        
        List<String> sortedGenresCount = genresCountMap.entrySet().stream().sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
        
        List<Integer> answerList = new ArrayList<>();
        for (String key : sortedGenresCount) {
            List<Integer> sortedSongs = playsMap.get(key).stream().sorted((o1, o2) -> Integer.compare(plays[o2], plays[o1])).limit(2).collect(Collectors.toList());
            sortedSongs.forEach(it -> answerList.add(it));
        }
        
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}