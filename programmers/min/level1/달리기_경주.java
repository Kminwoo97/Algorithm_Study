import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        String[] answer = new String[n];
        
        HashMap<String, Integer> name_rank = new HashMap<>();
        HashMap<Integer, String> rank_name = new HashMap<>();
        
        for(int i=0; i<n; i++){
            name_rank.put(players[i], i);
            rank_name.put(i, players[i]);
        }
        
        for(String player1 : callings){
            
            
            //1단계 - 추월한 player1의 랭킹 상승
            name_rank.put(player1, name_rank.get(player1) - 1);
            
            //2단계 - 랭킹:선수 갱신
            String player2= rank_name.get(name_rank.get(player1));
            rank_name.put(name_rank.get(player1), player1);
            rank_name.put(name_rank.get(player1)+1, player2);
            
            //3단계 - 추월당한 player2 랭킹 하강
            name_rank.put(player2, name_rank.get(player1)+1);
        }
        
        for(int i=0; i<n; i++){
            answer[i] = rank_name.get(i);
        }
        
        return answer;
    }
}
