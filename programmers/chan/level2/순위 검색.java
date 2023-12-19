import java.util.*;

class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for (int i = 0; i < info.length; i++) {
            String[] infos = info[i].split(" ");
            
            String[] language = {infos[0], "-"};
            String[] position = {infos[1], "-"};
            String[] role = {infos[2], "-"};
            String[] food = {infos[3], "-"};
            int score = Integer.parseInt(infos[4]);
            String[][] mapKeys = {language, position, role, food};
            
            dfs(mapKeys, score, new ArrayList<>(), -1);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        // map에 저장한 값 중 query의 score보다 큰 값 찾기
        for (int i = 0; i < query.length; i++) {
            String str = query[i].replaceAll(" and ", "");
            String[] key = str.split(" ");
            
            int score = Integer.parseInt(key[1]);
            
            List<Integer> scoreList = map.getOrDefault(key[0], new ArrayList<>());
            
            if (scoreList.size() > 0) {
                // 이분탐색
                int left = 0;
                int right = scoreList.size() - 1;
                int mid = (left + right) / 2;
                
                while (left < right) {                    
                    if (score > scoreList.get(mid)) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                    
                    mid = (left + right) / 2;
                }
                
                answer[i] = scoreList.size() - 1 - mid;
                
                if (scoreList.get(mid) >= score) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
    
    public void dfs(String[][] mapKeys, int score, List<String> list, int nextIndex) {
        if (list.size() == 4) {
            String newStr = "";
            
            for (String str : list) {
                newStr += str;
            }
            
            List<Integer> scoreList = map.getOrDefault(newStr, new ArrayList<>());
            scoreList.add(score);
            
            map.put(newStr, scoreList);
        }
        
        for (int i = nextIndex + 1; i < 4; i++) {
            List<String> sub1 = new ArrayList<>(list);
            List<String> sub2 = new ArrayList<>(list);
            
            sub1.add(mapKeys[i][0]);
            sub2.add(mapKeys[i][1]);
            
            dfs(mapKeys, score, sub1, i);
            dfs(mapKeys, score, sub2, i);
        }
    }
}
