import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        //U D R L 에 대한 좌표
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        String[] inputs = dirs.split("");
        for(String input : inputs){
            switch(input){
                case "U":
                    if(x + dx[0] > 5 || x + dx[0] < -5)
                        continue;
                    if(y + dy[0] > 5 || y + dy[0] < -5)
                        continue;
                    set.add(Arrays.toString(new int[]{x,y, x+dx[0], y+dy[0]}));
                    set.add(Arrays.toString(new int[]{x+dx[0], y+dy[0],x,y}));
                    x = x + dx[0];
                    y = y + dy[0];
                    break;
                case "D":
                    if(x + dx[1] > 5 || x + dx[1] < -5)
                        continue;
                    if(y + dy[1] > 5 || y + dy[1] < -5)
                        continue;
                    set.add(Arrays.toString(new int[]{x,y, x+dx[1], y+dy[1]}));
                    set.add(Arrays.toString(new int[]{x+dx[1], y+dy[1],x,y}));
                    x = x + dx[1];
                    y = y + dy[1];
                    break;
                case "R":
                    if(x + dx[2] > 5 || x + dx[2] < -5)
                        continue;
                    if(y + dy[2] > 5 || y + dy[2] < -5)
                        continue;
                    set.add(Arrays.toString(new int[]{x,y, x+dx[2], y+dy[2]}));
                    set.add(Arrays.toString(new int[]{x+dx[2], y+dy[2],x,y}));
                    x = x + dx[2];
                    y = y + dy[2];
                    break;
                case "L":
                    if(x + dx[3] > 5 || x + dx[3] < -5)
                        continue;
                    if(y + dy[3] > 5 || y + dy[3] < -5)
                        continue;
                    set.add(Arrays.toString(new int[]{x,y, x+dx[3], y+dy[3]}));
                    set.add(Arrays.toString(new int[]{x+dx[3], y+dy[3],x,y}));
                    x = x + dx[3];
                    y = y + dy[3];
                    break;
                    
            }
        }
        answer = set.size() / 2;
        return answer;
    }
}
