import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < info.length; i++) {
            String[] infos = info[i].split(" ");
            
            String[] language = {infos[0], "-"};
            String[] position = {infos[1], "-"};
            String[] role = {infos[2], "-"};
            String[] food = {infos[3], "-"};
            boolean[][] isVisited = new boolean[4][2];
            
            // 2차원배열로 만들고 하기
            
            int score = Integer.parseInt(infos[4]);
            String str = "";
            
            dfs(map, isVisited, language, position, role, food, score, str);
        }
        
        return answer;
    }
    
    public void dfs(Map<String, Integer> map, boolean[][] isVisited, String[] language, String[] position, String[] role, String[] food, int score, String str) {
        
        // 2차원배열로 만들고 하기
        for (int i = 0; i < 2; i++) {
            if (isVisited[0][i] == false) {
                isVisited[0][i] = true;
                dfs(map, isVisited, language, position, role, food, score, str + language[i]);
            }
        }
        
        for (int i = 0; i < 2; i++) {
            if (isVisited[1][i] == false) {
                isVisited[1][i] = true;
                dfs(map, isVisited, language, position, role, food, score, str + position[i]);
            }
        }
        
        for (int i = 0; i < 2; i++) {
            if (isVisited[2][i] == false) {
                isVisited[2][i] = true;
                dfs(map, isVisited, language, position, role, food, score, str + role[i]);
            }
        }
        
        for (int i = 0; i < 2; i++) {
            if (isVisited[3][i] == false) {
                isVisited[3][i] = true;
                dfs(map, isVisited, language, position, role, food, score, str + food[i]);
                
                map.put(str + food[i], score);
                System.out.println(str + food[i] + " " + score);
            }
        }
    }
}
