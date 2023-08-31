import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        // int[] highway = new int[60001];
        
        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare (int[] e1, int[] e2) {
                return e1[1] - e2[1];
            }
        });
        
        // 첫 번째 카메라는 첫 차가 빠져나가는 위치에 설치.
        int end = routes[0][1];
        answer++;
        
        for (int i = 1; i < routes.length; i++) {
            // 다음 차량의 시작 지점이 끝나는 지점보다 앞서면 이미 찍힌 차량
            if (routes[i][0] <= end) {
                continue;
            } else {
                end = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}
