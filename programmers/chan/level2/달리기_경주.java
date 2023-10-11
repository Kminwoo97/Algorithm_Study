import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> rankMap = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i + 1);
            rankMap.put(i + 1, players[i]);
        }
        
        for (int i = 0; i < callings.length; i++) {
            int rank = map.get(callings[i]);            
            String player = rankMap.get(rank - 1);
            
            map.put(player, rank);
            rankMap.put(rank, player);
            map.put(callings[i], rank - 1);
            rankMap.put(rank - 1, callings[i]);
        }
        
        List<Integer> keys = new ArrayList<>(rankMap.keySet());
        
        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            
            answer[i] = rankMap.get(key);
        }
        
        return answer;
    }
}
