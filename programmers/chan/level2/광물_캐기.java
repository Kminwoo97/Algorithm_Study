import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int pickaxe = picks[0] + picks[1] + picks[2];
        int[] pick = new int[3];
        
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                pick[0] += 1;
                pick[1] += 5;
                pick[2] += 25;
            } else if (minerals[i].equals("iron")) {
                pick[0] += 1;
                pick[1] += 1;
                pick[2] += 5;
            } else {
                pick[0] += 1;
                pick[1] += 1;
                pick[2] += 1;
            }
            
            if (i % 5 == 4 && list.size() < pickaxe) {
                list.add(new int[]{pick[0], pick[1], pick[2]});
                pick[0] = 0;
                pick[1] = 0;
                pick[2] = 0;
            }
        }
        
        if ((minerals.length - 1) / 5 + 1 <= pickaxe) {
            list.add(new int[]{pick[0], pick[1], pick[2]});
        }
        
        Collections.sort(list, (e1, e2) -> e2[2] - e1[2]);
        
        for (int i = 0; i < list.size(); i++) {
            if (picks[0] > 0) {
                answer += list.get(i)[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += list.get(i)[1];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += list.get(i)[2];
                picks[2]--;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
