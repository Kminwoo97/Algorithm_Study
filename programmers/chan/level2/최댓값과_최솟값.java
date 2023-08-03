import java.util.*;

class 최댓값과_최솟값 {
    public String solution(String s) {
        String answer = "";
        String[] stringArray = s.split(" ");

        int[] intArr = Arrays.stream(stringArray)
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(intArr);

        answer = intArr[0] + " " + intArr[intArr.length - 1];

        return answer;
    }
}