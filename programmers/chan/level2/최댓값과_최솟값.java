import java.util.*;

class Solution {
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