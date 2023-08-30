class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String str = Long.toBinaryString(numbers[i]);
                StringBuilder sb = new StringBuilder();                
                int len = str.length();
                int oneCount = Long.bitCount(numbers[i]);
                
                sb.append(str);
                
                // str 길이랑 1의 갯수가 같으면 str에서 1번 index 위치에 0 삽입 후 Long으로 변환
                if (len == oneCount) {
                    sb.insert(1, "0");
                } else {
                    // 0이 하나라도 있으면 "01"이 나오는 마지막 구간을 찾아서 "10"으로 반전한 값 구하기
                    int index = 0;
                    
                    for (int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) == '0' && str.charAt(j + 1) == '1') {
                            index = j;
                        }
                    }
                    
                    sb.insert(index, '0');
                    sb.insert(index, '1');
                    sb.delete(index + 2, index + 4);
                }
                
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        
        return answer;
    }
}
