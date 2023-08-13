import java.util.*;

class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int[] answer = new int[len];
        int[] preCharIndex = new int[26];

        Arrays.fill(preCharIndex, -1);
        // s의 길이만큼 int 배열 preCharIndex 선언한다. 여기에는 해당 글자의 index를 저장한다.
        // s를 순회하면서 preCharIndex["해당Char"] 확인하여,
        // -1이 아닌 경우, 해당 index를 preCharIndex에 저장한다.
        // 저장된 인덱스와 현재 인덱스의 차를 구해서 answer에 저장한다.

        for (int i = 0; i < len; i++) {
            int alpha = s.charAt(i) - 97;

            if (preCharIndex[alpha] != -1) {
                answer[i] = i - preCharIndex[alpha];
            } else {
                answer[i] = -1;
            }

            preCharIndex[alpha] = i;
        }

        return answer;
    }
}