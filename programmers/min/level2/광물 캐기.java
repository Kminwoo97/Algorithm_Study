import java.util.*;

class Solution {    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        //광물에게 인덱스 부여
        int[][] score = {{1,1,1},{5,1,1},{25,5,1}};
        HashMap<String, Integer> map = new HashMap<>();
        map.put("diamond", 0);
        map.put("iron", 1);
        map.put("stone", 2);
        
        //캘 수 있는 최대 광물 수 - min(곡괭이 x 5, 총 광물의 수) 
        int max_minerals = Math.min(picks[0] * 5 + picks[1] * 5 + picks[2] * 5, minerals.length);
        
        //각 곡괭이로 광물을 캤을때의 피로도 값을 구한다. 5개씩 그룹으로 분리한다.
        int start = 0;
        int end = 5;
        if(end > max_minerals)
            end = max_minerals;
        
        ArrayList<int[]> list = new ArrayList<>();

        while(start < end && end <= max_minerals){    
            int[] sub_list = new int[5];
            
            //다이아, 철, 돌, 시작, 끝
            for(int i=start; i<end; i++){
                int x = map.get(minerals[i]);
                
                sub_list[0] += score[0][x];
                sub_list[1] += score[1][x];
                sub_list[2] += score[2][x];
            }
            sub_list[3] = start;
            sub_list[4] = end;
            list.add(sub_list);
            
            start = end;
            end += 5;
            if(end > max_minerals)
                end = max_minerals;
        }
        
        //stone 곡괭이로 캤을 때의 가중치를 기준으로 내림차순 정렬한다.
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(b[2] == a[2]){
                    
                    if(b[1] == a[1])
                        return b[0] - a[0];
                    
                    return b[1] - a[1];
                }
                return b[2] - a[2];
            }
        });
        
        
        for(int[] sub_list : list){
            start = sub_list[3];
            end = sub_list[4];
            
            //곡괭이 선택
            int pick_num = -1;
            if(picks[0] != 0)
                pick_num = 0;
            else if(picks[1] != 0)
                pick_num = 1;
            else
                pick_num = 2;
            
            //최소 피로도 구하기
            for(int i=start; i<end; i++){
                int x = map.get(minerals[i]);
                answer += score[pick_num][x];
            }
            
            //해당 곡괭이 소모
            picks[pick_num]--;
        }
        
     
        return answer;
    }
}
