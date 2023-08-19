import java.util.*;

class Solution {
    ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        int[][] answer = {};
        
        hanoi(n, 1, 2, 3);
        
        answer = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            int[] x = list.get(i);
            answer[i][0] = x[0];
            answer[i][1] = x[1];
        }
        
        return answer;
    }
    public void hanoi(int n, int start, int mid, int end){
        if(n == 1){
            list.add(new int[]{start, end});
        }
        else{
            //n-1개의 원판을 end를 거쳐서 mid로 이동
            hanoi(n-1, start, end, mid);
            
            //n번째 원판을 3번 기둥으로
            list.add(new int[]{start, end});
            
            //n-1개의 원판을 start를 거쳐서 end로 이동
            hanoi(n-1, mid, start, end);
        }
    }
}
