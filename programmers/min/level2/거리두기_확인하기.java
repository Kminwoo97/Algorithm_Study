import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer,1);
        
        //P:사람, X:파티션, O:책상
        for(int i=0; i<5; i++){
            
            String[] place = places[i];
            
            //앉은 사람들 리스트 만들기
            ArrayList<int[]> list = new ArrayList<>();
            for(int j=0; j<place.length; j++){
                for(int k=0; k<place[j].length(); k++){
                    if(place[j].charAt(k) == 'P'){
                        list.add(new int[]{j,k});
                    }
                }
            }
            
            //앉은 사람들 끼리 맨해튼 거리 계산하기
            for(int j=0; j<list.size()-1; j++){
                int[] pointA = list.get(j);
                for(int k=j+1; k<list.size(); k++){
                    int[] pointB = list.get(k);
                    
                    int dis = Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
                    
                    //멘해튼 거리가 2이하라면 중간에 파티션이 있는지 체킹
                    if(dis <= 2){
                        if(!CheckPartition(place, pointA, pointB)){
                            answer[i] = 0;
                        }
                    }
                    
                }
            }
            
        }
        return answer;
    }
    
    public boolean CheckPartition(String[] place, int[] a, int[] b){
        int target = 2;
        if(a[0] == b[0])
            target = 1;
        if(a[1] == b[1])
            target = 1;
        
        int x1 = a[0];
        int y1 = a[1];
        int x2 = b[0];
        int y2 = b[1];
        if(x1 > x2){
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
        }
        if(y1 > y2){
            int tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
        
        int cnt = 0;
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(place[i].charAt(j) == 'X')
                    cnt += 1;
            }
        }
        
        if(target != cnt)
            return false;
        return true;
    }
}
