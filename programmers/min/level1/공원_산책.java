import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = SearchStartLocation(park);
        
        int n = park.length;
        int m = park[0].length();

        Map<String, int[]> map = new HashMap<>();
        map.put("E", new int[]{0,1});
        map.put("W", new int[]{0,-1});
        map.put("S", new int[]{1, 0});
        map.put("N", new int[]{-1, 0});
        
        for(int i=0; i<routes.length; i++){
            String[] command = routes[i].split(" ");
        
            int[] move_dir = map.get(command[0]);
            int cnt = Integer.parseInt(command[1]);
            boolean flag = true;
            for(int j=1; j<=cnt; j++){
                int nx = answer[0] + move_dir[0] * j;
                int ny = answer[1] + move_dir[1] * j;
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    flag = false;
                    break;
                }
                if(park[nx].charAt(ny) == 'X'){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                answer[0] = answer[0] + move_dir[0] * cnt;
                answer[1] = answer[1] + move_dir[1] * cnt;
            }
 
        }
        
        return answer;
    }
    
    public int[] SearchStartLocation(String[] park){
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    return new int[]{i,j};
                }
            }
        }
        
        return new int[]{-1,-1};
    }
}
