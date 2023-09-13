import java.util.*;

class Solution {
    static List<String> paths = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        boolean[] isUsed = new boolean[tickets.length]; // 티켓 사용여부
        
        dfs(tickets, isUsed, "ICN", "ICN", 0);
        
        Collections.sort(paths);
        
        for (String path : paths) {
            String[] str = path.split(",");
            answer = str;
            
            break;
        }
        
        return answer;
    }
    
    public void dfs(String[][] tickets, boolean[] isUsed, String departure, String path, int depth) {
        
        if (depth == tickets.length) {
            paths.add(path);
            
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            // 티켓을 사용하지 않았고, 해당 티켓의 출발지점이 depature와 일치할 경우
            if (isUsed[i] == false && tickets[i][0].equals(departure)) {
                isUsed[i] = true;
                
                dfs(tickets, isUsed, tickets[i][1], path + "," + tickets[i][1], depth + 1);
                isUsed[i] = false;
            }
        }
    }
}
