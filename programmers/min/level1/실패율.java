import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        //1 ~ N 단계에서 x 단계에 몇명이 있는지 카운팅
        int[] cur_stages = new int[N+1];
        for(int i=0; i<stages.length; i++){
            if(stages[i] == N + 1)
                continue;
            int x = stages[i];
            cur_stages[x]++;
        }
        
        //N단계 실패율 계산및 정렬
        int total = stages.length;
        ArrayList<Stage> fail_ratio = new ArrayList<>();
        for(int i=1; i<cur_stages.length; i++){
            if(cur_stages[i] == 0)
                fail_ratio.add(new Stage(i, 0.0));
            else{
                fail_ratio.add(new Stage(i, (double)cur_stages[i] / (double)total));
                total -= cur_stages[i];
            }
        }
        Collections.sort(fail_ratio);
        
        
        //정답
        for(int i=0; i<N; i++){
            answer[i] = fail_ratio.get(i).idx;
        }
        
        return answer;
    }
}

class Stage implements Comparable<Stage>{
    int idx;
    double fail_ratio;
    
    public Stage(int idx, double fail_ratio){
        this.idx = idx;
        this.fail_ratio = fail_ratio;
    }
    
    @Override
    public int compareTo(Stage o){
        if(this.fail_ratio < o.fail_ratio)
            return 1;
        else if(this.fail_ratio == o.fail_ratio)
            return this.idx - o.idx;
        else
            return -1;
    }
}


