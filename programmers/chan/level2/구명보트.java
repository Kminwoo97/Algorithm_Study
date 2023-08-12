import java.util.*;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int len = people.length;
        int answer = len;

        Arrays.sort(people);

        int i = 0;
        int j = len - 1;

        while (i < j) {
            if (people[i] + people[j] <= limit) {
                answer--;
                i++;
            }

            j--;
        }

        return answer;
    }
}
