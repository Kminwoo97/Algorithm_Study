import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 삼총사 {
    static int answer = 0;

    public int solution(int[] number) {
        boolean[] isVisited = new boolean[number.length];
        List<Integer> list = new ArrayList<>();

        dfs(number, list, isVisited, -1, 0);

        return answer;
    }

    public void dfs(int[] number, List<Integer> list, boolean[] isVisited, int i, int sum) {

        if (list.size() == 3) {
            if (sum == 0) {
                answer++;
            }

            return;
        }

        for (int j = 0; j < number.length; j++) {
            if (isVisited[j] == false) {
                list.add(number[j]);
                isVisited[j] = true;
                boolean[] newIsVisited = Arrays.copyOf(isVisited, isVisited.length);

                dfs(number, list, newIsVisited, j, sum + number[j]);
                list.remove(list.size() - 1);
            }
        }
    }
}
