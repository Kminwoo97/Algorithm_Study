import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] total = new int[N + 1]; // 스테이지에 도달한 플레이어 수
        int[] unclear = new int[N + 1]; // 스테이지에 도달했으나 클리어하지 못한 플레이어 수
        List<Stage> list = new ArrayList<>();
        
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] <= N) {
                unclear[stages[i]]++;
            }
            
            for (int j = 1; j <= stages[i]; j++) {
                if (j <= N) {
                    total[j]++;
                }
            }
        }
        
        for (int i = 1; i < total.length; i++) {
            double failureRate = 0;
            
            if (total[i] == 0) {
                failureRate = 0;
            } else {
                failureRate = (double) unclear[i] / total[i];
            }
            
            list.add(new Stage(i, failureRate));
        }
        
        Collections.sort(list, (e1, e2) -> Double.compare(e2.failureRate, e1.failureRate));
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).index;
        }
        
        return answer;
    }
}

class Stage {
    int index;
    double failureRate;
    
    Stage (int index, double failureRate) {
        this.index = index;
        this.failureRate = failureRate;
    }
}
