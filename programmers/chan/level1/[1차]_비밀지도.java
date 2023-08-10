class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] map1 = new String[n];
        String[] map2 = new String[n];

        // 10진수 -> 2진수로 변환해서 지도 그리기
        for (int i = 0; i < n; i++) {
            map1[i] = decimalToBinary(arr1[i], n);
            map2[i] = decimalToBinary(arr2[i], n);

            StringBuilder sb = new StringBuilder();
            // 지도 겹치기
            for (int j = 0; j < n; j++) {
                if (map1[i].charAt(j) == map2[i].charAt(j) &&
                        map1[i].charAt(j) == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

    public String decimalToBinary(int num, int n) {
        String binaryNum = Integer.toBinaryString(num);

        if (binaryNum.length() != n) {
            while (binaryNum.length() < n) {
                binaryNum = "0" + binaryNum;
            }
        }

        return binaryNum;
    }
}