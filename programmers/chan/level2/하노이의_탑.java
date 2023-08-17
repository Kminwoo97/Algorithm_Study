import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        int[][] answer;

        recursive(n, 1, 2, 3);

        answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }

        return answer;
    }

    // n층을 start번에서 end번 타워로 옮긴다.
    public void recursive(int n, int start, int mid, int end) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return;
        }

        // 1 ~ n-1 층을 start에서 end타워를 거쳐 mid타워로 옮긴다.
        recursive(n - 1 , start, end, mid);

        // n번째 원판을 start에서 end로 이동
        list.add(new int[]{start, end});

        // 1 ~ n-1 층을 mid에서 start를 거쳐 end타워로 옮긴다.
        recursive(n - 1, mid, start, end);
    }
}